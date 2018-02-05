package com.recommend_system.job.dao;

import com.recommend_system.job.entity.Job;

public interface JobMapper {
    int deleteByPrimaryKey(String jobId);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(String jobId);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKeyWithBLOBs(Job record);

    int updateByPrimaryKey(Job record);
}