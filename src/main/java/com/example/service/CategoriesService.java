package com.example.service;

import com.example.database.ConnectionDatabase;
import com.example.repository.ICategories;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriesService implements ICategories {
    @Override
    public void insertCategories(int idComic, int idCategoy) throws SQLException {
        try{
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO `categories` (`id_category`, `id_comics`) VALUES ( ?, ?);");
            preparedStatement.setInt(1,idCategoy);
            preparedStatement.setInt(2, idComic);
            preparedStatement.executeUpdate();
            connection.close();
        }
        catch (SQLException e){

        }
    }

    @Override
    public void deleteCategoriesByIdComic(int idComic) throws SQLException {
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM `categories` WHERE (`id_comics` = ?);");
            preparedStatement.setInt(1, idComic);
            preparedStatement.executeUpdate();
            connection.close();
        }
        catch (SQLException e){
        }
    }

}
