package com.recommend_system.utils;

import java.util.*;

/**
 * Created by cx on 2017/04/09.
 */
public class MapHelper {



    /**
     * 使用 Map按value进行排序
     * @param oriMap
     * @return
     */
    public static Map<String, Float> sortMapByValue(Map<String, Float> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, Float> sortedMap = new LinkedHashMap<String, Float>();
        List<Map.Entry<String, Float>> entryList = new ArrayList<Map.Entry<String, Float>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Collections.reverse(entryList);

        Iterator<Map.Entry<String, Float>> iter = entryList.iterator();
        Map.Entry<String, Float> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }

        return sortedMap;
    }

}

