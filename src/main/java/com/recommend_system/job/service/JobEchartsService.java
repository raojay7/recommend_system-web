package com.recommend_system.job.service;

public interface JobEchartsService {

    /*
     *城市平均工资条形统计图
     * SELECT workcity,AVG((salary_min+SALARY_MAX)/2) FROM t_job GROUP BY workcity
     */
    public void getCityAvgSalary();

    /*
     *学历工资分布
     * SELECT SUM(NEED_NUM),AVG((SALARY_MIN+SALARY_MAX)/2),EDUCATION FROM T_JOB GROUP BY EDUCATION;
     */
    public void getEducationAvgSalary();

    /*
     *职位地域分布
     * SELECT WORKCITY,COUNT(*) FROM T_JOB GROUP BY WORKCITY
     */
    public void getJobCity();

    /*
     *工作经验工资分布
     * SELECT WORKEXPERIENCE_MIN,WORKEXPERIENCE_MAX,AVG((SALARY_MIN+SALARY_MAX)/2) FROM T_JOB GROUP BY WORKEXPERIENCE_MIN,WORKEXPERIENCE_MAX;
     */
    public void getExperienceSalary();
}
