
package com.recommend_system.user.controller;

import com.recommend_system.user.entity.User;
import com.recommend_system.user.entity.UserJobIntension;
import com.recommend_system.user.service.UserJobIntensionService;
import com.recommend_system.user.service.UserService;
import com.recommend_system.userlike.entity.UserLikeKey;
import com.recommend_system.userlike.service.UserLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserJobIntensionService userJobIntensionService;
    @Autowired
    private UserLikeService userLikeService;

    @RequestMapping("register")
    public ModelAndView register(HttpSession session, User user){//注册方法
        ModelAndView mav = new ModelAndView();
        try {
            userService.register(user);
            User us = userService.logIn(user);
            UserJobIntension userJobIntension = new UserJobIntension();
            userJobIntension.setUserId(us.getUserId());
            userJobIntensionService.addIntension(userJobIntension);
            UserJobIntension uji = userJobIntensionService.getIntension(us);
            session.setAttribute("uji", uji);
            session.setAttribute("user", us);//注册完即为登录状态
            mav.setViewName("job_intension");//注册完成后跳转到用户职位兴趣选择页面
            return mav;
        }catch (Exception e){
            mav.setViewName("error");
            return mav;
        }
    }

    @RequestMapping("logIn")
    public ModelAndView logIn(HttpSession session, HttpServletResponse response, HttpServletRequest request, User user){//登录方法
        ModelAndView mav = new ModelAndView();
        /*String flag = request.getParameter("flag");//set cookie
        System.out.println("flag::::::::::::"+flag);
        if(flag!=null && flag.equals("1")){
            Cookie cookie = new Cookie("cookie_user", user.getUserName()+"-"+user.getPassword());
            cookie.setMaxAge(60*60*24*30); //cookie 保存30天
            request.setAttribute("flag","1");
            response.addCookie(cookie);
        }else{
            Cookie cookie = new Cookie("cookie_user",user.getUserName()+"-"+null);
            cookie.setMaxAge(60*60*24*30); //cookie 保存30天
            request.setAttribute("flag", null);
            response.addCookie(cookie);
        }*/

        try {
            User us = userService.logIn(user);
            UserJobIntension userJobIntension = userJobIntensionService.getIntension(us);
            session.setAttribute("uji",userJobIntension);
            session.setAttribute("user",us);
            mav.setViewName("index");
            return mav;
        }catch (Exception e){
            request.setAttribute("msg", "<font color='red'>请检查用户名或密码！</font>");
            mav.setViewName("homepage");
            return mav;
        }
    }

    @RequestMapping("logOut")
    public ModelAndView logOut(HttpSession session){//注销方法
        session.invalidate();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("homepage");
        return mav;
    }

    @RequestMapping("setUser")
    public ModelAndView setUser(User user, HttpServletRequest request, HttpSession session){//修改个人信息
        ModelAndView mav = new ModelAndView();
        try {
            request.setCharacterEncoding("UTF-8");
            userService.setUser(user);
            session.setAttribute("user",user);
            mav.setViewName("user_info");//修改后回到个人信息页面
            return mav;
        }catch (Exception e){
            mav.setViewName("error");
            return mav;
        }
    }

    @RequestMapping("validate")
    public void validate(HttpServletResponse response, HttpServletRequest request){
        try {
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("name");
            User user = userService.getUserByName(name);
            response.setCharacterEncoding("UTF-8");
            if (user != null) response.getWriter().write("<font color='red'>该用户名已被注册！</font>");
            else response.getWriter().write("");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

