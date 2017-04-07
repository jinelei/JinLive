package cn.jinelei.live.utils.live;

import cn.jinelei.live.exception.RoomException;
import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.enumstatus.room.RoomStatus;
import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.model.nginx.live.Stream;
import cn.jinelei.live.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinelei on 17-4-6.
 */
@PropertySource("classpath:/application.properties")
public class LiveUtils {

    @Autowired
    private RoomService roomService;

    private static final Logger logger = LoggerFactory.getLogger(LiveUtils.class);

    public void updateRoomStatus(List<Stream> streamList) {
        streamList.forEach(stream -> {
            try {
                Room room = roomService.getRoomByStream(stream.getName());
                room.setRoomStatus(RoomStatus.ONLINE.ordinal());
                roomService.updateRoom(room);
            } catch (RoomException e) {
                e.printStackTrace();
            }
        });
    }

}
