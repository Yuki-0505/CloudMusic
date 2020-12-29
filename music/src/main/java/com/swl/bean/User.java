package com.swl.bean;

import java.util.Date;

public class User {
    private Integer userId;
    private String userName;
    private String password;
    private Date birthday;
    private String email;
    private String wechat;
    private String signature;
    private Integer isVIP;
    private Date createTime;

    public User() {
        super();
    }

    public User(Integer userId, String userName, String password, Date birthday, String email, String wechat, String signature, Integer isVIP, Date createTime) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.birthday = birthday;
        this.email = email;
        this.wechat = wechat;
        this.signature = signature;
        this.isVIP = isVIP;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ApplicantDao{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", wechat='" + wechat + '\'' +
                ", signature='" + signature + '\'' +
                ", isVIP=" + isVIP +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getIsVIP() {
        return isVIP;
    }

    public void setIsVIP(Integer isVIP) {
        this.isVIP = isVIP;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
