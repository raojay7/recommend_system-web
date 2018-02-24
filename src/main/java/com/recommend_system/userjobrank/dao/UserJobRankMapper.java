package com.recommend_system.userjobrank.dao;

import com.recommend_system.userjobrank.entity.UserJobRank;
import com.recommend_system.userjobrank.entity.UserJobRankExample;
import com.recommend_system.userjobrank.entity.UserJobRankKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserJobRankMapper {
    int countByExample(UserJobRankExample example);

    int deleteByExample(UserJobRankExample example);

    int deleteByPrimaryKey(UserJobRankKey key);

    int insert(UserJobRank record);

    int insertSelective(UserJobRank record);

    List<UserJobRank> selectByExample(UserJobRankExample example);

    UserJobRank selectByPrimaryKey(UserJobRankKey key);

    int updateByExampleSelective(@Param("record") UserJobRank record, @Param("example") UserJobRankExample example);

    int updateByExample(@Param("record") UserJobRank record, @Param("example") UserJobRankExample example);

    int updateByPrimaryKeySelective(UserJobRank record);

    int updateByPrimaryKey(UserJobRank record);
}