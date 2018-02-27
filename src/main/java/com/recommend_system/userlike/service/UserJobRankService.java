package com.recommend_system.userlike.service;

import com.recommend_system.job.entity.Job;
import com.recommend_system.user.entity.User;
import com.recommend_system.user.entity.UserJobIntension;
import com.taotao.common.pojo.SolrItem;

import java.util.List;

public interface UserJobRankService {

    /**
     *
     * @param user 用户个人信息
     * @param userJobIntension 用户求职意愿
     * @return 打了分的工作数量
     */
    public String prescore(User user, UserJobIntension userJobIntension) throws Exception;

    /**
     *
     * @param user 判断该用户是否已打分
     * @return 返回真代表用户已打分，假表示还未打分
     */
    public boolean hasScored(User user);

    /**
     *
     * @param user 要推荐的用户
     * @return 返回推荐的工作集
     */
    public List<SolrItem> recommend(User user, String path);
}
