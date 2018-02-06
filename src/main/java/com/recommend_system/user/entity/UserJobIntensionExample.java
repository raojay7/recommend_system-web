package com.recommend_system.user.entity;

import java.util.ArrayList;
import java.util.List;

public class UserJobIntensionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserJobIntensionExample() {
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

        public Criteria andIntensionIdIsNull() {
            addCriterion("intension_id is null");
            return (Criteria) this;
        }

        public Criteria andIntensionIdIsNotNull() {
            addCriterion("intension_id is not null");
            return (Criteria) this;
        }

        public Criteria andIntensionIdEqualTo(Integer value) {
            addCriterion("intension_id =", value, "intensionId");
            return (Criteria) this;
        }

        public Criteria andIntensionIdNotEqualTo(Integer value) {
            addCriterion("intension_id <>", value, "intensionId");
            return (Criteria) this;
        }

        public Criteria andIntensionIdGreaterThan(Integer value) {
            addCriterion("intension_id >", value, "intensionId");
            return (Criteria) this;
        }

        public Criteria andIntensionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("intension_id >=", value, "intensionId");
            return (Criteria) this;
        }

        public Criteria andIntensionIdLessThan(Integer value) {
            addCriterion("intension_id <", value, "intensionId");
            return (Criteria) this;
        }

        public Criteria andIntensionIdLessThanOrEqualTo(Integer value) {
            addCriterion("intension_id <=", value, "intensionId");
            return (Criteria) this;
        }

        public Criteria andIntensionIdIn(List<Integer> values) {
            addCriterion("intension_id in", values, "intensionId");
            return (Criteria) this;
        }

        public Criteria andIntensionIdNotIn(List<Integer> values) {
            addCriterion("intension_id not in", values, "intensionId");
            return (Criteria) this;
        }

        public Criteria andIntensionIdBetween(Integer value1, Integer value2) {
            addCriterion("intension_id between", value1, value2, "intensionId");
            return (Criteria) this;
        }

        public Criteria andIntensionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("intension_id not between", value1, value2, "intensionId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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