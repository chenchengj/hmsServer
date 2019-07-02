package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HomeworkSubmitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HomeworkSubmitExample() {
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

        public Criteria andHSubmitIdIsNull() {
            addCriterion("h_submit_id is null");
            return (Criteria) this;
        }

        public Criteria andHSubmitIdIsNotNull() {
            addCriterion("h_submit_id is not null");
            return (Criteria) this;
        }

        public Criteria andHSubmitIdEqualTo(Long value) {
            addCriterion("h_submit_id =", value, "hSubmitId");
            return (Criteria) this;
        }

        public Criteria andHSubmitIdNotEqualTo(Long value) {
            addCriterion("h_submit_id <>", value, "hSubmitId");
            return (Criteria) this;
        }

        public Criteria andHSubmitIdGreaterThan(Long value) {
            addCriterion("h_submit_id >", value, "hSubmitId");
            return (Criteria) this;
        }

        public Criteria andHSubmitIdGreaterThanOrEqualTo(Long value) {
            addCriterion("h_submit_id >=", value, "hSubmitId");
            return (Criteria) this;
        }

        public Criteria andHSubmitIdLessThan(Long value) {
            addCriterion("h_submit_id <", value, "hSubmitId");
            return (Criteria) this;
        }

        public Criteria andHSubmitIdLessThanOrEqualTo(Long value) {
            addCriterion("h_submit_id <=", value, "hSubmitId");
            return (Criteria) this;
        }

        public Criteria andHSubmitIdIn(List<Long> values) {
            addCriterion("h_submit_id in", values, "hSubmitId");
            return (Criteria) this;
        }

        public Criteria andHSubmitIdNotIn(List<Long> values) {
            addCriterion("h_submit_id not in", values, "hSubmitId");
            return (Criteria) this;
        }

        public Criteria andHSubmitIdBetween(Long value1, Long value2) {
            addCriterion("h_submit_id between", value1, value2, "hSubmitId");
            return (Criteria) this;
        }

        public Criteria andHSubmitIdNotBetween(Long value1, Long value2) {
            addCriterion("h_submit_id not between", value1, value2, "hSubmitId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(Long value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(Long value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(Long value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(Long value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(Long value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<Long> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<Long> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(Long value1, Long value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(Long value1, Long value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andHSubmitUrlIsNull() {
            addCriterion("h_submit_url is null");
            return (Criteria) this;
        }

        public Criteria andHSubmitUrlIsNotNull() {
            addCriterion("h_submit_url is not null");
            return (Criteria) this;
        }

        public Criteria andHSubmitUrlEqualTo(String value) {
            addCriterion("h_submit_url =", value, "hSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andHSubmitUrlNotEqualTo(String value) {
            addCriterion("h_submit_url <>", value, "hSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andHSubmitUrlGreaterThan(String value) {
            addCriterion("h_submit_url >", value, "hSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andHSubmitUrlGreaterThanOrEqualTo(String value) {
            addCriterion("h_submit_url >=", value, "hSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andHSubmitUrlLessThan(String value) {
            addCriterion("h_submit_url <", value, "hSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andHSubmitUrlLessThanOrEqualTo(String value) {
            addCriterion("h_submit_url <=", value, "hSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andHSubmitUrlLike(String value) {
            addCriterion("h_submit_url like", value, "hSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andHSubmitUrlNotLike(String value) {
            addCriterion("h_submit_url not like", value, "hSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andHSubmitUrlIn(List<String> values) {
            addCriterion("h_submit_url in", values, "hSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andHSubmitUrlNotIn(List<String> values) {
            addCriterion("h_submit_url not in", values, "hSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andHSubmitUrlBetween(String value1, String value2) {
            addCriterion("h_submit_url between", value1, value2, "hSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andHSubmitUrlNotBetween(String value1, String value2) {
            addCriterion("h_submit_url not between", value1, value2, "hSubmitUrl");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andHIdIsNull() {
            addCriterion("h_id is null");
            return (Criteria) this;
        }

        public Criteria andHIdIsNotNull() {
            addCriterion("h_id is not null");
            return (Criteria) this;
        }

        public Criteria andHIdEqualTo(Long value) {
            addCriterion("h_id =", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdNotEqualTo(Long value) {
            addCriterion("h_id <>", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdGreaterThan(Long value) {
            addCriterion("h_id >", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdGreaterThanOrEqualTo(Long value) {
            addCriterion("h_id >=", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdLessThan(Long value) {
            addCriterion("h_id <", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdLessThanOrEqualTo(Long value) {
            addCriterion("h_id <=", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdIn(List<Long> values) {
            addCriterion("h_id in", values, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdNotIn(List<Long> values) {
            addCriterion("h_id not in", values, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdBetween(Long value1, Long value2) {
            addCriterion("h_id between", value1, value2, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdNotBetween(Long value1, Long value2) {
            addCriterion("h_id not between", value1, value2, "hId");
            return (Criteria) this;
        }

        public Criteria andAttachIdIsNull() {
            addCriterion("attach_id is null");
            return (Criteria) this;
        }

        public Criteria andAttachIdIsNotNull() {
            addCriterion("attach_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttachIdEqualTo(Long value) {
            addCriterion("attach_id =", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotEqualTo(Long value) {
            addCriterion("attach_id <>", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdGreaterThan(Long value) {
            addCriterion("attach_id >", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdGreaterThanOrEqualTo(Long value) {
            addCriterion("attach_id >=", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdLessThan(Long value) {
            addCriterion("attach_id <", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdLessThanOrEqualTo(Long value) {
            addCriterion("attach_id <=", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdIn(List<Long> values) {
            addCriterion("attach_id in", values, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotIn(List<Long> values) {
            addCriterion("attach_id not in", values, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdBetween(Long value1, Long value2) {
            addCriterion("attach_id between", value1, value2, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotBetween(Long value1, Long value2) {
            addCriterion("attach_id not between", value1, value2, "attachId");
            return (Criteria) this;
        }

        public Criteria andRateLevelIsNull() {
            addCriterion("rate_level is null");
            return (Criteria) this;
        }

        public Criteria andRateLevelIsNotNull() {
            addCriterion("rate_level is not null");
            return (Criteria) this;
        }

        public Criteria andRateLevelEqualTo(String value) {
            addCriterion("rate_level =", value, "rateLevel");
            return (Criteria) this;
        }

        public Criteria andRateLevelNotEqualTo(String value) {
            addCriterion("rate_level <>", value, "rateLevel");
            return (Criteria) this;
        }

        public Criteria andRateLevelGreaterThan(String value) {
            addCriterion("rate_level >", value, "rateLevel");
            return (Criteria) this;
        }

        public Criteria andRateLevelGreaterThanOrEqualTo(String value) {
            addCriterion("rate_level >=", value, "rateLevel");
            return (Criteria) this;
        }

        public Criteria andRateLevelLessThan(String value) {
            addCriterion("rate_level <", value, "rateLevel");
            return (Criteria) this;
        }

        public Criteria andRateLevelLessThanOrEqualTo(String value) {
            addCriterion("rate_level <=", value, "rateLevel");
            return (Criteria) this;
        }

        public Criteria andRateLevelLike(String value) {
            addCriterion("rate_level like", value, "rateLevel");
            return (Criteria) this;
        }

        public Criteria andRateLevelNotLike(String value) {
            addCriterion("rate_level not like", value, "rateLevel");
            return (Criteria) this;
        }

        public Criteria andRateLevelIn(List<String> values) {
            addCriterion("rate_level in", values, "rateLevel");
            return (Criteria) this;
        }

        public Criteria andRateLevelNotIn(List<String> values) {
            addCriterion("rate_level not in", values, "rateLevel");
            return (Criteria) this;
        }

        public Criteria andRateLevelBetween(String value1, String value2) {
            addCriterion("rate_level between", value1, value2, "rateLevel");
            return (Criteria) this;
        }

        public Criteria andRateLevelNotBetween(String value1, String value2) {
            addCriterion("rate_level not between", value1, value2, "rateLevel");
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