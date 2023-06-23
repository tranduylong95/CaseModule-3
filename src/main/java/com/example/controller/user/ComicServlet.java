package com.example.controller.user;

import com.example.model.Comic;
import com.example.model.DTO.ComicDTO;
import com.example.repository.IComic;
import com.example.service.ComicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ComicServlet extends HttpServlet {
    private ComicService comicService= new ComicService();

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        try{
            String pathInfo = request.getPathInfo();
            String[] parts = pathInfo.split("/");
            String url="/"+parts[1];
            int idComic=Integer.parseInt(parts[1].replaceAll("[^0-9]", ""));
            Comic comic=comicService.selectComic(idComic);
            // Chưa xử lý chuoi tên để có thời gian sẽ xử lý
            if(comic!=null){
                showComicByID(request,response,idComic);

            }
        }
        catch (Exception e){

        }

    }
    private void showComicByID(HttpServletRequest request, HttpServletResponse response,int idComic) throws IOException, ServletException{
        ComicDTO comicDTO= comicService.findComicSelectWhereShow(idComic);
        request.setAttribute("comic",comicDTO);
        request.getRequestDispatcher("/user/views/detailComic.jsp").forward(request,response);
    }
}
