package com.example.model;

import com.example.model.DTO.ChapterDTO;
import com.example.utils.DateUtils;

import java.sql.Timestamp;

public class Chapter {
    private int id;
    private String name;
    private byte lock;
    private int view;
    private int price;
    private byte show;
    private int idComic;
    private long timeLock;
    private Timestamp createAt;
    private Timestamp updateAt;

    public void setTimeLock(long timeLock) {
        this.timeLock = timeLock;
    }

    public long getTimeLock() {
        return timeLock;
    }


    public int getIdComic() {
        return idComic;
    }


    public int getId() {
        return id;
    }

    public void setIdComic(int idComic) {
        this.idComic = idComic;
    }

    public String getName() {
        return name;
    }

    public byte getLock() {
        return lock;
    }

    public Chapter(String name, byte lock, byte show, int idComic) {
        this.name = name;
        this.lock = lock;
        this.show = show;
        this.idComic = idComic;
    }
    public Chapter(String name, byte lock, byte show, int idComic,int price,long timeLock) {
        this.name = name;
        this.lock = lock;
        this.show = show;
        this.idComic = idComic;
        this.price=price;
        this.timeLock=timeLock;
    }
    public Chapter(){

    }

    public int getView() {
        return view;
    }

    public int getPrice() {
        return price;
    }

    public byte getShow() {
        return show;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLock(byte lock) {
        this.lock = lock;
    }

    public void setView(int view) {
        this.view = view;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setShow(byte show) {
        this.show = show;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }
    public ChapterDTO converChapterDTO(){
        ChapterDTO chapterDTO=new ChapterDTO();
        chapterDTO.setId(this.id);
        chapterDTO.setName(this.name);
        chapterDTO.setLock(this.lock);
        chapterDTO.setIdComic(this.idComic);
        chapterDTO.setView(this.view);
        chapterDTO.setPrice(this.price);
        chapterDTO.setTimeLock(this.timeLock);
        chapterDTO.setShow(this.show);
        chapterDTO.setCreateAt(this.createAt);
        chapterDTO.setUpdateAt(this.updateAt);
        return chapterDTO;
    }
}
