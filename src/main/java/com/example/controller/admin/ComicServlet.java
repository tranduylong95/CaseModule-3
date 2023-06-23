package com.example.controller.admin;

import com.example.model.Comic;
import com.example.repository.ICategory;
import com.example.repository.IComic;
import com.example.service.CategoriesService;
import com.example.service.CategoryService;
import com.example.service.ComicService;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;


@WebServlet({"/admin/comic/create","/admin/comic","/admin/comic/edit/*","/admin/comic/delete/*"})
@MultipartConfig
public class ComicServlet extends HttpServlet {
    private final String LINK_IMAGE_DEFAULT="/admin/resources/images.png";
    private ICategory categoryService=new CategoryService();
    private IComic comicService=new ComicService();
    private CategoriesService categoriesService=new CategoriesService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action){
            case "/admin/comic/create":
                showCreateComic(request,response);
                break;
            case "/admin/comic":
                showListComic(request,response);
                break;
            case "/admin/comic/edit":
                try {
                    String pathInfo = request.getPathInfo();
                    String[] parts = pathInfo.split("/");
                    int id = Integer.parseInt(parts[1]);
                    showEditComicById(request, response, id);
                }
                catch (Exception e){
                    request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
                }
                break;
            case "/admin/comic/delete":
                try{
                    String pathInfo = request.getPathInfo();
                    String[] parts = pathInfo.split("/");
                    int id = Integer.parseInt(parts[1]);
                    DeleteComic(request,response,id);
                }
                catch (Exception e){
                    request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action){
                case "/admin/comic/create":
                    createComic(request,response);
                    break;
                case "/admin/comic/edit":
                    try{
                        String pathInfo = request.getPathInfo();
                        String[] parts = pathInfo.split("/");
                        int id = Integer.parseInt(parts[1]);
                        UpdateComic(request, response, id);
                    }
                    catch (Exception e){
                        request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
                    }
                    break;
            }
        }
        catch (SQLException ex){

        }

    }

    private void showCreateComic(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        request.setAttribute("listCategory", categoryService.selectAllCategory());
        request.getRequestDispatcher("/admin/view/comics/create.jsp").forward(request,response);
    }
    private void showListComic(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        request.setAttribute("listComic",comicService.selectAllComics());
        request.getRequestDispatcher("/admin/view/comics/list.jsp").forward(request,response);
    }
    private void showEditComicById(HttpServletRequest request, HttpServletResponse response,int id)throws IOException, ServletException{
        Comic comic=comicService.selectComic(id);
        if(comic==null)
            request.getRequestDispatcher("/admin/view/error/404.jsp").forward(request,response);
        else {
            request.setAttribute("comic",comic);
            request.setAttribute("listCategory",categoryService.selectAllCategory());
            request.getRequestDispatcher("/admin/view/comics/edit.jsp").forward(request, response);
        }
    }
    private void createComic(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException,SQLException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String describe=request.getParameter("describe");
        int sex = Integer.parseInt(request.getParameter("sex"));
        byte show=Byte.parseByte(request.getParameter("show"));
        byte status=Byte.parseByte(request.getParameter("status"));
        byte hot;
        String image;
        if(request.getParameter("hot")==""){
             hot =0;
        }
        else {
             hot=1;
        }
        if(request.getPart("image")!=null && request.getPart("image").getSize() > 0){
            String imagesPath= request.getServletContext().getRealPath("/admin/resources/image/");
            Part filePart = request.getPart("image");
            String originalFileName=filePart.getSubmittedFileName();
            image=UUID.randomUUID().toString()+"."+getFileExtension(originalFileName);// Lấy chuỗi không trùng nhau
            File file =new File(imagesPath,image);
            filePart.write(file.getAbsolutePath());
            image="/admin/resources/image/"+image;
        }
        else {
            image = LINK_IMAGE_DEFAULT;
        }
        Comic comic=new Comic(name,sex,hot,status,image,describe,show);
        comicService.insertComic(comic);
        String[] selectedOptions = request.getParameterValues("categories");
        if (selectedOptions != null) {
            for (String option : selectedOptions) {
                categoriesService.insertCategories(comic.getId(),Integer.parseInt(option));
            }
        }
    }
    private void UpdateComic(HttpServletRequest request, HttpServletResponse response,int id) throws IOException, ServletException,SQLException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String describe=request.getParameter("describe");
        int sex = Integer.parseInt(request.getParameter("sex"));
        byte show=Byte.parseByte(request.getParameter("show"));
        byte status=Byte.parseByte(request.getParameter("status"));
        byte hot;
        String image=request.getParameter("imageText");
        if(request.getParameter("hot")==""){
            hot =0;
        }
        else {
            hot=1;
        }
        if(request.getPart("image")!=null && request.getPart("image").getSize() > 0){
            String imagesPath= request.getServletContext().getRealPath("/admin/resources/image/");
            Part filePart = request.getPart("image");
            String originalFileName=filePart.getSubmittedFileName();
            image=UUID.randomUUID().toString()+"."+getFileExtension(originalFileName);// Lấy chuỗi không trùng nhau
            File file =new File(imagesPath,image);
            filePart.write(file.getAbsolutePath());
            image="/admin/resources/image/"+image;
        }

        Comic comic=new Comic(name,sex,hot,status,image,describe,show);
        comic.setId(id);
        comicService.updateComics(comic);
        String[] selectedOptions = request.getParameterValues("categories");
        if (selectedOptions != null) {
            categoriesService.deleteCategoriesByIdComic(id);
            for (String option : selectedOptions) {
                categoriesService.insertCategories(comic.getId(),Integer.parseInt(option));
            }
        }
    }
    private void DeleteComic(HttpServletRequest request, HttpServletResponse response,int id)throws IOException, ServletException,SQLException{
        comicService.deleteComics(id);
        request.setAttribute("messge","Xóa thành công");
        request.getRequestDispatcher("").forward(request,response);
    }
    private String getFileExtension(String fileName) {
        // Lấy đuôi file từ tên file
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex != -1) {
            return fileName.substring(lastDotIndex + 1);
        }
        return "";
    }
}
