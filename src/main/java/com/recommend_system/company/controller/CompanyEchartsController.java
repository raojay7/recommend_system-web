package com.recommend_system.company.controller;

import com.recommend_system.company.service.CompanyEchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("company")
public class CompanyEchartsController {

    @Autowired
    private CompanyEchartsService companyEchartsService;

    @RequestMapping("companycity")
    public void getCompanyCity(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try {
            String json = companyEchartsService.getCompanyCity();
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("companyindustry")
    public void getCompanyIndustry(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try {
            String json = companyEchartsService.getCompanyIndustry();
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("companynature")
    public void getCompanyNature(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try {
            String json = companyEchartsService.getCompanyNature();
            System.out.println("4 visited");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("companyscale")
    public void getCompanyScale(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try {
            String json = companyEchartsService.getCompanyScale();
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("companyntneedavg")
    public void getCompanyntNeedAvg(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try {
            String json = companyEchartsService.getCompanyNatureNeedAvg();
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("industryneedavg")
    public void getCompanyIndustryNeedAvg(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try {
            String json = companyEchartsService.getCompanyIndustryNeedAvg();
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
