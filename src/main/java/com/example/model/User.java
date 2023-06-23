package com.example.model;



import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String image;
    private String email;
    private String password;
    private byte sex;
    private int blance;
    private int poin;
    private int status;
    private List<Order> orders;
    private Timestamp timestamp;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public User(String name, String image, String email, String password, byte sex) {
        this.name = name;
        this.image = image;
        this.email = email;
        this.password = password;
        this.sex = sex;
        orders=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public byte getSex() {
        return sex;
    }

    public int getBlance() {
        return blance;
    }

    public int getPoin() {
        return poin;
    }

    public int getStatus() {
        return status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public void setBlance(int blance) {
        this.blance = blance;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    public boolean checkOrder(int idChapter){
        for (Order order:orders){
            if(order.getIdChapter()==idChapter){
                return true;
            }
        }
        return false;
    }
}
