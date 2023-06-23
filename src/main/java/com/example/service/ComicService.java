package com.example.service;

import com.example.database.ConnectionDatabase;
import com.example.model.Category;
import com.example.model.Chapter;
import com.example.model.Comic;
import com.example.model.DTO.CategoryDTO;
import com.example.model.DTO.ComicDTO;
import com.example.repository.ICategory;
import com.example.repository.IChapter;
import com.example.repository.IComic;
import com.example.repository.user.IComicUser;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComicService implements IComic, IComicUser {
    public ComicService() {
        super();
    }
    private ICategory categoryService=new CategoryService();
    private IChapter chapterService=new ChapterService();
    @Override
    public void insertComic(Comic comic) throws SQLException {
        // try-with-resource statement will auto close the connection.
        try {
            Connection connection = ConnectionDatabase.getConnection();
            //INSERT INTO `commicdb`.`comics` (`name`, `sex`, `hot`, `status`, `describe`, `image`) VALUES ( '2', '2', '2', '2', '22qwq', '23');
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `comics` (`name`, `sex`, `hot`, `status`, `describe`, `image`, `show`) VALUES ( ?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, comic.getName());
            preparedStatement.setInt(2, comic.getSex());
            preparedStatement.setByte(3, comic.getHot());
            preparedStatement.setByte(4, comic.getStatus());
            preparedStatement.setString(5, comic.getDescribe());
            preparedStatement.setString(6, comic.getImage());
            preparedStatement.setByte(7, comic.getShow());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int newId = generatedKeys.getInt(1);
                comic.setId(newId);
            }
            connection.close();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Comic selectComic(int id) {
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("select * from comics where id=?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int idProduct = rs.getInt("id");
                String name=rs.getString("name");
                int sex=rs.getInt("sex");
                byte hot=rs.getByte("hot");
                byte status=rs.getByte("status");
                int rank=rs.getInt("rank");
                int poinRank=rs.getInt("poinRank");
                String describe=rs.getString("describe");
                String image=rs.getString("image");
                int follow=rs.getInt("follow");
                byte show=rs.getByte("show");
                Timestamp createAt=rs.getTimestamp("create_at");
                Timestamp updateAt=rs.getTimestamp("update_at");
                Comic comic =new Comic(name,sex,hot,status,image,describe,show);
                comic.setId(idProduct);
                comic.setRank(rank);
                comic.setPoinRank(poinRank);
                comic.setFollow(follow);
                comic.setCreateAt(createAt);
                comic.setUpdateAt(updateAt);
                List<Category> categoryList=new ArrayList<>();
                preparedStatement = connection.prepareStatement("SELECT cate.* FROM category as cate,(SELECT * FROM categories as ct Where ct.id_comics=?)  as cate1 WHERE cate.id=cate1.id_category;");
                preparedStatement.setInt(1,id);
                ResultSet rs1 = preparedStatement.executeQuery();
                while (rs1.next()){
                    int idCategory=rs1.getInt("id");
                    String nameCategory=rs1.getString("name");
                    String describeCategory=rs1.getString("describe");
                    categoryList.add(new Category(idCategory,nameCategory,describeCategory));
                }
                comic.setCategoryList(categoryList);
                connection.close();
                return comic;
            }
        }
         catch (SQLException e){
             printSQLException(e);
         }
        return null;
    }

    @Override
    public List<Comic> selectAllComics() {
        List<Comic> comicList=new ArrayList<>();
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM comics");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name=rs.getString("name");
                int sex=rs.getInt("sex");
                byte hot=rs.getByte("hot");
                byte status=rs.getByte("status");
                int rank=rs.getInt("rank");
                int poinRank=rs.getInt("poinRank");
                String describe=rs.getString("describe");
                String image=rs.getString("image");
                int follow=rs.getInt("follow");
                byte show=rs.getByte("show");
                Timestamp createAt=rs.getTimestamp("create_at");
                Timestamp updateAt=rs.getTimestamp("update_at");
                Comic comic =new Comic(name,sex,hot,status,image,describe,show);
                comic.setId(id);
                comic.setRank(rank);
                comic.setPoinRank(poinRank);
                comic.setFollow(follow);
                comic.setCreateAt(createAt);
                comic.setUpdateAt(updateAt);
                List<Category> categoryList=new ArrayList<>();
                preparedStatement = connection.prepareStatement("SELECT cate.* FROM category as cate,(SELECT * FROM categories as ct Where ct.id_comics=?)  as cate1 WHERE cate.id=cate1.id_category;");
                preparedStatement.setInt(1,id);
                ResultSet rs1 = preparedStatement.executeQuery();
                while (rs1.next()){
                    int idCategory=rs1.getInt("id");
                    String nameCategory=rs1.getString("name");
                    String describeCategory=rs1.getString("describe");
                    categoryList.add(new Category(idCategory,nameCategory,describeCategory));
                }
                comic.setCategoryList(categoryList);
                comicList.add(comic);
            }
            connection.close();
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return comicList;
    }

    @Override
    public boolean deleteComics(int id) throws SQLException {
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `comics` WHERE (`id` = ?);");
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
    public boolean updateComics(Comic comic) throws SQLException {
        try{
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `comics` SET `name` = ?, `sex` = ?, `hot` = ?, `status` = ?, `describe` = ? , `image` = ?,  `show` = ? WHERE (`id` = ?);");
            preparedStatement.setString(1, comic.getName());
            preparedStatement.setInt(2, comic.getSex());
            preparedStatement.setByte(3, comic.getHot());
            preparedStatement.setByte(4, comic.getStatus());
            preparedStatement.setString(5, comic.getDescribe());
            preparedStatement.setString(6, comic.getImage());
            preparedStatement.setByte(7, comic.getShow());
            preparedStatement.setInt(8,comic.getId());
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

    @Override
    public List<ComicDTO> selectComicOrderBy(int page) {
        List<ComicDTO> comicList=new ArrayList<>();
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(" SELECT co.*,group_concat(distinct ct.id separator \",\") as id_category,group_concat( distinct pg.id separator \",\")as page_id,group_concat( distinct cp.id separator \",\")as chapter_id\n" +
                    " FROM comics co\n" +
                    " join categories cts on co.id= cts.id_comics\n" +
                    " join category ct on ct.id=cts.id_category\n" +
                    " LEFT JOIN (SELECT * FROM chapter where chapter.show=1) cp on co.id=cp.id_comics \n" +
                    " LEFT JOIN page pg on pg.id_chapter=cp.id\n" +
                    " WHERE co.show=1\n" +
                    " group by co.id\n" +
                    "ORDER BY co.update_at DESC LIMIT ?,36");
            preparedStatement.setInt(1,(page-1)*36);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                ComicDTO comicDTO=new ComicDTO();
                comicDTO.setId(rs.getInt("id"));
                comicDTO.setName(rs.getString("name"));
                comicDTO.setSex(rs.getByte("sex"));
                comicDTO.setHot(rs.getByte("hot"));
                comicDTO.setStatus(rs.getByte("status"));
                comicDTO.setPoinRank(rs.getInt("poinRank"));
                comicDTO.setRank(rs.getInt("rank"));
                comicDTO.setDescribe(rs.getString("describe"));
                comicDTO.setImage(rs.getString("image"));
                comicDTO.setFollow(rs.getInt("follow"));
                comicDTO.setCreateAt(rs.getTimestamp("create_at"));
                comicDTO.setUpdate_At(rs.getTimestamp("update_at"));
                if(rs.getString("id_category")!=null){
                   String [] id_categories = rs.getString("id_category").split(",");
                   for(String id_category:id_categories){
                       Category category =categoryService.selectCategory(Integer.parseInt(id_category));
                       comicDTO.getCategories().add(category.convertCategoryDTO());
                   }
                }
                if(rs.getString("chapter_id")!=null){
                    String [] chapters_id = rs.getString("chapter_id").split(",");
                    for(String chapter_id:chapters_id){
                        Chapter chapter =chapterService.selectChapter(Integer.parseInt(chapter_id));
                        comicDTO.getChapters().add(chapter.converChapterDTO());
                    }
                }
                Collections.reverse(comicDTO.getChapters());
                comicList.add(comicDTO);

            }
            connection.close();

        }
        catch (SQLException e)
        {
            printSQLException(e);
        }
        return comicList;
    }


    @Override
    public ComicDTO findComicSelectWhereShow(int id) {
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(" SELECT co.*,group_concat(distinct ct.id separator \",\") as id_category,group_concat( distinct pg.id separator \",\")as page_id,group_concat( distinct cp.id separator \",\")as chapter_id\n" +
                    " FROM comics co\n" +
                    " join categories cts on co.id= cts.id_comics\n" +
                    " join category ct on ct.id=cts.id_category\n" +
                    " LEFT JOIN (SELECT * FROM chapter where chapter.show=1) cp on co.id=cp.id_comics\n" +
                    " LEFT JOIN page pg on pg.id_chapter=cp.id\n" +
                    " WHERE co.show=1 AND co.id=?\n " +
                    " group by co.id;");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                ComicDTO comicDTO=new ComicDTO();
                comicDTO.setId(rs.getInt("id"));
                comicDTO.setName(rs.getString("name"));
                comicDTO.setSex(rs.getByte("sex"));
                comicDTO.setHot(rs.getByte("hot"));
                comicDTO.setStatus(rs.getByte("status"));
                comicDTO.setPoinRank(rs.getInt("poinRank"));
                comicDTO.setRank(rs.getInt("rank"));
                comicDTO.setDescribe(rs.getString("describe"));
                comicDTO.setImage(rs.getString("image"));
                comicDTO.setFollow(rs.getInt("follow"));
                comicDTO.setCreateAt(rs.getTimestamp("create_at"));
                comicDTO.setUpdate_At(rs.getTimestamp("update_at"));
                if(rs.getString("id_category")!=null){
                    String [] id_categories = rs.getString("id_category").split(",");
                    for(String id_category:id_categories){
                        Category category =categoryService.selectCategory(Integer.parseInt(id_category));
                        comicDTO.getCategories().add(category.convertCategoryDTO());
                    }
                }
                if(rs.getString("chapter_id")!=null){
                    String [] chapters_id = rs.getString("chapter_id").split(",");
                    for(String chapter_id:chapters_id){
                        Chapter chapter =chapterService.selectChapter(Integer.parseInt(chapter_id));
                        comicDTO.getChapters().add(chapter.converChapterDTO());
                    }
                }
                Collections.reverse(comicDTO.getChapters());
              return comicDTO;
            }
            connection.close();
        }
        catch (SQLException e)
        {
            printSQLException(e);
        }
        return null;
    }

    @Override
    public List<ComicDTO> selectComicOrderByWhereHot() {
        List<ComicDTO> comicList=new ArrayList<>();
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(" SELECT co.*,group_concat(distinct ct.id separator \",\") as id_category,group_concat( distinct pg.id separator \",\")as page_id,group_concat( distinct cp.id separator \",\")as chapter_id\n" +
                    " FROM comics co\n" +
                    " join categories cts on co.id= cts.id_comics\n" +
                    " join category ct on ct.id=cts.id_category\n" +
                    " LEFT JOIN (SELECT * FROM chapter where chapter.show=1) cp on co.id=cp.id_comics \n" +
                    " LEFT JOIN page pg on pg.id_chapter=cp.id\n" +
                    " WHERE co.show=1 AND co.hot=1\n" +
                    " group by co.id\n" +
                    "ORDER BY co.update_at DESC;");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                ComicDTO comicDTO=new ComicDTO();
                comicDTO.setId(rs.getInt("id"));
                comicDTO.setName(rs.getString("name"));
                comicDTO.setSex(rs.getByte("sex"));
                comicDTO.setHot(rs.getByte("hot"));
                comicDTO.setStatus(rs.getByte("status"));
                comicDTO.setPoinRank(rs.getInt("poinRank"));
                comicDTO.setRank(rs.getInt("rank"));
                comicDTO.setDescribe(rs.getString("describe"));
                comicDTO.setImage(rs.getString("image"));
                comicDTO.setFollow(rs.getInt("follow"));
                comicDTO.setCreateAt(rs.getTimestamp("create_at"));
                comicDTO.setUpdate_At(rs.getTimestamp("update_at"));
                if(rs.getString("id_category")!=null){
                    String [] id_categories = rs.getString("id_category").split(",");
                    for(String id_category:id_categories){
                        Category category =categoryService.selectCategory(Integer.parseInt(id_category));
                        comicDTO.getCategories().add(category.convertCategoryDTO());
                    }
                }
                if(rs.getString("chapter_id")!=null){
                    String [] chapters_id = rs.getString("chapter_id").split(",");
                    for(String chapter_id:chapters_id){
                        Chapter chapter =chapterService.selectChapter(Integer.parseInt(chapter_id));
                        comicDTO.getChapters().add(chapter.converChapterDTO());
                    }
                }
                Collections.reverse(comicDTO.getChapters());
                comicList.add(comicDTO);
            }
            connection.close();
        }
        catch (SQLException e)
        {
            printSQLException(e);
        }
        return comicList;
    }

    @Override
    public List<ComicDTO> selectComicOrderByWhereSex(int sex) {
        List<ComicDTO> comicList=new ArrayList<>();
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(" SELECT co.*,group_concat(distinct ct.id separator \",\") as id_category,group_concat( distinct pg.id separator \",\")as page_id,group_concat( distinct cp.id separator \",\")as chapter_id\n" +
                    " FROM comics co\n" +
                    " join categories cts on co.id= cts.id_comics\n" +
                    " join category ct on ct.id=cts.id_category\n" +
                    " LEFT JOIN (SELECT * FROM chapter where chapter.show=1) cp on co.id=cp.id_comics \n" +
                    " LEFT JOIN page pg on pg.id_chapter=cp.id\n" +
                    " WHERE co.show=1 AND co.sex=?" +
                    " group by co.id\n" +
                    "ORDER BY co.update_at DESC;");
            preparedStatement.setInt(1,sex);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                ComicDTO comicDTO=new ComicDTO();
                comicDTO.setId(rs.getInt("id"));
                comicDTO.setName(rs.getString("name"));
                comicDTO.setSex(rs.getByte("sex"));
                comicDTO.setHot(rs.getByte("hot"));
                comicDTO.setStatus(rs.getByte("status"));
                comicDTO.setPoinRank(rs.getInt("poinRank"));
                comicDTO.setRank(rs.getInt("rank"));
                comicDTO.setDescribe(rs.getString("describe"));
                comicDTO.setImage(rs.getString("image"));
                comicDTO.setFollow(rs.getInt("follow"));
                comicDTO.setCreateAt(rs.getTimestamp("create_at"));
                comicDTO.setUpdate_At(rs.getTimestamp("update_at"));
                if(rs.getString("id_category")!=null){
                    String [] id_categories = rs.getString("id_category").split(",");
                    for(String id_category:id_categories){
                        Category category =categoryService.selectCategory(Integer.parseInt(id_category));
                        comicDTO.getCategories().add(category.convertCategoryDTO());
                    }
                }
                if(rs.getString("chapter_id")!=null){
                    String [] chapters_id = rs.getString("chapter_id").split(",");
                    for(String chapter_id:chapters_id){
                        Chapter chapter =chapterService.selectChapter(Integer.parseInt(chapter_id));
                        comicDTO.getChapters().add(chapter.converChapterDTO());
                    }
                }
                Collections.reverse(comicDTO.getChapters());
                comicList.add(comicDTO);
            }
            connection.close();
        }
        catch (SQLException e)
        {
            printSQLException(e);
        }
        return comicList;
    }
    public int totalPage(String sql){
        try {
            Connection connection = ConnectionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
            connection.close();
        }
        catch (SQLException e){

        }
        return 0;
    }
}
