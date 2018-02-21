package com.recommend_system.userlike.entity;

import java.io.Serializable;

public class UserLikeKey implements Serializable {
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