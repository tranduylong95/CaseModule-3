package com.example.controller.admin;

import com.example.model.Chapter;
import com.example.repository.IChapter;
import com.example.service.ChapterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet({"/admin/comic/*"})
public class ChapterServlet extends HttpServlet {
    private ChapterService chapterService=new ChapterService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        String pathInfo = request.getPathInfo();
        String[] parts = pathInfo.split("/");
        String url="/"+parts[1];
        int idComic=Integer.parseInt(parts[1].replaceAll("[^0-9]", ""));
        if(pathInfo.matches(url+"/chapter/create")){
            request.setAttribute("pathInfo",pathInfo);
            showCreateChapter(request,response);
            return;
//            request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
        }
        else if(pathInfo.matches(url+"/chapter")){
            request.setAttribute("path",pathInfo);
            showListChapter(request,response,idComic);
        }
        else if(pathInfo.matches(url+"/chapter/edit/[0-9]+")){
            try {
                int id = Integer.parseInt(parts[4]);
                request.setAttribute("pathInfo",pathInfo);
                showEditChapter(request,response,id);
            }
            catch (Exception e) {
                request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request, response);
            }
        }
        else if(pathInfo.matches(url+"/chapter/delete/[0-9]+")){
            request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

        String pathInfo = request.getPathInfo();
        String[] parts = pathInfo.split("/");
        String url="/"+parts[1];
        int idComic=Integer.parseInt(parts[1].replaceAll("[^0-9]", ""));
        if(pathInfo.matches(url+"/chapter/create")){
            try {
                createChapter(request,response,idComic,url);
            }
            catch (SQLException e){

            }
        }
        else if(pathInfo.matches(url+"/chapter/edit/[0-9]+")){
            try {
                int id = Integer.parseInt(parts[4]);
                editChapter(request,response,id,url);
            }
            catch (Exception e) {
                request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request, response);
            }
        }
    }
    private void showListChapter(HttpServletRequest request, HttpServletResponse response,int idComic)throws IOException, ServletException{
        List<Chapter> chapterList=chapterService.selectAllChapterByComics(idComic);
        request.setAttribute("listChapter",chapterList);
        request.getRequestDispatcher("/admin/view/chapter/list.jsp").forward(request,response);
    }
    private void showCreateChapter(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        request.getRequestDispatcher("/admin/view/chapter/create.jsp").forward(request,response);
    }
    private void createChapter(HttpServletRequest request, HttpServletResponse response,int idComic, String url)throws IOException, ServletException,SQLException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Chapter chapter;
        String name = request.getParameter("name");
        byte show=Byte.parseByte(request.getParameter("show"));
        byte lock=Byte.parseByte(request.getParameter("lock"));
        if(lock==0){
            chapter=new Chapter(name,lock,show,idComic);
        }
        else  {
            int price=Integer.parseInt(request.getParameter("price"));
            int hoursChange=Integer.parseInt(request.getParameter("hoursChange"));
            int minutesChange=Integer.parseInt(request.getParameter("minutesChange"));
            int secondsChange=Integer.parseInt(request.getParameter("secondsChange"));
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
            Duration duration = Duration.ofHours(hoursChange).plusMinutes(minutesChange).plusSeconds(secondsChange);
            ZonedDateTime futureDateTime = now.plus(duration);

            long crutime = futureDateTime.toEpochSecond();
            long currentTimeMillis = crutime * 1000L;
//            Instant instant = Instant.ofEpochMilli(currentTimeMillis);
//            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//            System.out.println("Ngày tháng năm giờ phút giây: " + dateTime);
              chapter=new Chapter(name,lock,show,idComic,price,currentTimeMillis);
        }
            chapterService.insertChapter(chapter);
             response.sendRedirect("/admin/comic"+url+"/chapter");
    }
    private void showEditChapter(HttpServletRequest request, HttpServletResponse response,int id)throws IOException, ServletException{
        Chapter chapter=chapterService.selectChapter(id);
        if(chapter==null){
            request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
        }
        else {
            request.setAttribute("chapter",chapter);
            request.getRequestDispatcher("/admin/view/chapter/edit.jsp").forward(request,response);
        }

    }
    private void editChapter(HttpServletRequest request, HttpServletResponse response,int id,String url) throws IOException, ServletException,SQLException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Chapter chapter;
        String name = request.getParameter("name");
        byte show=Byte.parseByte(request.getParameter("show"));
        byte lock=Byte.parseByte(request.getParameter("lock"));
        if(lock==0){
            chapter=new Chapter();
            chapter.setName(name);
            chapter.setShow(show);
            chapter.setLock(lock);
            chapter.setId(id);
        }
        else  {
            int price=Integer.parseInt(request.getParameter("price"));
            int hoursChange=Integer.parseInt(request.getParameter("hoursChange"));
            int minutesChange=Integer.parseInt(request.getParameter("minutesChange"));
            int secondsChange=Integer.parseInt(request.getParameter("secondsChange"));
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
            Duration duration = Duration.ofHours(hoursChange).plusMinutes(minutesChange).plusSeconds(secondsChange);
            ZonedDateTime futureDateTime = now.plus(duration);

            long crutime = futureDateTime.toEpochSecond();
            long currentTimeMillis = crutime * 1000L;
//            Instant instant = Instant.ofEpochMilli(currentTimeMillis);
//            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//            System.out.println("Ngày tháng năm giờ phút giây: " + dateTime);
              chapter=new Chapter();
              chapter.setId(id);
              chapter.setName(name);
              chapter.setShow(show);
              chapter.setPrice(price);
              chapter.setTimeLock(currentTimeMillis);
              chapter.setLock(lock);

        }
        chapterService.updateChapter(chapter);
        response.sendRedirect("/admin/comic"+url+"/chapter");
    }
}
