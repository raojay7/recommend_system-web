package com.recommend_system.user.entity;

import java.io.Serializable;

public class UserJobIntension implements Serializable {
    private Integer intensionId;

    private Integer userId;

    private Integer jobNature;

    private String jobName;

    private Integer salaryMin;

    private Integer salaryMax;

    private String workplace;

    private static final long serialVersionUID = 1L;

    public Integer getIntensionId() {
        return intensionId;
    }

    public void setIntensionId(Integer intensionId) {
        this.intensionId = intensionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getJobNature() {
        return jobNature;
    }

    public void setJobNature(Integer jobNature) {
        this.jobNature = jobNature;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public Integer getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Integer salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Integer getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Integer salaryMax) {
        this.salaryMax = salaryMax;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace == null ? null : workplace.trim();
    }
}