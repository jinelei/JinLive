package cn.jinelei.live.dao;

import cn.jinelei.live.model.TagCategory;
import cn.jinelei.live.model.TagCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagCategoryMapper {
    long countByExample(TagCategoryExample example);

    int deleteByExample(TagCategoryExample example);

    int deleteByPrimaryKey(Integer tagCategoryId);

    int insert(TagCategory record);

    int insertSelective(TagCategory record);

    List<TagCategory> selectByExample(TagCategoryExample example);

    TagCategory selectByPrimaryKey(Integer tagCategoryId);

    int updateByExampleSelective(@Param("record") TagCategory record, @Param("example") TagCategoryExample example);

    int updateByExample(@Param("record") TagCategory record, @Param("example") TagCategoryExample example);

    int updateByPrimaryKeySelective(TagCategory record);

    int updateByPrimaryKey(TagCategory record);
}