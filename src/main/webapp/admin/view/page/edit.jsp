<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14/06/2023
  Time: 4:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../layout/head.jsp" />
</head>

<body class="sidebar-mini layout-fixed">
<div class="wrapper">
    <jsp:include page="../layout/header.jsp" />
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-12">
                        <ol class="breadcrumb float-sm-left">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Comic</a></li>
                            <li class="breadcrumb-item active">Create</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- Left col -->
                    <section class="col-lg-12 connectedSortable">
                        <!-- Custom tabs (Charts with tabs)-->
                        <div class="card card-info">
                            <div class="card-header">
                                <h3 class="card-title">Chỉnh sửa  Page</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form class="form-horizontal mb-0" action="/admin/comic/chapter${pathInfo}" method="post" >
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label  class="col-sm-2 col-form-label ">Tên Truyện Tranh</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control"  placeholder="..Tên Truyện Tranh" name="name" value="${page.getName()}">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label  class="col-sm-2 col-form-label ">Link</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control"  placeholder="..Tên Truyện Tranh" name="link" value="${page.getLink()}">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label  class="col-sm-2 col-form-label ">Chỉ số</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="form-control" placeholder="....Đường dẫn" name="index" max="100" min="0" value="${page.getIndex()}">
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer ">
                                    <div class="d-flex justify-content-end">
                                        <button type="submit" class="btn btn-info mr-2">Cập nhật</button>
                                        <button type="submit" class="btn btn-danger">Hủy bỏ</button>
                                    </div>
                                </div>
                                <!-- /.card-footer -->
                            </form>
                        </div>
                        <!-- /.card -->
                    </section>
                </div>
                <!-- /.row (main row) -->
            </div>
        </section>
    </div>
</div>
</body>
<script src="/admin/resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/admin/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/admin/resources/dist/js/adminlte.min.js"></script>
</html>
