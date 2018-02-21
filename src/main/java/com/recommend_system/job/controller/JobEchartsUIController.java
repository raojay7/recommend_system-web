package com.recommend_system.job.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobEchartsUIController {

    @RequestMapping("city_avg_salary")
    public ModelAndView getcas(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("city_avg_salary");
        return mav;
    }

    @RequestMapping("education")
    public ModelAndView gete(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("education");
        return mav;
    }

    @RequestMapping("job_city")
    public ModelAndView getjc(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("job_city");
        return mav;
    }

    @RequestMapping("workex")
    public ModelAndView getw(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("workex");
        return mav;
    }
}
