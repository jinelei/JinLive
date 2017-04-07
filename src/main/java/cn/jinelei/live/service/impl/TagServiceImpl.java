package cn.jinelei.live.service.impl;

import cn.jinelei.live.dao.TagMapper;
import cn.jinelei.live.exception.TagException;
import cn.jinelei.live.model.data.Tag;
import cn.jinelei.live.model.data.TagExample;
import cn.jinelei.live.service.TagService;
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
public class TagServiceImpl implements TagService {

    private static final Logger logger = LoggerFactory.getLogger(TagServiceImpl.class);

    @Autowired
    private TagMapper tagMapper;

    @Override
    public Tag insertTag(Tag tag) throws TagException {
        return insertTag(tag.getTagName());
    }

    @Override
    public Tag insertTag(String tagName) throws TagException {
        List<Tag> tags = getTagFuzzyTagName(tagName);
        if (tags.size() > 0)
            throw new TagException(TagException.TAG_WAS_EXIST);
        Tag tag = new Tag();
        tag.setTagName(tagName);
        int res = tagMapper.insert(tag);
        if (res != 1)
            throw new TagException(TagException.TAG_INSERT_FAILED);
        tags = getTagFuzzyTagName(tagName);
        if (tags.size() > 1)
            throw new TagException(TagException.TAG_WAS_EXIST);
        else if (tags.size() < 1)
            throw new TagException(TagException.TAG_NOT_EXIST);
        return tags.get(0);
    }

    @Override
    public boolean deleteTag(Tag tag) throws TagException {
        return deletaTag(tag.getTagId());
    }

    @Override
    public boolean deletaTag(Integer tagId) throws TagException {
        Tag tag = getTag(tagId);
        int res = tagMapper.delete(tag);
        if (res != 1)
            throw new TagException(TagException.TAG_DELETE_FAILED);
        return true;
    }

    @Override
    public Tag update(Tag tag) throws TagException {
        List<Tag> tags = getTagFuzzyTagName(tag.getTagName());
        if (tags.size() > 0)
            throw new TagException(TagException.TAG_WAS_EXIST);
        int res = tagMapper.updateByPrimaryKey(tag);
        if (res != 1)
            throw new TagException(TagException.TAG_UPDATE_FAILED);
        return tag;
    }

    @Override
    public Tag getTag(Integer tagId) throws TagException {
        Tag tag = tagMapper.selectByPrimaryKey(tagId);
        if (tag == null)
            throw new TagException(TagException.TAG_NOT_EXIST);
        return tag;
    }

    @Override
    public List<Tag> getTagFuzzyTagName(String tagName) {
        TagExample example = new TagExample();
        example.createCriteria().andTagNameLike(tagName);
        return tagMapper.selectByExample(example);
    }

    @Override
    public List<Tag> getTagAll() {
        return tagMapper.selectByExample(new TagExample());
    }
}
