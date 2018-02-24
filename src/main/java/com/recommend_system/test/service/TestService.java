package com.recommend_system.test.service;

import com.recommend_system.company.dao.CompanyMapper;
import com.recommend_system.company.entity.CompanyExt;
import com.recommend_system.job.dao.JobMapper;
import com.recommend_system.job.entity.JobExt;
import com.recommend_system.user.dao.UserMapper;
import com.recommend_system.user.entity.User;
import com.recommend_system.utils.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService
{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private JobMapper jobMapper;

    @Autowired
    private JedisClient jedisClient;

    public void show()
    {
        List<JobExt> list = jobMapper.getCityAvgSalary();
        for (JobExt j : list)
        {
            System.out.println(j.getWorkcity() + "---" + j.getAve_salary());
        }

        list = jobMapper.getEducationAvgSalary();
        for (JobExt j : list)
        {
            System.out.println(j.getEducation() + "---" + j.getAve_salary() + "---" + j.getJobnum());
        }

        list = jobMapper.getJobCity();
        for (JobExt j : list)
        {
            System.out.println(j.getJobnum() + "---" + j.getWorkcity());
        }
        list = jobMapper.getExperienceSalary();
        for (JobExt j : list)
        {
            System.out.println(
                j.getWorkexperience_min() + "---" + j.getWorkexperience_max() + "---" + j.getAve_salary());
        }
    }

    public int insert(User user)
    {
        return userMapper.insert(user);
    }

    public void showRedis()
    {
        jedisClient.set("hadoop","kkfdkldklf");
    }
}
