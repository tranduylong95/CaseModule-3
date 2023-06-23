package com.example.service;

import com.example.database.ConnectionDatabase;
import com.example.model.Page;
import com.example.model.User;
import com.example.repository.user.IUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService implements IUser {
    @Override
    public boolean insertUser(User user) throws SQLException {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `commicdb`.`user` (`name`, `email`, `password`, `sex`, `image`) VALUES (?, ?, ?, ?, ?);");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setByte(4,user.getSex());
            preparedStatement.setString(5,user.getImage());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
    }

    @Override
    public User verifyUser(String email) throws SQLException {

        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM commicdb.user where email=?");
            preparedStatement.setString(1,email);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name=rs.getString("name");
                String password=rs.getString("password");
                Byte status=rs.getByte("status");
                int blance=rs.getInt("blance");
                byte sex=rs.getByte("sex");
                int point=rs.getInt("point");
                String image=rs.getString("image");
                User user=new User(name,image,email,password,sex);
                user.setBlance(blance);
                user.setPoin(point);
                user.setStatus(status);
                user.setId(id);
                return user;
            }
        }
        catch (SQLException e){

        }
        return null;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement=null;
            preparedStatement = connection.prepareStatement("UPDATE `user` SET `name` = ?, `email` = ?, `password` = ?, `blance` = ?, `sex` = ?, `point` = ?, `image` = ? WHERE (`id` = ?);");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setInt(4,user.getBlance());
            preparedStatement.setByte(5,user.getSex());
            preparedStatement.setInt(6,user.getPoin());
            preparedStatement.setString(7,user.getImage());
            preparedStatement.setInt(8,user.getId());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        }
        catch (SQLException e){

        }
        return false;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
