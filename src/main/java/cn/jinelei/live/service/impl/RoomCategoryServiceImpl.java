package cn.jinelei.live.service.impl;

import cn.jinelei.live.dao.RoomCategoryMapper;
import cn.jinelei.live.exception.RoomCategoryException;
import cn.jinelei.live.model.data.Category;
import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.data.RoomCategory;
import cn.jinelei.live.model.data.RoomCategoryExample;
import cn.jinelei.live.service.RoomCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
@Service("roomCategoryService")
@Transactional
public class RoomCategoryServiceImpl implements RoomCategoryService {

    private static final Logger logger = LoggerFactory.getLogger(RoomCategoryServiceImpl.class);

    @Autowired
    private RoomCategoryMapper roomCategoryMapper;

    @Override
    public RoomCategory insertRoomCategory(Room room, Category category) throws RoomCategoryException {
        return insertRoomCategory(room.getRoomId(), category.getCategoryId());
    }

    @Override
    public RoomCategory insertRoomCategory(Integer roomId, Integer categoryId) throws RoomCategoryException {
        RoomCategory roomCategory = null;
        int res = 0;
        try {
            roomCategory = getRoomCategory(roomId, categoryId);
        } catch (RoomCategoryException e) {
            if (e.getMessage().equals(RoomCategoryException.ROOMCATEGORY_NOT_EXIST)) {
                roomCategory = new RoomCategory();
                roomCategory.setCategoryId(categoryId);
                roomCategory.setRoomId(roomId);
                res = roomCategoryMapper.insertSelective(roomCategory);
            }
        }
        if (res != 1)
            throw new RoomCategoryException(RoomCategoryException.ROOMCATEGORY_INSERT_FAILED);
        return getRoomCategory(roomId, categoryId);
    }

    @Override
    public boolean deleteRoomCateGory(Room room, Category category) throws RoomCategoryException {
        return deleteRoomCateGory(room.getRoomId(), category.getCategoryId());
    }

    @Override
    public boolean deleteRoomCateGoryByRoomId(Integer roomId) throws RoomCategoryException {
        RoomCategoryExample example = new RoomCategoryExample();
        example.createCriteria().andRoomIdEqualTo(roomId);
        int res = roomCategoryMapper.deleteByExample(example);
        if (res != 1)
            throw new RoomCategoryException(RoomCategoryException.ROOMCATEGORY_DELETE_FAILED);
        return true;
    }

    @Override
    public boolean deleteRoomCateGory(Integer roomId, Integer categoryId) throws RoomCategoryException {
        RoomCategory roomCategory = getRoomCategory(roomId, categoryId);
        if (roomCategory == null)
            throw new RoomCategoryException(RoomCategoryException.ROOMCATEGORY_NOT_EXIST);
        int res = roomCategoryMapper.deleteByPrimaryKey(roomCategory);
        if (res != 1)
            throw new RoomCategoryException(RoomCategoryException.ROOMCATEGORY_DELETE_FAILED);
        return true;
    }

    @Override
    public RoomCategory updateRoomCategory(RoomCategory roomCategory, Room room, Category category) throws RoomCategoryException {
        return updateRoomCategory(roomCategory.getRoomCategoryId(), room.getRoomId(), category.getCategoryId());
    }

    @Override
    public RoomCategory updateRoomCategory(Integer roomCategoryId, Integer roomId, Integer categoryId) throws RoomCategoryException {
        RoomCategory roomCategory = getRoomCategory(roomId, categoryId);
        if (roomCategory != null)
            throw new RoomCategoryException(RoomCategoryException.ROOMCATEGORY_WAS_EXIST);
        roomCategory = roomCategoryMapper.selectByPrimaryKey(roomCategoryId);
        roomCategory.setCategoryId(categoryId);
        roomCategory.setRoomId(roomId);
        int res = roomCategoryMapper.updateByPrimaryKey(roomCategory);
        if (res != 1)
            throw new RoomCategoryException(RoomCategoryException.ROOMCATEGORY_INSERT_FAILED);
        return roomCategory;
    }

    @Override
    public RoomCategory getRoomCategory(Integer roomId, Integer categoryId) throws RoomCategoryException {
        RoomCategoryExample example = new RoomCategoryExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId)
                .andRoomIdEqualTo(roomId);
        List<RoomCategory> roomCategories = roomCategoryMapper.selectByExample(example);
        if (roomCategories.size() > 1)
            throw new RoomCategoryException(RoomCategoryException.ROOMCATEGORY_NOT_UNIQUE);
        else if (roomCategories.size() < 1)
            throw new RoomCategoryException(RoomCategoryException.ROOMCATEGORY_NOT_EXIST);
        return roomCategories.get(0);
    }

    @Override
    public RoomCategory getRoomCategory(Room room, Category category) throws RoomCategoryException {
        return getRoomCategory(room.getRoomId(), category.getCategoryId());
    }

    @Override
    public List<RoomCategory> getRoomCategoryByRoomId(Integer roomId) {
        RoomCategoryExample example = new RoomCategoryExample();
        example.createCriteria().andRoomIdEqualTo(roomId);
        return roomCategoryMapper.selectByExample(example);
    }

    @Override
    public List<RoomCategory> getRoomCategoryByCategoryId(Integer categoryId) {
        RoomCategoryExample example = new RoomCategoryExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        return roomCategoryMapper.selectByExample(example);
    }

    @Override
    public boolean insertOrUpdateRoomCategory(Integer roomId, Integer userId) {
        boolean result = true;
        try {
            if (getRoomCategoryByRoomId(roomId).size() != 0) {
                deleteRoomCateGoryByRoomId(roomId);
            }
            insertRoomCategory(roomId, userId);
        } catch (RoomCategoryException e) {
            result = false;
        }
        return result;
    }
}
