package com.recommend_system.hotsearch.dao;

import com.recommend_system.hotsearch.entity.HotSearch;
import com.recommend_system.hotsearch.entity.HotSearchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotSearchMapper {
    int countByExample(HotSearchExample example);

    int deleteByExample(HotSearchExample example);

    int deleteByPrimaryKey(Integer hotsearchId);

    int insert(HotSearch record);

    int insertSelective(HotSearch record);

    List<HotSearch> selectByExample(HotSearchExample example);

    HotSearch selectByPrimaryKey(Integer hotsearchId);

    int updateByExampleSelective(@Param("record") HotSearch record, @Param("example") HotSearchExample example);

    int updateByExample(@Param("record") HotSearch record, @Param("example") HotSearchExample example);

    int updateByPrimaryKeySelective(HotSearch record);

    int updateByPrimaryKey(HotSearch record);
}