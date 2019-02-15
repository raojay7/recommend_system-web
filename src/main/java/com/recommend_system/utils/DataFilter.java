package com.recommend_system.utils;


import com.recommend_system.cnaturetreat.entity.CNatureTreat;
import com.recommend_system.company.entity.CompanyExt;
import com.recommend_system.citysalary.entity.CitySalary;
import com.recommend_system.companyindustry.entity.CompanyIndustry;

import java.util.List;

public interface DataFilter {
    /**
     * 本方法按升序排序
     * @param fsize 结果量(0到1)，要取的量，过滤掉后(1-fsize)的数据
     * @param jc jedis客户端
     * @param list
     */
    public void sort_filter(List<CitySalary> list, float fsize, JedisClient jc, String listName1, String listName2);
    public void sort_filter2(List<CompanyIndustry> list, float fsize, JedisClient jc, String listName1, String listName2);
    public void sort_filter3(List<CNatureTreat> list, float fsize, JedisClient jc, String listName1, String listName2);
}
