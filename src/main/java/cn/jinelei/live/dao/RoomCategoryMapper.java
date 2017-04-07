package cn.jinelei.live.dao;

import cn.jinelei.live.model.data.RoomCategory;
import cn.jinelei.live.model.data.RoomCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface RoomCategoryMapper extends Mapper<RoomCategory> {
    long countByExample(RoomCategoryExample example);

    int deleteByExample(RoomCategoryExample example);

    List<RoomCategory> selectByExample(RoomCategoryExample example);

    int updateByExampleSelective(@Param("record") RoomCategory record, @Param("example") RoomCategoryExample example);

    int updateByExample(@Param("record") RoomCategory record, @Param("example") RoomCategoryExample example);
}