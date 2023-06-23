package com.example.service;

import com.example.database.ConnectionDatabase;
import com.example.model.Chapter;
import com.example.model.Page;
import com.example.repository.IPage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PageService implements IPage {

    @Override
    public void insertPage(Page page) throws SQLException {
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `page` (`id_chapter`, `link`, `index`, `name`) VALUES (?, ?, ?, ?);");
            preparedStatement.setInt(1, page.getIdChapter());
            preparedStatement.setString(2, page.getLink());
            preparedStatement.setInt(3, page.getIndex());
            preparedStatement.setString(4, page.getName());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Page selectPage(int id) {
        Page page=new Page();
        try{
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("select * from page where id=?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                page.setId(rs.getInt(1));
                page.setIdChapter(rs.getInt(2));
                page.setLink(rs.getString(3));
                page.setIndex(rs.getInt(4));
                page.setName(rs.getString(5));
                return page;
            }
        }
        catch (SQLException e){

        }
        return null;
    }

    @Override
    public List<Page> selectAllPageByIdChapter(int idChapter) {
        List<Page> listPage= new ArrayList<>();
        try{
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM page where id_chapter=?;");
            preparedStatement.setInt(1, idChapter);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name=rs.getString("name");
                String link = rs.getString("link");
                int index =rs.getInt("index");
                Page page =new Page(idChapter,link,index,name);
                page.setId(id);
                listPage.add(page);
            }
            return listPage;
        }
        catch (SQLException e){

        }
        return listPage;
    }

    @Override
    public boolean deletePage(int id) throws SQLException {
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `page` WHERE (`id` = ?);");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        }
        catch (SQLException e){

        }
        return false;
    }

    @Override
    public boolean updatePage(Page page) throws SQLException {
        try{
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `page` SET  `link` = ?, `index` = ?, `name` = ? WHERE (`id` = ?);");
            preparedStatement.setString(1, page.getLink());
            preparedStatement.setInt(2, page.getIndex());
            preparedStatement.setString(3, page.getName());
            preparedStatement.setInt(4, page.getId());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        }
        catch (SQLException e){
            printSQLException(e);
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
