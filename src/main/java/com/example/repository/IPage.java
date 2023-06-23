package com.example.repository;



import com.example.model.Page;

import java.sql.SQLException;
import java.util.List;

public interface IPage {
    public void insertPage(Page page) throws SQLException;

    public Page selectPage(int id);

    public List<Page> selectAllPageByIdChapter(int idChapter);

    public boolean deletePage(int id) throws SQLException;

    public boolean updatePage(Page page) throws SQLException;
}
