package com.management.pp.bean;

import org.litepal.crud.LitePalSupport;
/**
 * 评论表
 * */
public class CommentsBean extends LitePalSupport {
    long id;
    String landId;//耕地 或者论坛 id
    String userID;
    String userName;
    String timeSting;
    String con;

    public String getLandId() {
        return landId;
    }

    public void setLandId(String landId) {
        this.landId = landId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTimeSting() {
        return timeSting;
    }

    public void setTimeSting(String timeSting) {
        this.timeSting = timeSting;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }
}
