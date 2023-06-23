package com.example.repository;

import java.sql.SQLException;

public interface  ICategories{
     void insertCategories(int idComic, int idCategoy) throws SQLException;
     void deleteCategoriesByIdComic(int idComic) throws SQLException;

}
