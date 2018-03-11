package com.recommend_system.test.controller;

import com.recommend_system.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController
{
    @Autowired
    TestService testService;

    @RequestMapping("index")
    public String show()
    {
        testService.show();
        System.out.println("controller的show");
        return "index";
    }
}
