package com.example.repository;

import com.example.model.Category;
import com.example.model.Comic;

import java.sql.SQLException;
import java.util.List;

public interface IComic {
    public void insertComic(Comic comic) throws SQLException;

    public Comic selectComic(int id);

    public List<Comic> selectAllComics();

    public boolean deleteComics(int id) throws SQLException;

    public boolean updateComics(Comic comic) throws SQLException;
}
