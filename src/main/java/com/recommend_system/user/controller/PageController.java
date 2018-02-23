package com.recommend_system.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @RequestMapping("")
    public ModelAndView toDefault(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("homepage");
        return mav;
    }
    @RequestMapping("search")
    public ModelAndView toSearch(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("job_search");
        return mav;
    }
    @RequestMapping("/{page}")
    public ModelAndView toHome(@PathVariable String page){
        ModelAndView mav = new ModelAndView();
        mav.setViewName(page);
        return mav;
    }
}
