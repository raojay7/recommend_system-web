package com.recommend_system.job.controller;

import com.recommend_system.company.dao.CompanyMapper;
import com.recommend_system.company.entity.Company;
import com.recommend_system.job.dao.JobMapper;
import com.recommend_system.job.entity.Job;
import com.recommend_system.job.entity.JobExample;
import com.recommend_system.userlike.entity.UserLikeKey;
import com.recommend_system.userlike.service.UserLikeService;
import com.recommend_system.uservisit.service.UserVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("detail")
public class JobDetailController {
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private UserLikeService userLikeService;
    @Autowired
    private UserVisitService userVisitService;

    @RequestMapping("job")
    public ModelAndView toJobDetail(HttpSession session, HttpServletRequest request, String page){
        ModelAndView mav = new ModelAndView();
        int companyId = Integer.parseInt(request.getParameter("companyId"));
        int jobId = Integer.parseInt(request.getParameter("jobId"));
        int uid = Integer.parseInt(request.getParameter("userId"));
        userVisitService.visit(uid, jobId);
        System.out.println(companyId + " " + jobId);
        Job job = jobMapper.selectByPrimaryKey(jobId);
        Company company = companyMapper.selectByPrimaryKey(companyId);
        request.setAttribute("job", job);
        request.setAttribute("company", company);
        session.setAttribute("page", page);
        List<UserLikeKey> list = userLikeService.getList(uid);
        if(list.size() == 0)request.setAttribute("flag", "0");
        else {
            for (UserLikeKey userLikeKey : list) {
                if (userLikeKey.getJobId() == jobId) {
                    request.setAttribute("flag", "1");
                    break;
                } else request.setAttribute("flag", "0");
            }
        }
        mav.setViewName("job_detail");
        return mav;
    }
}
