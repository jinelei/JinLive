package cn.jinelei.live.utils.rtmp;

import cn.jinelei.live.exception.RoomException;
import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.enumstatus.room.RoomStatus;
import cn.jinelei.live.model.nginx.live.Stream;
import cn.jinelei.live.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jinelei on 17-4-6.
 */
@PropertySource("classpath:/application.properties")
public class LiveUtils {

    @Autowired
    private RoomService roomService;
    @Autowired
    private RTMPUtils rtmpUtils;
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
        rtmpUtils.getScreenShotFromLiveStream(roomList);
    }

}
