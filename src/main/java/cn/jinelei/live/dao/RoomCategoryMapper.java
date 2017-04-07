package cn.jinelei.live.dao;

import cn.jinelei.live.model.RoomCategory;
import cn.jinelei.live.model.RoomCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomCategoryMapper {
    int countByExample(RoomCategoryExample example);

    int deleteByExample(RoomCategoryExample example);

    int deleteByPrimaryKey(Integer roomCategoryId);

    int insert(RoomCategory record);

    int insertSelective(RoomCategory record);

    List<RoomCategory> selectByExample(RoomCategoryExample example);

    RoomCategory selectByPrimaryKey(Integer roomCategoryId);

    int updateByExampleSelective(@Param("record") RoomCategory record, @Param("example") RoomCategoryExample example);

    int updateByExample(@Param("record") RoomCategory record, @Param("example") RoomCategoryExample example);

    int updateByPrimaryKeySelective(RoomCategory record);

    int updateByPrimaryKey(RoomCategory record);
}