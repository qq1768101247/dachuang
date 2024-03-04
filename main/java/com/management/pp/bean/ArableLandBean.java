package com.management.pp.bean;

import org.litepal.crud.LitePalSupport;
/**
 * 耕地表
 * */
public class ArableLandBean extends LitePalSupport {
    long id;
    String type;//是否已种植
    String area;//面积
    String soil;//土壤
    String userId;
    String unmber;//编号
    String con;//描述
    String address;//地址



    public String getUnmber() {
        return unmber;
    }

    public void setUnmber(String unmber) {
        this.unmber = unmber;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
