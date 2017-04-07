package cn.jinelei.live.model.data;

import java.io.Serializable;
import javax.persistence.*;

public class Room implements Serializable {
    @Id
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

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "stream_key")
    private String streamKey;

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
        Room other = (Room) that;
        return (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getRoomName() == null ? other.getRoomName() == null : this.getRoomName().equals(other.getRoomName()))
            && (this.getRoomStatus() == null ? other.getRoomStatus() == null : this.getRoomStatus().equals(other.getRoomStatus()))
            && (this.getRoomScreenshot() == null ? other.getRoomScreenshot() == null : this.getRoomScreenshot().equals(other.getRoomScreenshot()))
            && (this.getRoomIntroduce() == null ? other.getRoomIntroduce() == null : this.getRoomIntroduce().equals(other.getRoomIntroduce()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStreamKey() == null ? other.getStreamKey() == null : this.getStreamKey().equals(other.getStreamKey()));
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
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStreamKey() == null) ? 0 : getStreamKey().hashCode());
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
        sb.append(", userId=").append(userId);
        sb.append(", streamKey=").append(streamKey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}