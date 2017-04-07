package cn.jinelei.live.service.impl;

import cn.jinelei.live.dao.TagCategoryMapper;
import cn.jinelei.live.exception.TagCategoryException;
import cn.jinelei.live.model.data.Category;
import cn.jinelei.live.model.data.Tag;
import cn.jinelei.live.model.data.TagCategory;
import cn.jinelei.live.model.data.TagCategoryExample;
import cn.jinelei.live.service.TagCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
@Service("tagCategoryService")
@Transactional
public class TagCategoryServiceImpl implements TagCategoryService {

    private static final Logger logger = LoggerFactory.getLogger(TagCategoryServiceImpl.class);

    @Autowired
    private TagCategoryMapper tagCategoryMapper;

    @Override
    public TagCategory insertTagCategory(Tag tag, Category category) throws TagCategoryException {
        return insertTagCategory(tag.getTagId(), category.getCategoryId());
    }

    @Override
    public TagCategory insertTagCategory(Integer tagId, Integer categoryId) throws TagCategoryException {
        TagCategory tagCategory = getTagCategory(tagId, categoryId);
        if (tagCategory != null)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_WAS_EXIST);
        tagCategory = new TagCategory();
        tagCategory.setCategoryId(categoryId);
        tagCategory.setTagId(tagId);
        int res = tagCategoryMapper.insertSelective(tagCategory);
        if (res != 1)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_INSERT_FAILED);
        return getTagCategory(tagId, categoryId);
    }

    @Override
    public boolean deleteTagCategory(Tag tag, Category category) throws TagCategoryException {
        return deleteTagCategory(tag.getTagId(), category.getCategoryId());
    }

    @Override
    public boolean deleteTagCategory(Integer tagId, Integer categoryId) throws TagCategoryException {
        TagCategory tagCategory = getTagCategory(tagId, categoryId);
        if (tagCategory == null)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_NOT_EXIST);
        int res = tagCategoryMapper.deleteByPrimaryKey(tagCategory);
        if (res != 1)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_DELETE_FAILED);
        return true;
    }

    @Override
    public TagCategory updateTagCategory(TagCategory tagCategory, Tag tag, Category category) throws TagCategoryException {
        return updateTagCategory(tagCategory.getTagCategoryId(), tag.getTagId(), category.getCategoryId());
    }

    @Override
    public TagCategory updateTagCategory(Integer tagCategoryId, Integer tagId, Integer categoryId) throws TagCategoryException {
        TagCategory tagCategory = getTagCategory(tagId, categoryId);
        if (tagCategory != null)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_WAS_EXIST);
        tagCategory = tagCategoryMapper.selectByPrimaryKey(tagCategoryId);
        tagCategory.setCategoryId(categoryId);
        tagCategory.setTagId(tagId);
        int res = tagCategoryMapper.updateByPrimaryKey(tagCategory);
        if (res != 1)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_INSERT_FAILED);
        return tagCategory;
    }

    @Override
    public TagCategory getTagCategory(Integer tagId, Integer categoryId) throws TagCategoryException {
        TagCategoryExample example = new TagCategoryExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId)
                .andTagIdEqualTo(tagId);
        List<TagCategory> tagCategories = tagCategoryMapper.selectByExample(example);
        if (tagCategories.size() > 1)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_NOT_UNIQUE);
        else if (tagCategories.size() < 1)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_NOT_EXIST);
        return tagCategories.get(0);
    }

    @Override
    public TagCategory getTagCategory(Tag tag, Category category) throws TagCategoryException {
        return getTagCategory(tag.getTagId(), category.getCategoryId());
    }

    @Override
    public List<TagCategory> getTagCategoryByTagId(Integer tagId) {
        TagCategoryExample example = new TagCategoryExample();
        example.createCriteria().andTagIdEqualTo(tagId);
        return tagCategoryMapper.selectByExample(example);
    }

    @Override
    public List<TagCategory> getTagCategoryByCategoryId(Integer categoryId) {
        TagCategoryExample example = new TagCategoryExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        return tagCategoryMapper.selectByExample(example);
    }
}
