package cn.jinelei.live.dao;

import cn.jinelei.live.model.data.UserSubscribe;
import cn.jinelei.live.model.data.UserSubscribeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface UserSubscribeMapper extends Mapper<UserSubscribe> {
    long countByExample(UserSubscribeExample example);

    int deleteByExample(UserSubscribeExample example);

    List<UserSubscribe> selectByExample(UserSubscribeExample example);

    int updateByExampleSelective(@Param("record") UserSubscribe record, @Param("example") UserSubscribeExample example);

    int updateByExample(@Param("record") UserSubscribe record, @Param("example") UserSubscribeExample example);
}