package cn.jinelei.live.model;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;

    private String userName;

    private String userNickname;

    private Integer userSex;

    private Integer userAge;

    private String userPhone;

    private Integer userHeight;

    private Integer userWeight;

    private Integer userArea;

    private Integer userStatus;

    private Integer userTreasure;

    private String userPasswd;

    private String userEmail;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(Integer userHeight) {
        this.userHeight = userHeight;
    }

    public Integer getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(Integer userWeight) {
        this.userWeight = userWeight;
    }

    public Integer getUserArea() {
        return userArea;
    }

    public void setUserArea(Integer userArea) {
        this.userArea = userArea;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserTreasure() {
        return userTreasure;
    }

    public void setUserTreasure(Integer userTreasure) {
        this.userTreasure = userTreasure;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
        User other = (User) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserNickname() == null ? other.getUserNickname() == null : this.getUserNickname().equals(other.getUserNickname()))
            && (this.getUserSex() == null ? other.getUserSex() == null : this.getUserSex().equals(other.getUserSex()))
            && (this.getUserAge() == null ? other.getUserAge() == null : this.getUserAge().equals(other.getUserAge()))
            && (this.getUserPhone() == null ? other.getUserPhone() == null : this.getUserPhone().equals(other.getUserPhone()))
            && (this.getUserHeight() == null ? other.getUserHeight() == null : this.getUserHeight().equals(other.getUserHeight()))
            && (this.getUserWeight() == null ? other.getUserWeight() == null : this.getUserWeight().equals(other.getUserWeight()))
            && (this.getUserArea() == null ? other.getUserArea() == null : this.getUserArea().equals(other.getUserArea()))
            && (this.getUserStatus() == null ? other.getUserStatus() == null : this.getUserStatus().equals(other.getUserStatus()))
            && (this.getUserTreasure() == null ? other.getUserTreasure() == null : this.getUserTreasure().equals(other.getUserTreasure()))
            && (this.getUserPasswd() == null ? other.getUserPasswd() == null : this.getUserPasswd().equals(other.getUserPasswd()))
            && (this.getUserEmail() == null ? other.getUserEmail() == null : this.getUserEmail().equals(other.getUserEmail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserNickname() == null) ? 0 : getUserNickname().hashCode());
        result = prime * result + ((getUserSex() == null) ? 0 : getUserSex().hashCode());
        result = prime * result + ((getUserAge() == null) ? 0 : getUserAge().hashCode());
        result = prime * result + ((getUserPhone() == null) ? 0 : getUserPhone().hashCode());
        result = prime * result + ((getUserHeight() == null) ? 0 : getUserHeight().hashCode());
        result = prime * result + ((getUserWeight() == null) ? 0 : getUserWeight().hashCode());
        result = prime * result + ((getUserArea() == null) ? 0 : getUserArea().hashCode());
        result = prime * result + ((getUserStatus() == null) ? 0 : getUserStatus().hashCode());
        result = prime * result + ((getUserTreasure() == null) ? 0 : getUserTreasure().hashCode());
        result = prime * result + ((getUserPasswd() == null) ? 0 : getUserPasswd().hashCode());
        result = prime * result + ((getUserEmail() == null) ? 0 : getUserEmail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", userNickname=").append(userNickname);
        sb.append(", userSex=").append(userSex);
        sb.append(", userAge=").append(userAge);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userHeight=").append(userHeight);
        sb.append(", userWeight=").append(userWeight);
        sb.append(", userArea=").append(userArea);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", userTreasure=").append(userTreasure);
        sb.append(", userPasswd=").append(userPasswd);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}