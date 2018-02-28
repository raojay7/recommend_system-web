package com.recommend_system.userlike.controller;

import com.recommend_system.job.entity.Job;
import com.recommend_system.user.entity.User;
import com.recommend_system.user.entity.UserJobIntension;
import com.recommend_system.userlike.service.UserJobRankService;
import com.taotao.common.pojo.Layui;
import com.taotao.common.pojo.SolrItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("recommend")
public class UserJobRankController {
    @Autowired
    private UserJobRankService userJobRankService;

    @RequestMapping("work")
    @ResponseBody
    public Layui recommend(HttpSession session, HttpServletResponse response){
        System.out.println("进入推荐controller");
        User user = (User)session.getAttribute("user");
        UserJobIntension userJobIntension = (UserJobIntension)session.getAttribute("uji");
        Map<Integer,String> map = new HashMap<>();
        Job job;
        String path = session.getServletContext().getRealPath("/")+user.getUserName()+".scv";
        session.setAttribute("vali", "0");
        try {
            if(!userJobRankService.hasScored(user)) {
                System.out.println("该用户没有评分");
                userJobRankService.prescore(user, userJobIntension);
                List<SolrItem> list = userJobRankService.recommend(user, path);
                /*Iterator<Job> it = list.iterator();
                while(it.hasNext()){
                    job = it.next();
                    map.put(job.getJobId(), "工作名："+job.getJobName()+"学历要求："+job.getEducation()+"工作地："+job.getWorkcity()+"最低薪水"+job.getSalaryMin());
                }
                response.getWriter().write(map.toString());*/
                return Layui.data((long)list.size(), list);
            }else{
                List<SolrItem> list = userJobRankService.recommend(user, path);
                /*Iterator<Job> it = list.iterator();
                while(it.hasNext()){
                    job = it.next();
                    map.put(job.getJobId(), "工作名："+job.getJobName()+"学历要求："+job.getEducation()+"工作地："+job.getWorkcity()+"最低薪水"+job.getSalaryMin());
                }
                response.getWriter().write(map.toString());*/
                return Layui.data((long)list.size(), list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Layui.data((long)0, null);
        }
    }
    @RequestMapping("wf")
    public void writeFile(HttpSession session, HttpServletResponse response, HttpServletRequest request){
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        User user = (User)session.getAttribute("user");
        String path = session.getServletContext().getRealPath("/")+user.getUserName()+".scv";
        List<SolrItem> jlist = userJobRankService.recommend(user, path);
        //System.out.println(jlist.get(0).getJobName());
        try {
            OutputStream os = response.getOutputStream();

            SolrItem j;
            Iterator<SolrItem> jit = jlist.iterator();
            String rcmd;
            while(jit.hasNext()){
                j = jit.next();
                rcmd = "jobId:"+j.getJobId()+"jobName:"+j.getJobName()+"jobEducation:"+j.getEducation()+"jobSM:"+j.getSalaryMin()+"jobWorkcity:"+j.getWorkcity();
                System.out.println("jobId:"+j.getJobId()+"jobName:"+j.getJobName()+"jobEducation:"+j.getEducation()+"jobSM:"+j.getSalaryMin()+"jobWorkcity:"+j.getWorkcity());
                os.write(rcmd.getBytes("UTF-8"));
                os.write("<br/>".getBytes());
            }
            /*BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
                //pw.write(line);
            }*/
            FileWriter fw = new FileWriter(new File(path));
            fw.write("");
            fw.close();
            //br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
