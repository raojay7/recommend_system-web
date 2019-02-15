package com.recommend_system.eduandsalary.dao;

import com.recommend_system.eduandsalary.entity.EduandSalary;
import com.recommend_system.eduandsalary.entity.EduandSalaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EduandSalaryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eduandsalary
     *
     * @mbggenerated
     */
    int countByExample(EduandSalaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eduandsalary
     *
     * @mbggenerated
     */
    int deleteByExample(EduandSalaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eduandsalary
     *
     * @mbggenerated
     */
    int insert(EduandSalary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eduandsalary
     *
     * @mbggenerated
     */
    int insertSelective(EduandSalary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eduandsalary
     *
     * @mbggenerated
     */
    List<EduandSalary> selectByExample(EduandSalaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eduandsalary
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") EduandSalary record, @Param("example") EduandSalaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eduandsalary
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") EduandSalary record, @Param("example") EduandSalaryExample example);
}