package com.recommend_system.hotsearch.service;

import com.recommend_system.hotsearch.entity.HotSearch;

import java.util.List;

public interface HotSearchService {
    /**
     *
     * @param content 用户的搜索内容
     * @return 数据库存在返回真，否则返回假
     */
    public boolean doExist(String content);

    /**
     *
     * @param content 用户搜送内容
     */
    public void writeData(String content);

    /**
     *
     * @return 返回最多五个最热的搜素关键词
     */
    public List<HotSearch> getHottest();

}
