package com.recommend_system.test.controller;

import com.recommend_system.test.service.UserJobIntensionServiceTest;
import com.recommend_system.user.entity.UserJobIntension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("JobIntension")
public class UserJobIntensionControllerTest {
    @Autowired
    private UserJobIntensionServiceTest userJobIntensionServiceTest;

    @RequestMapping("add")
    public ModelAndView addIntensionTest(){
        ModelAndView mav = new ModelAndView();
        UserJobIntension userJobIntension = new UserJobIntension();
        userJobIntension.setUserId(1);
        userJobIntension.setIntensionId(1);
        userJobIntension.setJobName("java");
        userJobIntension.setJobNature(0);
        userJobIntension.setSalaryMax(20000);
        userJobIntension.setSalaryMin(10000);
        userJobIntension.setWorkplace("Beijing");
        userJobIntensionServiceTest.addIntensionTest(userJobIntension);
        mav.setViewName("index");
        return mav;
    }
    @RequestMapping("set")
    public ModelAndView setIntensionTest(){
        ModelAndView mav = new ModelAndView();
        UserJobIntension userJobIntension = new UserJobIntension();
        userJobIntension.setUserId(1);
        userJobIntension.setIntensionId(1);
        userJobIntension.setJobName("java");
        userJobIntension.setJobNature(0);
        userJobIntension.setSalaryMax(20000);
        userJobIntension.setSalaryMin(10000);
        userJobIntension.setWorkplace("Shanghai");
        userJobIntensionServiceTest.setIntensionTest(userJobIntension);
        mav.setViewName("index");
        return mav;
    }
}
