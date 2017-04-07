package cn.jinelei.live.service;

import cn.jinelei.live.model.Room;
import cn.jinelei.live.model.User;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
public interface RoomService {
    boolean updateRoom(Room room);

    boolean deleteRoom(Room room);

    boolean deleteRoom(Integer roomID);

    Room insertRoom(Room room);

    Room insertRoom(
            String roomName,
            Integer roomStatus,
            String roomScreenshot,
            String roomIntroduce,
            User user,
            String streamKey);

    Room insertRoom(
            String roomName,
            Integer roomStatus,
            String roomScreenshot,
            String roomIntroduce,
            Integer userId,
            String streamKey);
    List<Room> getAllRoom();
}
