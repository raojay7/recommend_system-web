package com.recommend_system.utils.impl;

import com.recommend_system.job.entity.JobExt;
import com.recommend_system.utils.DataFilter;
import com.recommend_system.utils.JedisClient;

import java.util.*;

public class SortFilter implements DataFilter {
    @Override
    public void sort_filter(List<JobExt> list, float fsize, JedisClient jc) {
        Map<Double,String> smap = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(o1 < o2)return 1;
                else if(o1 > o2)return -1;
                else return 0;
            }
        });
        JobExt je;
        Iterator<JobExt> it = list.iterator();
        while(it.hasNext()){
            je = it.next();
            smap.put(je.getAve_salary(), je.getWorkcity());
        }
        int size = smap.size();
        size *= fsize;
        int count = 0;
        for(Map.Entry<Double,String> entry : smap.entrySet()){
            jc.appendRightList("cityavgsalary_city", entry.getValue());
            jc.appendRightList("cityavgsalary_avg", String.valueOf(entry.getKey()));
            count++;
            if(count == size)break;
        }

    }
}
