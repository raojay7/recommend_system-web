package com.recommend_system.user.controller;

//import com.recommend_system.user.entity.UserJobIntension;
import com.recommend_system.user.service.UserJobIntensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("User")
public class UserJobIntensionController {
    /*@Autowired
    UserJobIntensionService userJobIntensionService;

    @RequestMapping("setIntension")
    public ModelAndView setIntension(UserJobIntension userJobIntension){//修改求职意愿
        userJobIntensionService.setIntension(userJobIntension);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("intension");//修改完跳回个人求职意愿页面
        return mav;
    }

    @RequestMapping("addIntension")
    public ModelAndView addIntension(UserJobIntension userJobIntension){//增加求职意愿
        userJobIntensionService.addIntension(userJobIntension);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("intension");//增加完跳转到个人求职意愿页面
        return mav;
    }*/
}
