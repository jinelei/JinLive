package cn.jinelei.live.dao;

import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.data.RoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface RoomMapper extends Mapper<Room> {
    long countByExample(RoomExample example);

    int deleteByExample(RoomExample example);

    List<Room> selectByExample(RoomExample example);

    int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);
}