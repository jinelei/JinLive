package cn.jinelei.live.service;

import cn.jinelei.live.exception.RoomException;
import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.exception.UserSubscribeException;
import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.data.UserSubscribe;
import cn.jinelei.live.model.data.ViUserSubscribe;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
public interface UserSubscribeService {

    boolean addSubscribe(Integer userId, Integer roomId) throws UserSubscribeException, RoomException, UserException;

    boolean removeSubscribe(Integer userId, Integer roomId) throws UserSubscribeException, RoomException, UserException;

    UserSubscribe getSubscribe(Integer userId, Integer roomId) throws UserSubscribeException, UserException, RoomException;

}
