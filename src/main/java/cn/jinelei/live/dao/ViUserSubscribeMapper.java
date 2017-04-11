package cn.jinelei.live.dao;

import cn.jinelei.live.model.data.ViUserSubscribe;
import cn.jinelei.live.model.data.ViUserSubscribeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface ViUserSubscribeMapper extends Mapper<ViUserSubscribe> {
    long countByExample(ViUserSubscribeExample example);

    int deleteByExample(ViUserSubscribeExample example);

    List<ViUserSubscribe> selectByExample(ViUserSubscribeExample example);

    int updateByExampleSelective(@Param("record") ViUserSubscribe record, @Param("example") ViUserSubscribeExample example);

    int updateByExample(@Param("record") ViUserSubscribe record, @Param("example") ViUserSubscribeExample example);
}