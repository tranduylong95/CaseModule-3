package com.example.service;

import com.example.database.ConnectionDatabase;
import com.example.model.Category;
import com.example.repository.ICategory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategory {

    @Override
    public void insertCategory(Category category) throws SQLException {

    }

    @Override
    public Category selectCategory(int id) {

        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("select * from Category where id=?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String describe = rs.getString("describe");
                Category category=new Category(id,name,describe);
                return category;
            }
        }
        catch (SQLException e ){

        }
        return null;
    }

    @Override
    public List<Category> selectAllCategory() {
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String describe = rs.getString("describe");
                categories.add(new Category(id,name,describe));
            }
            connection.close();
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return categories;
    }

    @Override
    public boolean deleteCategory(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateCategory(Category category) throws SQLException {
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
