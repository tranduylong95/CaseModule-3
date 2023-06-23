<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/06/2023
  Time: 6:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../layout/head.jsp" />
    <style>
        .timepicker > span{
            font: normal 5.94em/107px "Lato";
            font-weight: 700;
            color: #de4848;
        }
        .timepicker{
            height: auto;
            width: auto;
            margin-right: 5px;
            padding: 5px;
            background-color: #F2F1ED;
            border-radius: 8px;
            display: inline-block;
        }
    </style>
</head>
<body class="sidebar-mini layout-fixed">
    <div class="wrapper">
        <jsp:include page="/admin/view/layout/header.jsp" />
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
                                    <h3 class="card-title">Thêm mới Chapter</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form class="form-horizontal mb-0" action="/admin/comic${pathInfo}"  method="post" >
                                    <div class="card-body">
                                        <div class="form-group row">
                                            <label for="inputEmail3" class="col-sm-2 col-form-label ">Tên Chapter</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="inputEmail3" placeholder="Tên chapter" name="name">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputEmail3" class="col-sm-2 col-form-label ">Lock</label>
                                            <div class="col-sm-6">
                                               <select class="custom-select" name="lock" onchange="showTimePichker(this)">
                                                   <option value="0">Miễn phí</option>
                                                   <option value="1">Khóa</option>
                                               </select>
                                            </div>
                                        </div>
                                        <div class="form-group row" id="time-picker" style="display: none;">
                                            <div class="col-12 row" style="margin-bottom: 16px;">
                                                <label for="inputEmail3" class="col-sm-2 col-form-label ">Giá tiền</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control text-right" placeholder="Giá tiền....." name="price">
                                                </div>
                                            </div>
                                            <div class="col-12 row" style="margin-bottom: 16px;">
                                                 <label for="inputEmail3" class="col-sm-2 col-form-label ">Time Lock</label>
                                                <div class="col-sm-10"  data-toggle="modal" data-target="#exampleModal">
                                                    <div class="row">
                                                        <div class="hour col-sm-4 text-center" id="timelock-hours">
                                                            <h4 >HOURS</h4>
                                                            <div class="timepicker">
                                                                <span>0</span>

                                                            </div>
                                                            <div class="timepicker">
                                                                <span >0</span>
                                                            </div>
                                                            <div class="timepicker">
                                                                <span >1</span>
                                                            </div>
                                                            <input type="text" name="hoursChange" hidden>
                                                        </div>
                                                        <div class="minute col-sm-4 text-center" id="timelock-minutes">
                                                            <h4 >MINUTES</h4>
                                                            <div class="timepicker">
                                                                <span class="">0</span>
                                                            </div>
                                                            <div class="timepicker">
                                                                <span class="">0</span>
                                                            </div>
                                                            <input type="text" name="minutesChange" hidden>
                                                        </div>
                                                        <div class="second col-sm-4 text-center" id="timelock-seconds">
                                                            <h4>SECONDS</h4>
                                                            <div class="timepicker">
                                                                <span class="">0</span>
                                                            </div>
                                                            <div class="timepicker">
                                                                <span class="">0</span>
                                                            </div>
                                                            <input type="text" name="secondsChange" hidden>
                                                        </div>
                                                    </div>
                                                </div>
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
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label ">Hour</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control text-right" max="999" value="0" min="1" name="hours">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label ">Minute</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control text-right" max="59" value="0" min="0" name="minutes">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label ">Second</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control text-right" max="59" value="0" min="0" name="seconds">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="notSaveInputTime()">Close</button>
                    <button type="button" class="btn btn-primary" onclick="saveInputTime()">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
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
function saveInputTime(){
    document.querySelector('input[name="hoursChange"]').value=document.querySelector('input[name="hours"]').value;
    document.querySelector('input[name="minutesChange"]').value=document.querySelector('input[name="minutes"]').value;
    document.querySelector('input[name="secondsChange"]').value=document.querySelector('input[name="seconds"]').value;
    var stringHours=checkLength(document.querySelector('input[name="hours"]').value,1);
    var stringMinutes=checkLength(document.querySelector('input[name="minutes"]').value);
    var stringSeconds=checkLength(document.querySelector('input[name="seconds"]').value);
    document.getElementById("timelock-hours").getElementsByTagName("span")[0].innerHTML=stringHours.charAt(0);
    document.getElementById("timelock-hours").getElementsByTagName("span")[1].innerHTML=stringHours.charAt(1);
    document.getElementById("timelock-hours").getElementsByTagName("span")[2].innerHTML=stringHours.charAt(2);
    document.getElementById("timelock-minutes").getElementsByTagName("span")[0].innerHTML=stringMinutes.charAt(0);
    document.getElementById("timelock-minutes").getElementsByTagName("span")[1].innerHTML=stringMinutes.charAt(1);
    document.getElementById("timelock-seconds").getElementsByTagName("span")[0].innerHTML=stringSeconds.charAt(0);
    document.getElementById("timelock-seconds").getElementsByTagName("span")[1].innerHTML=stringSeconds.charAt(1);

}
function checkLength(input,status){
    if(status==1){
        for (var i=input.length;i<3;i++){
            input="0"+input;
        }
        return input;
    }
    else {
        for (var i=input.length;i<2;i++){
            input="0"+input;
        }
        return input;
    }
}
function notSaveInputTime(){
    var stringHours= document.getElementById("timelock-hours").getElementsByTagName("span")[0].innerText
                    +document.getElementById("timelock-hours").getElementsByTagName("span")[1].innerText
                    +document.getElementById("timelock-hours").getElementsByTagName("span")[2].innerText;
    var stringMinutes   = document.getElementById("timelock-minutes").getElementsByTagName("span")[0].innerText
                        + document.getElementById("timelock-minutes").getElementsByTagName("span")[1].innerText;
    var stringSeconds =  document.getElementById("timelock-seconds").getElementsByTagName("span")[0].innerText
                         +  document.getElementById("timelock-seconds").getElementsByTagName("span")[1].innerText;
    document.querySelector('input[name="hours"]').value=Number(stringHours);
    document.querySelector('input[name="minutes"]').value= Number(stringMinutes);
    document.querySelector('input[name="seconds"]').value= Number(stringSeconds);
}
function showTimePichker(element){
    var lock = element.value;
    if(lock==1)
        document.getElementById("time-picker").style.display="block";
    else
        document.getElementById("time-picker").style.display="none";

}
</script>
