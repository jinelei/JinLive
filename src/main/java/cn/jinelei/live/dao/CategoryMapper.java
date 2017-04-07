package cn.jinelei.live.dao;

import cn.jinelei.live.model.data.Category;
import cn.jinelei.live.model.data.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface CategoryMapper extends Mapper<Category> {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    List<Category> selectByExample(CategoryExample example);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);
}