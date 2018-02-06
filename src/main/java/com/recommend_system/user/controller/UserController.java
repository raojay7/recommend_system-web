
package com.recommend_system.user.controller;

import com.recommend_system.user.entity.User;
import com.recommend_system.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("register")
    public ModelAndView register(HttpSession session, User user){//注册方法
        userService.register(user);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("interest");//注册完成后跳转到用户职位兴趣选择页面
        session.setAttribute("User", user);//注册完即为登录状态
        return mav;
    }

    @RequestMapping("logIn")
    public ModelAndView logIn(HttpSession session, HttpServletRequest request, User user){//登录方法
        User us = userService.logIn(user);
        ModelAndView mav = new ModelAndView();
        if(us != null){//返回来的User对象不为空说明登录成功了，跳转到home首页
            session.setAttribute("User", user);
            mav.setViewName("index");
        }else{//返回来的User对象为空说明登录失败了，跳转到登录界面，并提示用户输入正确信息
            request.setAttribute("message", "用户名或密码错误");
            mav.setViewName("loginUI");
        }
        return mav;
    }

    @RequestMapping("logOut")
    public ModelAndView logOut(HttpSession session){//注销方法
        session.invalidate();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("setUser")
    public ModelAndView setUser(User user){//修改个人信息
        userService.setUser(user);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("userinfo");//修改后回到个人信息页面
        return mav;
    }
}

