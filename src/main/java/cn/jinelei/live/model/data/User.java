package cn.jinelei.live.model.data;

import cn.jinelei.live.model.enumstatus.user.UserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

public class User implements Serializable ,UserDetails {
    @Id
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

    @Column(name = "user_passwd")
    private String userPasswd;

    @Column(name = "user_email")
    private String userEmail;

    private static final long serialVersionUID = 1L;

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

    /**
     * @return user_passwd
     */
    public String getUserPasswd() {
        return userPasswd;
    }

    /**
     * @param userPasswd
     */
    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if ((getUserStatus() & Integer.valueOf(UserStatus.ANCHOR.toString())) != 0) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ANCHOR"));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return getUserPasswd();
    }

    @Override
    public String getUsername() {
        return getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return (getUserStatus() & Integer.valueOf(UserStatus.EXPIRED.toString())) == 0 ? true : false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return (getUserStatus() & Integer.valueOf(UserStatus.LOCKED.toString())) == 0 ? true : false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return (getUserStatus() & Integer.valueOf(UserStatus.ENABLE.toString())) == 0 ? true : false;
    }

}