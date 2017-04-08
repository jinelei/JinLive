package cn.jinelei.live.service;

import cn.jinelei.live.exception.CategoryException;
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

    List<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyName(String name);

    List<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyNameLimit(String name, Integer offset, Integer limit);

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyNamePageInfo(String name);

    List<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyIntroduce(String introduce);

    List<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyIntroduceLimit(String introduce, Integer offset, Integer limit);

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyIntroducePageInfo(String introduce);

    List<ViRoomUserCategory> getAllViRoomUserCategoryByUser(String username) throws UserException;

    List<ViRoomUserCategory> getAllViRoomUserCategoryByUserLimit(String username, Integer offset, Integer limit) throws UserException;

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByUserPageInfo(String username) throws UserException;

    List<ViRoomUserCategory> getAllViRoomUserCategoryByUser(Integer userId);

    List<ViRoomUserCategory> getAllViRoomUserCategoryByUserLimit(Integer userId, Integer offset, Integer limit);

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByUserPageInfo(Integer userId);

    List<ViRoomUserCategory> getAllViRoomUserCategoryByUser(User user);

    List<ViRoomUserCategory> getAllViRoomUserCategoryByUserLimit(User user, Integer offset, Integer limit);

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByUserPageInfo(User user);

    List<ViRoomUserCategory> getAllViRoomUserCategoryByCategory(Integer categoryId);

    List<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryLimit(Integer categoryId, Integer offset, Integer limit);

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryPageInfo(Integer categoryId);

    List<ViRoomUserCategory> getAllViRoomUserCategoryByCategory(String categoryName) throws CategoryException;

    List<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryLimit(String categoryName, Integer offset, Integer limit) throws CategoryException;

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryPageInfo(String categoryName) throws CategoryException;

    List<ViRoomUserCategory> getAllViRoomUserCategoryByCategory(Category category);

    List<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryLimit(Category category, Integer offset, Integer limit);

    PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryPageInfo(Category category);

}
