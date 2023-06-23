package com.example.controller.user;

import com.example.model.Transaction;
import com.example.model.User;
import com.example.repository.ITransaction;
import com.example.repository.user.IUser;
import com.example.service.TransactionService;
import com.example.service.UserService;
import com.example.utils.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet({"/thanh-toan","/payment"})
public class PayMentServlet  extends HttpServlet {
    private ITransaction transactionService=new TransactionService();
    private IUser userService=new UserService();
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action){
            case "/thanh-toan":
                showPayment(request,response);
                break;
        }
    }
    public void showPayment(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        if(request.getParameter("vnp_TransactionStatus")!=null&&request.getParameter("vnp_TransactionStatus").equals("00")){
            String redirectUrl = "/thanh-toan?param1=success";
            try {
                int amount =Integer.parseInt(request.getParameter("vnp_Amount"))/100;
                int idTransaction=Integer.parseInt(request.getParameter("vnp_TransactionNo"));
                HttpSession session = request.getSession();
                User user= (User) session.getAttribute("user");
                user.setBlance(user.getBlance()+amount);
                Transaction transaction=new Transaction(idTransaction,user.getId(),amount);
                transactionService.insertChapter(transaction);
                userService.updateUser(user);
                session.setAttribute("user",user);
                response.sendRedirect(redirectUrl);
            }
           catch (SQLException e){
                System.out.println(e);
           }
            catch (Exception e){
                System.out.println(e);

            }
        }
        else if(request.getParameter("vnp_TransactionStatus")!=null&&request.getParameter("vnp_TransactionStatus")!="00"){
            String redirectUrl = "/thanh-toan?param1=error";
            response.sendRedirect(redirectUrl);
        }
        else {
            request.getRequestDispatcher("/user/views/payment.jsp").forward(request,response);
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String action = request.getServletPath();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        switch (action){
            case "/thanh-toan":
                Payment(request,response);
                break;
        }
    }
    private void Payment(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException{
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String vnp_OrderInfo = req.getParameter("OrderDescription");
        String orderType = "19000";
        String vnp_TxnRef = Config.getRandomNumber(8);
        String vnp_IpAddr = Config.getIpAddress(req);
        String vnp_TmnCode = Config.vnp_TmnCode;
        int amount =  Integer.parseInt(req.getParameter("amount")) * 100;
        Map vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
        String bank_code = req.getParameter("bankcode");
        if (bank_code != null && !bank_code.isEmpty()) {
            vnp_Params.put("vnp_BankCode", bank_code);
        }
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
        vnp_Params.put("vnp_OrderType", orderType);

        String locate = req.getParameter("language");
        if (locate != null && !locate.isEmpty()) {
            vnp_Params.put("vnp_Locale", locate);
        } else {
            vnp_Params.put("vnp_Locale", "vn");
        }
        vnp_Params.put("vnp_ReturnUrl", Config.vnp_Returnurl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());

        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        //Add Params of 2.1.0 Version
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
        //Billing

        //Build data to hash and querystring
        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(Config.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
        response.sendRedirect(paymentUrl);
//        com.google.gson.JsonObject job = new JsonObject();
//        job.addProperty("code", "00");
//        job.addProperty("message", "success");
//        job.addProperty("data", paymentUrl);
//        Gson gson = new Gson();
//        resp.getWriter().write(gson.toJson(job));
    }

}
