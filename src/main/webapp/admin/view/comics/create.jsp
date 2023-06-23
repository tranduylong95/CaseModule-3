<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 06/06/2023
  Time: 8:15 CH
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
        <!-- /.content-header -->
        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- Left col -->
                    <section class="col-lg-12 connectedSortable">
                        <!-- Custom tabs (Charts with tabs)-->
                        <div class="card card-info">
                            <div class="card-header">
                                <h3 class="card-title">Thêm mới truyện tranh</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form class="form-horizontal mb-0" action="/admin/comic/create" method="post" enctype="multipart/form-data">
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label for="inputEmail3" class="col-sm-2 col-form-label ">Tên Truyện Tranh</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputEmail3" placeholder="..Tên Truyện Tranh" name="name">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label  class="col-sm-2 col-form-label">Hình Ảnh</label>
                                        <div class="col-sm-10">
                                                <div class="col-sm-10 p-0" style="margin-bottom: 10px" >
                                                    <img src="/admin/resources/image/images.png" style="max-width: 250px;min-height: 375px;"  id="blah" >
                                                </div>
                                            <input type="file" accept="image/*"  id="imgInp" name="image">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputEmail3" class="col-sm-2 col-form-label ">Nội dung</label>
                                        <div class="col-sm-10">
                                           <textarea id="summernote" name="describe">
                                          </textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row align-items-center">
                                        <label for="inputEmail3" class="col-2 col-form-label ">Hot</label>
                                        <div class="clearfix col-10 ">
                                            <div class="icheck-primary d-inline">
                                                <input type="checkbox" id="checkboxPrimary1" checked name="hot" value="1">
                                                <label for="checkboxPrimary1">
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row align-items-center">
                                        <label for="inputEmail3" class="col-2 col-form-label ">Giới tính</label>
                                        <div class="col-10">
                                            <div class="icheck-primary d-inline" >
                                                <input type="radio" id="radioPrimary1" name="sex" value="1" >
                                                <label for="radioPrimary1">
                                                    Nam
                                                </label>
                                            </div>
                                            <div class="icheck-primary d-inline" style="margin-left: 5px">
                                                <input type="radio" id="radioPrimary2" name="sex" value="2">
                                                <label for="radioPrimary2">
                                                    Nữ
                                                </label>
                                            </div >
                                            <div class="icheck-primary d-inline" style="margin-left: 5px">
                                                <input type="radio" id="radioPrimary3" name="sex" checked value="0">
                                                <label for="radioPrimary3">
                                                    Tất cả
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label  class="col-sm-2 col-form-label">Thể loại</label>
                                        <div class="col-sm-10">
                                            <select class="duallistbox" multiple="multiple" name="categories">
                                                <c:forEach items="${listCategory}" var="category">
                                                    <option value="${category.id}">${category.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row align-items-center">
                                        <label for="inputEmail3" class="col-2 col-form-label ">Tiến trình</label>
                                        <div class="col-10">
                                            <div class="icheck-primary d-inline" >
                                                <input type="radio" id="radioPrimary5" name="status" checked value="0">
                                                <label for="radioPrimary5">
                                                    Đang tiến hành
                                                </label>
                                            </div>
                                            <div class="icheck-primary d-inline" style="margin-left: 5px">
                                                <input type="radio" id="radioPrimary6" name="status" value="1">
                                                <label for="radioPrimary6">
                                                    Đã hoàn thành
                                                </label>
                                            </div >
                                        </div>
                                    </div>
                                    <div class="form-group row align-items-center">
                                        <label for="inputEmail3" class="col-2 col-form-label ">Trạng thái</label>
                                        <div class="col-10">
                                            <div class="icheck-primary d-inline" >
                                                <input type="radio" id="radioPrimary7" name="show" value="1">
                                                <label for="radioPrimary7">
                                                    Hiển thị
                                                </label>
                                            </div>
                                            <div class="icheck-primary d-inline" style="margin-left: 5px">
                                                <input type="radio" id="radioPrimary8" name="show" value="0" checked>
                                                <label for="radioPrimary8">
                                                    Không hiển thị
                                                </label>
                                            </div >
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer ">
                                    <div class="d-flex justify-content-end">
                                        <button type="submit" class="btn btn-info mr-2">Thêm mới</button>
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
        <!-- /.content -->
        <jsp:include page="../layout/footer.jsp" />
    </div>
</div>
</body>
<script src="/admin/resources/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="/admin/resources/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<!-- Bootstrap 4 -->
<script src="/admin/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="/admin/resources/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="/admin/resources/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="/admin/resources/plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="/admin/resources/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="/admin/resources/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="/admin/resources/plugins/moment/moment.min.js"></script>
<script src="/admin/resources/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="/admin/resources/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="/admin/resources/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="/admin/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="/admin/resources/dist/js/adminlte.js"></script>

<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/admin/resources/dist/js/pages/dashboard.js"></script>
<script src="/admin/resources/plugins/summernote/summernote-bs4.min.js"></script>
<script src="/admin/resources/plugins/codemirror/codemirror.js"></script>
<script src="/admin/resources/plugins/codemirror/mode/css/css.js"></script>
<script src="/admin/resources/plugins/codemirror/mode/xml/xml.js"></script>
<script src="/admin/resources/plugins/codemirror/mode/htmlmixed/htmlmixed.js"></script>
<script src="/admin/resources/plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button)
    $(function () {
        // Summernote
        $('#summernote').summernote()

        // CodeMirror
        CodeMirror.fromTextArea(document.getElementById("codeMirrorDemo"), {
            mode: "htmlmixed",
            theme: "monokai"
        });
    })

    $('.duallistbox').bootstrapDualListbox({
        nonSelectedListLabel: 'Tất cả thể loại',
        selectedListLabel: 'Thể loại được chọn',
        preserveSelectionOnMove: 'moved',
        moveOnSelect: false,
        nonSelectedFilter: '',
        infoText:'',
        filterPlaceHolder:'Tìm kiếm tên danh mục....',
    });
    imgInp.onchange = evt => {
        const [file] = imgInp.files
        if (file) {
            blah.src = URL.createObjectURL(file)
        }
    }
</script>
</html>
