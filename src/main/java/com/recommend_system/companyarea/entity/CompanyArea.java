package com.recommend_system.companyarea.entity;

public class CompanyArea {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column companyarea.city
     *
     * @mbggenerated
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column companyarea.companynum
     *
     * @mbggenerated
     */
    private Integer companynum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column companyarea.city
     *
     * @return the value of companyarea.city
     *
     * @mbggenerated
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column companyarea.city
     *
     * @param city the value for companyarea.city
     *
     * @mbggenerated
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column companyarea.companynum
     *
     * @return the value of companyarea.companynum
     *
     * @mbggenerated
     */
    public Integer getCompanynum() {
        return companynum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column companyarea.companynum
     *
     * @param companynum the value for companyarea.companynum
     *
     * @mbggenerated
     */
    public void setCompanynum(Integer companynum) {
        this.companynum = companynum;
    }
}