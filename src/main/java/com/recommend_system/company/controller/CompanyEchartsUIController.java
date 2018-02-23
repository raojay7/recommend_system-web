package com.recommend_system.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyEchartsUIController {

    @RequestMapping("company_city")
    public ModelAndView getcc(){//
        ModelAndView mav = new ModelAndView();
        mav.setViewName("company_city");
        return mav;
    }

    @RequestMapping("company_industry")
    public ModelAndView getci(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("company_industry");
        return mav;
    }
    @RequestMapping("company_nature")
    public ModelAndView getcn(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("company_nature");
        return mav;
    }
    @RequestMapping("company_scale")
    public ModelAndView getcs(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("company_scale");
        return mav;
    }
    @RequestMapping("companynt_need_avg")
    public ModelAndView getcna(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("companynt_need_avg");
        return mav;
    }

    @RequestMapping("industry_need_avg")
    public ModelAndView getina(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("industry_need_avg");
        return mav;
    }


}
