package com.recommend_system.userlike.dao;

import com.recommend_system.userlike.entity.UserLikeExample;
import com.recommend_system.userlike.entity.UserLikeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLikeMapper {
    int countByExample(UserLikeExample example);

    int deleteByExample(UserLikeExample example);

    int deleteByPrimaryKey(UserLikeKey key);

    int insert(UserLikeKey record);

    int insertSelective(UserLikeKey record);

    List<UserLikeKey> selectByExample(UserLikeExample example);

    int updateByExampleSelective(@Param("record") UserLikeKey record, @Param("example") UserLikeExample example);

    int updateByExample(@Param("record") UserLikeKey record, @Param("example") UserLikeExample example);
}