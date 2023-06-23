package com.example.service;

import com.example.database.ConnectionDatabase;
import com.example.model.Chapter;
import com.example.repository.IChapter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChapterService implements IChapter {
    @Override
    public void insertChapter(Chapter chapter) throws SQLException {
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement=null;
            if(chapter.getLock()==0){
                preparedStatement = connection.prepareStatement("INSERT INTO `chapter` (`name`, `lock`, `id_comics`, `show`) VALUES (?, ?, ?, ?);");
                preparedStatement.setString(1, chapter.getName());
                preparedStatement.setByte(2, chapter.getLock());
                preparedStatement.setInt(3,chapter.getIdComic());
                preparedStatement.setByte(4,chapter.getShow());
            }
            else {
                preparedStatement=connection.prepareStatement("INSERT INTO `commicdb`.`chapter` (`name`, `lock`, `time_lock`, `price`, `id_comics`, `show`) VALUES (?, ?, ?, ?, ?, ?);");
                preparedStatement.setString(1, chapter.getName());
                preparedStatement.setByte(2, chapter.getLock());
                preparedStatement.setLong(3,chapter.getTimeLock());
                preparedStatement.setInt(4,chapter.getPrice());
                preparedStatement.setInt(5,chapter.getIdComic());
                preparedStatement.setByte(6,chapter.getShow());

            }
            preparedStatement.executeUpdate();
            connection.close();
        }
       catch (SQLException e){
           printSQLException(e);
       }

    }

    @Override
    public Chapter selectChapter(int id) {
        Chapter chapter=new Chapter();
        try{
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("select * from chapter where id=?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
               chapter.setId(rs.getInt(1));
               chapter.setName(rs.getString(2));
               chapter.setLock(rs.getByte(3));
               chapter.setView(rs.getInt(4));
               chapter.setTimeLock(rs.getLong(5));
               chapter.setPrice(rs.getInt(6));
               chapter.setCreateAt(rs.getTimestamp(7));
               chapter.setUpdateAt(rs.getTimestamp(8));
               return chapter;
            }
        }
        catch (SQLException e){

        }
        return null;
    }

    @Override
    public List<Chapter> selectAllChapterByComics(int idComic) {
        List<Chapter> listChapter= new ArrayList<>();
        try{
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM chapter where id_comics=?;");
            preparedStatement.setInt(1, idComic);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name=rs.getString("name");
                byte lock = rs.getByte("lock");
                int view =rs.getInt("view");
                long timeLock=rs.getLong("time_lock");
                int price=rs.getInt("price");
                byte show=rs.getByte("show");
                Timestamp createAt=rs.getTimestamp("create_at");
                Timestamp updateAt=rs.getTimestamp("update_at");
                Chapter chapter=new Chapter(name,lock,show,idComic,price,timeLock);
                chapter.setId(id);
                chapter.setView(view);
                chapter.setCreateAt(createAt);
                chapter.setUpdateAt(updateAt);
                listChapter.add(chapter);
            }
            return listChapter;
        }
        catch (SQLException e){

        }
        return null;
    }

    @Override
    public boolean deleteChapter(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateChapter(Chapter chapter) throws SQLException {
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement=null;
            if(chapter.getLock()==0){
                preparedStatement = connection.prepareStatement("UPDATE `chapter` SET `name` = ?, `lock` = ?, `time_lock` = '0', `price` = '0', `show `= ? WHERE (`id` = ?);");
                preparedStatement.setString(1, chapter.getName());
                preparedStatement.setByte(2, chapter.getLock());
                preparedStatement.setByte(3,chapter.getShow());
                preparedStatement.setInt(4,chapter.getId());
            }
            else {
                preparedStatement = connection.prepareStatement("UPDATE `chapter` SET `name` = ?, `lock` = ?, `time_lock` = ?, `price` = ?, `show` = ?,`time_lock` = ?  WHERE (`id` = ?);");
                preparedStatement.setString(1, chapter.getName());
                preparedStatement.setByte(2, chapter.getLock());
                preparedStatement.setLong(3,chapter.getTimeLock());
                preparedStatement.setInt(4,chapter.getPrice());
                preparedStatement.setByte(5,chapter.getShow());
                System.out.println(chapter.getShow());
                preparedStatement.setLong(6,chapter.getTimeLock());
                preparedStatement.setInt(7,chapter.getId());
            }
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        }
        catch (SQLException e){

        }
        return false;
    }
    public boolean updateChapterView(Chapter chapter)throws SQLException {
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement=null;
            preparedStatement = connection.prepareStatement("UPDATE `commicdb`.`chapter` SET `view` = ? WHERE (`id` = ?);");
            preparedStatement.setInt(1, chapter.getView());
            preparedStatement.setInt(2, chapter.getId());
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
