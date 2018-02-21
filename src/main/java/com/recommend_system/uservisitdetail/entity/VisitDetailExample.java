package com.recommend_system.uservisitdetail.entity;

import java.util.ArrayList;
import java.util.List;

public class VisitDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisitDetailExample() {
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

        public Criteria andVisitedDetailIdIsNull() {
            addCriterion("visited_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andVisitedDetailIdIsNotNull() {
            addCriterion("visited_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andVisitedDetailIdEqualTo(Integer value) {
            addCriterion("visited_detail_id =", value, "visitedDetailId");
            return (Criteria) this;
        }

        public Criteria andVisitedDetailIdNotEqualTo(Integer value) {
            addCriterion("visited_detail_id <>", value, "visitedDetailId");
            return (Criteria) this;
        }

        public Criteria andVisitedDetailIdGreaterThan(Integer value) {
            addCriterion("visited_detail_id >", value, "visitedDetailId");
            return (Criteria) this;
        }

        public Criteria andVisitedDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("visited_detail_id >=", value, "visitedDetailId");
            return (Criteria) this;
        }

        public Criteria andVisitedDetailIdLessThan(Integer value) {
            addCriterion("visited_detail_id <", value, "visitedDetailId");
            return (Criteria) this;
        }

        public Criteria andVisitedDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("visited_detail_id <=", value, "visitedDetailId");
            return (Criteria) this;
        }

        public Criteria andVisitedDetailIdIn(List<Integer> values) {
            addCriterion("visited_detail_id in", values, "visitedDetailId");
            return (Criteria) this;
        }

        public Criteria andVisitedDetailIdNotIn(List<Integer> values) {
            addCriterion("visited_detail_id not in", values, "visitedDetailId");
            return (Criteria) this;
        }

        public Criteria andVisitedDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("visited_detail_id between", value1, value2, "visitedDetailId");
            return (Criteria) this;
        }

        public Criteria andVisitedDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("visited_detail_id not between", value1, value2, "visitedDetailId");
            return (Criteria) this;
        }

        public Criteria andWebIdIsNull() {
            addCriterion("web_id is null");
            return (Criteria) this;
        }

        public Criteria andWebIdIsNotNull() {
            addCriterion("web_id is not null");
            return (Criteria) this;
        }

        public Criteria andWebIdEqualTo(String value) {
            addCriterion("web_id =", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdNotEqualTo(String value) {
            addCriterion("web_id <>", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdGreaterThan(String value) {
            addCriterion("web_id >", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdGreaterThanOrEqualTo(String value) {
            addCriterion("web_id >=", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdLessThan(String value) {
            addCriterion("web_id <", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdLessThanOrEqualTo(String value) {
            addCriterion("web_id <=", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdLike(String value) {
            addCriterion("web_id like", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdNotLike(String value) {
            addCriterion("web_id not like", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdIn(List<String> values) {
            addCriterion("web_id in", values, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdNotIn(List<String> values) {
            addCriterion("web_id not in", values, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdBetween(String value1, String value2) {
            addCriterion("web_id between", value1, value2, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdNotBetween(String value1, String value2) {
            addCriterion("web_id not between", value1, value2, "webId");
            return (Criteria) this;
        }

        public Criteria andJobCategoryIsNull() {
            addCriterion("job_category is null");
            return (Criteria) this;
        }

        public Criteria andJobCategoryIsNotNull() {
            addCriterion("job_category is not null");
            return (Criteria) this;
        }

        public Criteria andJobCategoryEqualTo(Integer value) {
            addCriterion("job_category =", value, "jobCategory");
            return (Criteria) this;
        }

        public Criteria andJobCategoryNotEqualTo(Integer value) {
            addCriterion("job_category <>", value, "jobCategory");
            return (Criteria) this;
        }

        public Criteria andJobCategoryGreaterThan(Integer value) {
            addCriterion("job_category >", value, "jobCategory");
            return (Criteria) this;
        }

        public Criteria andJobCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_category >=", value, "jobCategory");
            return (Criteria) this;
        }

        public Criteria andJobCategoryLessThan(Integer value) {
            addCriterion("job_category <", value, "jobCategory");
            return (Criteria) this;
        }

        public Criteria andJobCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("job_category <=", value, "jobCategory");
            return (Criteria) this;
        }

        public Criteria andJobCategoryIn(List<Integer> values) {
            addCriterion("job_category in", values, "jobCategory");
            return (Criteria) this;
        }

        public Criteria andJobCategoryNotIn(List<Integer> values) {
            addCriterion("job_category not in", values, "jobCategory");
            return (Criteria) this;
        }

        public Criteria andJobCategoryBetween(Integer value1, Integer value2) {
            addCriterion("job_category between", value1, value2, "jobCategory");
            return (Criteria) this;
        }

        public Criteria andJobCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("job_category not between", value1, value2, "jobCategory");
            return (Criteria) this;
        }

        public Criteria andJobPropertyIsNull() {
            addCriterion("job_property is null");
            return (Criteria) this;
        }

        public Criteria andJobPropertyIsNotNull() {
            addCriterion("job_property is not null");
            return (Criteria) this;
        }

        public Criteria andJobPropertyEqualTo(Integer value) {
            addCriterion("job_property =", value, "jobProperty");
            return (Criteria) this;
        }

        public Criteria andJobPropertyNotEqualTo(Integer value) {
            addCriterion("job_property <>", value, "jobProperty");
            return (Criteria) this;
        }

        public Criteria andJobPropertyGreaterThan(Integer value) {
            addCriterion("job_property >", value, "jobProperty");
            return (Criteria) this;
        }

        public Criteria andJobPropertyGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_property >=", value, "jobProperty");
            return (Criteria) this;
        }

        public Criteria andJobPropertyLessThan(Integer value) {
            addCriterion("job_property <", value, "jobProperty");
            return (Criteria) this;
        }

        public Criteria andJobPropertyLessThanOrEqualTo(Integer value) {
            addCriterion("job_property <=", value, "jobProperty");
            return (Criteria) this;
        }

        public Criteria andJobPropertyIn(List<Integer> values) {
            addCriterion("job_property in", values, "jobProperty");
            return (Criteria) this;
        }

        public Criteria andJobPropertyNotIn(List<Integer> values) {
            addCriterion("job_property not in", values, "jobProperty");
            return (Criteria) this;
        }

        public Criteria andJobPropertyBetween(Integer value1, Integer value2) {
            addCriterion("job_property between", value1, value2, "jobProperty");
            return (Criteria) this;
        }

        public Criteria andJobPropertyNotBetween(Integer value1, Integer value2) {
            addCriterion("job_property not between", value1, value2, "jobProperty");
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

        public Criteria andWorkyearMinIsNull() {
            addCriterion("workyear_min is null");
            return (Criteria) this;
        }

        public Criteria andWorkyearMinIsNotNull() {
            addCriterion("workyear_min is not null");
            return (Criteria) this;
        }

        public Criteria andWorkyearMinEqualTo(Integer value) {
            addCriterion("workyear_min =", value, "workyearMin");
            return (Criteria) this;
        }

        public Criteria andWorkyearMinNotEqualTo(Integer value) {
            addCriterion("workyear_min <>", value, "workyearMin");
            return (Criteria) this;
        }

        public Criteria andWorkyearMinGreaterThan(Integer value) {
            addCriterion("workyear_min >", value, "workyearMin");
            return (Criteria) this;
        }

        public Criteria andWorkyearMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("workyear_min >=", value, "workyearMin");
            return (Criteria) this;
        }

        public Criteria andWorkyearMinLessThan(Integer value) {
            addCriterion("workyear_min <", value, "workyearMin");
            return (Criteria) this;
        }

        public Criteria andWorkyearMinLessThanOrEqualTo(Integer value) {
            addCriterion("workyear_min <=", value, "workyearMin");
            return (Criteria) this;
        }

        public Criteria andWorkyearMinIn(List<Integer> values) {
            addCriterion("workyear_min in", values, "workyearMin");
            return (Criteria) this;
        }

        public Criteria andWorkyearMinNotIn(List<Integer> values) {
            addCriterion("workyear_min not in", values, "workyearMin");
            return (Criteria) this;
        }

        public Criteria andWorkyearMinBetween(Integer value1, Integer value2) {
            addCriterion("workyear_min between", value1, value2, "workyearMin");
            return (Criteria) this;
        }

        public Criteria andWorkyearMinNotBetween(Integer value1, Integer value2) {
            addCriterion("workyear_min not between", value1, value2, "workyearMin");
            return (Criteria) this;
        }

        public Criteria andWorkyearMaxIsNull() {
            addCriterion("workyear_max is null");
            return (Criteria) this;
        }

        public Criteria andWorkyearMaxIsNotNull() {
            addCriterion("workyear_max is not null");
            return (Criteria) this;
        }

        public Criteria andWorkyearMaxEqualTo(Integer value) {
            addCriterion("workyear_max =", value, "workyearMax");
            return (Criteria) this;
        }

        public Criteria andWorkyearMaxNotEqualTo(Integer value) {
            addCriterion("workyear_max <>", value, "workyearMax");
            return (Criteria) this;
        }

        public Criteria andWorkyearMaxGreaterThan(Integer value) {
            addCriterion("workyear_max >", value, "workyearMax");
            return (Criteria) this;
        }

        public Criteria andWorkyearMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("workyear_max >=", value, "workyearMax");
            return (Criteria) this;
        }

        public Criteria andWorkyearMaxLessThan(Integer value) {
            addCriterion("workyear_max <", value, "workyearMax");
            return (Criteria) this;
        }

        public Criteria andWorkyearMaxLessThanOrEqualTo(Integer value) {
            addCriterion("workyear_max <=", value, "workyearMax");
            return (Criteria) this;
        }

        public Criteria andWorkyearMaxIn(List<Integer> values) {
            addCriterion("workyear_max in", values, "workyearMax");
            return (Criteria) this;
        }

        public Criteria andWorkyearMaxNotIn(List<Integer> values) {
            addCriterion("workyear_max not in", values, "workyearMax");
            return (Criteria) this;
        }

        public Criteria andWorkyearMaxBetween(Integer value1, Integer value2) {
            addCriterion("workyear_max between", value1, value2, "workyearMax");
            return (Criteria) this;
        }

        public Criteria andWorkyearMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("workyear_max not between", value1, value2, "workyearMax");
            return (Criteria) this;
        }

        public Criteria andProfessionalIsNull() {
            addCriterion("professional is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalIsNotNull() {
            addCriterion("professional is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalEqualTo(String value) {
            addCriterion("professional =", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotEqualTo(String value) {
            addCriterion("professional <>", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalGreaterThan(String value) {
            addCriterion("professional >", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalGreaterThanOrEqualTo(String value) {
            addCriterion("professional >=", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLessThan(String value) {
            addCriterion("professional <", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLessThanOrEqualTo(String value) {
            addCriterion("professional <=", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLike(String value) {
            addCriterion("professional like", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotLike(String value) {
            addCriterion("professional not like", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalIn(List<String> values) {
            addCriterion("professional in", values, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotIn(List<String> values) {
            addCriterion("professional not in", values, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalBetween(String value1, String value2) {
            addCriterion("professional between", value1, value2, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotBetween(String value1, String value2) {
            addCriterion("professional not between", value1, value2, "professional");
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

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andVisitLengthIsNull() {
            addCriterion("visit_length is null");
            return (Criteria) this;
        }

        public Criteria andVisitLengthIsNotNull() {
            addCriterion("visit_length is not null");
            return (Criteria) this;
        }

        public Criteria andVisitLengthEqualTo(Integer value) {
            addCriterion("visit_length =", value, "visitLength");
            return (Criteria) this;
        }

        public Criteria andVisitLengthNotEqualTo(Integer value) {
            addCriterion("visit_length <>", value, "visitLength");
            return (Criteria) this;
        }

        public Criteria andVisitLengthGreaterThan(Integer value) {
            addCriterion("visit_length >", value, "visitLength");
            return (Criteria) this;
        }

        public Criteria andVisitLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("visit_length >=", value, "visitLength");
            return (Criteria) this;
        }

        public Criteria andVisitLengthLessThan(Integer value) {
            addCriterion("visit_length <", value, "visitLength");
            return (Criteria) this;
        }

        public Criteria andVisitLengthLessThanOrEqualTo(Integer value) {
            addCriterion("visit_length <=", value, "visitLength");
            return (Criteria) this;
        }

        public Criteria andVisitLengthIn(List<Integer> values) {
            addCriterion("visit_length in", values, "visitLength");
            return (Criteria) this;
        }

        public Criteria andVisitLengthNotIn(List<Integer> values) {
            addCriterion("visit_length not in", values, "visitLength");
            return (Criteria) this;
        }

        public Criteria andVisitLengthBetween(Integer value1, Integer value2) {
            addCriterion("visit_length between", value1, value2, "visitLength");
            return (Criteria) this;
        }

        public Criteria andVisitLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("visit_length not between", value1, value2, "visitLength");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andCookieIdIsNull() {
            addCriterion("cookie_id is null");
            return (Criteria) this;
        }

        public Criteria andCookieIdIsNotNull() {
            addCriterion("cookie_id is not null");
            return (Criteria) this;
        }

        public Criteria andCookieIdEqualTo(String value) {
            addCriterion("cookie_id =", value, "cookieId");
            return (Criteria) this;
        }

        public Criteria andCookieIdNotEqualTo(String value) {
            addCriterion("cookie_id <>", value, "cookieId");
            return (Criteria) this;
        }

        public Criteria andCookieIdGreaterThan(String value) {
            addCriterion("cookie_id >", value, "cookieId");
            return (Criteria) this;
        }

        public Criteria andCookieIdGreaterThanOrEqualTo(String value) {
            addCriterion("cookie_id >=", value, "cookieId");
            return (Criteria) this;
        }

        public Criteria andCookieIdLessThan(String value) {
            addCriterion("cookie_id <", value, "cookieId");
            return (Criteria) this;
        }

        public Criteria andCookieIdLessThanOrEqualTo(String value) {
            addCriterion("cookie_id <=", value, "cookieId");
            return (Criteria) this;
        }

        public Criteria andCookieIdLike(String value) {
            addCriterion("cookie_id like", value, "cookieId");
            return (Criteria) this;
        }

        public Criteria andCookieIdNotLike(String value) {
            addCriterion("cookie_id not like", value, "cookieId");
            return (Criteria) this;
        }

        public Criteria andCookieIdIn(List<String> values) {
            addCriterion("cookie_id in", values, "cookieId");
            return (Criteria) this;
        }

        public Criteria andCookieIdNotIn(List<String> values) {
            addCriterion("cookie_id not in", values, "cookieId");
            return (Criteria) this;
        }

        public Criteria andCookieIdBetween(String value1, String value2) {
            addCriterion("cookie_id between", value1, value2, "cookieId");
            return (Criteria) this;
        }

        public Criteria andCookieIdNotBetween(String value1, String value2) {
            addCriterion("cookie_id not between", value1, value2, "cookieId");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andVisistedJobIdIsNull() {
            addCriterion("visisted_job_id is null");
            return (Criteria) this;
        }

        public Criteria andVisistedJobIdIsNotNull() {
            addCriterion("visisted_job_id is not null");
            return (Criteria) this;
        }

        public Criteria andVisistedJobIdEqualTo(Integer value) {
            addCriterion("visisted_job_id =", value, "visistedJobId");
            return (Criteria) this;
        }

        public Criteria andVisistedJobIdNotEqualTo(Integer value) {
            addCriterion("visisted_job_id <>", value, "visistedJobId");
            return (Criteria) this;
        }

        public Criteria andVisistedJobIdGreaterThan(Integer value) {
            addCriterion("visisted_job_id >", value, "visistedJobId");
            return (Criteria) this;
        }

        public Criteria andVisistedJobIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("visisted_job_id >=", value, "visistedJobId");
            return (Criteria) this;
        }

        public Criteria andVisistedJobIdLessThan(Integer value) {
            addCriterion("visisted_job_id <", value, "visistedJobId");
            return (Criteria) this;
        }

        public Criteria andVisistedJobIdLessThanOrEqualTo(Integer value) {
            addCriterion("visisted_job_id <=", value, "visistedJobId");
            return (Criteria) this;
        }

        public Criteria andVisistedJobIdIn(List<Integer> values) {
            addCriterion("visisted_job_id in", values, "visistedJobId");
            return (Criteria) this;
        }

        public Criteria andVisistedJobIdNotIn(List<Integer> values) {
            addCriterion("visisted_job_id not in", values, "visistedJobId");
            return (Criteria) this;
        }

        public Criteria andVisistedJobIdBetween(Integer value1, Integer value2) {
            addCriterion("visisted_job_id between", value1, value2, "visistedJobId");
            return (Criteria) this;
        }

        public Criteria andVisistedJobIdNotBetween(Integer value1, Integer value2) {
            addCriterion("visisted_job_id not between", value1, value2, "visistedJobId");
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