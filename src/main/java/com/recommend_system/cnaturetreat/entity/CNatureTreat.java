package com.recommend_system.cnaturetreat.entity;

public class CNatureTreat {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cnature_treat.worknum
     *
     * @mbggenerated
     */
    private Integer worknum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cnature_treat.company_nature
     *
     * @mbggenerated
     */
    private String companyNature;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cnature_treat.avg_salary
     *
     * @mbggenerated
     */
    private Integer avgSalary;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cnature_treat.worknum
     *
     * @return the value of cnature_treat.worknum
     *
     * @mbggenerated
     */
    public Integer getWorknum() {
        return worknum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cnature_treat.worknum
     *
     * @param worknum the value for cnature_treat.worknum
     *
     * @mbggenerated
     */
    public void setWorknum(Integer worknum) {
        this.worknum = worknum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cnature_treat.company_nature
     *
     * @return the value of cnature_treat.company_nature
     *
     * @mbggenerated
     */
    public String getCompanyNature() {
        return companyNature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cnature_treat.company_nature
     *
     * @param companyNature the value for cnature_treat.company_nature
     *
     * @mbggenerated
     */
    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature == null ? null : companyNature.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cnature_treat.avg_salary
     *
     * @return the value of cnature_treat.avg_salary
     *
     * @mbggenerated
     */
    public Integer getAvgSalary() {
        return avgSalary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cnature_treat.avg_salary
     *
     * @param avgSalary the value for cnature_treat.avg_salary
     *
     * @mbggenerated
     */
    public void setAvgSalary(Integer avgSalary) {
        this.avgSalary = avgSalary;
    }
}