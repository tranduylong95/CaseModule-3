package com.example.repository;

import com.example.model.Chapter;
import com.example.model.Comic;

import java.sql.SQLException;
import java.util.List;

public interface IChapter {
    public void insertChapter(Chapter chapter) throws SQLException;

    public Chapter selectChapter(int id);

    public List<Chapter> selectAllChapterByComics(int idComic);

    public boolean deleteChapter(int id) throws SQLException;

    public boolean updateChapter(Chapter chapter) throws SQLException;
}
