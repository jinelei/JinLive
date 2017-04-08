package cn.jinelei.live.dao;

import cn.jinelei.live.model.data.ViRoomUserCategory;
import cn.jinelei.live.model.data.ViRoomUserCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface ViRoomUserCategoryMapper extends Mapper<ViRoomUserCategory> {
    long countByExample(ViRoomUserCategoryExample example);

    int deleteByExample(ViRoomUserCategoryExample example);

    List<ViRoomUserCategory> selectByExample(ViRoomUserCategoryExample example);

    int updateByExampleSelective(@Param("record") ViRoomUserCategory record, @Param("example") ViRoomUserCategoryExample example);

    int updateByExample(@Param("record") ViRoomUserCategory record, @Param("example") ViRoomUserCategoryExample example);
}