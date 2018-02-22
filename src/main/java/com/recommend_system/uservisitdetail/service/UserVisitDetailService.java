package com.recommend_system.uservisitdetail.service;

import com.recommend_system.job.entity.Job;
import com.recommend_system.user.entity.User;

public interface UserVisitDetailService {
    /**
     * 对用户浏览某个职位页面的记录,存入t_visited_job和t_visited_detail
     * @param user 得到用户id
     * @param job 得到工作的详细信息
     * @param staytime 用户在该页面停留的时长
     */
    public void visit(User user, Job job, long staytime);
}
