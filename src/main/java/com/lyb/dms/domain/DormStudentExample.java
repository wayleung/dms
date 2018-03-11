package com.lyb.dms.domain;

import java.util.ArrayList;
import java.util.List;

public class DormStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DormStudentExample() {
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

        public Criteria andDsIdIsNull() {
            addCriterion("ds_id is null");
            return (Criteria) this;
        }

        public Criteria andDsIdIsNotNull() {
            addCriterion("ds_id is not null");
            return (Criteria) this;
        }

        public Criteria andDsIdEqualTo(Integer value) {
            addCriterion("ds_id =", value, "dsId");
            return (Criteria) this;
        }

        public Criteria andDsIdNotEqualTo(Integer value) {
            addCriterion("ds_id <>", value, "dsId");
            return (Criteria) this;
        }

        public Criteria andDsIdGreaterThan(Integer value) {
            addCriterion("ds_id >", value, "dsId");
            return (Criteria) this;
        }

        public Criteria andDsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ds_id >=", value, "dsId");
            return (Criteria) this;
        }

        public Criteria andDsIdLessThan(Integer value) {
            addCriterion("ds_id <", value, "dsId");
            return (Criteria) this;
        }

        public Criteria andDsIdLessThanOrEqualTo(Integer value) {
            addCriterion("ds_id <=", value, "dsId");
            return (Criteria) this;
        }

        public Criteria andDsIdIn(List<Integer> values) {
            addCriterion("ds_id in", values, "dsId");
            return (Criteria) this;
        }

        public Criteria andDsIdNotIn(List<Integer> values) {
            addCriterion("ds_id not in", values, "dsId");
            return (Criteria) this;
        }

        public Criteria andDsIdBetween(Integer value1, Integer value2) {
            addCriterion("ds_id between", value1, value2, "dsId");
            return (Criteria) this;
        }

        public Criteria andDsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ds_id not between", value1, value2, "dsId");
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

        public Criteria andStudentIdEqualTo(Integer value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(Integer value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(Integer value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(Integer value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<Integer> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<Integer> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andDormIdIsNull() {
            addCriterion("dorm_id is null");
            return (Criteria) this;
        }

        public Criteria andDormIdIsNotNull() {
            addCriterion("dorm_id is not null");
            return (Criteria) this;
        }

        public Criteria andDormIdEqualTo(Integer value) {
            addCriterion("dorm_id =", value, "dormId");
            return (Criteria) this;
        }

        public Criteria andDormIdNotEqualTo(Integer value) {
            addCriterion("dorm_id <>", value, "dormId");
            return (Criteria) this;
        }

        public Criteria andDormIdGreaterThan(Integer value) {
            addCriterion("dorm_id >", value, "dormId");
            return (Criteria) this;
        }

        public Criteria andDormIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dorm_id >=", value, "dormId");
            return (Criteria) this;
        }

        public Criteria andDormIdLessThan(Integer value) {
            addCriterion("dorm_id <", value, "dormId");
            return (Criteria) this;
        }

        public Criteria andDormIdLessThanOrEqualTo(Integer value) {
            addCriterion("dorm_id <=", value, "dormId");
            return (Criteria) this;
        }

        public Criteria andDormIdIn(List<Integer> values) {
            addCriterion("dorm_id in", values, "dormId");
            return (Criteria) this;
        }

        public Criteria andDormIdNotIn(List<Integer> values) {
            addCriterion("dorm_id not in", values, "dormId");
            return (Criteria) this;
        }

        public Criteria andDormIdBetween(Integer value1, Integer value2) {
            addCriterion("dorm_id between", value1, value2, "dormId");
            return (Criteria) this;
        }

        public Criteria andDormIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dorm_id not between", value1, value2, "dormId");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNull() {
            addCriterion("join_time is null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNotNull() {
            addCriterion("join_time is not null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeEqualTo(String value) {
            addCriterion("join_time =", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotEqualTo(String value) {
            addCriterion("join_time <>", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThan(String value) {
            addCriterion("join_time >", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThanOrEqualTo(String value) {
            addCriterion("join_time >=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThan(String value) {
            addCriterion("join_time <", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThanOrEqualTo(String value) {
            addCriterion("join_time <=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLike(String value) {
            addCriterion("join_time like", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotLike(String value) {
            addCriterion("join_time not like", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIn(List<String> values) {
            addCriterion("join_time in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotIn(List<String> values) {
            addCriterion("join_time not in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeBetween(String value1, String value2) {
            addCriterion("join_time between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotBetween(String value1, String value2) {
            addCriterion("join_time not between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIsNull() {
            addCriterion("leave_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIsNotNull() {
            addCriterion("leave_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeEqualTo(String value) {
            addCriterion("leave_time =", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotEqualTo(String value) {
            addCriterion("leave_time <>", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeGreaterThan(String value) {
            addCriterion("leave_time >", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeGreaterThanOrEqualTo(String value) {
            addCriterion("leave_time >=", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLessThan(String value) {
            addCriterion("leave_time <", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLessThanOrEqualTo(String value) {
            addCriterion("leave_time <=", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLike(String value) {
            addCriterion("leave_time like", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotLike(String value) {
            addCriterion("leave_time not like", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIn(List<String> values) {
            addCriterion("leave_time in", values, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotIn(List<String> values) {
            addCriterion("leave_time not in", values, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeBetween(String value1, String value2) {
            addCriterion("leave_time between", value1, value2, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotBetween(String value1, String value2) {
            addCriterion("leave_time not between", value1, value2, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIsNull() {
            addCriterion("leave_reason is null");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIsNotNull() {
            addCriterion("leave_reason is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonEqualTo(String value) {
            addCriterion("leave_reason =", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotEqualTo(String value) {
            addCriterion("leave_reason <>", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonGreaterThan(String value) {
            addCriterion("leave_reason >", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonGreaterThanOrEqualTo(String value) {
            addCriterion("leave_reason >=", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLessThan(String value) {
            addCriterion("leave_reason <", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLessThanOrEqualTo(String value) {
            addCriterion("leave_reason <=", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLike(String value) {
            addCriterion("leave_reason like", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotLike(String value) {
            addCriterion("leave_reason not like", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIn(List<String> values) {
            addCriterion("leave_reason in", values, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotIn(List<String> values) {
            addCriterion("leave_reason not in", values, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonBetween(String value1, String value2) {
            addCriterion("leave_reason between", value1, value2, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotBetween(String value1, String value2) {
            addCriterion("leave_reason not between", value1, value2, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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