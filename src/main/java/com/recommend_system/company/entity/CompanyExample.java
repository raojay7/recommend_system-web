package com.recommend_system.company.entity;

import java.util.ArrayList;
import java.util.List;

public class CompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyExample() {
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIsNull() {
            addCriterion("company_nature is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIsNotNull() {
            addCriterion("company_nature is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureEqualTo(String value) {
            addCriterion("company_nature =", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotEqualTo(String value) {
            addCriterion("company_nature <>", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureGreaterThan(String value) {
            addCriterion("company_nature >", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureGreaterThanOrEqualTo(String value) {
            addCriterion("company_nature >=", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLessThan(String value) {
            addCriterion("company_nature <", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLessThanOrEqualTo(String value) {
            addCriterion("company_nature <=", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLike(String value) {
            addCriterion("company_nature like", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotLike(String value) {
            addCriterion("company_nature not like", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIn(List<String> values) {
            addCriterion("company_nature in", values, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotIn(List<String> values) {
            addCriterion("company_nature not in", values, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureBetween(String value1, String value2) {
            addCriterion("company_nature between", value1, value2, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotBetween(String value1, String value2) {
            addCriterion("company_nature not between", value1, value2, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleIsNull() {
            addCriterion("company_scale is null");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleIsNotNull() {
            addCriterion("company_scale is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleEqualTo(String value) {
            addCriterion("company_scale =", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleNotEqualTo(String value) {
            addCriterion("company_scale <>", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleGreaterThan(String value) {
            addCriterion("company_scale >", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleGreaterThanOrEqualTo(String value) {
            addCriterion("company_scale >=", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleLessThan(String value) {
            addCriterion("company_scale <", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleLessThanOrEqualTo(String value) {
            addCriterion("company_scale <=", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleLike(String value) {
            addCriterion("company_scale like", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleNotLike(String value) {
            addCriterion("company_scale not like", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleIn(List<String> values) {
            addCriterion("company_scale in", values, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleNotIn(List<String> values) {
            addCriterion("company_scale not in", values, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleBetween(String value1, String value2) {
            addCriterion("company_scale between", value1, value2, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleNotBetween(String value1, String value2) {
            addCriterion("company_scale not between", value1, value2, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryIsNull() {
            addCriterion("company_industry is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryIsNotNull() {
            addCriterion("company_industry is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryEqualTo(String value) {
            addCriterion("company_industry =", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryNotEqualTo(String value) {
            addCriterion("company_industry <>", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryGreaterThan(String value) {
            addCriterion("company_industry >", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("company_industry >=", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryLessThan(String value) {
            addCriterion("company_industry <", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryLessThanOrEqualTo(String value) {
            addCriterion("company_industry <=", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryLike(String value) {
            addCriterion("company_industry like", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryNotLike(String value) {
            addCriterion("company_industry not like", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryIn(List<String> values) {
            addCriterion("company_industry in", values, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryNotIn(List<String> values) {
            addCriterion("company_industry not in", values, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryBetween(String value1, String value2) {
            addCriterion("company_industry between", value1, value2, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryNotBetween(String value1, String value2) {
            addCriterion("company_industry not between", value1, value2, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyHomepageIsNull() {
            addCriterion("company_homepage is null");
            return (Criteria) this;
        }

        public Criteria andCompanyHomepageIsNotNull() {
            addCriterion("company_homepage is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyHomepageEqualTo(String value) {
            addCriterion("company_homepage =", value, "companyHomepage");
            return (Criteria) this;
        }

        public Criteria andCompanyHomepageNotEqualTo(String value) {
            addCriterion("company_homepage <>", value, "companyHomepage");
            return (Criteria) this;
        }

        public Criteria andCompanyHomepageGreaterThan(String value) {
            addCriterion("company_homepage >", value, "companyHomepage");
            return (Criteria) this;
        }

        public Criteria andCompanyHomepageGreaterThanOrEqualTo(String value) {
            addCriterion("company_homepage >=", value, "companyHomepage");
            return (Criteria) this;
        }

        public Criteria andCompanyHomepageLessThan(String value) {
            addCriterion("company_homepage <", value, "companyHomepage");
            return (Criteria) this;
        }

        public Criteria andCompanyHomepageLessThanOrEqualTo(String value) {
            addCriterion("company_homepage <=", value, "companyHomepage");
            return (Criteria) this;
        }

        public Criteria andCompanyHomepageLike(String value) {
            addCriterion("company_homepage like", value, "companyHomepage");
            return (Criteria) this;
        }

        public Criteria andCompanyHomepageNotLike(String value) {
            addCriterion("company_homepage not like", value, "companyHomepage");
            return (Criteria) this;
        }

        public Criteria andCompanyHomepageIn(List<String> values) {
            addCriterion("company_homepage in", values, "companyHomepage");
            return (Criteria) this;
        }

        public Criteria andCompanyHomepageNotIn(List<String> values) {
            addCriterion("company_homepage not in", values, "companyHomepage");
            return (Criteria) this;
        }

        public Criteria andCompanyHomepageBetween(String value1, String value2) {
            addCriterion("company_homepage between", value1, value2, "companyHomepage");
            return (Criteria) this;
        }

        public Criteria andCompanyHomepageNotBetween(String value1, String value2) {
            addCriterion("company_homepage not between", value1, value2, "companyHomepage");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
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