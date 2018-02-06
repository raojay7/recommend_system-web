package com.recommend_system.test.controller;

import com.recommend_system.test.service.TestService;
import com.recommend_system.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TestController
{
    @Autowired
    TestService testService;

    @RequestMapping("/index")
    public String show()
    {
        testService.show();
        System.out.println("controller的show");
        return "index";
    }

    @RequestMapping("user/insert")
    public void testUserInsert(){
        User u=new User();
        u.setUserName("zhangsan");
        u.setPassword("123");
        testService.insert(u);
    }
}
