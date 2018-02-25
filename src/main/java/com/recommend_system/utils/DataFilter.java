package com.recommend_system.utils;


import com.recommend_system.job.entity.JobExt;

import java.util.List;
import java.util.Map;

public interface DataFilter {
    /**
     * 本方法按升序排序
     * @param fsize 结果量(0到1)，要取的量，过滤掉后(1-fsize)的数据
     * @param jc jedis客户端
     * @param list
     */
    public void sort_filter(List<JobExt> list, float fsize, JedisClient jc);
}
