package cn.jinelei.live.model;

import java.util.ArrayList;
import java.util.List;

public class RoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomExample() {
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

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Integer value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Integer value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Integer value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Integer value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Integer> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Integer> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNull() {
            addCriterion("room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNotNull() {
            addCriterion("room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNameEqualTo(String value) {
            addCriterion("room_name =", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotEqualTo(String value) {
            addCriterion("room_name <>", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThan(String value) {
            addCriterion("room_name >", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_name >=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThan(String value) {
            addCriterion("room_name <", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThanOrEqualTo(String value) {
            addCriterion("room_name <=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLike(String value) {
            addCriterion("room_name like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotLike(String value) {
            addCriterion("room_name not like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameIn(List<String> values) {
            addCriterion("room_name in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotIn(List<String> values) {
            addCriterion("room_name not in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameBetween(String value1, String value2) {
            addCriterion("room_name between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotBetween(String value1, String value2) {
            addCriterion("room_name not between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIsNull() {
            addCriterion("room_status is null");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIsNotNull() {
            addCriterion("room_status is not null");
            return (Criteria) this;
        }

        public Criteria andRoomStatusEqualTo(Integer value) {
            addCriterion("room_status =", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotEqualTo(Integer value) {
            addCriterion("room_status <>", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusGreaterThan(Integer value) {
            addCriterion("room_status >", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_status >=", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusLessThan(Integer value) {
            addCriterion("room_status <", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusLessThanOrEqualTo(Integer value) {
            addCriterion("room_status <=", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIn(List<Integer> values) {
            addCriterion("room_status in", values, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotIn(List<Integer> values) {
            addCriterion("room_status not in", values, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusBetween(Integer value1, Integer value2) {
            addCriterion("room_status between", value1, value2, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("room_status not between", value1, value2, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotIsNull() {
            addCriterion("room_screenshot is null");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotIsNotNull() {
            addCriterion("room_screenshot is not null");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotEqualTo(String value) {
            addCriterion("room_screenshot =", value, "roomScreenshot");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotNotEqualTo(String value) {
            addCriterion("room_screenshot <>", value, "roomScreenshot");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotGreaterThan(String value) {
            addCriterion("room_screenshot >", value, "roomScreenshot");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotGreaterThanOrEqualTo(String value) {
            addCriterion("room_screenshot >=", value, "roomScreenshot");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotLessThan(String value) {
            addCriterion("room_screenshot <", value, "roomScreenshot");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotLessThanOrEqualTo(String value) {
            addCriterion("room_screenshot <=", value, "roomScreenshot");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotLike(String value) {
            addCriterion("room_screenshot like", value, "roomScreenshot");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotNotLike(String value) {
            addCriterion("room_screenshot not like", value, "roomScreenshot");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotIn(List<String> values) {
            addCriterion("room_screenshot in", values, "roomScreenshot");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotNotIn(List<String> values) {
            addCriterion("room_screenshot not in", values, "roomScreenshot");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotBetween(String value1, String value2) {
            addCriterion("room_screenshot between", value1, value2, "roomScreenshot");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotNotBetween(String value1, String value2) {
            addCriterion("room_screenshot not between", value1, value2, "roomScreenshot");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceIsNull() {
            addCriterion("room_introduce is null");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceIsNotNull() {
            addCriterion("room_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceEqualTo(String value) {
            addCriterion("room_introduce =", value, "roomIntroduce");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceNotEqualTo(String value) {
            addCriterion("room_introduce <>", value, "roomIntroduce");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceGreaterThan(String value) {
            addCriterion("room_introduce >", value, "roomIntroduce");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("room_introduce >=", value, "roomIntroduce");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceLessThan(String value) {
            addCriterion("room_introduce <", value, "roomIntroduce");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceLessThanOrEqualTo(String value) {
            addCriterion("room_introduce <=", value, "roomIntroduce");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceLike(String value) {
            addCriterion("room_introduce like", value, "roomIntroduce");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceNotLike(String value) {
            addCriterion("room_introduce not like", value, "roomIntroduce");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceIn(List<String> values) {
            addCriterion("room_introduce in", values, "roomIntroduce");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceNotIn(List<String> values) {
            addCriterion("room_introduce not in", values, "roomIntroduce");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceBetween(String value1, String value2) {
            addCriterion("room_introduce between", value1, value2, "roomIntroduce");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceNotBetween(String value1, String value2) {
            addCriterion("room_introduce not between", value1, value2, "roomIntroduce");
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

        public Criteria andStreamKeyIsNull() {
            addCriterion("stream_key is null");
            return (Criteria) this;
        }

        public Criteria andStreamKeyIsNotNull() {
            addCriterion("stream_key is not null");
            return (Criteria) this;
        }

        public Criteria andStreamKeyEqualTo(String value) {
            addCriterion("stream_key =", value, "streamKey");
            return (Criteria) this;
        }

        public Criteria andStreamKeyNotEqualTo(String value) {
            addCriterion("stream_key <>", value, "streamKey");
            return (Criteria) this;
        }

        public Criteria andStreamKeyGreaterThan(String value) {
            addCriterion("stream_key >", value, "streamKey");
            return (Criteria) this;
        }

        public Criteria andStreamKeyGreaterThanOrEqualTo(String value) {
            addCriterion("stream_key >=", value, "streamKey");
            return (Criteria) this;
        }

        public Criteria andStreamKeyLessThan(String value) {
            addCriterion("stream_key <", value, "streamKey");
            return (Criteria) this;
        }

        public Criteria andStreamKeyLessThanOrEqualTo(String value) {
            addCriterion("stream_key <=", value, "streamKey");
            return (Criteria) this;
        }

        public Criteria andStreamKeyLike(String value) {
            addCriterion("stream_key like", value, "streamKey");
            return (Criteria) this;
        }

        public Criteria andStreamKeyNotLike(String value) {
            addCriterion("stream_key not like", value, "streamKey");
            return (Criteria) this;
        }

        public Criteria andStreamKeyIn(List<String> values) {
            addCriterion("stream_key in", values, "streamKey");
            return (Criteria) this;
        }

        public Criteria andStreamKeyNotIn(List<String> values) {
            addCriterion("stream_key not in", values, "streamKey");
            return (Criteria) this;
        }

        public Criteria andStreamKeyBetween(String value1, String value2) {
            addCriterion("stream_key between", value1, value2, "streamKey");
            return (Criteria) this;
        }

        public Criteria andStreamKeyNotBetween(String value1, String value2) {
            addCriterion("stream_key not between", value1, value2, "streamKey");
            return (Criteria) this;
        }

        public Criteria andRoomNameLikeInsensitive(String value) {
            addCriterion("upper(room_name) like", value.toUpperCase(), "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomScreenshotLikeInsensitive(String value) {
            addCriterion("upper(room_screenshot) like", value.toUpperCase(), "roomScreenshot");
            return (Criteria) this;
        }

        public Criteria andRoomIntroduceLikeInsensitive(String value) {
            addCriterion("upper(room_introduce) like", value.toUpperCase(), "roomIntroduce");
            return (Criteria) this;
        }

        public Criteria andStreamKeyLikeInsensitive(String value) {
            addCriterion("upper(stream_key) like", value.toUpperCase(), "streamKey");
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