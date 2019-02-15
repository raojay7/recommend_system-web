package com.recommend_system.utils.impl;

import com.recommend_system.cnaturetreat.entity.CNatureTreat;
import com.recommend_system.company.entity.CompanyExt;
import com.recommend_system.citysalary.entity.CitySalary;
import com.recommend_system.companyindustry.entity.CompanyIndustry;
import com.recommend_system.utils.DataFilter;
import com.recommend_system.utils.JedisClient;

import java.util.*;

public class SortFilter implements DataFilter {
    @Override
    public void sort_filter3(List<CNatureTreat> list, float fsize, JedisClient jc, String listName1, String listName2) {
        Map<Double,String> smap = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(o1 < o2)return 1;
                else if(o1 > o2)return -1;
                else return 0;
            }
        });
        CNatureTreat je;
        Iterator<CNatureTreat> it = list.iterator();
        while(it.hasNext()){
            je = it.next();
            smap.put(Double.parseDouble(String.valueOf(je.getWorknum())), je.getCompanyNature());
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
    public void sort_filter2(List<CompanyIndustry> list, float fsize, JedisClient jc, String listName1, String listName2) {
        Map<Double,String> smap = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(o1 < o2)return 1;
                else if(o1 > o2)return -1;
                else return 0;
            }
        });
        CompanyIndustry je;
        Iterator<CompanyIndustry> it = list.iterator();
        while(it.hasNext()){
            je = it.next();
            smap.put(Double.parseDouble(String.valueOf(je.getNum())), je.getCompanyIndustry());
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
    public void sort_filter(List<CitySalary> list, float fsize, JedisClient jc, String listName1, String listName2) {
        Map<Double,String> smap = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(o1 < o2)return 1;
                else if(o1 > o2)return -1;
                else return 0;
            }
        });
        CitySalary je;
        Iterator<CitySalary> it = list.iterator();
        while(it.hasNext()){
            je = it.next();
            smap.put(je.getAvgSalary() * 1.0, je.getCity());
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
