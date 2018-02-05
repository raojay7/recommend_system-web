package com.recommend_system.user.dao;

import com.recommend_system.user.entity.UserJobIntension;
import com.recommend_system.user.entity.UserJobIntensionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserJobIntensionMapper {
    int countByExample(UserJobIntensionExample example);

    int deleteByExample(UserJobIntensionExample example);

    int deleteByPrimaryKey(Integer intensionId);

    int insert(UserJobIntension record);

    int insertSelective(UserJobIntension record);

    List<UserJobIntension> selectByExample(UserJobIntensionExample example);

    UserJobIntension selectByPrimaryKey(Integer intensionId);

    int updateByExampleSelective(@Param("record") UserJobIntension record, @Param("example") UserJobIntensionExample example);

    int updateByExample(@Param("record") UserJobIntension record, @Param("example") UserJobIntensionExample example);

    int updateByPrimaryKeySelective(UserJobIntension record);

    int updateByPrimaryKey(UserJobIntension record);
}