package com.example.model;

import java.sql.Timestamp;

public class Transaction {
    private int id_transaction;
    private int id_user;
    private int amount ;
    private Timestamp timestamp;

    public int getId_transaction() {
        return id_transaction;
    }

    public Transaction(int id_transaction, int id_user, int amount) {
        this.id_transaction = id_transaction;
        this.id_user = id_user;
        this.amount = amount;
    }

    public void setId_transaction(int id_transaction) {
        this.id_transaction = id_transaction;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getId_user() {
        return id_user;
    }

    public int getAmount() {
        return amount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
