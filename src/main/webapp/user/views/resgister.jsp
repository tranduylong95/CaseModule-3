<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 16/06/2023
  Time: 8:30 CH
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
                        <form method="post" action="/dang-ky"  style="margin-bottom: 16px;" enctype="multipart/form-data">
                            <h1 class="title-auth">ĐĂNG KÝ TÀI KHOẢN</h1>
                            <div class="mb-3">
                                <label style="font-size: 16px;">Tên Bạn:</label>
                                <input type="text" class="form-control"  placeholder="Mời bạn nhập tên" name="name"  required  value="${requestScope.name}">
                                <div class="error"></div>
                            </div>
                            <div class="mb-3">
                                <label style="font-size: 16px;">Email:</label>
                                <input type="email" class="form-control"  placeholder="Mời bạn nhập email" name="email" required >
                                <div class="error">${requestScope.error}</div>
                            </div>
                            <div class="mb-3">
                                <label style="font-size: 16px;">Mật Khẩu:</label>
                                <input type="password" class="form-control" id="password" name="pwd" required >
                                <div class="error"></div>
                            </div>
                            <div class="mb-3">
                                <label style="font-size: 16px;">Giới tính</label>
                                <select class="form-control" id="exampleFormControlSelect1" name="sex">
                                    <option value="0">Nam</option>
                                    <option value="1">Nữ</option>
                                </select>
                                <div class="error"></div>
                            </div>
                            <div class="mb-3">
                                <label style="font-size: 16px;">Hình ảnh</label>
                                <input type="file" class="form-control"  accept="image/*" name="image">
                                <div class="error"></div>
                            </div>
                            <div class="d-grid gap-2">
                                <button class="btn btn-warning" type="submit">Đăng ký</button>
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
