package cn.jinelei.live.service;

import cn.jinelei.live.exception.TagException;
import cn.jinelei.live.model.data.Tag;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
public interface TagService {

    Tag insertTag(Tag tag) throws TagException;

    Tag insertTag(String tagName) throws TagException;

    boolean deleteTag(Tag tag) throws TagException;

    boolean deletaTag(Integer tagId) throws TagException;

    Tag update(Tag tag) throws TagException;

    Tag getTag(Integer tagId) throws TagException;

    List<Tag> getTagFuzzyTagName(String tagName);

    List<Tag> getTagAll();
}
