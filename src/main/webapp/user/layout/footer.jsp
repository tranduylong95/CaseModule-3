<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 05/06/2023
  Time: 3:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="param1" value="${param.param1}" />
<%--// param là chỉ ẩn danh của tham so --%>
<div class="footer">
    <div class="container pd-10" style="max-width: 1030px;">
        <div><img src="//st.nhattruyenmin.com/data/logos/logo-nhattruyen.png"></div>
        <div class="footer-content">
            <p class="mr-bt-0">Liên hệ bản quyền</p>
            <p class="mr-bt-0">Copyright © 2022 NhatTruyen   </p>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script>

<c:if test="${param1=='success'}">Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Thanh toán thành công',
        showConfirmButton: false,
        timer: 1500
    })
</c:if>
<c:if test="${param1=='error'}">
Swal.fire({
    position: 'top-end',
    icon: 'error',
    title: 'Thanh toán không thành công',
    showConfirmButton: false,
    timer: 1500
})
</c:if>
</script>


