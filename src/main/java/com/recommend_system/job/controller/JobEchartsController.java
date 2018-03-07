package com.recommend_system.job.controller;

import com.recommend_system.job.service.JobEchartsService;
import com.recommend_system.utils.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.exceptions.JedisConnectionException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("job")
public class JobEchartsController {

    @Autowired
    private JobEchartsService jobEchartsService;
    @Autowired
    private JedisClient jc;


    @RequestMapping("cityavgsalary")
    public void getCityAvgSalary(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try {
            String json = jobEchartsService.getCityAvgSalary();
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("education")
    public void getEducation(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try {
            String json = jobEchartsService.getEducationAvgSalary();
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("jobcity")
    public void getJobCity(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try {
            String json = jobEchartsService.getJobCity();
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("workex")
    public void getWorkEx(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try {
            String json = jobEchartsService.getExperienceSalary();
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
