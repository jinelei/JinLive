package cn.jinelei.live.service;

import cn.jinelei.live.exception.RoomCategoryException;
import cn.jinelei.live.model.data.Category;
import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.data.RoomCategory;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
public interface RoomCategoryService {

    RoomCategory insertRoomCategory(Room room, Category category) throws RoomCategoryException;

    RoomCategory insertRoomCategory(Integer roomId, Integer categoryId) throws RoomCategoryException;

    boolean deleteRoomCateGoryByRoomId(Integer roomId) throws RoomCategoryException;

    boolean deleteRoomCateGory(Room room, Category category) throws RoomCategoryException;

    boolean deleteRoomCateGory(Integer roomId, Integer categoryId) throws RoomCategoryException;

    RoomCategory updateRoomCategory(RoomCategory roomCategory, Room room, Category category) throws RoomCategoryException;

    RoomCategory updateRoomCategory(Integer roomCategoryId, Integer roomId, Integer categoryId) throws RoomCategoryException;

    RoomCategory getRoomCategory(Integer roomId, Integer categoryId) throws RoomCategoryException;

    RoomCategory getRoomCategory(Room room, Category category) throws RoomCategoryException;

    List<RoomCategory> getRoomCategoryByRoomId(Integer roomId);

    List<RoomCategory> getRoomCategoryByCategoryId(Integer categoryId);

    boolean insertOrUpdateRoomCategory(Integer roomId, Integer integer);
}
