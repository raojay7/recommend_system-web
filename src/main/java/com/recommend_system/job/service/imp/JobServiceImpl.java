package com.recommend_system.job.service.imp;

import com.recommend_system.job.dao.JobMapper;
import com.recommend_system.job.entity.Job;
import com.recommend_system.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jobMapper;
    @Override
    public int getCompanyId(int jobId) {
        Job job = jobMapper.selectByPrimaryKey(jobId);
        return job.getJobId();
    }

    @Override
    public Job getJobById(int jid) {
        return jobMapper.selectByPrimaryKey(jid);
    }
}
