package cn.jinelei.live.model.data;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "vi_user_subscribe")
public class ViUserSubscribe implements Serializable {
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "user_subscribe_id")
    private Integer userSubscribeId;

    @Column(name = "anchor_id")
    private Integer anchorId;

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
     * @return user_subscribe_id
     */
    public Integer getUserSubscribeId() {
        return userSubscribeId;
    }

    /**
     * @param userSubscribeId
     */
    public void setUserSubscribeId(Integer userSubscribeId) {
        this.userSubscribeId = userSubscribeId;
    }

    /**
     * @return anchor_id
     */
    public Integer getAnchorId() {
        return anchorId;
    }

    /**
     * @param anchorId
     */
    public void setAnchorId(Integer anchorId) {
        this.anchorId = anchorId;
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
        ViUserSubscribe other = (ViUserSubscribe) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getRoomName() == null ? other.getRoomName() == null : this.getRoomName().equals(other.getRoomName()))
            && (this.getUserSubscribeId() == null ? other.getUserSubscribeId() == null : this.getUserSubscribeId().equals(other.getUserSubscribeId()))
            && (this.getAnchorId() == null ? other.getAnchorId() == null : this.getAnchorId().equals(other.getAnchorId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getRoomName() == null) ? 0 : getRoomName().hashCode());
        result = prime * result + ((getUserSubscribeId() == null) ? 0 : getUserSubscribeId().hashCode());
        result = prime * result + ((getAnchorId() == null) ? 0 : getAnchorId().hashCode());
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
        sb.append(", roomId=").append(roomId);
        sb.append(", roomName=").append(roomName);
        sb.append(", userSubscribeId=").append(userSubscribeId);
        sb.append(", anchorId=").append(anchorId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}