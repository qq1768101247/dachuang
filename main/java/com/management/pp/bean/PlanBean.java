package com.management.pp.bean;

import org.litepal.crud.LitePalSupport;
/**
 * 论坛表
 * */
public class PlanBean extends LitePalSupport {
    long id;
    String name;//标题
    String con;//内容
    String timeString;//时间
    String userId;//用户id

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
