package com.recommend_system.company.dao;

import com.recommend_system.company.entity.Company;
import com.recommend_system.company.entity.CompanyExample;
import java.util.List;
import java.util.Map;

import com.recommend_system.company.entity.CompanyExt;
import org.apache.ibatis.annotations.Param;

public interface CompanyMapper {
    int countByExample(CompanyExample example);

    int deleteByExample(CompanyExample example);

    int deleteByPrimaryKey(Integer companyId);

    int insert(Company record);

    int insertSelective(Company record);

    List<Company> selectByExample(CompanyExample example);

    Company selectByPrimaryKey(Integer companyId);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    //显示城市公司数目
    List<CompanyExt> getCompanyCity();

    //企业行业分布
    List<CompanyExt> getCompanyIndustry();

    //企业性质分布
    List<CompanyExt> getCompanyNature();

    //企业规模分布
    List<CompanyExt> getCompanyScale(String company_industry);

    //企业规模分布
    List<CompanyExt> getCompanyScaleGroupByScale();

    //不同性质公司的平均工资及岗位需求量分布
    List<CompanyExt> getCompanyNatureNeedAvg();

    //不同行业公司平均工资及岗位需求量分布
    List<CompanyExt> getCompanyIndustryNeedAvg();




}