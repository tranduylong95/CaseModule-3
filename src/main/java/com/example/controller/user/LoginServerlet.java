package com.example.controller.user;

import com.example.model.User;
import com.example.repository.user.IUser;
import com.example.service.OrderService;
import com.example.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet({"/dang-nhap","/dang-xuat"})
public class LoginServerlet extends HttpServlet {
    private IUser userService=new UserService();
    private OrderService orderService=new OrderService();
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action){
            case "/dang-nhap":
                showLogin(request,response);
                break;
            case "/dang-xuat":
                logOut(request,response);
                break;
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String action = request.getServletPath();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        switch (action){
            case "/dang-nhap":
                login(request,response);
                break;
        }
    }
    private void showLogin(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        request.getRequestDispatcher("/user/views/login.jsp").forward(request,response);
    }
    private void login(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String email = request.getParameter("email");
            String password = hashPassword(request.getParameter("password"));
            User user=userService.verifyUser(email);
            if(user!=null){
                if(user.getPassword().equals(password)){
                    user.setOrders(orderService.selectOrderByIdUser(user.getId()));
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    response.sendRedirect("/trang-chu");
                }
                else {
                    request.setAttribute("error","Mật khẩu không đúng mời bạn nhập lại");
                    request.getRequestDispatcher("/user/views/login.jsp").forward(request,response);
                }
            }
            else {
                request.setAttribute("error","Email không chính xác");
                request.getRequestDispatcher("/user/views/login.jsp").forward(request,response);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    private String hashPassword(String password)  throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return myHash;
    }
    private void logOut(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        HttpSession session = request.getSession();
        if (session != null) {
            session.removeAttribute("user");
        }
        response.sendRedirect("/trang-chu");
    }
}
