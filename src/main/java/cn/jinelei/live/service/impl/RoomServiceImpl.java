package cn.jinelei.live.service.impl;

import cn.jinelei.live.dao.RoomMapper;
import cn.jinelei.live.exception.RoomException;
import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.data.RoomExample;
import cn.jinelei.live.model.data.User;
import cn.jinelei.live.model.enumstatus.room.RoomStatus;
import cn.jinelei.live.service.RoomService;
import cn.jinelei.live.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
@Service("roomService")
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private UserService userService;

    @Override
    public boolean updateRoom(Room room) throws RoomException {
        Room room1 = getRoom(room.getRoomId());
        if (room.getRoomIntroduce() != null && !room.getRoomIntroduce().equals("") && !room.getRoomIntroduce().equals(room1.getRoomIntroduce()))
            room1.setRoomIntroduce(room.getRoomIntroduce());
        if (room.getRoomName() != null && !room.getRoomName().equals("") && !room.getRoomName().equals(room1.getRoomName()))
            room1.setRoomName(room.getRoomName());
        if (room.getRoomScreenshot() != null && !room.getRoomScreenshot().equals("") && !room.getRoomScreenshot().equals(room1.getRoomScreenshot()))
            room1.setRoomScreenshot(room.getRoomScreenshot());
        if (room.getRoomStatus() != null && room.getRoomStatus() != room1.getRoomStatus())
            room1.setRoomStatus(room.getRoomStatus());
        int res = roomMapper.updateByPrimaryKeySelective(room1);
        return res == 1 ? true : false;
    }

    @Override
    public boolean deleteRoom(Room room) throws RoomException {
        return deleteRoom(room.getRoomId());
    }

    @Override
    public boolean deleteRoom(Integer roomID) throws RoomException {
        Room room1 = getRoom(roomID);
        int res = roomMapper.deleteByPrimaryKey(room1.getRoomId());
        return res == 1 ? true : false;
    }

    @Override
    public Room insertRoom(Room room) throws RoomException {
        return insertRoom(room.getRoomName(), room.getRoomStatus(), room.getRoomScreenshot(), room.getRoomIntroduce(), room.getUserId(), room.getStreamKey());
    }

    @Override
    public Room insertRoom(String roomName, Integer roomStatus, String roomScreenshot, String roomIntroduce, User user, String streamKey) throws RoomException {
        return insertRoom(roomName, roomStatus, roomScreenshot, roomIntroduce, user.getUserId(), streamKey);
    }

    @Override
    public Room insertRoom(String roomName, Integer roomStatus, String roomScreenshot, String roomIntroduce, Integer userId, String streamKey) throws RoomException {
        Room room1 = new Room();
        if (roomName != null && !roomName.equals(""))
            room1.setRoomName(roomName);
        if (roomIntroduce != null && !roomIntroduce.equals(""))
            room1.setRoomIntroduce(roomIntroduce);
        if (roomScreenshot != null && !roomScreenshot.equals(""))
            room1.setRoomScreenshot(roomScreenshot);
        if (streamKey != null && !streamKey.equals(""))
            room1.setStreamKey(streamKey);
        if (userId != null)
            room1.setUserId(userId);
        if (roomStatus != null)
            room1.setRoomStatus(roomStatus);
        int res = roomMapper.insertSelective(room1);
        if (res != 1)
            throw new RoomException(RoomException.ROOM_INSERT_FAILED);
        return room1;
    }

    @Override
    public List<Room> getAllRoom() {
        return roomMapper.selectByExample(new RoomExample());
    }

    @Override
    public List<Room> getAllRoomLimit(Integer offset, Integer limit) {
        PageInfo<Room> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            roomMapper.selectByExample(new RoomExample());
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<Room> getAllRoomPageInfo() {
        RoomExample example = new RoomExample();
        return new PageInfo<Room>(roomMapper.selectByExample(example));
    }

    @Override
    public List<Room> getAllRoomByStatus(Integer roomStatus) {
        RoomExample example = new RoomExample();
        example.createCriteria().andRoomStatusEqualTo(roomStatus);
        return roomMapper.selectByExample(example);
    }

    @Override
    public List<Room> getAllRoomByStatusLimit(Integer roomStatus, Integer offset, Integer limit) {
        PageInfo<Room> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            RoomExample example = new RoomExample();
            example.createCriteria().andRoomStatusEqualTo(roomStatus);
            roomMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<Room> getAllRoomByStatusPageInfo(Integer roomStatus) {
        RoomExample example = new RoomExample();
        example.createCriteria().andRoomStatusEqualTo(roomStatus);
        return new PageInfo<Room>(roomMapper.selectByExample(example));
    }

    @Override
    public List<Room> getAllRoomFuzzyName(String name) {
        RoomExample example = new RoomExample();
        example.createCriteria().andRoomNameLike(name);
        return roomMapper.selectByExample(example);
    }

    @Override
    public List<Room> getAllRoomFuzzyNameLimit(String name, Integer offset, Integer limit) {
        PageInfo<Room> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            RoomExample example = new RoomExample();
            example.createCriteria().andRoomNameLike(name);
            roomMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<Room> getAllRoomFuzzyNamePageInfo(String name) {
        RoomExample example = new RoomExample();
        example.createCriteria().andRoomNameLike(name);
        return new PageInfo<Room>(roomMapper.selectByExample(example));
    }

    @Override
    public List<Room> getAllRoomFuzzyIntroduce(String introduce) {
        RoomExample example = new RoomExample();
        example.createCriteria().andRoomIntroduceLike(introduce);
        return roomMapper.selectByExample(example);
    }

    @Override
    public List<Room> getAllRoomFuzzyIntroduceLimit(String introduce, Integer offset, Integer limit) {
        PageInfo<Room> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            RoomExample example = new RoomExample();
            example.createCriteria().andRoomIntroduceLike(introduce);
            roomMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<Room> getAllRoomFuzzyIntroducePageInfo(String introduce) {
        RoomExample example = new RoomExample();
        example.createCriteria().andRoomIntroduceLike(introduce);
        return new PageInfo<Room>(roomMapper.selectByExample(example));
    }

    @Override
    public List<Room> getAllRoomByUser(String username) throws UserException {
        User user = userService.getUserInfo(username);
        return getAllRoomByUser(user.getUserId());
    }

    @Override
    public List<Room> getAllRoomByUserLimit(String username, Integer offset, Integer limit) throws UserException {
        User user = userService.getUserInfo(username);
        return getAllRoomByUserLimit(user.getUserId(), offset, limit);
    }

    @Override
    public PageInfo<Room> getAllRoomByUserPageInfo(String username) throws UserException {
        User user = userService.getUserInfo(username);
        return getAllRoomByUserPageInfo(user.getUserId());
    }

    @Override
    public List<Room> getAllRoomByUser(Integer userId) {
        RoomExample example = new RoomExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return roomMapper.selectByExample(example);
    }

    @Override
    public List<Room> getAllRoomByUserLimit(Integer userId, Integer offset, Integer limit) {
        PageInfo<Room> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            RoomExample example = new RoomExample();
            example.createCriteria().andUserIdEqualTo(userId);
            roomMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<Room> getAllRoomByUserPageInfo(Integer userId) {
        RoomExample example = new RoomExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return new PageInfo<Room>(roomMapper.selectByExample(example));
    }

    @Override
    public List<Room> getAllRoomByUser(User user) {
        return getAllRoomByUser(user.getUserId());
    }

    @Override
    public List<Room> getAllRoomByUserLimit(User user, Integer offset, Integer limit) {
        return getAllRoomByUserLimit(user.getUserId(), offset, limit);
    }

    @Override
    public PageInfo<Room> getAllRoomByUserPageInfo(User user) {
        return getAllRoomByUserPageInfo(user.getUserId());
    }

    @Override
    public Room getRoom(Integer roomId) throws RoomException {
        Room room = roomMapper.selectByPrimaryKey(roomId);
        if (room == null)
            throw new RoomException(RoomException.ROOM_NOT_EXIST);
        return room;
    }

    @Override
    public Room getRoomByStream(String streamId) throws RoomException {
        RoomExample example = new RoomExample();
        example.createCriteria().andStreamKeyEqualTo(streamId);
        List<Room> rooms = roomMapper.selectByExample(example);
        if (rooms.size() > 1)
            throw new RoomException(RoomException.ROOM_NOT_UNIQUE);
        else if (rooms.size() < 1)
            throw new RoomException(RoomException.ROOM_NOT_EXIST);
        return rooms.get(0);
    }

    @Override
    public boolean setRoomStatusOffline(Room room) {
        room.setRoomStatus(RoomStatus.OFFLINE.ordinal());
        boolean res = false;
        try {
            res = updateRoom(room);
        } catch (RoomException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean setRoomStatusOnline(Room room) {
        room.setRoomStatus(RoomStatus.ONLINE.ordinal());
        boolean res = false;
        try {
            res = updateRoom(room);
        } catch (RoomException e) {
            e.printStackTrace();
        }
        return res;
    }
}
