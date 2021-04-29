package com.example.my31_recyclerview3;

import java.io.Serializable;

public class SingerDTO implements Serializable {

    String name, mobile, location, Most;
    int resId;

    public SingerDTO(String name, String mobile, String location, String Most, int resId) {
        this.name = name;
        this.mobile = mobile;
        this.location = location;
        this.Most = Most;
        this.resId = resId;
    }

    public SingerDTO(String name, String mobile, int resId) {
        this.name = name;
        this.mobile = mobile;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(int age) {
        this.location = location;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMost() {
        return Most;
    }

    public void setMost(String most) {
        Most = most;
    }
}
