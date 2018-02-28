package com.recommend_system.job.service;

import com.recommend_system.job.entity.Job;

public interface JobService {
    public int getCompanyId(int jobId);

    public Job getJobById(int jid);
}
