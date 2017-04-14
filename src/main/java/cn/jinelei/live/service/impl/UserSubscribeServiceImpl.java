package cn.jinelei.live.service.impl;

import cn.jinelei.live.dao.UserSubscribeMapper;
import cn.jinelei.live.dao.ViUserSubscribeMapper;
import cn.jinelei.live.exception.RoomException;
import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.exception.UserSubscribeException;
import cn.jinelei.live.model.data.*;
import cn.jinelei.live.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
@Service("userSubscribeService")
@Transactional
public class UserSubscribeServiceImpl implements UserSubscribeService {

    @Autowired
    private UserSubscribeMapper userSubscribeMapper;
    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;

    @Override
    public boolean addSubscribe(Integer userId, Integer roomId) throws UserSubscribeException, RoomException, UserException {
        UserSubscribe userSubscribe = new UserSubscribe();
        userSubscribe.setUserId(userId);
        userSubscribe.setRoomId(roomId);
        boolean result = false;
        try {
            userSubscribeMapper.delete(getSubscribe(userId, roomId));
        } catch (UserSubscribeException e) {
            if (e.getMessage().equals(UserSubscribeException.USER_SUBSCRIBE_NOT_EXIST)) {
                int res = userSubscribeMapper.insert(userSubscribe);
                if (res == 1)
                    result = true;
                else {
                    throw new UserSubscribeException(UserSubscribeException.USER_SUBSCRIBE_INSERT_FAILED);
                }
            }
        } catch (RoomException e) {
            throw new RoomException(RoomException.ROOM_NOT_EXIST);
        } catch (UserException e) {
            throw new UserException(UserException.USER_NOT_EXIST);
        }
        return result;
    }

    @Override
    public boolean removeSubscribe(Integer userId, Integer roomId) throws UserSubscribeException, RoomException, UserException {
        boolean result = false;
        int line = userSubscribeMapper.delete(getSubscribe(userId, roomId));
        if (line == 1)
            result = true;
        return result;
    }

    @Override
    public UserSubscribe getSubscribe(Integer userId, Integer roomId) throws UserSubscribeException, UserException, RoomException {
        UserSubscribe result = null;
        Room room1 = roomService.getRoom(roomId);
        User user = userService.getUserInfo(userId);
        UserSubscribeExample example = new UserSubscribeExample();
        example.createCriteria().andRoomIdEqualTo(roomId)
                .andUserIdEqualTo(userId);
        List<UserSubscribe> res = userSubscribeMapper.selectByExample(example);
        if (res.size() > 1) {
            throw new UserSubscribeException(UserSubscribeException.USER_SUBSCRIBE_NOT_UNIQUE);
        } else if (res.size() < 1) {
            throw new UserSubscribeException(UserSubscribeException.USER_SUBSCRIBE_NOT_EXIST);
        } else {
            result = res.get(0);
        }
        return result;
    }


}


