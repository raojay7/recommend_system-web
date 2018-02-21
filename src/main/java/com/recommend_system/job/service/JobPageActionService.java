package com.recommend_system.job.service;

import com.recommend_system.job.entity.Job;
import com.recommend_system.user.entity.User;

public interface JobPageActionService {
    /**
     * 用户收藏某个工作，存入tr_user_like
     * @param user 得到用户id
     * @param job 得到工作id
     */
    public void collect(User user, Job job);

    /**
     * 对用户浏览某个职位页面的记录,存入t_visited_job和t_visited_detail
     * @param user 得到用户id
     * @param job 得到工作的详细信息
     * @param staytime 用户在该页面停留的时长
     */
    public void visit(User user, Job job, long staytime);
}
