package com.recommend_system.job.entity;

import java.io.Serializable;

public class JobExt implements Serializable
{
    private Double ave_salary;
    private String workcity;
    private Integer jobnum;
    private Integer education;
    private Integer workexperience_min;
    private Integer workexperience_max;

    public Double getAve_salary()
    {
        return ave_salary;
    }

    public void setAve_salary(Double ave_salary)
    {
        this.ave_salary = ave_salary;
    }

    public String getWorkcity()
    {
        return workcity;
    }

    public void setWorkcity(String workcity)
    {
        this.workcity = workcity;
    }

    public Integer getJobnum()
    {
        return jobnum;
    }

    public void setJobnum(Integer jobnum)
    {
        this.jobnum = jobnum;
    }

    public Integer getEducation()
    {
        return education;
    }

    public void setEducation(Integer education)
    {
        this.education = education;
    }

    public Integer getWorkexperience_min()
    {
        return workexperience_min;
    }

    public void setWorkexperience_min(Integer workexperience_min)
    {
        this.workexperience_min = workexperience_min;
    }

    public Integer getWorkexperience_max()
    {
        return workexperience_max;
    }

    public void setWorkexperience_max(Integer workexperience_max)
    {
        this.workexperience_max = workexperience_max;
    }
}
