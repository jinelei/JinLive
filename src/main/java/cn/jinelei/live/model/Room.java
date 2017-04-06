package cn.jinelei.live.model;

import java.io.Serializable;

public class Room implements Serializable {
    private Integer roomId;

    private String roomName;

    private Integer roomStatus;

    private String roomScreenshot;

    private String roomIntroduce;

    private Integer userId;

    private String streamKey;

    private static final long serialVersionUID = 1L;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomScreenshot() {
        return roomScreenshot;
    }

    public void setRoomScreenshot(String roomScreenshot) {
        this.roomScreenshot = roomScreenshot;
    }

    public String getRoomIntroduce() {
        return roomIntroduce;
    }

    public void setRoomIntroduce(String roomIntroduce) {
        this.roomIntroduce = roomIntroduce;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStreamKey() {
        return streamKey;
    }

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