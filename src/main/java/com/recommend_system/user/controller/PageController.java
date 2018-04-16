package com.recommend_system.user.controller;

import com.recommend_system.user.entity.User;
import com.recommend_system.user.entity.UserJobIntension;
import com.recommend_system.user.service.UserJobIntensionService;
import com.recommend_system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserJobIntensionService userJobIntensionService;

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
    public ModelAndView toHome(@PathVariable String page, HttpSession session, HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        User user = (User)session.getAttribute("user");
        if(user != null){
            if(page.equals("homepage"))mav.setViewName("index");
            else if(!page.equals("job_search")){
                mav.setViewName(page);
            }
        }else{
            if(!page.equals("homepage")) {
                request.setAttribute("msg", "<font color='red'>请先登录！</font>");
                mav.setViewName("homepage");
            }
        }
        return mav;
    }
}
