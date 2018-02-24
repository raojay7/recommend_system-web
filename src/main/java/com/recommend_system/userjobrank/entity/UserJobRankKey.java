package com.recommend_system.userjobrank.entity;

import java.io.Serializable;

public class UserJobRankKey implements Serializable {
    private Integer jobId;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}