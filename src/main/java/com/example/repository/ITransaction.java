package com.example.repository;

import com.example.model.Chapter;
import com.example.model.Transaction;

import java.sql.SQLException;

public interface ITransaction {
    public void insertChapter(Transaction transaction) throws SQLException;
}
