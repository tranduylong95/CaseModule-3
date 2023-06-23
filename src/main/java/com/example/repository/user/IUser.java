package com.example.repository.user;

import com.example.model.Chapter;
import com.example.model.User;

import java.sql.SQLException;

public interface IUser {
    boolean insertUser(User user) throws SQLException;
    User verifyUser(String email)throws SQLException;
    public boolean updateUser(User user) throws SQLException;
}
