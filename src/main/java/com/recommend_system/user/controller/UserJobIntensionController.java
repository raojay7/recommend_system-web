package com.recommend_system.user.controller;

import com.recommend_system.user.entity.UserJobIntension;
import com.recommend_system.user.service.UserJobIntensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("User")
public class UserJobIntensionController {
    @Autowired
    UserJobIntensionService userJobIntensionService;

    @RequestMapping("setIntension")
    public ModelAndView setIntension(HttpSession session, UserJobIntension userJobIntension){//修改求职意愿
        ModelAndView mav = new ModelAndView();
        try {
            if(userJobIntension.getSalaryMin() == 0)userJobIntension.setSalaryMax(3000);
            if(userJobIntension.getSalaryMin() == 3000)userJobIntension.setSalaryMax(6000);
            if(userJobIntension.getSalaryMin() == 6000)userJobIntension.setSalaryMax(10000);
            if(userJobIntension.getSalaryMin() == 10000)userJobIntension.setSalaryMax(20000);
            if(userJobIntension.getSalaryMin() == 20000)userJobIntension.setSalaryMax(20000);
            userJobIntensionService.setIntension(userJobIntension);
            session.setAttribute("uji",userJobIntension);
            mav.setViewName("job_intension");//修改完跳回个人求职意愿页面
            return mav;
        }catch (Exception e){
            mav.setViewName("error");
            return mav;
        }
    }

    @RequestMapping("addIntension")
    public ModelAndView addIntension(HttpServletRequest request, UserJobIntension userJobIntension){//增加求职意愿
        ModelAndView mav = new ModelAndView();
        try {
            request.setCharacterEncoding("UTF-8");
            userJobIntensionService.addIntension(userJobIntension);
            //mav.setViewName("job_intension");//修改完跳回个人求职意愿页面
            return mav;
        }catch (Exception e){
            mav.setViewName("error");
            return mav;
        }
    }
}
