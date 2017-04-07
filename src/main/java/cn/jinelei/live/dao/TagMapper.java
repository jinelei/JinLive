package cn.jinelei.live.dao;

import cn.jinelei.live.model.data.Tag;
import cn.jinelei.live.model.data.TagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface TagMapper extends Mapper<Tag> {
    long countByExample(TagExample example);

    int deleteByExample(TagExample example);

    List<Tag> selectByExample(TagExample example);

    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);
}