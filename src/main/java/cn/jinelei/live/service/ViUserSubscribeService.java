package cn.jinelei.live.service;

import cn.jinelei.live.exception.CategoryException;
import cn.jinelei.live.exception.RoomException;
import cn.jinelei.live.model.data.Category;
import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.data.ViRoomUserCategory;
import cn.jinelei.live.model.data.ViUserSubscribe;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
public interface ViUserSubscribeService {

    List<ViUserSubscribe> getAllViUserSubscribe();

    List<ViUserSubscribe> getAllViUserSubscribeLimit(Integer offset, Integer limit);

    PageInfo<ViUserSubscribe> getAllViUserSubscribePageInfo();


    List<ViUserSubscribe> getAllViUserSubscribeByUsername(String username);

    List<ViUserSubscribe> getAllViUserSubscribeByUsernameLimit(String username, Integer offset, Integer limit);

    PageInfo<ViUserSubscribe> getAllViUserSubscribeByUsernamePageInfo(String username);


    List<ViUserSubscribe> getAllViUserSubscribeByUserId(Integer userId);

    List<ViUserSubscribe> getAllViUserSubscribeByUserIdLimit(Integer userId, Integer offset, Integer limit);

    PageInfo<ViUserSubscribe> getAllViUserSubscribeByUserIdPageInfo(Integer userId);


    List<ViUserSubscribe> getAllViUserSubscribeByRoom(Room room);

    List<ViUserSubscribe> getAllViUserSubscribeByRoomLimit(Room room, Integer offset, Integer limit);

    PageInfo<ViUserSubscribe> getAllViUserSubscribeByRoomPageInfo(Room room);


    List<ViUserSubscribe> getAllViUserSubscribeByRoomId(Integer roomId);

    List<ViUserSubscribe> getAllViUserSubscribeByRoomIdLimit(Integer roomId, Integer offset, Integer limit);

    PageInfo<ViUserSubscribe> getAllViUserSubscribeByRoomIdPageInfo(Integer roomId);


    List<ViUserSubscribe> getAllViUserSubscribeByAnchorId(Integer anchorId);

    List<ViUserSubscribe> getAllViUserSubscribeByAnchorIdLimit(Integer anchorId, Integer offset, Integer limit);

    PageInfo<ViUserSubscribe> getAllViUserSubscribeByAnchorIdPageInfo(Integer anchorId);

}
