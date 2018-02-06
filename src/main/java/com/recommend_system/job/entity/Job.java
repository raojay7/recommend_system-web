package com.recommend_system.job.entity;

import java.io.Serializable;
import java.util.Date;

public class Job implements Serializable {
    private Integer jobId;

    private Integer companyId;

    private String jobName;

    private Integer salaryMin;

    private Integer salaryMax;

    private Integer education;

    private String workplace;

    private Integer workexperienceMin;

    private Integer workexperienceMax;

    private Integer needNum;

    private Date ctime;

    private Integer jobNature;

    private String welfare;

    private String workcity;

    private String ageMin;

    private String ageMax;

    private Integer needGender;

    private String language;

    private String tag;

    private String specification;

    private static final long serialVersionUID = 1L;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
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

    public Integer getJobNature() {
        return jobNature;
    }

    public void setJobNature(Integer jobNature) {
        this.jobNature = jobNature;
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

    public String getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(String ageMin) {
        this.ageMin = ageMin == null ? null : ageMin.trim();
    }

    public String getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(String ageMax) {
        this.ageMax = ageMax == null ? null : ageMax.trim();
    }

    public Integer getNeedGender() {
        return needGender;
    }

    public void setNeedGender(Integer needGender) {
        this.needGender = needGender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }
}