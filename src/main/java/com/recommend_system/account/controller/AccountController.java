package com.recommend_system.account.controller;

import com.recommend_system.account.entity.Account;
import com.recommend_system.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("register")
    public ModelAndView register(HttpSession session, Account account){//用户注册
        ModelAndView mav = new ModelAndView();
        accountService.register(account);
        session.setAttribute("Account", account);
        mav.setViewName("interest");//注册成功后跳转到职位兴趣页面
        return mav;
    }

    @RequestMapping("logIn")
    public ModelAndView logIn(HttpSession session, HttpServletRequest request, Account account){//用户登录
        ModelAndView mav = new ModelAndView();
        Account ac = accountService.logIn(account);
        if(ac){
            session.setAttribute("Account", ac);
            mav.setViewName("home");//若登录成功则跳转到首页
        }else{
            request.setAttriute("message","用户名或密码错误！");
            mav.setViewName("loginUI");//登录失败则跳转到之前的登录界面
        }
        return mav;
    }

    @RequestMapping("logOut")
    public ModelAndView logOut(HttpSession session){//注销账户
        ModelAndView mav = new ModelAndView();
        session.invalidate();
        mav.setViewName("redirect:home");//直接跳转到首页
        return mav;
    }
}
