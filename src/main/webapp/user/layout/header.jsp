<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 05/06/2023
  Time: 3:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.utils.StringUtils" %>
<div class="head">
  <div class="container">
    <div class="head-nav">
      <div class="head-nav-logo">
        <img src="https://st.nhattruyenmin.com/data/logos/logo-nhattruyen.png" alt="logo-nhattruyen">
      </div>
      <form action="" style="margin-block-end: 0px">
        <div class="head-nav-search">
          <div class="d-flex">
            <input class="form-control borRbor" width="455px">
            <button class="btn btn-search borRbor"><i class="fa fa-search"></i></button>
          </div>
        </div>
      </form>
      <div class="head-nav-user">
        <c:if test="${sessionScope.user == null}"><div class="nav-user-out">
          <a class="link-item" href="/dang-nhap">Đăng nhập/</a>
          <a class="link-item" href="/dang-ky">Đăng ký</a>
        </div>
        </c:if>
        <c:if test="${ sessionScope.user!=null }">
          <div class="nav-user-in dropdown-toggle" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false" role="button">
          <img src="//st.ntcdntempv3.com/data/siteimages/anonymous.png">
          <span class="user-blance">BLANCE: ${StringUtils.formatVietnameseCurrency(sessionScope.user.getBlance())}đ</span>
          <i class="fa fa-caret-down pdl-10" style="color:#DEDEDE"></i>
        </div>
          <ul class="dropdown-menu pd-0" aria-labelledby="dropdownMenuButton1">
          <li class="pd-0"><a class="dropdown-item" href="#" style="padding-left: 5px">Trang cá nhân</a></li>
          <li class="pd-0"><a class="dropdown-item" href="/thanh-toan" style="padding-left: 5px"><i class="fa fa-money pd-0" style="margin-right: 5px"></i>Nạp tiền</a></li>
          <li class="pd-0"><a class="dropdown-item" href="/dang-xuat" style="padding-left: 5px"><i class="fa fa-sign-out pd-0" style="margin-right: 5px"></i>Logout</a></li>
        </ul>
        </c:if>
      </div>
    </div>
    <button type="button" class=" btn nav-bar-dropdownbtn" data-bs-toggle="collapse" aria-controls="navbarToggle" data-bs-target="#navbarToggle" aria-expanded="false">
      <i class="fa fa-bars"></i>
    </button>
  </div>
</div>
<div class="head-nav-main">
  <div class="container">
    <nav class="navbar navbar-expand-lg navbar-light">
      <div class="collapse navbar-collapse" id="navbarToggle">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/trang-chu"><span class="fa fa-home" style="font-size: 20px;"></span ><span class="d-xl-none d-lg-none d-md-block">TRANG CHỦ</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">HOT</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">THEO DÕI</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              THỂ LOẠI
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown" style="margin: 0px;padding: 0px;  ">
                  <ul class="nav">
                    <li class="active">
                      <a data-title="" href="https://nhattruyenmin.com/the-loai" target="_self">
                        <strong>Tất cả</strong>
                      </a>
                    </li>
                  </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">TÌM TRUYỆN</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">CON TRAI</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">CON GÁI</a>
          </li>
        </ul>
      </div>
    </nav>
  </div>
</div>
