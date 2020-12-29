package com.swl.bean;

import java.util.Date;

public class Favorite {
    private Integer favoriteId;
    private Integer userId;
    private String favoriteName;
    private String filePath;
    private Date createTime;

    public Favorite() {
        super();
    }

    public Favorite(Integer favoriteId, Integer userId, String favoriteName, String filePath, Date createTime) {
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.favoriteName = favoriteName;
        this.filePath = filePath;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "favoriteId=" + favoriteId +
                ", userId=" + userId +
                ", favoriteName='" + favoriteName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFavoriteName() {
        return favoriteName;
    }

    public void setFavoriteName(String favoriteName) {
        this.favoriteName = favoriteName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
