package cn.jinelei.live.model.data;

import java.io.Serializable;
import javax.persistence.*;

public class Tag implements Serializable {
    @Id
    @Column(name = "tag_id")
    private Integer tagId;

    @Column(name = "tag_name")
    private String tagName;

    private static final long serialVersionUID = 1L;

    /**
     * @return tag_id
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * @param tagId
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * @return tag_name
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * @param tagName
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
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
        Tag other = (Tag) that;
        return (this.getTagId() == null ? other.getTagId() == null : this.getTagId().equals(other.getTagId()))
            && (this.getTagName() == null ? other.getTagName() == null : this.getTagName().equals(other.getTagName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTagId() == null) ? 0 : getTagId().hashCode());
        result = prime * result + ((getTagName() == null) ? 0 : getTagName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tagId=").append(tagId);
        sb.append(", tagName=").append(tagName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}