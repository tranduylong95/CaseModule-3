<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15/06/2023
  Time: 9:03 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../layout/head.jsp" />
    <style>
        .card-header::after{
            content: none;
        }
        .color-red{
            color: red;
        }
        .card-body{
            overflow: auto!important;
        }
    </style>
</head>
<body class="sidebar-mini layout-fixed">
<div class="wrapper">
    <jsp:include page="../layout/header.jsp" />
    <div class="content-wrapper">
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-12">
                        <ol class="breadcrumb float-sm-left">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active"><a href="#">Comic</a></li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header d-flex align-items-center justify-content-between" >
                                <h3 class="card-title">Danh sách các Page</h3>
                                <a href="page/create" class="btn btn-primary">Thêm mới</a>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example2" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th class="text-center">Tên page</th>
                                        <th class="text-center" >Link</th>
                                        <th class="text-center" >Chỉ số</th>
                                        <th class="text-center">Thao Tác</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listPage}" var="page">
                                        <tr>
                                            <td class="text-center align-middle">${page.getName()}</td>
                                            <td class="text-center align-middle"><a href="${page.getLink()}" target="_blank">${page.getLink()}</a></td>
                                            <td class="text-center align-middle">
                                                    ${page.getIndex()}
                                            </td>
                                            <td class="text-center align-middle">
                                                <a href="page/edit/${page.getId()}"><i class="far fa-edit"></i></a>
                                                <a><i class="fas fa-trash-alt color-red"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                    <tfoot>

                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                </div>
            </div>
        </section>
    </div>
    <jsp:include page="../layout/footer.jsp" />
</div>
</body>
</html>
<script src="/admin/resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/admin/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/admin/resources/dist/js/adminlte.min.js"></script>
