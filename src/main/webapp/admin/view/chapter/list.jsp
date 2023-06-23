<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/06/2023
  Time: 6:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.utils.DateUtils" %>
<html>
<head>
    <jsp:include page="../layout/head.jsp" />
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
    .time-lock{
        color: #DE4848;
    }
</style>
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
                            <div class="card-header d-flex align-items-center justify-content-between" style="content: none;">
                                <h3 class="card-title">Danh sách các chapter</h3>
                                <a class="btn btn-primary"href="/admin/comic${path}/create">Thêm mới</a>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example2" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th class="text-center">Tên Chapter</th>
                                        <th class="text-center" style="width: 90px">Lượt xem</th>
                                        <th class="text-center" style="width: 200px">Lock</th>
                                        <th class="text-center">Ngày tạo</th>
                                        <th class="text-center">Trạng thái</th>
                                        <th class="text-center">Thao Tác</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listChapter}" var="chapter">
                                    <tr>
                                        <td class="text-center align-middle"><a href="/admin/comic/chapter/${chapter.getId()}/page">${chapter.getName()}</a></td>
                                        <td class="text-center align-middle">${chapter.getView()}</td>
                                        <td class="text-center align-middle">
                                            <c:choose>
                                                <c:when test="${chapter.getLock()==0}">
                                                    <div>
                                                        <i class="fa fa-unlock" style="font-size: 13px"></i>
                                                        <span>Free</span>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                    <div>
                                                        <i class="fa fa-lock" style="font-size: 13px"></i>
                                                        <span>Lock</span>
                                                    </div>
                                                    <div class="time-lock">
                                                        ${DateUtils.ProcessTimeAfter(chapter.getTimeLock())}
                                                    </div>
                                                    <div class="price-lock">
                                                        ${chapter.getPrice()} đ
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="text-center align-middle">
                                            ${DateUtils.timeStamptoString(chapter.getCreateAt())}
                                        </td>
                                        <td class="text-center align-middle">
                                            <c:choose>
                                                <c:when test="${chapter.getShow()==1}">
                                                    Hiển thị
                                                </c:when>
                                                <c:otherwise>
                                                    Không hiển thị
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="text-center align-middle">
                                            <a href="/admin/comic${path}/edit/${chapter.getId()}"><i class="far fa-edit"></i></a>
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
    function timelock(text){
        var x= setInterval(function(){
            timeString = text.innerText;
            var timeParts = timeString.split(":"); // Tách chuỗi thành mảng các phần tử
            var hours = parseInt(timeParts[0]); // Lấy giờ và chuyển thành số nguyên
            var minutes = parseInt(timeParts[1]); // Lấy phút và chuyển thành số nguyên
            var seconds = parseInt(timeParts[2]);
            if((seconds==1&&minutes==0&&hours==0)||timeString.trim()==""){
                text.innerText="";
                text.previousSibling.setAttribute("class", "fa fa-unlock")
                clearInterval(x);
            }
            else {
                if (seconds > 0) {
                    seconds--;
                } else {
                    if (minutes > 0) {
                        minutes--;
                        seconds = 59;
                    } else {
                        if (hours > 0) {
                            hours--;
                            minutes = 59;
                            seconds = 59;
                        }
                    }
                }
                if(seconds<10){
                    seconds="0"+seconds;
                }
                if(minutes<10){
                    minutes="0"+minutes;
                }
                if(hours<10){
                    hours="0"+hours;
                }
                var newTimeString =  hours+ ":" +
                    minutes + ":" +
                    seconds;
                text.innerText=newTimeString;
            }
        },1000);
    }
    document.addEventListener('DOMContentLoaded', function() {
        var div = document.getElementsByClassName('time-lock');
        for (let index = 0; index < div.length; index++) {
            timelock(div[index]);
        }
    });
</script>
</html>
