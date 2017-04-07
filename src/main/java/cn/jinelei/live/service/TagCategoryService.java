package cn.jinelei.live.service;

import cn.jinelei.live.exception.TagCategoryException;
import cn.jinelei.live.model.data.Category;
import cn.jinelei.live.model.data.Tag;
import cn.jinelei.live.model.data.TagCategory;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
public interface TagCategoryService {

    TagCategory insertTagCategory(Integer tagId, Integer categoryId) throws TagCategoryException;

    TagCategory insertTagCategory(Tag tag, Category category) throws TagCategoryException;

    TagCategory updateTagCategory(Integer tagCategoryId, Integer tagId, Integer categoryId) throws TagCategoryException;

    TagCategory updateTagCategory(TagCategory tagCategory, Tag tag, Category category) throws TagCategoryException;

    boolean deleteTagCategory(Integer tagId, Integer categoryId) throws TagCategoryException;

    boolean deleteTagCategory(Tag tag, Category category) throws TagCategoryException;

    TagCategory getTagCategory(Integer tagId, Integer categoryId) throws TagCategoryException;

    TagCategory getTagCategory(Tag tag, Category category) throws TagCategoryException;

    List<TagCategory> getTagCategoryByTagId(Integer tagId);

    List<TagCategory> getTagCategoryByCategoryId(Integer categoryId);
}
