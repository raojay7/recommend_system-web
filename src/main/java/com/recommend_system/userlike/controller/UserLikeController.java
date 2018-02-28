package com.recommend_system.userlike.controller;

import com.recommend_system.job.service.JobService;
import com.recommend_system.userlike.service.UserLikeService;
import com.taotao.common.pojo.Layui;
import com.taotao.common.pojo.SolrItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("action")
public class UserLikeController {
    @Autowired
    private UserLikeService userLikeService;
    @Autowired
    private JobService jobService;

    @RequestMapping("collect")
    public ModelAndView doCollect(HttpSession session, int uid, int jid){
        ModelAndView mav = new ModelAndView();
        userLikeService.collect(uid, jid);
        mav.addObject("job", jobService.getJobById(jid));
        mav.addObject("jobId", jid);
        mav.addObject("companyId", jobService.getCompanyId(jid));
        mav.addObject("userId", uid);
        mav.addObject("ull",userLikeService.getList(uid));
        mav.addObject("flag", "1");
        if(session.getAttribute("vali").equals("1"))mav.addObject("page", "my_favorites");
        else mav.addObject("page","recommended_posts");
        mav.setViewName("job_detail");
        return mav;
    }
    @RequestMapping("delete")
    public ModelAndView doDelete(HttpSession session, int uid, int jid){
        ModelAndView mav = new ModelAndView();
        userLikeService.delete(uid, jid);
        mav.addObject("job", jobService.getJobById(jid));
        mav.addObject("jobId", jid);
        mav.addObject("companyId", jobService.getCompanyId(jid));
        mav.addObject("userId", uid);
        mav.addObject("ull",userLikeService.getList(uid));
        mav.addObject("flag", "1");
        if(session.getAttribute("vali").equals("1"))mav.addObject("page", "my_favorites");
        else mav.addObject("page","recommended_posts");
        mav.setViewName("my_favorites");
        return mav;
    }

    @RequestMapping("show")
    @ResponseBody
    public Layui doShow(HttpSession session, int uid){
        System.out.println("进入show controller " + uid);
        List<SolrItem> list = userLikeService.getLikeList(uid);
        session.setAttribute("vali","1");
        if(list == null){System.out.println("收藏列表为空");return Layui.data((long)0, null);}
        return Layui.data((long)list.size(), list);
    }
}
