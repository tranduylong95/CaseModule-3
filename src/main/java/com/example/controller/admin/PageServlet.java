package com.example.controller.admin;

import com.example.model.Chapter;
import com.example.model.Page;
import com.example.repository.IPage;
import com.example.service.PageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/admin/comic/chapter/*"})
public class PageServlet extends HttpServlet {
    private IPage pageService=new PageService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        try {
            String pathInfo = request.getPathInfo();
            String[] parts = pathInfo.split("/");
            int idChapter=Integer.parseInt(parts[1]);
            if(pathInfo.matches("/[0-9]+/page")){
                request.setAttribute("pathInfo",pathInfo);
                showListPage(request,response,idChapter);
            }
            else if(pathInfo.matches("/[0-9]+/page/create")){
                request.setAttribute("pathInfo",pathInfo);
                showCreatePage(request,response,idChapter);
            }
            else if(pathInfo.matches("/[0-9]+/page/edit/[0-9]+")){
                request.setAttribute("pathInfo",pathInfo);
                int id=Integer.parseInt(parts[4]);
                showEditPage(request,response,id);
            }
            else {
                request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
            }
        }
        catch (RuntimeException e){
            request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
        }

    }

    private void showEditPage(HttpServletRequest request, HttpServletResponse response, int id)throws IOException, ServletException {
        Page page=pageService.selectPage(id);
        if(page==null){
            request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
        }
        else {
            request.setAttribute("page",page);
            request.getRequestDispatcher("/admin/view/page/edit.jsp").forward(request,response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        try {
            String pathInfo = request.getPathInfo();
            String[] parts = pathInfo.split("/");
            int idChapter=Integer.parseInt(parts[1]);
            if(pathInfo.matches("/[0-9]+/page")){

            }
            else if(pathInfo.matches("/[0-9]+/page/create")){
                try{

                    createPage(request,response,idChapter);
                }
                catch (SQLException e){
                    request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
                }
            }
            else if(pathInfo.matches("/[0-9]+/page/edit/[0-9]+")){
              try{
                  int id=Integer.parseInt(parts[4]);
                  updatePage(request,response,id,idChapter);
              }
              catch (SQLException e){
                  request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
              }
            }
            else {
                request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
            }
        }
        catch (RuntimeException e){
            request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
        }
    }
    protected void showCreatePage(HttpServletRequest request, HttpServletResponse response,int idChapter) throws IOException, ServletException{
        request.getRequestDispatcher("/admin/view/page/create.jsp").forward(request,response);
    }
    protected void showListPage(HttpServletRequest request, HttpServletResponse response,int idChapter) throws IOException, ServletException{
        List<Page> listPage=pageService.selectAllPageByIdChapter(idChapter);
        request.setAttribute("listPage",listPage);
        request.getRequestDispatcher("/admin/view/page/list.jsp").forward(request,response);
    }
    protected  void createPage(HttpServletRequest request, HttpServletResponse response,int idChapter) throws IOException, ServletException, SQLException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int index=Integer.parseInt(request.getParameter("index"));
        String link =request.getParameter("link");
        Page page =new Page(idChapter,link,index,name);
        pageService.insertPage(page);
        response.sendRedirect("/admin/comic/chapter/"+idChapter+"/page");
    }
    protected void updatePage(HttpServletRequest request, HttpServletResponse response, int id,int idChapter) throws IOException, ServletException,SQLException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Page page=new Page();
        String name=request.getParameter("name");
        String link =request.getParameter("link");
        int index =Integer.parseInt(request.getParameter("index"));
        page.setId(id);
        page.setName(name);
        page.setLink(link);
        page.setIndex(index);
        if(pageService.updatePage(page)==true){
            response.sendRedirect("/admin/comic/chapter/"+idChapter+"/page");
        }
        else {
            request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
        }
    }
    protected void deletePage(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException,SQLException{
        if(pageService.deletePage(id)==true){
           request.setAttribute("message","Xóa thành công");
           request.getRequestDispatcher("").forward(request,response);
       }
       else {
           request.setAttribute("message","Xóa không thành công");
           request.getRequestDispatcher("").forward(request,response);
       }

    }
}