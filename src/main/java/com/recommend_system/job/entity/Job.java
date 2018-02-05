package com.recommend_system.job.entity;

import java.io.Serializable;
import java.util.Date;

public class Job implements Serializable {
    private String jobId;

    private String jobName;

    private Integer salaryMin;

    private Integer salaryMax;

    private String education;

    private String workplace;

    private Integer workexperienceMin;

    private Integer workexperienceMax;

    private Integer needNum;

    private Date ctime;

    private String jobNature;

    private String companyId;

    private String welfare;

    private String workcity;

    private String jobfindUrl;

    private String specification;

    private static final long serialVersionUID = 1L;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace == null ? null : workplace.trim();
    }

    public Integer getWorkexperienceMin() {
        return workexperienceMin;
    }

    public void setWorkexperienceMin(Integer workexperienceMin) {
        this.workexperienceMin = workexperienceMin;
    }

    public Integer getWorkexperienceMax() {
        return workexperienceMax;
    }

    public void setWorkexperienceMax(Integer workexperienceMax) {
        this.workexperienceMax = workexperienceMax;
    }

    public Integer getNeedNum() {
        return needNum;
    }

    public void setNeedNum(Integer needNum) {
        this.needNum = needNum;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getJobNature() {
        return jobNature;
    }

    public void setJobNature(String jobNature) {
        this.jobNature = jobNature == null ? null : jobNature.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare == null ? null : welfare.trim();
    }

    public String getWorkcity() {
        return workcity;
    }

    public void setWorkcity(String workcity) {
        this.workcity = workcity == null ? null : workcity.trim();
    }

    public String getJobfindUrl() {
        return jobfindUrl;
    }

    public void setJobfindUrl(String jobfindUrl) {
        this.jobfindUrl = jobfindUrl == null ? null : jobfindUrl.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }
}