package com.swl.bean;

import java.util.Date;

public class Music {
    private Integer musicId;
    private Integer favoriteId;
    private String musicName;
    private String writerName;
    private String kind;
    private Integer price;
    private Integer plays;
    private String filePath;
    private Date createTime;

    public Music() {
        super();
    }

    public Music(Integer musicId, Integer favoriteId, String musicName, String writerName, String kind, Integer price, Integer plays, String filePath, Date createTime) {
        this.musicId = musicId;
        this.favoriteId = favoriteId;
        this.musicName = musicName;
        this.writerName = writerName;
        this.kind = kind;
        this.price = price;
        this.plays = plays;
        this.filePath = filePath;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Music{" +
                "musicId=" + musicId +
                ", favoriteId=" + favoriteId +
                ", musicName='" + musicName + '\'' +
                ", writerName='" + writerName + '\'' +
                ", kind='" + kind + '\'' +
                ", price=" + price +
                ", plays=" + plays +
                ", filePath='" + filePath + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public Integer getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPlays() {
        return plays;
    }

    public void setPlays(Integer plays) {
        this.plays = plays;
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
