package cn.jinelei.live.model.data;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "vi_room_user_category")
public class ViRoomUserCategory implements Serializable {
    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "room_status")
    private Integer roomStatus;

    @Column(name = "room_screenshot")
    private String roomScreenshot;

    @Column(name = "room_introduce")
    private String roomIntroduce;

    @Column(name = "stream_key")
    private String streamKey;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_nickname")
    private String userNickname;

    @Column(name = "user_sex")
    private Integer userSex;

    @Column(name = "user_age")
    private Integer userAge;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_height")
    private Integer userHeight;

    @Column(name = "user_weight")
    private Integer userWeight;

    @Column(name = "user_area")
    private Integer userArea;

    @Column(name = "user_status")
    private Integer userStatus;

    @Column(name = "user_treasure")
    private Integer userTreasure;

    private static final long serialVersionUID = 1L;

    /**
     * @return room_id
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * @param roomId
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * @return room_name
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * @param roomName
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * @return room_status
     */
    public Integer getRoomStatus() {
        return roomStatus;
    }

    /**
     * @param roomStatus
     */
    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    /**
     * @return room_screenshot
     */
    public String getRoomScreenshot() {
        return roomScreenshot;
    }

    /**
     * @param roomScreenshot
     */
    public void setRoomScreenshot(String roomScreenshot) {
        this.roomScreenshot = roomScreenshot;
    }

    /**
     * @return room_introduce
     */
    public String getRoomIntroduce() {
        return roomIntroduce;
    }

    /**
     * @param roomIntroduce
     */
    public void setRoomIntroduce(String roomIntroduce) {
        this.roomIntroduce = roomIntroduce;
    }

    /**
     * @return stream_key
     */
    public String getStreamKey() {
        return streamKey;
    }

    /**
     * @param streamKey
     */
    public void setStreamKey(String streamKey) {
        this.streamKey = streamKey;
    }

    /**
     * @return category_id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_nickname
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * @param userNickname
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    /**
     * @return user_sex
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * @param userSex
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * @return user_age
     */
    public Integer getUserAge() {
        return userAge;
    }

    /**
     * @param userAge
     */
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    /**
     * @return user_phone
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * @param userPhone
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * @return user_email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return user_height
     */
    public Integer getUserHeight() {
        return userHeight;
    }

    /**
     * @param userHeight
     */
    public void setUserHeight(Integer userHeight) {
        this.userHeight = userHeight;
    }

    /**
     * @return user_weight
     */
    public Integer getUserWeight() {
        return userWeight;
    }

    /**
     * @param userWeight
     */
    public void setUserWeight(Integer userWeight) {
        this.userWeight = userWeight;
    }

    /**
     * @return user_area
     */
    public Integer getUserArea() {
        return userArea;
    }

    /**
     * @param userArea
     */
    public void setUserArea(Integer userArea) {
        this.userArea = userArea;
    }

    /**
     * @return user_status
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * @param userStatus
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * @return user_treasure
     */
    public Integer getUserTreasure() {
        return userTreasure;
    }

    /**
     * @param userTreasure
     */
    public void setUserTreasure(Integer userTreasure) {
        this.userTreasure = userTreasure;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ViRoomUserCategory other = (ViRoomUserCategory) that;
        return (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getRoomName() == null ? other.getRoomName() == null : this.getRoomName().equals(other.getRoomName()))
            && (this.getRoomStatus() == null ? other.getRoomStatus() == null : this.getRoomStatus().equals(other.getRoomStatus()))
            && (this.getRoomScreenshot() == null ? other.getRoomScreenshot() == null : this.getRoomScreenshot().equals(other.getRoomScreenshot()))
            && (this.getRoomIntroduce() == null ? other.getRoomIntroduce() == null : this.getRoomIntroduce().equals(other.getRoomIntroduce()))
            && (this.getStreamKey() == null ? other.getStreamKey() == null : this.getStreamKey().equals(other.getStreamKey()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserNickname() == null ? other.getUserNickname() == null : this.getUserNickname().equals(other.getUserNickname()))
            && (this.getUserSex() == null ? other.getUserSex() == null : this.getUserSex().equals(other.getUserSex()))
            && (this.getUserAge() == null ? other.getUserAge() == null : this.getUserAge().equals(other.getUserAge()))
            && (this.getUserPhone() == null ? other.getUserPhone() == null : this.getUserPhone().equals(other.getUserPhone()))
            && (this.getUserEmail() == null ? other.getUserEmail() == null : this.getUserEmail().equals(other.getUserEmail()))
            && (this.getUserHeight() == null ? other.getUserHeight() == null : this.getUserHeight().equals(other.getUserHeight()))
            && (this.getUserWeight() == null ? other.getUserWeight() == null : this.getUserWeight().equals(other.getUserWeight()))
            && (this.getUserArea() == null ? other.getUserArea() == null : this.getUserArea().equals(other.getUserArea()))
            && (this.getUserStatus() == null ? other.getUserStatus() == null : this.getUserStatus().equals(other.getUserStatus()))
            && (this.getUserTreasure() == null ? other.getUserTreasure() == null : this.getUserTreasure().equals(other.getUserTreasure()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getRoomName() == null) ? 0 : getRoomName().hashCode());
        result = prime * result + ((getRoomStatus() == null) ? 0 : getRoomStatus().hashCode());
        result = prime * result + ((getRoomScreenshot() == null) ? 0 : getRoomScreenshot().hashCode());
        result = prime * result + ((getRoomIntroduce() == null) ? 0 : getRoomIntroduce().hashCode());
        result = prime * result + ((getStreamKey() == null) ? 0 : getStreamKey().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserNickname() == null) ? 0 : getUserNickname().hashCode());
        result = prime * result + ((getUserSex() == null) ? 0 : getUserSex().hashCode());
        result = prime * result + ((getUserAge() == null) ? 0 : getUserAge().hashCode());
        result = prime * result + ((getUserPhone() == null) ? 0 : getUserPhone().hashCode());
        result = prime * result + ((getUserEmail() == null) ? 0 : getUserEmail().hashCode());
        result = prime * result + ((getUserHeight() == null) ? 0 : getUserHeight().hashCode());
        result = prime * result + ((getUserWeight() == null) ? 0 : getUserWeight().hashCode());
        result = prime * result + ((getUserArea() == null) ? 0 : getUserArea().hashCode());
        result = prime * result + ((getUserStatus() == null) ? 0 : getUserStatus().hashCode());
        result = prime * result + ((getUserTreasure() == null) ? 0 : getUserTreasure().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roomId=").append(roomId);
        sb.append(", roomName=").append(roomName);
        sb.append(", roomStatus=").append(roomStatus);
        sb.append(", roomScreenshot=").append(roomScreenshot);
        sb.append(", roomIntroduce=").append(roomIntroduce);
        sb.append(", streamKey=").append(streamKey);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", userNickname=").append(userNickname);
        sb.append(", userSex=").append(userSex);
        sb.append(", userAge=").append(userAge);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userHeight=").append(userHeight);
        sb.append(", userWeight=").append(userWeight);
        sb.append(", userArea=").append(userArea);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", userTreasure=").append(userTreasure);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}