package com.example.repository;

import com.example.model.Chapter;
import com.example.model.Order;

import java.sql.SQLException;

public interface IOrder {
    public void insertOrder(Order order) throws SQLException;
}
