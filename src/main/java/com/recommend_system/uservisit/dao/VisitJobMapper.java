package com.recommend_system.uservisit.dao;

import com.recommend_system.uservisit.entity.VisitJob;
import com.recommend_system.uservisit.entity.VisitJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisitJobMapper {
    int countByExample(VisitJobExample example);

    int deleteByExample(VisitJobExample example);

    int deleteByPrimaryKey(Integer visistedJobId);

    int insert(VisitJob record);

    int insertSelective(VisitJob record);

    List<VisitJob> selectByExampleWithBLOBs(VisitJobExample example);

    List<VisitJob> selectByExample(VisitJobExample example);

    VisitJob selectByPrimaryKey(Integer visistedJobId);

    int updateByExampleSelective(@Param("record") VisitJob record, @Param("example") VisitJobExample example);

    int updateByExampleWithBLOBs(@Param("record") VisitJob record, @Param("example") VisitJobExample example);

    int updateByExample(@Param("record") VisitJob record, @Param("example") VisitJobExample example);

    int updateByPrimaryKeySelective(VisitJob record);

    int updateByPrimaryKeyWithBLOBs(VisitJob record);

    int updateByPrimaryKey(VisitJob record);
}