package com.example.repository.user;

import com.example.model.Comic;
import com.example.model.DTO.ComicDTO;
import com.example.repository.IComic;

import java.awt.*;
import java.util.List;

public interface IComicUser {
    List<ComicDTO> selectComicOrderBy(int page);
    ComicDTO findComicSelectWhereShow(int id);
    List<ComicDTO> selectComicOrderByWhereHot();
    List<ComicDTO> selectComicOrderByWhereSex(int sex);
    int totalPage(String sql);
}
