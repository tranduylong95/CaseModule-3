package com.example.controller.admin;

import com.example.model.User;
import com.example.repository.user.IUser;
import com.example.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebFilter("/admin/*")
public class LoginServlet implements Filter {
    private IUser userService=new UserService();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String action = request.getServletPath();
        String method = request.getMethod();
        if (action.equals("/admin/login") && method.equals("POST")) {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String email = request.getParameter("email");
            try {
                String password = hashPassword(request.getParameter("pwd"));
                User user=userService.verifyUser(email);
                if(user!=null){
                    if(user.getPassword().equals(password)&&user.getId()==1){
                        HttpSession session = request.getSession();
                        session.setAttribute("admin", user);
                        response.sendRedirect( "/admin/comic");
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

            }

        }
        else {
            if (action.equals("/admin/login")) {
                request.getRequestDispatcher("/admin/view/login.jsp").forward(request, response);
            } else {
                // Kiểm tra vai trò của người dùng
                HttpSession session = request.getSession();


                if (session.getAttribute("admin") == null) {
                    // Người dùng chưa đăng nhập hoặc không có vai trò là admin, chuyển hướng đến trang đăng nhập
                    response.sendRedirect("/admin/login");
                } else {
                    filterChain.doFilter(request, response);
                }
            }
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
}

