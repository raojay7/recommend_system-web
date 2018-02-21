package com.recommend_system.uservisitdetail.entity;

import java.io.Serializable;

public class VisitDetail implements Serializable {
    private Integer visitedDetailId;

    private String webId;

    private Integer jobCategory;

    private Integer jobProperty;

    private String workplace;

    private Integer workyearMin;

    private Integer workyearMax;

    private String professional;

    private Integer salaryMin;

    private Integer salaryMax;

    private Integer education;

    private Integer age;

    private Integer gender;

    private Integer visitLength;

    private Integer userType;

    private String cookieId;

    private String ip;

    private Integer visistedJobId;

    private static final long serialVersionUID = 1L;

    public Integer getVisitedDetailId() {
        return visitedDetailId;
    }

    public void setVisitedDetailId(Integer visitedDetailId) {
        this.visitedDetailId = visitedDetailId;
    }

    public String getWebId() {
        return webId;
    }

    public void setWebId(String webId) {
        this.webId = webId == null ? null : webId.trim();
    }

    public Integer getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(Integer jobCategory) {
        this.jobCategory = jobCategory;
    }

    public Integer getJobProperty() {
        return jobProperty;
    }

    public void setJobProperty(Integer jobProperty) {
        this.jobProperty = jobProperty;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace == null ? null : workplace.trim();
    }

    public Integer getWorkyearMin() {
        return workyearMin;
    }

    public void setWorkyearMin(Integer workyearMin) {
        this.workyearMin = workyearMin;
    }

    public Integer getWorkyearMax() {
        return workyearMax;
    }

    public void setWorkyearMax(Integer workyearMax) {
        this.workyearMax = workyearMax;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional == null ? null : professional.trim();
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getVisitLength() {
        return visitLength;
    }

    public void setVisitLength(Integer visitLength) {
        this.visitLength = visitLength;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getCookieId() {
        return cookieId;
    }

    public void setCookieId(String cookieId) {
        this.cookieId = cookieId == null ? null : cookieId.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getVisistedJobId() {
        return visistedJobId;
    }

    public void setVisistedJobId(Integer visistedJobId) {
        this.visistedJobId = visistedJobId;
    }
}