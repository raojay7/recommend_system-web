package com.recommend_system.uservisitdetail.dao;

import com.recommend_system.uservisitdetail.entity.VisitDetail;
import com.recommend_system.uservisitdetail.entity.VisitDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisitDetailMapper {
    int countByExample(VisitDetailExample example);

    int deleteByExample(VisitDetailExample example);

    int deleteByPrimaryKey(Integer visitedDetailId);

    int insert(VisitDetail record);

    int insertSelective(VisitDetail record);

    List<VisitDetail> selectByExample(VisitDetailExample example);

    VisitDetail selectByPrimaryKey(Integer visitedDetailId);

    int updateByExampleSelective(@Param("record") VisitDetail record, @Param("example") VisitDetailExample example);

    int updateByExample(@Param("record") VisitDetail record, @Param("example") VisitDetailExample example);

    int updateByPrimaryKeySelective(VisitDetail record);

    int updateByPrimaryKey(VisitDetail record);
}