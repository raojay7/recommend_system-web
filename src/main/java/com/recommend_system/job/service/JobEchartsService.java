package com.recommend_system.job.service;

public interface JobEchartsService {

    /*
     *城市平均工资条形统计图
     * SELECT workcity,AVG((salary_min+SALARY_MAX)/2) FROM t_job GROUP BY workcity
     * 需要map<String,Integer>
     */
    public String getCityAvgSalary();

    /*
     *学历工资分布
     * SELECT SUM(NEED_NUM),AVG((SALARY_MIN+SALARY_MAX)/2),EDUCATION FROM T_JOB GROUP BY EDUCATION;
     * 需要map<String,Integer>
     */
    public String getEducationAvgSalary();

    /*
     *职位地域分布
     * SELECT WORKCITY,COUNT(*) FROM T_JOB GROUP BY WORKCITY
     * 需要map<String,Integer>
     */
    public String getJobCity();

    /*
     *工作经验工资分布
     * SELECT WORKEXPERIENCE_MIN,WORKEXPERIENCE_MAX,AVG((SALARY_MIN+SALARY_MAX)/2) FROM T_JOB GROUP BY WORKEXPERIENCE_MIN,WORKEXPERIENCE_MAX;
     * 工作经验范围是固定的，1-3,3-5,5-10,只需要三个对应的AVG值，需要list<Integer>
     */
    public String getExperienceSalary();
}
