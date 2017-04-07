package cn.jinelei.live.service.impl;

import cn.jinelei.live.dao.CategoryMapper;
import cn.jinelei.live.exception.CategoryException;
import cn.jinelei.live.model.data.Category;
import cn.jinelei.live.model.data.CategoryExample;
import cn.jinelei.live.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
@Service("tagService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category insertCategory(Category category) throws CategoryException {
        return insertCategory(category.getCategoryName(), category.getCategoryIntroduce());
    }

    @Override
    public Category insertCategory(String categoryName, String categoryIntroduce) throws CategoryException {
        List<Category> categories = getCategoryFuzzyName(categoryName);
        if (categories.size() > 0)
            throw new CategoryException(CategoryException.CATEGORY_WAS_EXIST);
        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setCategoryIntroduce(categoryIntroduce);
        int res = categoryMapper.insertSelective(category);
        if (res != 1)
            throw new CategoryException(CategoryException.CATEGORY_INSERT_FAILED);
        categories = getCategoryFuzzyName(categoryName);
        return categories.get(0);
    }

    @Override
    public boolean deleteCategory(Category category) throws CategoryException {
        return deleteCategory(category.getCategoryId());
    }

    @Override
    public boolean deleteCategory(Integer categoryId) throws CategoryException {
        int res = categoryMapper.deleteByPrimaryKey(categoryId);
        if (res !=1)
            throw new CategoryException(CategoryException.CATEGORY_DELETE_FAILED);
        return true;
    }

    @Override
    public Category updateCategory(Category category) throws CategoryException {
        CategoryExample example = new CategoryExample();
        example.createCriteria().andCategoryIdEqualTo(category.getCategoryId());
        int res = categoryMapper.updateByExampleSelective(category,example);
        if (res !=1)
            throw new CategoryException(CategoryException.CATEGORY_UPDATE_FAILED);
        return categoryMapper.selectByPrimaryKey(category.getCategoryId());
    }

    @Override
    public Category updateCategory(Integer categoryId, String categoryName, String categoryIntroduce) throws CategoryException {
        Category category = new Category();
        category.setCategoryId(categoryId);
        category.setCategoryName(categoryName);
        category.setCategoryIntroduce(categoryIntroduce);
        return updateCategory(category);
    }

    @Override
    public Category getCategory(Integer categoryId) throws CategoryException {
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category == null)
            throw new CategoryException(CategoryException.CATEGORY_NOT_EXIST);
        return category;
    }

    @Override
    public List<Category> getCategoryFuzzyName(String categoryName) {
        CategoryExample example = new CategoryExample();
        example.createCriteria().andCategoryNameLike(categoryName);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<Category> getCategoryFuzzyIntroduce(String categoryIntroduce) {
        CategoryExample example = new CategoryExample();
        example.createCriteria().andCategoryIntroduceLike(categoryIntroduce);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<Category> getCategoryAll() {
        return categoryMapper.selectByExample(new CategoryExample());
    }
}
