package cn.jinelei.live.model.data;

import java.util.ArrayList;
import java.util.List;

public class ViRoomUserCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViRoomUserCategoryExample() {
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceIsNull() {
            addCriterion("category_introduce is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceIsNotNull() {
            addCriterion("category_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceEqualTo(String value) {
            addCriterion("category_introduce =", value, "categoryIntroduce");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceNotEqualTo(String value) {
            addCriterion("category_introduce <>", value, "categoryIntroduce");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceGreaterThan(String value) {
            addCriterion("category_introduce >", value, "categoryIntroduce");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("category_introduce >=", value, "categoryIntroduce");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceLessThan(String value) {
            addCriterion("category_introduce <", value, "categoryIntroduce");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceLessThanOrEqualTo(String value) {
            addCriterion("category_introduce <=", value, "categoryIntroduce");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceLike(String value) {
            addCriterion("category_introduce like", value, "categoryIntroduce");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceNotLike(String value) {
            addCriterion("category_introduce not like", value, "categoryIntroduce");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceIn(List<String> values) {
            addCriterion("category_introduce in", values, "categoryIntroduce");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceNotIn(List<String> values) {
            addCriterion("category_introduce not in", values, "categoryIntroduce");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceBetween(String value1, String value2) {
            addCriterion("category_introduce between", value1, value2, "categoryIntroduce");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceNotBetween(String value1, String value2) {
            addCriterion("category_introduce not between", value1, value2, "categoryIntroduce");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNull() {
            addCriterion("user_nickname is null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNotNull() {
            addCriterion("user_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameEqualTo(String value) {
            addCriterion("user_nickname =", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotEqualTo(String value) {
            addCriterion("user_nickname <>", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThan(String value) {
            addCriterion("user_nickname >", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("user_nickname >=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThan(String value) {
            addCriterion("user_nickname <", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThanOrEqualTo(String value) {
            addCriterion("user_nickname <=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLike(String value) {
            addCriterion("user_nickname like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotLike(String value) {
            addCriterion("user_nickname not like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIn(List<String> values) {
            addCriterion("user_nickname in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotIn(List<String> values) {
            addCriterion("user_nickname not in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameBetween(String value1, String value2) {
            addCriterion("user_nickname between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotBetween(String value1, String value2) {
            addCriterion("user_nickname not between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(Integer value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(Integer value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(Integer value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(Integer value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(Integer value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<Integer> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<Integer> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(Integer value1, Integer value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(Integer value1, Integer value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserAgeIsNull() {
            addCriterion("user_age is null");
            return (Criteria) this;
        }

        public Criteria andUserAgeIsNotNull() {
            addCriterion("user_age is not null");
            return (Criteria) this;
        }

        public Criteria andUserAgeEqualTo(Integer value) {
            addCriterion("user_age =", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotEqualTo(Integer value) {
            addCriterion("user_age <>", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeGreaterThan(Integer value) {
            addCriterion("user_age >", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_age >=", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeLessThan(Integer value) {
            addCriterion("user_age <", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeLessThanOrEqualTo(Integer value) {
            addCriterion("user_age <=", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeIn(List<Integer> values) {
            addCriterion("user_age in", values, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotIn(List<Integer> values) {
            addCriterion("user_age not in", values, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeBetween(Integer value1, Integer value2) {
            addCriterion("user_age between", value1, value2, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_age not between", value1, value2, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserHeightIsNull() {
            addCriterion("user_height is null");
            return (Criteria) this;
        }

        public Criteria andUserHeightIsNotNull() {
            addCriterion("user_height is not null");
            return (Criteria) this;
        }

        public Criteria andUserHeightEqualTo(Integer value) {
            addCriterion("user_height =", value, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightNotEqualTo(Integer value) {
            addCriterion("user_height <>", value, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightGreaterThan(Integer value) {
            addCriterion("user_height >", value, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_height >=", value, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightLessThan(Integer value) {
            addCriterion("user_height <", value, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightLessThanOrEqualTo(Integer value) {
            addCriterion("user_height <=", value, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightIn(List<Integer> values) {
            addCriterion("user_height in", values, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightNotIn(List<Integer> values) {
            addCriterion("user_height not in", values, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightBetween(Integer value1, Integer value2) {
            addCriterion("user_height between", value1, value2, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("user_height not between", value1, value2, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightIsNull() {
            addCriterion("user_weight is null");
            return (Criteria) this;
        }

        public Criteria andUserWeightIsNotNull() {
            addCriterion("user_weight is not null");
            return (Criteria) this;
        }

        public Criteria andUserWeightEqualTo(Integer value) {
            addCriterion("user_weight =", value, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightNotEqualTo(Integer value) {
            addCriterion("user_weight <>", value, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightGreaterThan(Integer value) {
            addCriterion("user_weight >", value, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_weight >=", value, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightLessThan(Integer value) {
            addCriterion("user_weight <", value, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightLessThanOrEqualTo(Integer value) {
            addCriterion("user_weight <=", value, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightIn(List<Integer> values) {
            addCriterion("user_weight in", values, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightNotIn(List<Integer> values) {
            addCriterion("user_weight not in", values, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightBetween(Integer value1, Integer value2) {
            addCriterion("user_weight between", value1, value2, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("user_weight not between", value1, value2, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserAreaIsNull() {
            addCriterion("user_area is null");
            return (Criteria) this;
        }

        public Criteria andUserAreaIsNotNull() {
            addCriterion("user_area is not null");
            return (Criteria) this;
        }

        public Criteria andUserAreaEqualTo(Integer value) {
            addCriterion("user_area =", value, "userArea");
            return (Criteria) this;
        }

        public Criteria andUserAreaNotEqualTo(Integer value) {
            addCriterion("user_area <>", value, "userArea");
            return (Criteria) this;
        }

        public Criteria andUserAreaGreaterThan(Integer value) {
            addCriterion("user_area >", value, "userArea");
            return (Criteria) this;
        }

        public Criteria andUserAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_area >=", value, "userArea");
            return (Criteria) this;
        }

        public Criteria andUserAreaLessThan(Integer value) {
            addCriterion("user_area <", value, "userArea");
            return (Criteria) this;
        }

        public Criteria andUserAreaLessThanOrEqualTo(Integer value) {
            addCriterion("user_area <=", value, "userArea");
            return (Criteria) this;
        }

        public Criteria andUserAreaIn(List<Integer> values) {
            addCriterion("user_area in", values, "userArea");
            return (Criteria) this;
        }

        public Criteria andUserAreaNotIn(List<Integer> values) {
            addCriterion("user_area not in", values, "userArea");
            return (Criteria) this;
        }

        public Criteria andUserAreaBetween(Integer value1, Integer value2) {
            addCriterion("user_area between", value1, value2, "userArea");
            return (Criteria) this;
        }

        public Criteria andUserAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("user_area not between", value1, value2, "userArea");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNull() {
            addCriterion("user_status is null");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNotNull() {
            addCriterion("user_status is not null");
            return (Criteria) this;
        }

        public Criteria andUserStatusEqualTo(Integer value) {
            addCriterion("user_status =", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotEqualTo(Integer value) {
            addCriterion("user_status <>", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThan(Integer value) {
            addCriterion("user_status >", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_status >=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThan(Integer value) {
            addCriterion("user_status <", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThanOrEqualTo(Integer value) {
            addCriterion("user_status <=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusIn(List<Integer> values) {
            addCriterion("user_status in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotIn(List<Integer> values) {
            addCriterion("user_status not in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusBetween(Integer value1, Integer value2) {
            addCriterion("user_status between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("user_status not between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserTreasureIsNull() {
            addCriterion("user_treasure is null");
            return (Criteria) this;
        }

        public Criteria andUserTreasureIsNotNull() {
            addCriterion("user_treasure is not null");
            return (Criteria) this;
        }

        public Criteria andUserTreasureEqualTo(Integer value) {
            addCriterion("user_treasure =", value, "userTreasure");
            return (Criteria) this;
        }

        public Criteria andUserTreasureNotEqualTo(Integer value) {
            addCriterion("user_treasure <>", value, "userTreasure");
            return (Criteria) this;
        }

        public Criteria andUserTreasureGreaterThan(Integer value) {
            addCriterion("user_treasure >", value, "userTreasure");
            return (Criteria) this;
        }

        public Criteria andUserTreasureGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_treasure >=", value, "userTreasure");
            return (Criteria) this;
        }

        public Criteria andUserTreasureLessThan(Integer value) {
            addCriterion("user_treasure <", value, "userTreasure");
            return (Criteria) this;
        }

        public Criteria andUserTreasureLessThanOrEqualTo(Integer value) {
            addCriterion("user_treasure <=", value, "userTreasure");
            return (Criteria) this;
        }

        public Criteria andUserTreasureIn(List<Integer> values) {
            addCriterion("user_treasure in", values, "userTreasure");
            return (Criteria) this;
        }

        public Criteria andUserTreasureNotIn(List<Integer> values) {
            addCriterion("user_treasure not in", values, "userTreasure");
            return (Criteria) this;
        }

        public Criteria andUserTreasureBetween(Integer value1, Integer value2) {
            addCriterion("user_treasure between", value1, value2, "userTreasure");
            return (Criteria) this;
        }

        public Criteria andUserTreasureNotBetween(Integer value1, Integer value2) {
            addCriterion("user_treasure not between", value1, value2, "userTreasure");
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

        public Criteria andCategoryNameLikeInsensitive(String value) {
            addCriterion("upper(category_name) like", value.toUpperCase(), "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryIntroduceLikeInsensitive(String value) {
            addCriterion("upper(category_introduce) like", value.toUpperCase(), "categoryIntroduce");
            return (Criteria) this;
        }

        public Criteria andUserNameLikeInsensitive(String value) {
            addCriterion("upper(user_name) like", value.toUpperCase(), "userName");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLikeInsensitive(String value) {
            addCriterion("upper(user_nickname) like", value.toUpperCase(), "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLikeInsensitive(String value) {
            addCriterion("upper(user_phone) like", value.toUpperCase(), "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserEmailLikeInsensitive(String value) {
            addCriterion("upper(user_email) like", value.toUpperCase(), "userEmail");
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