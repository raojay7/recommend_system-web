package com.recommend_system.company.service;

public interface CompanyEchartsService {

    /*
     *企业地域分布
     * SELECT COUNT(CITY),CITY FROM T_COMPANY GROUP BY CITY
     * 需要map<String,Integer>
     */
    public String getCompanyCity();

    /*
     *企业行业分布
     * SELECT COMPANY_INDUSTRY,COUNT(*) FROM T_COMPANY GROUP BY COMPANY_INDUSTRY;
     * 需要map<String,Integer>
     */
    public String getCompanyIndustry();

    /*
     *企业性质分布
     * SELECT COUNT(*),COMPANY_NATURE FROM T_COMPANY GROUP BY COMPANY_NATURE;
     * 需要map<String,Integer>
     */
    public String getCompanyNature();

    /*
     *企业规模分布
     * SELECT COUNT(*),COMPANY_SCALE FROM T_COMPANY GROUP BY COMPANY_SCALE
     * 需要map<Integer,Integer>
     */
    public String getCompanyScale();

    /*
     *不同性质公司的平均工资及岗位需求量分布
     * SELECT SUM(need_num)AS '岗位个数',c.company_nature AS '公司性质',AVG((j.salary_min+j.salary_max)/2) AS '平均薪水' FROM t_job j,t_company c WHERE j.company_id=c.company_id GROUP BY c.company_nature;
     * 需要2个map<String,Integer>
     */
    public String getCompanyNatureNeedAvg();

    /*
     *不同行业公司平均工资及岗位需求量分布
     * SELECT SUM(need_num)AS '岗位个数',c.company_industry,AVG((j.salary_min+j.salary_max)/2) AS '平均薪水' FROM t_job j,t_company c WHERE j.company_id=c.company_id  GROUP BY company_industry;
     * 需要2个map<String,Integer>
     */
    public String getCompanyIndustryNeedAvg();
}
