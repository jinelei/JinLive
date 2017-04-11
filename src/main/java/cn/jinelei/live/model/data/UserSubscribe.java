package cn.jinelei.live.model.data;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "user_subscribe")
public class UserSubscribe implements Serializable {
    @Id
    @Column(name = "user_subscribe_id")
    private Integer userSubscribeId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "room_id")
    private Integer roomId;

    private static final long serialVersionUID = 1L;

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
        UserSubscribe other = (UserSubscribe) that;
        return (this.getUserSubscribeId() == null ? other.getUserSubscribeId() == null : this.getUserSubscribeId().equals(other.getUserSubscribeId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserSubscribeId() == null) ? 0 : getUserSubscribeId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userSubscribeId=").append(userSubscribeId);
        sb.append(", userId=").append(userId);
        sb.append(", roomId=").append(roomId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}