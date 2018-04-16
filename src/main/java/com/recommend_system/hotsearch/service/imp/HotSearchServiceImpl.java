package com.recommend_system.hotsearch.service.imp;

import com.recommend_system.hotsearch.dao.HotSearchMapper;
import com.recommend_system.hotsearch.entity.HotSearch;
import com.recommend_system.hotsearch.entity.HotSearchExample;
import com.recommend_system.hotsearch.service.HotSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

@Service
public class HotSearchServiceImpl implements HotSearchService {
    @Autowired
    private HotSearchMapper hotSearchMapper;

    @Override
    public List<HotSearch> getHottest() {
        List<HotSearch> list;
        //select frequency from t_hot_search order by frequency desc;
        HotSearchExample hotSearchExample = new HotSearchExample();
        hotSearchExample.setOrderByClause("frequency desc");
        list = hotSearchMapper.selectByExample(hotSearchExample);
        if(list.size() <= 5)
            return list;
        List<HotSearch> fiveList = new LinkedList<>();
        for(int i = 0;i < 5; i++)fiveList.add(list.get(i));
        return fiveList;
    }

    @Override
    public boolean doExist(String content) {
        HotSearchExample hotSearchExample = new HotSearchExample();
        HotSearchExample.Criteria criteria = hotSearchExample.createCriteria();
        criteria.andContentEqualTo(content.toLowerCase());
        if(hotSearchMapper.selectByExample(hotSearchExample).size() == 0)
            return false;
        return true;
    }

    @Override
    public void writeData(String content) {
        try {
            content = new String(content.getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if(doExist(content.toLowerCase())){
            HotSearchExample hotSearchExample = new HotSearchExample();
            HotSearchExample.Criteria criteria = hotSearchExample.createCriteria();
            criteria.andContentEqualTo(content.toLowerCase());
            HotSearch hotSearch = hotSearchMapper.selectByExample(hotSearchExample).get(0);
            hotSearch.setFrequency(hotSearch.getFrequency() + 1);
            hotSearchMapper.updateByPrimaryKeySelective(hotSearch);

        }else{
            HotSearch hotSearch = new HotSearch();
            hotSearch.setContent(content.toLowerCase());
            hotSearch.setFrequency(1);
            hotSearchMapper.insert(hotSearch);
        }
    }
}
