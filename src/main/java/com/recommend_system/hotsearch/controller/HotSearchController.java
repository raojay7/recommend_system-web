package com.recommend_system.hotsearch.controller;

import com.recommend_system.hotsearch.entity.HotSearch;
import com.recommend_system.hotsearch.service.HotSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HotSearchController {
    @Autowired
    private HotSearchService hotSearchService;

    @RequestMapping("job_search")
    public String getHotSearch(HttpServletRequest request){
        List<HotSearch> list = hotSearchService.getHottest();
        request.setAttribute("hotList", list);
        return "job_search";
    }
}
