package com.recommend_system.job.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("search")
public class JobSearchController {
    @RequestMapping("index")
    public String toIndex(){
        return "index";
    }
    @RequestMapping("job_search")
    public String toSearch(){
        return "job_search";
    }
}
