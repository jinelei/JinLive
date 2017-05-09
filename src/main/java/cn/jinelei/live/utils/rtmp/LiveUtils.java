package cn.jinelei.live.utils.rtmp;

import cn.jinelei.live.exception.RoomException;
import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.enumstatus.room.RoomStatus;
import cn.jinelei.live.model.nginx.Application;
import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.model.nginx.live.Live;
import cn.jinelei.live.model.nginx.live.Stream;
import cn.jinelei.live.service.RoomService;
import cn.jinelei.live.utils.net.HttpTools;
import cn.jinelei.live.utils.net.handler.EntityHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Created by jinelei on 17-4-6.
 */
@PropertySource("classpath:/application.properties")
public class LiveUtils {

    @Autowired
    private RoomService roomService;
    @Autowired
    private Environment environment;
    @Autowired
    private EntityHandler entityHandler;
    @Autowired
    private HttpTools httpTools;
    @Value("${nginx_server}")
    private String nginx_server;
    @Value("${tomcat_server}")
    private String tomcat_server;
    @Value("${application_name}")
    private String application_name;
    @Value("${screenshot_dir}")
    private String screenshot_dir;



    private static final Logger logger = LoggerFactory.getLogger(LiveUtils.class);

    public void updateRoomStatus(List<Stream> streamList) {
        List<String> roomList = streamList.stream().map(stream -> stream.getName()).collect(Collectors.toList());

        roomService.getAllRoom().forEach(room -> {
            if (roomList.contains(room.getStreamKey()) && room.getRoomStatus() != RoomStatus.ONLINE.ordinal()) {
                roomService.setRoomStatusOnline(room);
                logger.info("toggle room status online: " + room.getStreamKey());
            } else if (!roomList.contains(room.getStreamKey()) && room.getRoomStatus() != RoomStatus.OFFLINE.ordinal()) {
                roomService.setRoomStatusOffline(room);
                logger.info("toggle room status offline: " + room.getStreamKey());
            }
        });
    }

    public void grabScreenshots(List<Stream> streamList) {
        List<String> roomList = streamList.stream().map(stream -> {
//            logger.info("name : " + stream.getName());
            try {
                Room room = roomService.getRoomByStream(stream.getName());
                room.setRoomScreenshot(String.format("/screenshot/%s.jpg", stream.getName()));
                roomService.updateRoom(room);
            } catch (RoomException e) {
                e.printStackTrace();
            }
            return stream.getName();
        }).collect(Collectors.toList());
        getScreenShotFromLiveStream(roomList);
    }


    private static ExecutorService executor = Executors.newCachedThreadPool();

    public RTMP getRTMPInfoFromServer() {
        String statUrl = String.format("%s/stat", nginx_server);
        RTMP rtmp = entityHandler.handleEntity(httpTools.getEntity(statUrl));
        return rtmp;
    }

    public List<Stream> getLiveStreamFromRTMP(RTMP rtmp) {
        List<Stream> streamList = null;
        if (rtmp != null) {
            for (Application application : rtmp.getServer().getApplications()) {
                if ("live".equals(application.getName())) {
                    streamList = ((Live) application).getStreams();
                }
            }
        }
        return streamList;
    }

    public void getScreenShotFromLiveStream(List<String> streamList) {
        streamList.forEach(stream -> {
            String touch_file = String.format("ffmpeg -re -i rtmp://%s:1935/stream/%s -an -y -f image2 -r 1 %s%s.jpg",
                    nginx_server.substring(nginx_server.indexOf(':') + 3), stream, screenshot_dir, stream);
            logger.debug(touch_file);
            executor.submit(() -> {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    runtime.exec(touch_file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });
    }


}
