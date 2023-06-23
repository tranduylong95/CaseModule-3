
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 19/06/2023
  Time: 1:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.utils.DateUtils" %>
<%@ page import="com.example.utils.StringUtils" %>
<html>
    <head>
        <jsp:include page="../layout/head.jsp" />
    </head>
    <body style="background-color: #111111;">
        <jsp:include page="../layout/header.jsp"/>
        <div class="container" style="max-width: 1030px;">
            <div class="content-head" style="background-color: #FFFFFF; padding: 10px;">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb" style="margin-bottom: 10px;">
                        <li class="breadcrumb-item">
                            <a href="#">Trang chủ</a>
                        </li>
                        <li class="breadcrumb-item">
                            <a href="#">Hot</a>
                        </li>
                    </ol>
                    <h1 class="txt-note">
                        <a href="#">${comic.getName()} </a>- ${chapter.getName()}
                    </h1>
                    <i>[Cập nhật lúc: ${DateUtils.timeStamptoString(chapter.getUpdateAt())}]</i>
                </nav>
                <div class="alert alert-infor text-center" role="alert" id="ct1">
                    <i class="fa fa-info-circle"></i>
                    <em>Sử dụng mũi tên trái (←) hoặc phải (→) để chuyển chapter</em>
                </div>
                <div class="chapter-nav" id="ct-navdef">
                    <a class="home" href="/" title="Trang chủ"><i class="fa fa-home"></i></a>
                    <a class="home backward" href="https://nhattruyenmin.com/truyen-tranh/quay-ve-qua-khu-mo-tiem-banh-keo-68506#nt_listchapter" title="Quay Về Quá Khứ Mở Tiệm Bánh Kẹo"><i class="fa fa-list"></i></a>
                    <a class="home changeserver" href="#" title="Đổi server"><i class="fa fa-undo error"></i><span style="position: absolute;font-size: 15px;font-weight: 700;top: 7px;left: 11px;">1</span></a>
                    <a href="<c:if test="${indexNext!=-1}">/truyen-tranh/${StringUtils.removeVietnameseDiacritics(comic.getName().replaceAll(" ","-").toLowerCase())}-${comic.getId()}/${StringUtils.removeVietnameseDiacritics(comicSort.getChapters().get(indexNext).getName().replaceAll(" ","-").toLowerCase())}/${comicSort.getChapters().get(indexNext).getId()}</c:if>" class="a_button prve         <c:if test="${indexNext==-1}">disabled</c:if>"><i class="fa fa-chevron-left"></i></a>
                    <select name="ctl00$mainContent$ddlS  electChapter" id="ctl00_mainContent_ddlSelectChapter" class="form-control d-inline-block" style="width: 25%;" onchange="goToPage(this)">
                        <c:forEach items="${comic.getChapters()}"  var="chapter1">
                        <option value="/truyen-tranh/${StringUtils.removeVietnameseDiacritics(comic.getName().replaceAll(" ","-").toLowerCase())}-${comic.getId()}/${StringUtils.removeVietnameseDiacritics(chapter1.getName().replaceAll(" ","-").toLowerCase())}/${chapter1.getId()}" <c:if test="${chapter1.getId()==chapter.getId()}">selected</c:if>>${chapter1.getName()}</option>
                        </c:forEach>
                    </select>
                    <a href="<c:if test="${indexPrev!=-1}">/truyen-tranh/${StringUtils.removeVietnameseDiacritics(comic.getName().replaceAll(" ","-").toLowerCase())}-${comic.getId()}/${StringUtils.removeVietnameseDiacritics(comicSort.getChapters().get(indexPrev).getName().replaceAll(" ","-").toLowerCase())}/${comicSort.getChapters().get(indexPrev).getId()}</c:if>" class="a_button next <c:if test="${indexPrev==-1}">disabled</c:if>"> <i class="fa fa-chevron-right"></i></a>
                    <a class="follow-link btn btn-success" href="javascript:void(0)" data-id="68506"><i class="fa fa-heart"></i> <span>Theo dõi</span></a>
                </div>
            </div>
            <div class="content-main">
                <div class="page_break text-center">
                    <img src="https://img.truyentranhfull.net/vo-luyen-dinh-phong/chapter-1/001.jpg" >
                </div>
                <c:forEach items="${listPage}" var="page">
                    <div class="page_break text-center">
                        <img src="${page.getLink()}" style="width: 100%;">
                    </div>
                </c:forEach>
                <div class="page_break text-center">
                    <img src="https://tctruyen.com/upload/tctruyen-2.jpg" style="width: 100%;">
                </div>
            </div>
        </div>
        <jsp:include page="../layout/footer.jsp"/>
    </body>
    <script>
        window.addEventListener('scroll', function() {
            var element = document.getElementById('ct1');
            var bounding = element.getBoundingClientRect();
            var element1 = document.getElementById('ct-navdef');

            // Kiểm tra xem phần tử có trong tầm nhìn hay không
            if (
                bounding.top >= 0 &&
                bounding.left >= 0 &&
                bounding.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
                bounding.right <= (window.innerWidth || document.documentElement.clientWidth)
            ) {
                // Phần tử đang trong tầm nhìn
                element1.classList.remove('change');
            } else {
                // Phần tử không trong tầm nhìn
                element1.classList.add('change');
            }
        });
        function goToPage(selectElement){
            var selectedValue = selectElement.value;
            if (selectedValue !== '') {
                window.location.href = selectedValue;
            }
        }
    </script>
</html>
