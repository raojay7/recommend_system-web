package com.recommend_system.userlike.service;

import com.recommend_system.job.entity.Job;
import com.recommend_system.user.entity.User;
import com.recommend_system.userlike.entity.UserLikeKey;
import com.taotao.common.pojo.SolrItem;

import java.util.List;

public interface UserLikeService {
    /**
     * 用户收藏某个工作，存入tr_user_like
     * @param uid 得到用户id
     * @param jid 得到工作id
     */
    public void collect(int uid, int jid);

    /**删除收藏的工作
     *
     * @param uid 用户id
     * @param jid 工作id
     */
    public void delete(int uid, int jid);

    /**
     * 得到收藏列表
     * @param uid 用户id
     * @return 用户收藏列表
     */
    public List<UserLikeKey> getList(int uid);

    /**
     * 得到详细收藏列表
     * @param uid 用户id
     * @return 用户收藏项目列表
     */
    public List<SolrItem> getLikeList(int uid);
}
