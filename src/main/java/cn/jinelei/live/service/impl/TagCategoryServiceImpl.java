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
@Service("tagService")
@Transactional
public class TagCategoryServiceImpl implements TagCategoryService {

    private static final Logger logger = LoggerFactory.getLogger(TagCategoryServiceImpl.class);

    @Autowired
    private TagCategoryMapper roomCategoryMapper;

    @Override
    public TagCategory insertTagCategory(Tag room, Category category) throws TagCategoryException {
        return insertTagCategory(room.getTagId(), category.getCategoryId());
    }

    @Override
    public TagCategory insertTagCategory(Integer roomId, Integer categoryId) throws TagCategoryException {
        TagCategory roomCategory = getTagCategory(roomId, categoryId);
        if (roomCategory != null)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_WAS_EXIST);
        roomCategory = new TagCategory();
        roomCategory.setCategoryId(categoryId);
        roomCategory.setTagId(roomId);
        int res = roomCategoryMapper.insertSelective(roomCategory);
        if (res != 1)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_INSERT_FAILED);
        return getTagCategory(roomId, categoryId);
    }

    @Override
    public boolean deleteTagCategory(Tag room, Category category) throws TagCategoryException {
        return deleteTagCategory(room.getTagId(), category.getCategoryId());
    }

    @Override
    public boolean deleteTagCategory(Integer roomId, Integer categoryId) throws TagCategoryException {
        TagCategory roomCategory = getTagCategory(roomId, categoryId);
        if (roomCategory == null)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_NOT_EXIST);
        int res = roomCategoryMapper.deleteByPrimaryKey(roomCategory);
        if (res != 1)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_DELETE_FAILED);
        return true;
    }

    @Override
    public TagCategory updateTagCategory(TagCategory tagCategory, Tag tag, Category category) throws TagCategoryException {
        return updateTagCategory(tagCategory.getTagCategoryId(), tag.getTagId(), category.getCategoryId());
    }

    @Override
    public TagCategory updateTagCategory(Integer roomCategoryId, Integer roomId, Integer categoryId) throws TagCategoryException {
        TagCategory roomCategory = getTagCategory(roomId, categoryId);
        if (roomCategory != null)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_WAS_EXIST);
        roomCategory = roomCategoryMapper.selectByPrimaryKey(roomCategoryId);
        roomCategory.setCategoryId(categoryId);
        roomCategory.setTagId(roomId);
        int res = roomCategoryMapper.updateByPrimaryKey(roomCategory);
        if (res != 1)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_INSERT_FAILED);
        return roomCategory;
    }

    @Override
    public TagCategory getTagCategory(Integer roomId, Integer categoryId) throws TagCategoryException {
        TagCategoryExample example = new TagCategoryExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId)
                .andTagIdEqualTo(roomId);
        List<TagCategory> roomCategories = roomCategoryMapper.selectByExample(example);
        if (roomCategories.size() > 1)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_NOT_UNIQUE);
        else if (roomCategories.size() < 1)
            throw new TagCategoryException(TagCategoryException.TAGCATEGORY_NOT_EXIST);
        return roomCategories.get(0);
    }

    @Override
    public TagCategory getTagCategory(Tag room, Category category) throws TagCategoryException {
        return getTagCategory(room.getTagId(), category.getCategoryId());
    }

    @Override
    public List<TagCategory> getTagCategoryByTagId(Integer roomId) {
        TagCategoryExample example = new TagCategoryExample();
        example.createCriteria().andTagIdEqualTo(roomId);
        return roomCategoryMapper.selectByExample(example);
    }

    @Override
    public List<TagCategory> getTagCategoryByCategoryId(Integer categoryId) {
        TagCategoryExample example = new TagCategoryExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        return roomCategoryMapper.selectByExample(example);
    }
}
