package cn.jinelei.live.service;

import cn.jinelei.live.exception.RoomException;
import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.data.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
public interface RoomService {

    boolean updateRoom(Room room) throws RoomException;

    boolean deleteRoom(Room room) throws RoomException;

    boolean deleteRoom(Integer roomID) throws RoomException;

    Room insertRoom(Room room) throws RoomException;

    Room insertRoom(String roomName, Integer roomStatus, String roomScreenshot, String roomIntroduce, User user, String streamKey) throws RoomException;

    Room insertRoom(String roomName, Integer roomStatus, String roomScreenshot, String roomIntroduce, Integer userId, String streamKey) throws RoomException;

    List<Room> getAllRoom();

    List<Room> getAllRoomLimit(Integer offset, Integer limit);

    PageInfo<Room> getAllRoomPageInfo();

    List<Room> getAllRoomByStatus(Integer roomStatus);

    List<Room> getAllRoomByStatusLimit(Integer roomStatus, Integer offset, Integer limit);

    PageInfo<Room> getAllRoomByStatusPageInfo(Integer roomStatus);

    List<Room> getAllRoomFuzzyName(String name);

    List<Room> getAllRoomFuzzyNameLimit(String name, Integer offset, Integer limit);

    PageInfo<Room> getAllRoomFuzzyNamePageInfo(String name);

    List<Room> getAllRoomFuzzyIntroduce(String introduce);

    List<Room> getAllRoomFuzzyIntroduceLimit(String introduce, Integer offset, Integer limit);

    PageInfo<Room> getAllRoomFuzzyIntroducePageInfo(String introduce);

    List<Room> getAllRoomByUser(String username) throws UserException;

    List<Room> getAllRoomByUserLimit(String username, Integer offset, Integer limit) throws UserException;

    PageInfo<Room> getAllRoomByUserPageInfo(String username) throws UserException;

    List<Room> getAllRoomByUser(Integer userId);

    List<Room> getAllRoomByUserLimit(Integer userId, Integer offset, Integer limit);

    PageInfo<Room> getAllRoomByUserPageInfo(Integer userId);

    List<Room> getAllRoomByUser(User user);

    List<Room> getAllRoomByUserLimit(User user, Integer offset, Integer limit);

    PageInfo<Room> getAllRoomByUserPageInfo(User user);

    Room getRoom(Integer roomId) throws RoomException;

    Room getRoomByStream(String streamId) throws RoomException;


}
