package cn.jinelei.live.service;

import cn.jinelei.live.exception.CategoryException;
import cn.jinelei.live.exception.RoomException;
import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.Category;
import cn.jinelei.live.model.data.User;
import cn.jinelei.live.model.data.ViRoomUserCategory;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
public interface ViRoomUserCategoryService {

    List<ViRoomUserCategory> getAllViRoomUserCategory();

    List<ViRoomUserCategory> getAllViRoomUserCategoryLimit(Integer offset, Integer limit);

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryPageInfo();


    List<ViRoomUserCategory> getAllViRoomUserCategoryByStatus(Integer roomStatus);

    List<ViRoomUserCategory> getAllViRoomUserCategoryByStatusLimit(Integer roomStatus, Integer offset, Integer limit);

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByStatusPageInfo(Integer roomStatus);


    List<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyRoomIntroduce(String introduce);

    List<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyRoomIntroduceLimit(String introduce, Integer offset, Integer limit);

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyRoomIntroducePageInfo(String introduce);


    List<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyUsername(String username);

    List<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyUsernameLimit(String username, Integer offset, Integer limit);

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyUsernamePageInfo(String username);


    ViRoomUserCategory getViRoomUserCategoryByUserId(Integer userId) throws RoomException;

    ViRoomUserCategory getViRoomUserCategoryByRoomId(Integer roomId) throws RoomException;

    ViRoomUserCategory getViRoomUserCategoryByStreamKey(String streamKey) throws RoomException;


    List<ViRoomUserCategory> getAllViRoomUserCategoryByCategory(Integer categoryId);

    List<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryLimit(Integer categoryId, Integer offset, Integer limit);

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryPageInfo(Integer categoryId);


    List<ViRoomUserCategory> getAllViRoomUserCategoryByCategory(String categoryName) throws CategoryException;

    List<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryLimit(String categoryName, Integer offset, Integer limit) throws CategoryException;

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryPageInfo(String categoryName) throws CategoryException;


    List<ViRoomUserCategory> getAllViRoomUserCategoryByCategory(Category category);

    List<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryLimit(Category category, Integer offset, Integer limit);

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryPageInfo(Category category);


    List<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyRoomName(String roomName);

    List<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyRoomNameLimit(String roomName, Integer offset, Integer limit);

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyRoomNamePageInfo(String roomName);


}
