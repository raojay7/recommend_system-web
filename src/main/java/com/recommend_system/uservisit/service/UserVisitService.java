package com.recommend_system.uservisit.service;

import com.recommend_system.uservisit.entity.VisitJob;

import java.util.List;

public interface UserVisitService {
    /**
     * 用户点击记录
     * @param uid 用户id
     * @param jid 职位id
     */
    public void visit(int uid, int jid);

    /**
     * 判断是否存在相应用户的浏览记录
     * @param uid 用户id
     * @return 存在返回true，否则为false
     */
    public boolean isEmpty(int uid);

    /**
     * 获取用户最近浏览的最多3个的浏览记录
     * @param uid 用户id
     * @return 返回浏览记录集
     */
    public List<VisitJob> getRecentVisit(int uid);
}
