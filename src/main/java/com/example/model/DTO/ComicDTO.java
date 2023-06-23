package com.example.model.DTO;

import com.example.model.Category;
import com.example.model.Chapter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ComicDTO {
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
    private List<ChapterDTO> chapters;
    private List<CategoryDTO> categories;

    public ComicDTO() {
        chapters=new ArrayList<>();
        categories=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public String getImage() {
        return image;
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

    public Timestamp getCreateAt() {
        return createAt;
    }

    public Timestamp getUpdate_At() {
        return update_At;
    }

    public List<ChapterDTO> getChapters() {
        return chapters;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
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

    public void setImage(String image) {
        this.image = image;
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

    public void setUpdate_At(Timestamp update_At) {
        this.update_At = update_At;
    }

    public void setChapters(List<ChapterDTO> chapters) {
        this.chapters = chapters;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
    public int totalView(){
        int total=0;
        for (ChapterDTO chapter: chapters) {
            total+=chapter.getView();
        }
        return total;
    }
}
