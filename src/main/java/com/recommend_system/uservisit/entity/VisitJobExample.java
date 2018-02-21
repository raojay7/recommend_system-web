package com.recommend_system.uservisit.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VisitJobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisitJobExample() {
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

        public Criteria andServerTimeIsNull() {
            addCriterion("server_time is null");
            return (Criteria) this;
        }

        public Criteria andServerTimeIsNotNull() {
            addCriterion("server_time is not null");
            return (Criteria) this;
        }

        public Criteria andServerTimeEqualTo(Date value) {
            addCriterionForJDBCDate("server_time =", value, "serverTime");
            return (Criteria) this;
        }

        public Criteria andServerTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("server_time <>", value, "serverTime");
            return (Criteria) this;
        }

        public Criteria andServerTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("server_time >", value, "serverTime");
            return (Criteria) this;
        }

        public Criteria andServerTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("server_time >=", value, "serverTime");
            return (Criteria) this;
        }

        public Criteria andServerTimeLessThan(Date value) {
            addCriterionForJDBCDate("server_time <", value, "serverTime");
            return (Criteria) this;
        }

        public Criteria andServerTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("server_time <=", value, "serverTime");
            return (Criteria) this;
        }

        public Criteria andServerTimeIn(List<Date> values) {
            addCriterionForJDBCDate("server_time in", values, "serverTime");
            return (Criteria) this;
        }

        public Criteria andServerTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("server_time not in", values, "serverTime");
            return (Criteria) this;
        }

        public Criteria andServerTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("server_time between", value1, value2, "serverTime");
            return (Criteria) this;
        }

        public Criteria andServerTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("server_time not between", value1, value2, "serverTime");
            return (Criteria) this;
        }

        public Criteria andClientTimeIsNull() {
            addCriterion("client_time is null");
            return (Criteria) this;
        }

        public Criteria andClientTimeIsNotNull() {
            addCriterion("client_time is not null");
            return (Criteria) this;
        }

        public Criteria andClientTimeEqualTo(Date value) {
            addCriterionForJDBCDate("client_time =", value, "clientTime");
            return (Criteria) this;
        }

        public Criteria andClientTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("client_time <>", value, "clientTime");
            return (Criteria) this;
        }

        public Criteria andClientTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("client_time >", value, "clientTime");
            return (Criteria) this;
        }

        public Criteria andClientTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("client_time >=", value, "clientTime");
            return (Criteria) this;
        }

        public Criteria andClientTimeLessThan(Date value) {
            addCriterionForJDBCDate("client_time <", value, "clientTime");
            return (Criteria) this;
        }

        public Criteria andClientTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("client_time <=", value, "clientTime");
            return (Criteria) this;
        }

        public Criteria andClientTimeIn(List<Date> values) {
            addCriterionForJDBCDate("client_time in", values, "clientTime");
            return (Criteria) this;
        }

        public Criteria andClientTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("client_time not in", values, "clientTime");
            return (Criteria) this;
        }

        public Criteria andClientTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("client_time between", value1, value2, "clientTime");
            return (Criteria) this;
        }

        public Criteria andClientTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("client_time not between", value1, value2, "clientTime");
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

        public Criteria andCookieCtimeIsNull() {
            addCriterion("cookie_ctime is null");
            return (Criteria) this;
        }

        public Criteria andCookieCtimeIsNotNull() {
            addCriterion("cookie_ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCookieCtimeEqualTo(Date value) {
            addCriterionForJDBCDate("cookie_ctime =", value, "cookieCtime");
            return (Criteria) this;
        }

        public Criteria andCookieCtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("cookie_ctime <>", value, "cookieCtime");
            return (Criteria) this;
        }

        public Criteria andCookieCtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("cookie_ctime >", value, "cookieCtime");
            return (Criteria) this;
        }

        public Criteria andCookieCtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cookie_ctime >=", value, "cookieCtime");
            return (Criteria) this;
        }

        public Criteria andCookieCtimeLessThan(Date value) {
            addCriterionForJDBCDate("cookie_ctime <", value, "cookieCtime");
            return (Criteria) this;
        }

        public Criteria andCookieCtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cookie_ctime <=", value, "cookieCtime");
            return (Criteria) this;
        }

        public Criteria andCookieCtimeIn(List<Date> values) {
            addCriterionForJDBCDate("cookie_ctime in", values, "cookieCtime");
            return (Criteria) this;
        }

        public Criteria andCookieCtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("cookie_ctime not in", values, "cookieCtime");
            return (Criteria) this;
        }

        public Criteria andCookieCtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cookie_ctime between", value1, value2, "cookieCtime");
            return (Criteria) this;
        }

        public Criteria andCookieCtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cookie_ctime not between", value1, value2, "cookieCtime");
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

        public Criteria andTJobIdIsNull() {
            addCriterion("t_job_id is null");
            return (Criteria) this;
        }

        public Criteria andTJobIdIsNotNull() {
            addCriterion("t_job_id is not null");
            return (Criteria) this;
        }

        public Criteria andTJobIdEqualTo(Integer value) {
            addCriterion("t_job_id =", value, "tJobId");
            return (Criteria) this;
        }

        public Criteria andTJobIdNotEqualTo(Integer value) {
            addCriterion("t_job_id <>", value, "tJobId");
            return (Criteria) this;
        }

        public Criteria andTJobIdGreaterThan(Integer value) {
            addCriterion("t_job_id >", value, "tJobId");
            return (Criteria) this;
        }

        public Criteria andTJobIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_job_id >=", value, "tJobId");
            return (Criteria) this;
        }

        public Criteria andTJobIdLessThan(Integer value) {
            addCriterion("t_job_id <", value, "tJobId");
            return (Criteria) this;
        }

        public Criteria andTJobIdLessThanOrEqualTo(Integer value) {
            addCriterion("t_job_id <=", value, "tJobId");
            return (Criteria) this;
        }

        public Criteria andTJobIdIn(List<Integer> values) {
            addCriterion("t_job_id in", values, "tJobId");
            return (Criteria) this;
        }

        public Criteria andTJobIdNotIn(List<Integer> values) {
            addCriterion("t_job_id not in", values, "tJobId");
            return (Criteria) this;
        }

        public Criteria andTJobIdBetween(Integer value1, Integer value2) {
            addCriterion("t_job_id between", value1, value2, "tJobId");
            return (Criteria) this;
        }

        public Criteria andTJobIdNotBetween(Integer value1, Integer value2) {
            addCriterion("t_job_id not between", value1, value2, "tJobId");
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