package com.recommend_system.companyarea.dao;

import com.recommend_system.companyarea.entity.CompanyArea;
import com.recommend_system.companyarea.entity.CompanyAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyAreaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companyarea
     *
     * @mbggenerated
     */
    int countByExample(CompanyAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companyarea
     *
     * @mbggenerated
     */
    int deleteByExample(CompanyAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companyarea
     *
     * @mbggenerated
     */
    int insert(CompanyArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companyarea
     *
     * @mbggenerated
     */
    int insertSelective(CompanyArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companyarea
     *
     * @mbggenerated
     */
    List<CompanyArea> selectByExample(CompanyAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companyarea
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CompanyArea record, @Param("example") CompanyAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companyarea
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CompanyArea record, @Param("example") CompanyAreaExample example);
}