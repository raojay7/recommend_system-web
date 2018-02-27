package com.recommend_system.job.controller;

import com.recommend_system.company.dao.CompanyMapper;
import com.recommend_system.company.entity.Company;
import com.recommend_system.job.dao.JobMapper;
import com.recommend_system.job.entity.Job;
import com.recommend_system.job.entity.JobExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("detail")
public class JobDetailController {
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private CompanyMapper companyMapper;

    @RequestMapping("job")
    public ModelAndView toJobDetail(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        int companyId = Integer.parseInt(request.getParameter("companyId"));
        int jobId = Integer.parseInt(request.getParameter("jobId"));
        System.out.println(companyId + " " + jobId);
        Job job = jobMapper.selectByPrimaryKey(jobId);
        Company company = companyMapper.selectByPrimaryKey(companyId);
        request.setAttribute("job", job);
        request.setAttribute("company", company);
        mav.setViewName("job_detail");
        return mav;
    }
}
