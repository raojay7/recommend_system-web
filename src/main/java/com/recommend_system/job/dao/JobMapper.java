package com.recommend_system.job.dao;

import com.recommend_system.job.entity.Job;
import com.recommend_system.job.entity.JobExample;
import java.util.List;

import com.recommend_system.job.entity.JobExt;
import org.apache.ibatis.annotations.Param;

public interface JobMapper {
    int countByExample(JobExample example);

    int deleteByExample(JobExample example);

    int deleteByPrimaryKey(Integer jobId);

    int insert(Job record);

    int insertSelective(Job record);

    List<Job> selectByExampleWithBLOBs(JobExample example);

    List<Job> selectByExample(JobExample example);

    Job selectByPrimaryKey(Integer jobId);

    int updateByExampleSelective(@Param("record") Job record, @Param("example") JobExample example);

    int updateByExampleWithBLOBs(@Param("record") Job record, @Param("example") JobExample example);

    int updateByExample(@Param("record") Job record, @Param("example") JobExample example);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKeyWithBLOBs(Job record);

    int updateByPrimaryKey(Job record);

    //城市平均工资条形统计图
    List<JobExt> getCityAvgSalary();

    //学历工资分布
    List<JobExt> getEducationAvgSalary();

    //职位地域分布
    List<JobExt> getJobCity();

    //工作经验工资分布
    List<JobExt> getExperienceSalary();
}