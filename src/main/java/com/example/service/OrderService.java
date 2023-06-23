package com.example.service;

import com.example.database.ConnectionDatabase;
import com.example.model.Order;
import com.example.repository.IOrder;
import com.example.repository.IPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService  implements IOrder {
    @Override
    public void insertOrder(Order order) throws SQLException {
        try{
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO `order` (`id_user`, `id_chapter`, `price`) VALUES (?, ?, ?);");
            preparedStatement.setInt(1,order.getIdUser());
            preparedStatement.setInt(2, order.getIdChapter());
            preparedStatement.setInt(3, order.getPrice());
            preparedStatement.executeUpdate();
            connection.close();
        }
        catch (SQLException e){

        }
    }
    public boolean findOrderWhereUserAndChapter(int idUser,int idChapter){
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("select * from `order` where id_user=? and id_chapter=?");
            preparedStatement.setInt(1,idUser);
            preparedStatement.setInt(2,idChapter);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                return true;
            }
        }
        catch (SQLException e){

        }
        return false;
    }
    public List<Order> selectOrderByIdUser(int idUser){
        List<Order> orders=new ArrayList<>();
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("select * from `order` where id_user=? ");
            preparedStatement.setInt(1,idUser);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Order order=new Order();
                order.setId(rs.getInt("id"));
                order.setIdUser(rs.getInt("id_user"));
                order.setIdChapter(rs.getInt("id_chapter"));
                order.setPrice(rs.getInt("price"));
                order.setCreatAt(rs.getTimestamp("create_at"));
                orders.add(order);
            }
            connection.close();
        }
        catch (SQLException e){

        }
        return orders;
    }
}
