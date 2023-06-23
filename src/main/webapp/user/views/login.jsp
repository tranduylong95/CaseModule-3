<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 17/06/2023
  Time: 4:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../layout/head.jsp" />
</head>
<body>
    <jsp:include page="../layout/header.jsp"/>
    <div class="container" style="max-width: 1030px;">
        <div class="content">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="#">Trang chủ</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a href="#">Hot</a>
                    </li>
                </ol>
            </nav>
            <div class="content-main">
                <div class="row" style="margin: 0px;">
                    <div class="col-lg-6 offset-lg-3">
                        <form method="post" action="/dang-nhap" style="">
                            <h1 class="title-auth">ĐĂNG NHẬP</h1>
                            <div class="mb-3">
                                <label style="font-size: 16px;">Email:</label>
                                <input type="email" class="form-control"  placeholder="Mời bạn nhập email" name="email">
                                <div class="error"></div>
                            </div>
                            <div class="mb-3">
                                <label style="font-size: 16px;">Mật Khẩu:</label>
                                <input type="password" class="form-control"  placeholder="Mời bạn nhập password" required name="password">
                                <div class="error">${requestScope.error}</div>
                            </div>
                            <div class="mb-3" style="text-align: right;">
                                <a href="#" style="font-size: 13px; margin-right: 10px;">Quên mật khẩu</a>
                                <a href="#" style="font-size: 13px;">Đăng ký mới </a>
                            </div>
                            <div class="d-grid gap-2">
                                <button class="btn  btn-danger" type="submit">Đăng nhập</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../layout/footer.jsp"/>

</body>
</html>
<% if(session.getAttribute("message")!= null){%>
    <script>
        Swal.fire({
            position: 'top-end',
            icon: 'info',
            title: "${sessionScope.message}",
            showConfirmButton: false,
            timer: 1500
        });
    </script>
<%
            session.removeAttribute("message");
 }
%>



