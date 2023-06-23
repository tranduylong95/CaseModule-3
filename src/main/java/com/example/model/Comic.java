package com.example.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Comic {
    private int id;
    private String name;
    private int sex;
    private byte hot;
    private byte status;
    private String image;
    private int poinRank;
    private float rank;
    private String describe;
    private int follow;
    private byte show;
    private Timestamp createAt;
    private Timestamp update_At;
    private List<Category> categoryList =new ArrayList<>();
    private int totalPage;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setUpdate_At(Timestamp update_At) {
        this.update_At = update_At;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Timestamp getUpdate_At() {
        return update_At;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public int getSex() {
        return sex;
    }

    public byte getHot() {
        return hot;
    }

    public byte getStatus() {
        return status;
    }

    public int getPoinRank() {
        return poinRank;
    }

    public float getRank() {
        return rank;
    }

    public String getDescribe() {
        return describe;
    }

    public int getFollow() {
        return follow;
    }

    public byte getShow() {
        return show;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public Timestamp getUpdateAt() {
        return update_At;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setHot(byte hot) {
        this.hot = hot;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public void setPoinRank(int poinRank) {
        this.poinRank = poinRank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setFollow(int follow) {
        this.follow = follow;
    }

    public void setShow(byte show) {
        this.show = show;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(Timestamp update_At) {
        this.update_At = update_At;
    }

    public Comic(String name, int sex, byte hot, byte status, String image, String describe, byte show) {
        this.name = name;
        this.sex = sex;
        this.hot = hot;
        this.status = status;
        this.image = image;
        this.describe = describe;
        this.show = show;
    }
}
