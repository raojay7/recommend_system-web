package com.recommend_system.job.service;

import com.recommend_system.job.entity.Job;

import java.util.List;

/*
 *职位查询Service接口
 */
public interface JobSearchService {
    /*
     *---------暂时搁置-------------
     *职位查询方法，返回一个job列表
     * 查询列表经过几步筛选：
     * 1.在输入的薪资上下限范围内
     * 2.小于等于输入的学历
     * 3.工作地和输入的一致
     * 4.工作性质和输入的一致
     * 5.工作福利关键词匹配
     * 6.工作名称关键词匹配
     */
    public List<Job> jobSearch(Job jobCondition);
}
