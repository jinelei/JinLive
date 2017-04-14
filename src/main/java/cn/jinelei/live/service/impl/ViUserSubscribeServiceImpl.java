package cn.jinelei.live.service.impl;

import cn.jinelei.live.dao.ViUserSubscribeMapper;
import cn.jinelei.live.exception.CategoryException;
import cn.jinelei.live.exception.RoomException;
import cn.jinelei.live.model.data.Category;
import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.data.ViUserSubscribe;
import cn.jinelei.live.model.data.ViUserSubscribeExample;
import cn.jinelei.live.service.CategoryService;
import cn.jinelei.live.service.UserService;
import cn.jinelei.live.service.ViUserSubscribeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
@Service("viUserSubscribeService")
@Transactional
public class ViUserSubscribeServiceImpl implements ViUserSubscribeService {

    @Autowired
    private ViUserSubscribeMapper viUserSubscribeMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @Override
    public List<ViUserSubscribe> getAllViUserSubscribe() {
        return viUserSubscribeMapper.selectByExample(new ViUserSubscribeExample());
    }

    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeLimit(Integer offset, Integer limit) {
        PageInfo<ViUserSubscribe> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            viUserSubscribeMapper.selectByExample(new ViUserSubscribeExample());
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<ViUserSubscribe> getAllViUserSubscribePageInfo() {
        ViUserSubscribeExample example = new ViUserSubscribeExample();
        return new PageInfo<ViUserSubscribe>(viUserSubscribeMapper.selectByExample(example));
    }

    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeByUsername(String username) {
        ViUserSubscribeExample example = new ViUserSubscribeExample();
        example.createCriteria().andUserNameEqualTo(username);
        return viUserSubscribeMapper.selectByExample(example);
    }

    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeByUsernameLimit(String username, Integer offset, Integer limit) {
        PageInfo<ViUserSubscribe> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            ViUserSubscribeExample example = new ViUserSubscribeExample();
            example.createCriteria().andUserNameEqualTo(username);
            viUserSubscribeMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<ViUserSubscribe> getAllViUserSubscribeByUsernamePageInfo(String username) {
        ViUserSubscribeExample example = new ViUserSubscribeExample();
        example.createCriteria().andUserNameEqualTo(username);
        return new PageInfo<ViUserSubscribe>(viUserSubscribeMapper.selectByExample(example));
    }

    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeByUserId(Integer userId) {
        ViUserSubscribeExample example = new ViUserSubscribeExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return viUserSubscribeMapper.selectByExample(example);
    }


    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeByUserIdLimit(Integer userId, Integer offset, Integer limit) {
        PageInfo<ViUserSubscribe> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            ViUserSubscribeExample example = new ViUserSubscribeExample();
            example.createCriteria().andUserIdEqualTo(userId);
            viUserSubscribeMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<ViUserSubscribe> getAllViUserSubscribeByUserIdPageInfo(Integer userId) {
        ViUserSubscribeExample example = new ViUserSubscribeExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return new PageInfo<ViUserSubscribe>(viUserSubscribeMapper.selectByExample(example));
    }

    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeByRoom(Room room) {
        return getAllViUserSubscribeByRoomId(room.getRoomId());
    }

    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeByRoomLimit(Room room, Integer offset, Integer limit) {
        return getAllViUserSubscribeByRoomIdLimit(room.getRoomId(), offset, limit);
    }

    @Override
    public PageInfo<ViUserSubscribe> getAllViUserSubscribeByRoomPageInfo(Room room) {
        return getAllViUserSubscribeByRoomIdPageInfo(room.getRoomId());
    }

    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeByRoomId(Integer roomId) {
        ViUserSubscribeExample example = new ViUserSubscribeExample();
        example.createCriteria().andRoomIdEqualTo(roomId);
        return viUserSubscribeMapper.selectByExample(example);
    }

    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeByRoomIdLimit(Integer roomId, Integer offset, Integer limit) {
        PageInfo<ViUserSubscribe> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            ViUserSubscribeExample example = new ViUserSubscribeExample();
            example.createCriteria().andRoomIdEqualTo(roomId);
            viUserSubscribeMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<ViUserSubscribe> getAllViUserSubscribeByRoomIdPageInfo(Integer roomId) {
        ViUserSubscribeExample example = new ViUserSubscribeExample();
        example.createCriteria().andRoomIdEqualTo(roomId);
        return new PageInfo<ViUserSubscribe>(viUserSubscribeMapper.selectByExample(example));
    }

    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeByAnchorId(Integer anchorId) {
        ViUserSubscribeExample example = new ViUserSubscribeExample();
        example.createCriteria().andUserIdEqualTo(anchorId);
        return viUserSubscribeMapper.selectByExample(example);
    }

    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeByAnchorIdLimit(Integer anchorId, Integer offset, Integer limit) {
        PageInfo<ViUserSubscribe> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            ViUserSubscribeExample example = new ViUserSubscribeExample();
            example.createCriteria().andUserIdEqualTo(anchorId);
            viUserSubscribeMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<ViUserSubscribe> getAllViUserSubscribeByAnchorIdPageInfo(Integer anchorId) {
        ViUserSubscribeExample example = new ViUserSubscribeExample();
        example.createCriteria().andUserIdEqualTo(anchorId);
        return new PageInfo<ViUserSubscribe>(viUserSubscribeMapper.selectByExample(example));
    }


    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeBySubscriberId(Integer subscriberId) {
        ViUserSubscribeExample example = new ViUserSubscribeExample();
        example.createCriteria().andSubscriberIdEqualTo(subscriberId);
        return viUserSubscribeMapper.selectByExample(example);
    }

    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeBySubscriberIdLimit(Integer subscriberId, Integer offset, Integer limit) {
        PageInfo<ViUserSubscribe> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            ViUserSubscribeExample example = new ViUserSubscribeExample();
            example.createCriteria().andSubscriberIdEqualTo(subscriberId);
            viUserSubscribeMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<ViUserSubscribe> getAllViUserSubscribeBySubscriberIdPageInfo(Integer subscriberId) {
        ViUserSubscribeExample example = new ViUserSubscribeExample();
        example.createCriteria().andSubscriberIdEqualTo(subscriberId);
        return new PageInfo<ViUserSubscribe>(viUserSubscribeMapper.selectByExample(example));
    }

    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeByRoomStatus(Integer roomStatus) {
        ViUserSubscribeExample example = new ViUserSubscribeExample();
        example.createCriteria().andRoomStatusEqualTo(roomStatus);
        return viUserSubscribeMapper.selectByExample(example);
    }

    @Override
    public List<ViUserSubscribe> getAllViUserSubscribeByRoomStatusLimit(Integer roomStatus, Integer offset, Integer limit) {
        PageInfo<ViUserSubscribe> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            ViUserSubscribeExample example = new ViUserSubscribeExample();
            example.createCriteria().andRoomStatusEqualTo(roomStatus);
            viUserSubscribeMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<ViUserSubscribe> getAllViUserSubscribeByRoomStatusPageInfo(Integer roomStatus) {
        ViUserSubscribeExample example = new ViUserSubscribeExample();
        example.createCriteria().andRoomStatusEqualTo(roomStatus);
        return new PageInfo<ViUserSubscribe>(viUserSubscribeMapper.selectByExample(example));
    }
}


