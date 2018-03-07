package com.recommend_system.utils.impl;

import com.recommend_system.company.entity.Company;
import com.recommend_system.company.entity.CompanyExt;
import com.recommend_system.job.entity.JobExt;
import com.recommend_system.utils.DataFilter;
import com.recommend_system.utils.JedisClient;

import java.util.*;

public class SortFilter implements DataFilter {
    @Override
    public void sort_filter3(List<CompanyExt> list, float fsize, JedisClient jc, String listName1, String listName2) {
        Map<Double,String> smap = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(o1 < o2)return 1;
                else if(o1 > o2)return -1;
                else return 0;
            }
        });
        CompanyExt je;
        Iterator<CompanyExt> it = list.iterator();
        while(it.hasNext()){
            je = it.next();
            smap.put(Double.parseDouble(String.valueOf(je.getJobnum())), je.getCompany_nature());
        }
        int size = smap.size();
        size *= fsize;
        int count = 0;
        for(Map.Entry<Double,String> entry : smap.entrySet()){
            jc.appendRightList(listName1, entry.getValue());
            jc.appendRightList(listName2, String.valueOf(entry.getKey()));
            count++;
            if(count == size)break;
        }
    }

    @Override
    public void sort_filter2(List<CompanyExt> list, float fsize, JedisClient jc, String listName1, String listName2) {
        Map<Double,String> smap = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(o1 < o2)return 1;
                else if(o1 > o2)return -1;
                else return 0;
            }
        });
        CompanyExt je;
        Iterator<CompanyExt> it = list.iterator();
        while(it.hasNext()){
            je = it.next();
            smap.put(Double.parseDouble(String.valueOf(je.getJobnum())), je.getCompany_industry());
        }
        int size = smap.size();
        size *= fsize;
        int count = 0;
        for(Map.Entry<Double,String> entry : smap.entrySet()){
            jc.appendRightList(listName1, entry.getValue());
            jc.appendRightList(listName2, String.valueOf(entry.getKey()));
            count++;
            if(count == size)break;
        }
    }

    @Override
    public void sort_filter(List<JobExt> list, float fsize, JedisClient jc, String listName1, String listName2) {
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
            jc.appendRightList(listName1, entry.getValue());
            jc.appendRightList(listName2, String.valueOf(entry.getKey()));
            count++;
            if(count == size)break;
        }

    }
}
