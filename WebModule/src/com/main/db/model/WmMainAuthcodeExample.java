package com.main.db.model;

import java.util.ArrayList;
import java.util.List;

public class WmMainAuthcodeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
    public WmMainAuthcodeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
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

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andIdnoIsNull() {
            addCriterion("IDNO is null");
            return (Criteria) this;
        }

        public Criteria andIdnoIsNotNull() {
            addCriterion("IDNO is not null");
            return (Criteria) this;
        }

        public Criteria andIdnoEqualTo(String value) {
            addCriterion("IDNO =", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotEqualTo(String value) {
            addCriterion("IDNO <>", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoGreaterThan(String value) {
            addCriterion("IDNO >", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoGreaterThanOrEqualTo(String value) {
            addCriterion("IDNO >=", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLessThan(String value) {
            addCriterion("IDNO <", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLessThanOrEqualTo(String value) {
            addCriterion("IDNO <=", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLike(String value) {
            addCriterion("IDNO like", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotLike(String value) {
            addCriterion("IDNO not like", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoIn(List<String> values) {
            addCriterion("IDNO in", values, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotIn(List<String> values) {
            addCriterion("IDNO not in", values, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoBetween(String value1, String value2) {
            addCriterion("IDNO between", value1, value2, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotBetween(String value1, String value2) {
            addCriterion("IDNO not between", value1, value2, "idno");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIsNull() {
            addCriterion("EXPIRED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIsNotNull() {
            addCriterion("EXPIRED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeEqualTo(String value) {
            addCriterion("EXPIRED_TIME =", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotEqualTo(String value) {
            addCriterion("EXPIRED_TIME <>", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeGreaterThan(String value) {
            addCriterion("EXPIRED_TIME >", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeGreaterThanOrEqualTo(String value) {
            addCriterion("EXPIRED_TIME >=", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeLessThan(String value) {
            addCriterion("EXPIRED_TIME <", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeLessThanOrEqualTo(String value) {
            addCriterion("EXPIRED_TIME <=", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeLike(String value) {
            addCriterion("EXPIRED_TIME like", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotLike(String value) {
            addCriterion("EXPIRED_TIME not like", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIn(List<String> values) {
            addCriterion("EXPIRED_TIME in", values, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotIn(List<String> values) {
            addCriterion("EXPIRED_TIME not in", values, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeBetween(String value1, String value2) {
            addCriterion("EXPIRED_TIME between", value1, value2, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotBetween(String value1, String value2) {
            addCriterion("EXPIRED_TIME not between", value1, value2, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andSysIdIsNull() {
            addCriterion("SYS_ID is null");
            return (Criteria) this;
        }

        public Criteria andSysIdIsNotNull() {
            addCriterion("SYS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSysIdEqualTo(String value) {
            addCriterion("SYS_ID =", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotEqualTo(String value) {
            addCriterion("SYS_ID <>", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThan(String value) {
            addCriterion("SYS_ID >", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_ID >=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThan(String value) {
            addCriterion("SYS_ID <", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThanOrEqualTo(String value) {
            addCriterion("SYS_ID <=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLike(String value) {
            addCriterion("SYS_ID like", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotLike(String value) {
            addCriterion("SYS_ID not like", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdIn(List<String> values) {
            addCriterion("SYS_ID in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotIn(List<String> values) {
            addCriterion("SYS_ID not in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdBetween(String value1, String value2) {
            addCriterion("SYS_ID between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotBetween(String value1, String value2) {
            addCriterion("SYS_ID not between", value1, value2, "sysId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated do_not_delete_during_merge Mon Jun 06 15:02:45 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:02:45 CST 2016
     */
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