package com.recommend_system.userlike.service;

import com.recommend_system.job.entity.Job;
import com.recommend_system.user.entity.User;

public interface UserLikeService {
    /**
     * 用户收藏某个工作，存入tr_user_like
     * @param user 得到用户id
     * @param job 得到工作id
     */
    public void collect(User user, Job job);
}
