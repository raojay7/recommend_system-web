package com.recommend_system.job.service;

import com.recommend_system.job.entity.Job;

public interface JobService {
    /**
     *
     * @param jobId 职位id
     * @return 公司id
     */
    public int getCompanyId(int jobId);

    /**
     *
     * @param jid 职位id
     * @return 职位对象
     */
    public Job getJobById(int jid);
}
