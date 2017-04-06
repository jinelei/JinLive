package cn.jinelei.live.model;

import java.io.Serializable;

public class TagCategory implements Serializable {
    private Integer tagCategoryId;

    private Integer tagId;

    private Integer categoryId;

    private static final long serialVersionUID = 1L;

    public Integer getTagCategoryId() {
        return tagCategoryId;
    }

    public void setTagCategoryId(Integer tagCategoryId) {
        this.tagCategoryId = tagCategoryId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

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
        TagCategory other = (TagCategory) that;
        return (this.getTagCategoryId() == null ? other.getTagCategoryId() == null : this.getTagCategoryId().equals(other.getTagCategoryId()))
            && (this.getTagId() == null ? other.getTagId() == null : this.getTagId().equals(other.getTagId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTagCategoryId() == null) ? 0 : getTagCategoryId().hashCode());
        result = prime * result + ((getTagId() == null) ? 0 : getTagId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tagCategoryId=").append(tagCategoryId);
        sb.append(", tagId=").append(tagId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}