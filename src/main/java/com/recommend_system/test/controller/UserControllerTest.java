package com.recommend_system.test.controller;

import com.recommend_system.test.service.UserServiceTest;
import com.recommend_system.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("UserTest")
public class UserControllerTest {
    @Autowired
    UserServiceTest userServiceTest;

    @RequestMapping("register")
    public ModelAndView registerTest() throws IOException {
        User user = new User();
        user.setUserId(2);
        user.setUserName("jayrao");
        user.setPassword("123456");
        user.setUserType(1);
        user.setSchool("ncu");
        user.setProfessional("cs");
        user.setPresentAddress("Nanchang");
        //user.setGender(0);
        user.setEducation(1);
        user.setAge(20);
        System.out.println("UserTest running!");
        userServiceTest.registerTest(user);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("logIn")
    public ModelAndView logInTest(User user, HttpServletRequest request) throws IOException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        try {
            User us = userServiceTest.logInTest(user);
            request.setAttribute("msg", "登录成功！");
            return mav;
        }catch (Exception e){
            request.setAttribute("msg", "请检查用户名或密码！");
            return mav;
        }
    }

    @RequestMapping("setUser")
    public ModelAndView setUserTest(){
        User user = new User();
        user.setUserId(2);
        user.setUserName("jayrao");
        user.setPassword("123456");
        user.setUserType(1);
        user.setSchool("ncu");
        user.setProfessional("cs");
        user.setPresentAddress("Nanchang");
        user.setGender(0);
        user.setEducation(1);
        user.setAge(20);
        ModelAndView mav = new ModelAndView();
        userServiceTest.setUserTest(user);
        mav.setViewName("index");
        return mav;
    }
}
