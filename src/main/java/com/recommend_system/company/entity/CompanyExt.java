package com.recommend_system.company.entity;

import java.io.Serializable;

public class CompanyExt implements Serializable
{
    private Integer jobnum;
    private String city;
    private String company_industry;
    private String company_nature;
    private String company_scale;
    private Double ave_salary;

    public Double getAve_salary()
    {
        return ave_salary;
    }

    public void setAve_salary(Double ave_salary)
    {
        this.ave_salary = ave_salary;
    }

    public String getCompany_scale()
    {
        return company_scale;
    }

    public void setCompany_scale(String company_scale)
    {
        this.company_scale = company_scale;
    }

    public String getCompany_industry()
    {
        return company_industry;
    }

    public void setCompany_industry(String company_industry)
    {
        this.company_industry = company_industry;
    }

    public String getCompany_nature()
    {
        return company_nature;
    }

    public void setCompany_nature(String company_nature)
    {
        this.company_nature = company_nature;
    }

    private static final long serialVersionUID = 1L;

    public Integer getJobnum()
    {
        return jobnum;
    }

    public void setJobnum(Integer jobnum)
    {
        this.jobnum = jobnum;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }
}
