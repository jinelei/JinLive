package cn.jinelei.live.dao;

import cn.jinelei.live.model.data.TagCategory;
import cn.jinelei.live.model.data.TagCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface TagCategoryMapper extends Mapper<TagCategory> {
    long countByExample(TagCategoryExample example);

    int deleteByExample(TagCategoryExample example);

    List<TagCategory> selectByExample(TagCategoryExample example);

    int updateByExampleSelective(@Param("record") TagCategory record, @Param("example") TagCategoryExample example);

    int updateByExample(@Param("record") TagCategory record, @Param("example") TagCategoryExample example);
}