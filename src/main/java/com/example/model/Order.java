package com.example.model;


import java.sql.Timestamp;

public class Order {
    private int id;
    private int idUser;
    private int idChapter;
    private int price;
    private Timestamp creatAt;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdChapter() {
        return idChapter;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdChapter(int idChapter) {
        this.idChapter = idChapter;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCreatAt(Timestamp creatAt) {
        this.creatAt = creatAt;
    }

    public int getPrice() {
        return price;
    }

    public Timestamp getCreatAt() {
        return creatAt;
    }

    public Order( int idUser, int idChapter, int price) {
        this.idUser = idUser;
        this.idChapter = idChapter;
        this.price = price;
    }
    public Order(){

    }
}
