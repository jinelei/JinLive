package cn.jinelei.live.service.impl;

import cn.jinelei.live.dao.ViRoomUserCategoryMapper;
import cn.jinelei.live.exception.CategoryException;
import cn.jinelei.live.exception.RoomException;
import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.*;
import cn.jinelei.live.service.CategoryService;
import cn.jinelei.live.service.UserService;
import cn.jinelei.live.service.ViRoomUserCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
@Service("viRoomUserCategoryService")
@Transactional
public class ViRoomUserCategoryServiceImpl implements ViRoomUserCategoryService {

    @Autowired
    private ViRoomUserCategoryMapper viRoomUserCategoryMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategory() {
        return viRoomUserCategoryMapper.selectByExample(new ViRoomUserCategoryExample());
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryLimit(Integer offset, Integer limit) {
        PageInfo<ViRoomUserCategory> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            viRoomUserCategoryMapper.selectByExample(new ViRoomUserCategoryExample());
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryPageInfo() {
        ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
        return new PageInfo<ViRoomUserCategory>(viRoomUserCategoryMapper.selectByExample(example));
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryByStatus(Integer roomStatus) {
        ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
        example.createCriteria().andRoomStatusEqualTo(roomStatus);
        return viRoomUserCategoryMapper.selectByExample(example);
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryByStatusLimit(Integer roomStatus, Integer offset, Integer limit) {
        PageInfo<ViRoomUserCategory> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
            example.createCriteria().andRoomStatusEqualTo(roomStatus);
            viRoomUserCategoryMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByStatusPageInfo(Integer roomStatus) {
        ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
        example.createCriteria().andRoomStatusEqualTo(roomStatus);
        return new PageInfo<ViRoomUserCategory>(viRoomUserCategoryMapper.selectByExample(example));
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyName(String name) {
        ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
        example.createCriteria().andRoomNameLike(name);
        return viRoomUserCategoryMapper.selectByExample(example);
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyNameLimit(String name, Integer offset, Integer limit) {
        PageInfo<ViRoomUserCategory> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
            example.createCriteria().andRoomNameLike(name);
            viRoomUserCategoryMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyNamePageInfo(String name) {
        ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
        example.createCriteria().andRoomNameLike(name);
        return new PageInfo<ViRoomUserCategory>(viRoomUserCategoryMapper.selectByExample(example));
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyIntroduce(String introduce) {
        ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
        example.createCriteria().andRoomIntroduceLike(introduce);
        return viRoomUserCategoryMapper.selectByExample(example);
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyIntroduceLimit(String introduce, Integer offset, Integer limit) {
        PageInfo<ViRoomUserCategory> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
            example.createCriteria().andRoomIntroduceLike(introduce);
            viRoomUserCategoryMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryFuzzyIntroducePageInfo(String introduce) {
        ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
        example.createCriteria().andRoomIntroduceLike(introduce);
        return new PageInfo<ViRoomUserCategory>(viRoomUserCategoryMapper.selectByExample(example));
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryByUser(String username) throws UserException {
        User user = userService.getUserInfo(username);
        return getAllViRoomUserCategoryByUser(user.getUserId());
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryByUserLimit(String username, Integer offset, Integer limit) throws UserException {
        User user = userService.getUserInfo(username);
        return getAllViRoomUserCategoryByUserLimit(user.getUserId(), offset, limit);
    }

    @Override
    public PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByUserPageInfo(String username) throws UserException {
        User user = userService.getUserInfo(username);
        return getAllViRoomUserCategoryByUserPageInfo(user.getUserId());
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryByUser(Integer userId) {
        ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return viRoomUserCategoryMapper.selectByExample(example);
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryByUserLimit(Integer userId, Integer offset, Integer limit) {
        PageInfo<ViRoomUserCategory> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
            example.createCriteria().andUserIdEqualTo(userId);
            viRoomUserCategoryMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByUserPageInfo(Integer userId) {
        ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return new PageInfo<ViRoomUserCategory>(viRoomUserCategoryMapper.selectByExample(example));
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryByUser(User user) {
        return getAllViRoomUserCategoryByUser(user.getUserId());
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryByUserLimit(User user, Integer offset, Integer limit) {
        return getAllViRoomUserCategoryByUserLimit(user.getUserId(), offset, limit);
    }

    @Override
    public PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByUserPageInfo(User user) {
        return getAllViRoomUserCategoryByUserPageInfo(user.getUserId());
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryByCategory(Integer categoryId) {
        ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        return viRoomUserCategoryMapper.selectByExample(example);
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryLimit(Integer categoryId, Integer offset, Integer limit) {
        PageInfo<ViRoomUserCategory> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
            example.createCriteria().andCategoryIdEqualTo(categoryId);
            viRoomUserCategoryMapper.selectByExample(example);
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryPageInfo(Integer categoryId) {
        ViRoomUserCategoryExample example = new ViRoomUserCategoryExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        return new PageInfo<ViRoomUserCategory>(viRoomUserCategoryMapper.selectByExample(example));
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryByCategory(String categoryName) throws CategoryException {
        List<Category> categorys = categoryService.getCategoryFuzzyName(categoryName);
        if (categorys.size() != 1)
            throw new CategoryException(CategoryException.CATEGORY_NOT_UNIQUE);
        return getAllViRoomUserCategoryByCategory(categorys.get(0).getCategoryId());
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryLimit(String categoryName, Integer offset, Integer limit) throws CategoryException {
        List<Category> categorys = categoryService.getCategoryFuzzyName(categoryName);
        if (categorys.size() != 1)
            throw new CategoryException(CategoryException.CATEGORY_NOT_UNIQUE);
        return getAllViRoomUserCategoryByCategoryLimit(categorys.get(0).getCategoryId(), offset, limit);
    }

    @Override
    public PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryPageInfo(String categoryName) throws CategoryException {
        List<Category> categorys = categoryService.getCategoryFuzzyName(categoryName);
        if (categorys.size() != 1)
            throw new CategoryException(CategoryException.CATEGORY_NOT_UNIQUE);
        return getAllViRoomUserCategoryByCategoryPageInfo(categorys.get(0).getCategoryId());
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryByCategory(Category category) {
        return getAllViRoomUserCategoryByCategory(category.getCategoryId());
    }

    @Override
    public List<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryLimit(Category category, Integer offset, Integer limit) {
        return getAllViRoomUserCategoryByCategoryLimit(category.getCategoryId(), offset, limit);
    }

    @Override
    public PageInfo<ViRoomUserCategory> getAllViRoomUserCategoryByCategoryPageInfo(Category category) {
        return getAllViRoomUserCategoryByCategoryPageInfo(category.getCategoryId());
    }


}
