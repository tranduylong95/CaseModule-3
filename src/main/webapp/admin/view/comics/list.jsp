<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 07/06/2023
  Time: 3:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.utils.StringUtils" %>

<html>
<head>
    <jsp:include page="/admin/view/layout/head.jsp" />
</head>
<body class="sidebar-mini layout-fixed">
<style>
    #example2 tr td {
        padding: 5px;
    }
    #example2 th {
        padding: 5px;
        font-size: 14px;
    }
    .color-red{
        color: red;
    }
    .card-header::after{
        content: none;
    }
</style>
    <div class="wrapper">
        <jsp:include page="/admin/view/layout/header.jsp" />
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
                                <div class="card-header d-flex align-items-center justify-content-between" style="content: none;">
                                    <h3 class="card-title">Danh sách các truyện tranh</h3>
                                    <a class="btn btn-primary" href="/admin/comic/create">Thêm mới</a>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body">
                                    <table id="example2" class="table table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th class="text-center">Tên Truyện Tranh</th>
                                            <th class="text-center" style="width: 90px">Hình ảnh</th>
                                            <th class="text-center" style="width: 200px">Thể loại</th>
                                            <th class="text-center">Theo dõi</th>
                                            <th class="text-center" style="max-width: 40px;"> Số lượt đánh giá </th>
                                            <th class="text-center">Trạng thái</th>
                                            <th class="text-center">Thao Tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${listComic}" var="comic">
                                        <tr id="data-${comic.getId()}">
                                            <td class="text-center align-middle" style="padding: 5px;font-size: 14px;">
                                                <a href="/admin/comic/${StringUtils.removeVietnameseDiacritics(comic.getName().replaceAll(" ","-").toLowerCase())}-${comic.getId()}/chapter">${comic.getName()}</a></td>
                                            <td class="text-center align-middle" ><img src="${comic.getImage()}" style="width:50px; height: 50px;"></td>
                                            <td class="text-center align-middle"  >
                                            <c:forEach items="${comic.getCategoryList()}" var="category">
                                                <span class="badge badge-pill badge-primary" style="margin-bottom: 5px">${category.getName()}</span>
                                            </c:forEach>
                                            </td>
                                            <td class="text-center align-middle">${comic.getFollow()}</td>
                                            <td class="text-center align-middle">${comic.getPoinRank()}</td>
                                            <td class="text-center align-middle">
                                               <c:choose>
                                                   <c:when test="${comic.getStatus()==0}">
                                                       Đang tiến hành
                                                   </c:when>
                                                   <c:otherwise>
                                                       Đã hoàn thành
                                                   </c:otherwise>
                                               </c:choose>
                                            </td>
                                            <td class="text-center align-middle">
                                                <a href="/admin/comic/edit/${comic.getId()}"><i class="far fa-edit"></i></a>
                                                <a  onclick="remove(${comic.getId()})"><i class="fas fa-trash-alt color-red"></i></a>
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
        <jsp:include page="/admin/view/layout/footer.jsp" />
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
<script src="/admin/resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/admin/resources/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="/admin/resources/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="/admin/resources/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="/admin/resources/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="/admin/resources/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
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
       var data= $('#example2').DataTable( {
           "paging": true,
           "lengthChange": false,
           "searching": true,
           "ordering": false,
           "info": true,
           "autoWidth": false,
           "responsive": true,
           "pageLength": 5
       });

   function remove(id){
       data.rows('#data-'+id).remove().draw();
       $.ajax({

           type: "GET",

           url : "/admin/comic/delete/"+id,

           success: function(responseText){

               console.log($('#result').text(responseText));

           }

       });
   }
</script>
</html>
