package com.example.controller.user;

import com.example.model.User;
import com.example.repository.user.IUser;
import com.example.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.UUID;

@WebServlet({"/dang-ky"})
@MultipartConfig
    public class RegisterServerlet extends HttpServlet {
    private String LINK_IMAGE_DEFAULT="//st.nhattruyenmin.com/data/siteimages/anonymous.png";
    private IUser userService=new UserService();
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action){
            case "/dang-ky":
                showRegister(request,response);
                break;
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        String action = request.getServletPath();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        switch (action){
            case "/dang-ky":
                createUser(request,response);
                break;
        }
    }
    private void showRegister(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        request.getRequestDispatcher("/user/views/resgister.jsp").forward(request,response);
    }
    private void createUser(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        try {

            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String name =request.getParameter("name");
            String email=request.getParameter("email");
            String password=hashPassword(request.getParameter("pwd"));
            byte sex=Byte.parseByte(request.getParameter("sex"));
            String image;
            if(request.getPart("image")!=null && request.getPart("image").getSize() > 0){
                String imagesPath= request.getServletContext().getRealPath("/user/resources/image/");
                Part filePart = request.getPart("image");
                String originalFileName=filePart.getSubmittedFileName();
                image= UUID.randomUUID().toString()+"."+getFileExtension(originalFileName);// Lấy chuỗi không trùng nhau
                File file =new File(imagesPath,image);
                filePart.write(file.getAbsolutePath());
                image="/user/resources/image/"+image;
            }
            else {
                image = LINK_IMAGE_DEFAULT;
            }
            User user=new User(name,image,email,password,sex);
            userService.insertUser(user);
            response.sendRedirect("/dang-nhap");
        }
        catch (SQLException e){
            request.setAttribute("error","Email đã tồn tại");
            request.getRequestDispatcher("/user/views/resgister.jsp").forward(request,response);
        }
        catch (Exception e){

        }
    }
    private String getFileExtension(String fileName) {
        // Lấy đuôi file từ tên file
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex != -1) {
            return fileName.substring(lastDotIndex + 1);
        }
        return "";
    }
    private String hashPassword(String password)  throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return myHash;
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
}
