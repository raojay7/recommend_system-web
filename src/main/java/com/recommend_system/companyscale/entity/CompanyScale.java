package com.recommend_system.companyscale.entity;

public class CompanyScale {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column companyscale.company_scale
     *
     * @mbggenerated
     */
    private String companyScale;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column companyscale.companynum
     *
     * @mbggenerated
     */
    private Integer companynum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column companyscale.company_scale
     *
     * @return the value of companyscale.company_scale
     *
     * @mbggenerated
     */
    public String getCompanyScale() {
        return companyScale;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column companyscale.company_scale
     *
     * @param companyScale the value for companyscale.company_scale
     *
     * @mbggenerated
     */
    public void setCompanyScale(String companyScale) {
        this.companyScale = companyScale == null ? null : companyScale.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column companyscale.companynum
     *
     * @return the value of companyscale.companynum
     *
     * @mbggenerated
     */
    public Integer getCompanynum() {
        return companynum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column companyscale.companynum
     *
     * @param companynum the value for companyscale.companynum
     *
     * @mbggenerated
     */
    public void setCompanynum(Integer companynum) {
        this.companynum = companynum;
    }
}