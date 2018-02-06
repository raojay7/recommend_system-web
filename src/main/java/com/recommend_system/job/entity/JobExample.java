package com.recommend_system.job.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class JobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JobExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andJobIdIsNull() {
            addCriterion("job_id is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("job_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(Integer value) {
            addCriterion("job_id =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(Integer value) {
            addCriterion("job_id <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(Integer value) {
            addCriterion("job_id >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_id >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(Integer value) {
            addCriterion("job_id <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(Integer value) {
            addCriterion("job_id <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<Integer> values) {
            addCriterion("job_id in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<Integer> values) {
            addCriterion("job_id not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(Integer value1, Integer value2) {
            addCriterion("job_id between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(Integer value1, Integer value2) {
            addCriterion("job_id not between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("job_name like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("job_name not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("job_name in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andSalaryMinIsNull() {
            addCriterion("salary_min is null");
            return (Criteria) this;
        }

        public Criteria andSalaryMinIsNotNull() {
            addCriterion("salary_min is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryMinEqualTo(Integer value) {
            addCriterion("salary_min =", value, "salaryMin");
            return (Criteria) this;
        }

        public Criteria andSalaryMinNotEqualTo(Integer value) {
            addCriterion("salary_min <>", value, "salaryMin");
            return (Criteria) this;
        }

        public Criteria andSalaryMinGreaterThan(Integer value) {
            addCriterion("salary_min >", value, "salaryMin");
            return (Criteria) this;
        }

        public Criteria andSalaryMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("salary_min >=", value, "salaryMin");
            return (Criteria) this;
        }

        public Criteria andSalaryMinLessThan(Integer value) {
            addCriterion("salary_min <", value, "salaryMin");
            return (Criteria) this;
        }

        public Criteria andSalaryMinLessThanOrEqualTo(Integer value) {
            addCriterion("salary_min <=", value, "salaryMin");
            return (Criteria) this;
        }

        public Criteria andSalaryMinIn(List<Integer> values) {
            addCriterion("salary_min in", values, "salaryMin");
            return (Criteria) this;
        }

        public Criteria andSalaryMinNotIn(List<Integer> values) {
            addCriterion("salary_min not in", values, "salaryMin");
            return (Criteria) this;
        }

        public Criteria andSalaryMinBetween(Integer value1, Integer value2) {
            addCriterion("salary_min between", value1, value2, "salaryMin");
            return (Criteria) this;
        }

        public Criteria andSalaryMinNotBetween(Integer value1, Integer value2) {
            addCriterion("salary_min not between", value1, value2, "salaryMin");
            return (Criteria) this;
        }

        public Criteria andSalaryMaxIsNull() {
            addCriterion("salary_max is null");
            return (Criteria) this;
        }

        public Criteria andSalaryMaxIsNotNull() {
            addCriterion("salary_max is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryMaxEqualTo(Integer value) {
            addCriterion("salary_max =", value, "salaryMax");
            return (Criteria) this;
        }

        public Criteria andSalaryMaxNotEqualTo(Integer value) {
            addCriterion("salary_max <>", value, "salaryMax");
            return (Criteria) this;
        }

        public Criteria andSalaryMaxGreaterThan(Integer value) {
            addCriterion("salary_max >", value, "salaryMax");
            return (Criteria) this;
        }

        public Criteria andSalaryMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("salary_max >=", value, "salaryMax");
            return (Criteria) this;
        }

        public Criteria andSalaryMaxLessThan(Integer value) {
            addCriterion("salary_max <", value, "salaryMax");
            return (Criteria) this;
        }

        public Criteria andSalaryMaxLessThanOrEqualTo(Integer value) {
            addCriterion("salary_max <=", value, "salaryMax");
            return (Criteria) this;
        }

        public Criteria andSalaryMaxIn(List<Integer> values) {
            addCriterion("salary_max in", values, "salaryMax");
            return (Criteria) this;
        }

        public Criteria andSalaryMaxNotIn(List<Integer> values) {
            addCriterion("salary_max not in", values, "salaryMax");
            return (Criteria) this;
        }

        public Criteria andSalaryMaxBetween(Integer value1, Integer value2) {
            addCriterion("salary_max between", value1, value2, "salaryMax");
            return (Criteria) this;
        }

        public Criteria andSalaryMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("salary_max not between", value1, value2, "salaryMax");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(Integer value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(Integer value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(Integer value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(Integer value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(Integer value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(Integer value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<Integer> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<Integer> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(Integer value1, Integer value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(Integer value1, Integer value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andWorkplaceIsNull() {
            addCriterion("workplace is null");
            return (Criteria) this;
        }

        public Criteria andWorkplaceIsNotNull() {
            addCriterion("workplace is not null");
            return (Criteria) this;
        }

        public Criteria andWorkplaceEqualTo(String value) {
            addCriterion("workplace =", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotEqualTo(String value) {
            addCriterion("workplace <>", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceGreaterThan(String value) {
            addCriterion("workplace >", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceGreaterThanOrEqualTo(String value) {
            addCriterion("workplace >=", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceLessThan(String value) {
            addCriterion("workplace <", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceLessThanOrEqualTo(String value) {
            addCriterion("workplace <=", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceLike(String value) {
            addCriterion("workplace like", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotLike(String value) {
            addCriterion("workplace not like", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceIn(List<String> values) {
            addCriterion("workplace in", values, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotIn(List<String> values) {
            addCriterion("workplace not in", values, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceBetween(String value1, String value2) {
            addCriterion("workplace between", value1, value2, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotBetween(String value1, String value2) {
            addCriterion("workplace not between", value1, value2, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMinIsNull() {
            addCriterion("workexperience_min is null");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMinIsNotNull() {
            addCriterion("workexperience_min is not null");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMinEqualTo(Integer value) {
            addCriterion("workexperience_min =", value, "workexperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMinNotEqualTo(Integer value) {
            addCriterion("workexperience_min <>", value, "workexperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMinGreaterThan(Integer value) {
            addCriterion("workexperience_min >", value, "workexperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("workexperience_min >=", value, "workexperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMinLessThan(Integer value) {
            addCriterion("workexperience_min <", value, "workexperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMinLessThanOrEqualTo(Integer value) {
            addCriterion("workexperience_min <=", value, "workexperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMinIn(List<Integer> values) {
            addCriterion("workexperience_min in", values, "workexperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMinNotIn(List<Integer> values) {
            addCriterion("workexperience_min not in", values, "workexperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMinBetween(Integer value1, Integer value2) {
            addCriterion("workexperience_min between", value1, value2, "workexperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMinNotBetween(Integer value1, Integer value2) {
            addCriterion("workexperience_min not between", value1, value2, "workexperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMaxIsNull() {
            addCriterion("workexperience_max is null");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMaxIsNotNull() {
            addCriterion("workexperience_max is not null");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMaxEqualTo(Integer value) {
            addCriterion("workexperience_max =", value, "workexperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMaxNotEqualTo(Integer value) {
            addCriterion("workexperience_max <>", value, "workexperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMaxGreaterThan(Integer value) {
            addCriterion("workexperience_max >", value, "workexperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("workexperience_max >=", value, "workexperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMaxLessThan(Integer value) {
            addCriterion("workexperience_max <", value, "workexperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMaxLessThanOrEqualTo(Integer value) {
            addCriterion("workexperience_max <=", value, "workexperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMaxIn(List<Integer> values) {
            addCriterion("workexperience_max in", values, "workexperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMaxNotIn(List<Integer> values) {
            addCriterion("workexperience_max not in", values, "workexperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMaxBetween(Integer value1, Integer value2) {
            addCriterion("workexperience_max between", value1, value2, "workexperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkexperienceMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("workexperience_max not between", value1, value2, "workexperienceMax");
            return (Criteria) this;
        }

        public Criteria andNeedNumIsNull() {
            addCriterion("need_num is null");
            return (Criteria) this;
        }

        public Criteria andNeedNumIsNotNull() {
            addCriterion("need_num is not null");
            return (Criteria) this;
        }

        public Criteria andNeedNumEqualTo(Integer value) {
            addCriterion("need_num =", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumNotEqualTo(Integer value) {
            addCriterion("need_num <>", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumGreaterThan(Integer value) {
            addCriterion("need_num >", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_num >=", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumLessThan(Integer value) {
            addCriterion("need_num <", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumLessThanOrEqualTo(Integer value) {
            addCriterion("need_num <=", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumIn(List<Integer> values) {
            addCriterion("need_num in", values, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumNotIn(List<Integer> values) {
            addCriterion("need_num not in", values, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumBetween(Integer value1, Integer value2) {
            addCriterion("need_num between", value1, value2, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumNotBetween(Integer value1, Integer value2) {
            addCriterion("need_num not between", value1, value2, "needNum");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterionForJDBCDate("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterionForJDBCDate("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterionForJDBCDate("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andJobNatureIsNull() {
            addCriterion("job_nature is null");
            return (Criteria) this;
        }

        public Criteria andJobNatureIsNotNull() {
            addCriterion("job_nature is not null");
            return (Criteria) this;
        }

        public Criteria andJobNatureEqualTo(Integer value) {
            addCriterion("job_nature =", value, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureNotEqualTo(Integer value) {
            addCriterion("job_nature <>", value, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureGreaterThan(Integer value) {
            addCriterion("job_nature >", value, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_nature >=", value, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureLessThan(Integer value) {
            addCriterion("job_nature <", value, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureLessThanOrEqualTo(Integer value) {
            addCriterion("job_nature <=", value, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureIn(List<Integer> values) {
            addCriterion("job_nature in", values, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureNotIn(List<Integer> values) {
            addCriterion("job_nature not in", values, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureBetween(Integer value1, Integer value2) {
            addCriterion("job_nature between", value1, value2, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureNotBetween(Integer value1, Integer value2) {
            addCriterion("job_nature not between", value1, value2, "jobNature");
            return (Criteria) this;
        }

        public Criteria andWelfareIsNull() {
            addCriterion("welfare is null");
            return (Criteria) this;
        }

        public Criteria andWelfareIsNotNull() {
            addCriterion("welfare is not null");
            return (Criteria) this;
        }

        public Criteria andWelfareEqualTo(String value) {
            addCriterion("welfare =", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotEqualTo(String value) {
            addCriterion("welfare <>", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareGreaterThan(String value) {
            addCriterion("welfare >", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareGreaterThanOrEqualTo(String value) {
            addCriterion("welfare >=", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareLessThan(String value) {
            addCriterion("welfare <", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareLessThanOrEqualTo(String value) {
            addCriterion("welfare <=", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareLike(String value) {
            addCriterion("welfare like", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotLike(String value) {
            addCriterion("welfare not like", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareIn(List<String> values) {
            addCriterion("welfare in", values, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotIn(List<String> values) {
            addCriterion("welfare not in", values, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareBetween(String value1, String value2) {
            addCriterion("welfare between", value1, value2, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotBetween(String value1, String value2) {
            addCriterion("welfare not between", value1, value2, "welfare");
            return (Criteria) this;
        }

        public Criteria andWorkcityIsNull() {
            addCriterion("workcity is null");
            return (Criteria) this;
        }

        public Criteria andWorkcityIsNotNull() {
            addCriterion("workcity is not null");
            return (Criteria) this;
        }

        public Criteria andWorkcityEqualTo(String value) {
            addCriterion("workcity =", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityNotEqualTo(String value) {
            addCriterion("workcity <>", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityGreaterThan(String value) {
            addCriterion("workcity >", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityGreaterThanOrEqualTo(String value) {
            addCriterion("workcity >=", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityLessThan(String value) {
            addCriterion("workcity <", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityLessThanOrEqualTo(String value) {
            addCriterion("workcity <=", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityLike(String value) {
            addCriterion("workcity like", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityNotLike(String value) {
            addCriterion("workcity not like", value, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityIn(List<String> values) {
            addCriterion("workcity in", values, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityNotIn(List<String> values) {
            addCriterion("workcity not in", values, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityBetween(String value1, String value2) {
            addCriterion("workcity between", value1, value2, "workcity");
            return (Criteria) this;
        }

        public Criteria andWorkcityNotBetween(String value1, String value2) {
            addCriterion("workcity not between", value1, value2, "workcity");
            return (Criteria) this;
        }

        public Criteria andAgeMinIsNull() {
            addCriterion("age_min is null");
            return (Criteria) this;
        }

        public Criteria andAgeMinIsNotNull() {
            addCriterion("age_min is not null");
            return (Criteria) this;
        }

        public Criteria andAgeMinEqualTo(String value) {
            addCriterion("age_min =", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinNotEqualTo(String value) {
            addCriterion("age_min <>", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinGreaterThan(String value) {
            addCriterion("age_min >", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinGreaterThanOrEqualTo(String value) {
            addCriterion("age_min >=", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinLessThan(String value) {
            addCriterion("age_min <", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinLessThanOrEqualTo(String value) {
            addCriterion("age_min <=", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinLike(String value) {
            addCriterion("age_min like", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinNotLike(String value) {
            addCriterion("age_min not like", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinIn(List<String> values) {
            addCriterion("age_min in", values, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinNotIn(List<String> values) {
            addCriterion("age_min not in", values, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinBetween(String value1, String value2) {
            addCriterion("age_min between", value1, value2, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinNotBetween(String value1, String value2) {
            addCriterion("age_min not between", value1, value2, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMaxIsNull() {
            addCriterion("age_max is null");
            return (Criteria) this;
        }

        public Criteria andAgeMaxIsNotNull() {
            addCriterion("age_max is not null");
            return (Criteria) this;
        }

        public Criteria andAgeMaxEqualTo(String value) {
            addCriterion("age_max =", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxNotEqualTo(String value) {
            addCriterion("age_max <>", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxGreaterThan(String value) {
            addCriterion("age_max >", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxGreaterThanOrEqualTo(String value) {
            addCriterion("age_max >=", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxLessThan(String value) {
            addCriterion("age_max <", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxLessThanOrEqualTo(String value) {
            addCriterion("age_max <=", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxLike(String value) {
            addCriterion("age_max like", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxNotLike(String value) {
            addCriterion("age_max not like", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxIn(List<String> values) {
            addCriterion("age_max in", values, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxNotIn(List<String> values) {
            addCriterion("age_max not in", values, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxBetween(String value1, String value2) {
            addCriterion("age_max between", value1, value2, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxNotBetween(String value1, String value2) {
            addCriterion("age_max not between", value1, value2, "ageMax");
            return (Criteria) this;
        }

        public Criteria andNeedGenderIsNull() {
            addCriterion("need_gender is null");
            return (Criteria) this;
        }

        public Criteria andNeedGenderIsNotNull() {
            addCriterion("need_gender is not null");
            return (Criteria) this;
        }

        public Criteria andNeedGenderEqualTo(Integer value) {
            addCriterion("need_gender =", value, "needGender");
            return (Criteria) this;
        }

        public Criteria andNeedGenderNotEqualTo(Integer value) {
            addCriterion("need_gender <>", value, "needGender");
            return (Criteria) this;
        }

        public Criteria andNeedGenderGreaterThan(Integer value) {
            addCriterion("need_gender >", value, "needGender");
            return (Criteria) this;
        }

        public Criteria andNeedGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_gender >=", value, "needGender");
            return (Criteria) this;
        }

        public Criteria andNeedGenderLessThan(Integer value) {
            addCriterion("need_gender <", value, "needGender");
            return (Criteria) this;
        }

        public Criteria andNeedGenderLessThanOrEqualTo(Integer value) {
            addCriterion("need_gender <=", value, "needGender");
            return (Criteria) this;
        }

        public Criteria andNeedGenderIn(List<Integer> values) {
            addCriterion("need_gender in", values, "needGender");
            return (Criteria) this;
        }

        public Criteria andNeedGenderNotIn(List<Integer> values) {
            addCriterion("need_gender not in", values, "needGender");
            return (Criteria) this;
        }

        public Criteria andNeedGenderBetween(Integer value1, Integer value2) {
            addCriterion("need_gender between", value1, value2, "needGender");
            return (Criteria) this;
        }

        public Criteria andNeedGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("need_gender not between", value1, value2, "needGender");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNull() {
            addCriterion("language is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNotNull() {
            addCriterion("language is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageEqualTo(String value) {
            addCriterion("language =", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotEqualTo(String value) {
            addCriterion("language <>", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThan(String value) {
            addCriterion("language >", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("language >=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThan(String value) {
            addCriterion("language <", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThanOrEqualTo(String value) {
            addCriterion("language <=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLike(String value) {
            addCriterion("language like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotLike(String value) {
            addCriterion("language not like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageIn(List<String> values) {
            addCriterion("language in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotIn(List<String> values) {
            addCriterion("language not in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageBetween(String value1, String value2) {
            addCriterion("language between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotBetween(String value1, String value2) {
            addCriterion("language not between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}