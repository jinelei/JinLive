package cn.jinelei.live.model.data;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "room_category")
public class RoomCategory implements Serializable {
    @Id
    @Column(name = "room_category_id")
    private Integer roomCategoryId;

    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "category_id")
    private Integer categoryId;

    private static final long serialVersionUID = 1L;

    /**
     * @return room_category_id
     */
    public Integer getRoomCategoryId() {
        return roomCategoryId;
    }

    /**
     * @param roomCategoryId
     */
    public void setRoomCategoryId(Integer roomCategoryId) {
        this.roomCategoryId = roomCategoryId;
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
        RoomCategory other = (RoomCategory) that;
        return (this.getRoomCategoryId() == null ? other.getRoomCategoryId() == null : this.getRoomCategoryId().equals(other.getRoomCategoryId()))
            && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoomCategoryId() == null) ? 0 : getRoomCategoryId().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roomCategoryId=").append(roomCategoryId);
        sb.append(", roomId=").append(roomId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}