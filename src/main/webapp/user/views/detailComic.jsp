<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 16/06/2023
  Time: 9:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.utils.DateUtils" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.utils.StringUtils" %>


<html>
<head>
    <jsp:include page="../layout/head.jsp" />
    <style>
    .time-lock{
        margin-left: 5px;
    }
    </style>
</head>

<body>
    <jsp:include page="../layout/header.jsp"/>
    <div class="container">
        <div class="content">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="#">Trang chủ</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a href="#">Thể loại</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a href="#">Đại Quản Gia Là Ma Hoàng</a>
                    </li>
                </ol>
            </nav>
            <div class="content-main">
                <div class="row" style="margin: 0px;">
                    <div class="col-lg-8 pd-0">
                        <div class="content-title text-center">
                            <h5 class="content-title-head">${comic.getName()}</h5>
                            <p>[Cập nhật lúc: ${DateUtils.timeStamptoString(comic.getUpdate_At())}]</p>
                        </div>
                        <div class="row">
                            <div class="col-4 col-img">
                                <img src="${comic.getImage()}">
                            </div>
                            <div class="col-8 col-infor">
                                <table class="table mr-bt-0">
                                    <tbody>
                                    <tr>
                                        <td class="border-0"><i class="fa fa-user"></i> Tác giả</td>
                                        <td class="border-0">Đang cập nhật</td>
                                    </tr>
                                    <tr>
                                        <td class="border-0"><i class="fa fa-rss"></i> Tình Trạng</td>
                                        <td class="border-0">
                                           <c:if test="${comic.getStatus()==1}">Đã Hoàn Thành</c:if>
                                            <c:if test="${comic.getStatus()==0}">Đang tiến hành</c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="border-0"><i class="fa fa-tags"></i> Thể loại</td>
                                        <td class="border-0">
                                            <c:forEach items="${comic.getCategories()}" var="category" varStatus="loop">
                                            <a href="">${category.getName()}</a>
                                            <c:if test="${loop.index+1!=comic.getCategories().size()}">-</c:if>
                                            </c:forEach>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="border-0" ><i class="fa fa-eye"></i> Xem</td>
                                        <td class="border-0">
                                            ${comic.totalView() }
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div class="d-flex" style="align-items: center;">
                                    <div id="rating">
                                        <input type="radio" id="star5" name="rating" value="5"/>
                                        <label class = "full" for="star5" title="Awesome - 5 stars"></label>

                                        <input type="radio" id="star4half" name="rating" value="4 and a half" />
                                        <label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>

                                        <input type="radio" id="star4" name="rating" value="4"  />
                                        <label class = "full" for="star4" title="Pretty good - 4 stars"></label>

                                        <input type="radio" id="star3half" name="rating" value="3 and a half" />
                                        <label class="half" for="star3half" title="Meh - 3.5 stars"></label>

                                        <input type="radio" id="star3" name="rating" value="3"  />
                                        <label class = "full" for="star3" title="Meh - 3 stars"></label>

                                        <input type="radio" id="star2half" name="rating" value="2 and a half" />
                                        <label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>

                                        <input type="radio" id="star2" name="rating" value="2"   />
                                        <label class = "full" for="star2" title="Kinda bad - 2 stars"></label>

                                        <input type="radio" id="star1half" name="rating" value="1 and a half" />
                                        <label class="half" for="star1half" title="Meh - 1.5 stars"></label>

                                        <input type="radio" id="star1" name="rating" value="1" />
                                        <label class = "full" for="star1" title="Sucks big time - 1 star"></label>

                                        <input type="radio" id="starhalf" name="rating" value="half" />
                                        <label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
                                    </div>
                                    <p class="mr-bt-0" style="font-size: 14px;">Xếp hạng: 3.9/5 - 59874 Lượt đánh giá.</p>
                                </div>
                                <div class="col-infor-following">
                                    <button type="button" class="btn color1" style="color: #FFF;"><span class="fa fa-heart"></span> Theo dõi</button>
                                    <span><strong>232.840</strong> Lượt theo dõi</span>
                                </div>
                                <div class="col-infor-chapter">
                                    <button type="button" class="btn color2" style="color: #FFF;" > Đọc từ đầu</button>
                                    <button type="button" class="btn color2" style="color: #FFF;" > Đọc mới nhất</button>
                                </div>
                            </div>
                            <div class="col-12 product-detail">
                                <div class="product-detail-describe">
                                    <div class="product-detail-describe-title">
                                        <span class="fa fa-file-text-o"></span>
                                        <span class="d-inline-block mr-l5" >NỘI DUNG</span>
                                    </div>
                                    <div class="product-detail-describe-content">
                                        <p>
                                            ${comic.getDescribe()}
                                        </p>
                                        <a href="#" style="font-size: 13px;" onclick="" >Xem thêm ></a>
                                    </div>
                                    <div class="product-detail-list-title">
                                        <span class="fa fa-list"></span>
                                        <span class="d-inline-block mr-l5" >DANH SÁCH CHƯƠNG</span>
                                    </div>
                                    <div class="product-detail-list-content">
                                        <table class="table list-chapter-table">
                                            <thead>
                                            <tr>
                                                <td>Số Chương</td>
                                                <td class="text-center">Ngày cập nhập/Lock</td>
                                                <td class="text-center">Xem</td>
                                            </tr>
                                            </thead>
                                            <tbody id="myTableBody">
                                            <c:forEach items="${comic.getChapters()}" var="chapter">
                                            <tr>
                                                <td><a href="/truyen-tranh/${StringUtils.removeVietnameseDiacritics(comic.getName().replaceAll(" ","-").toLowerCase())}-${comic.getId()}/${StringUtils.removeVietnameseDiacritics(chapter.getName().replaceAll(" ","-").toLowerCase())}/${chapter.getId()}" style="color: black;">${chapter.getName()}</a></td>
                                                <td class="text-center">
                                                        ${chapter.parseCreatAt()}
                                                       <c:if test="${chapter.getLock()==0}"><i class="fa fa-unlock"></i><span class="time-lock"></span></c:if>
                                                       <c:if test="${chapter.getLock()==1}">
                                                           <c:choose>
                                                               <c:when test = "${sessionScope.user!=null && sessionScope.user.checkOrder(chapter.getId()) }">
                                                                   <i class="fa fa-unlock"></i>
                                                               </c:when>

                                                               <c:otherwise>
                                                                   <i class="fa fa-lock"></i>
                                                               </c:otherwise>
                                                           </c:choose>

                                                           <span class="time-lock">${DateUtils.ProcessTimeAfter(chapter.getTimeLock())}</span><span class="price" style="font-style: italic">&nbsp${chapter.getPrice()} đ</span>
                                                       </c:if>
                                                </td>
                                                <td class="text-center">${chapter.getView()}</td>
                                            </tr>
                                            </c:forEach>

                                            <tr id="load-add-list" style="display: table-row;">
                                                <td colspan="3"><button class="btn btn-outline-primary" style="width: 100%; font-size: 14px;" onclick="LoadList()"><i class="fa fa-plus"></i>&nbspXem Thêm</button></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4" style="padding-right: 0px;">
                        <div class="content-main-right border-cr mbt-5">
                            <ul class="nav nav-tabs">
                                <li class="nav-item">
                                    <a class="nav-link active-rank" href="#">Top Tháng</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Top Tuần</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Top Tháng</a>
                                </li>
                            </ul>
                            <div class="d-flex" style="padding: 5px; border-top: 1px solid #DEDEDE;">
                                <div class="text-rank">
                                    <span class="text-rank-index pos-1">01</span>
                                </div>
                                <div class="content-main-right-img">
                                    <a href="#" style="width: 55px; height: 45px; overflow: hidden; display: block;">
                                        <img src="https://st.ntcdntempv3.com/data/comics/230/thien-dao-do-thu-quan.jpg" style="width: 100%; transform: translate(-2%, -13%);">
                                    </a>
                                </div>
                                <div class="content-main-right-link">
                                    <p><a href="#">Thiên Đạo Đồ Thư Quán</a></p>
                                    <p>
                                        <a href="#">Chapter 255</a>
                                        <span class="float-r" style="color: #666666;"><i class="fa fa-eye"></i> 25M</span>
                                    </p>
                                </div>
                            </div>
                            <div class="d-flex" style="padding: 5px; border-top: 1px solid #DEDEDE;">
                                <div class="text-rank">
                                    <span class="text-rank-index pos-2">02</span>
                                </div>
                                <div class="content-main-right-img">
                                    <a href="#" style="width: 55px; height: 45px; overflow: hidden; display: block;">
                                        <img src="https://st.ntcdntempv3.com/data/comics/230/thien-dao-do-thu-quan.jpg" style="width: 100%; transform: translate(-2%, -13%);">
                                    </a>
                                </div>
                                <div class="content-main-right-link">
                                    <p><a href="#">Thiên Đạo Đồ Thư Quán</a></p>
                                    <p>
                                        <a href="#">Chapter 255</a>
                                        <span class="float-r" style="color: #666666;"><i class="fa fa-eye"></i> 25M</span>
                                    </p>
                                </div>
                            </div>
                            <div class="d-flex" style="padding: 5px; border-top: 1px solid #DEDEDE;">
                                <div class="text-rank">
                                    <span class="text-rank-index pos-3">03</span>
                                </div>
                                <div class="content-main-right-img">
                                    <a href="#" style="width: 55px; height: 45px; overflow: hidden; display: block;">
                                        <img src="https://st.ntcdntempv3.com/data/comics/230/thien-dao-do-thu-quan.jpg" style="width: 100%; transform: translate(-2%, -13%);">
                                    </a>
                                </div>
                                <div class="content-main-right-link">
                                    <p><a href="#">Thiên Đạo Đồ Thư Quán</a></p>
                                    <p>
                                        <a href="#">Chapter 255</a>
                                        <span class="float-r" style="color: #666666;"><i class="fa fa-eye"></i> 25M</span>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="content-main-right border-cr mbt-5">
                            <p class="content-main-right-title">
                                Top thành viên
                            </p>
                            <div class="d-flex" style="padding: 5px; border-top: 1px solid #DEDEDE;">
                                <div class="text-rank">
                                    <span class="text-rank-index pos-1">01</span>
                                </div>
                                <div class="content-main-right-img">
                                    <a href="#" style="width: 55px; height: 45px; overflow: hidden; display: block;">
                                        <img src="//st.nhattruyenmin.com/data/siteimages/anonymous.png" style="width: 100%; transform: translate(-2%, -13%);">
                                    </a>
                                </div>
                                <div class="content-main-right-link">
                                    <p><a href="#">Trần Duy Long</a></p>
                                    <p>
                                        <a href="#">Chapter 255</a>
                                    </p>
                                </div>
                            </div>
                            <div class="d-flex" style="padding: 5px; border-top: 1px solid #DEDEDE;">
                                <div class="text-rank">
                                    <span class="text-rank-index pos-2">02</span>
                                </div>
                                <div class="content-main-right-img">
                                    <a href="#" style="width: 55px; height: 45px; overflow: hidden; display: block;">
                                        <img src="//st.nhattruyenmin.com/data/siteimages/anonymous.png" style="width: 100%; transform: translate(-2%, -13%);">
                                    </a>
                                </div>
                                <div class="content-main-right-link">
                                    <p><a href="#">Cao Xuân Trường </a></p>
                                    <p>
                                        <a href="#">Chapter 255</a>
                                    </p>
                                </div>
                            </div>
                            <div class="d-flex" style="padding: 5px; border-top: 1px solid #DEDEDE;">
                                <div class="text-rank">
                                    <span class="text-rank-index pos-3">03</span>
                                </div>
                                <div class="content-main-right-img">
                                    <a href="#" style="width: 55px; height: 45px; overflow: hidden; display: block;">
                                        <img src="//st.nhattruyenmin.com/data/siteimages/anonymous.png" style="width: 100%; transform: translate(-2%, -13%);">
                                    </a>
                                </div>
                                <div class="content-main-right-link">
                                    <p><a href="#">Hòa Min Zy</a></p>
                                    <p>
                                        <a href="#">Chapter 255</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../layout/footer.jsp"/>
</body>
<script>
    function calcRate(r) {
        const f = ~~r,//Tương tự Math.floor(r)
            id = 'star' + f + (r % f ? 'half' : '')
        id && (document.getElementById(id).checked = !0)
    }

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
                if(text.nextSibling){
                    text.nextSibling.remove();
                }
                clearInterval(x);
            }
            if((seconds==0&&minutes==0&&hours==0)||timeString.trim()==""){
                text.innerText="";
                text.previousSibling.setAttribute("class", "fa fa-unlock")
                if(text.nextSibling){
                    text.nextSibling.remove();
                }
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
        var span = document.getElementsByClassName('time-lock');
        for (let index = 0; index < span.length; index++) {
            timelock(span[index]);
        }
    });
    function LoadList(){
        var tBody= document.getElementById("myTableBody");
        var row=tBody.getElementsByTagName("tr");
        for (let index = 9; index < row.length; index++) {
            row[index].style.display="table-row";
        }
        document.getElementById("load-add-list").style.display="none";
    }
    const tableRowList=function(){
        var tBody= document.getElementById("myTableBody");
        var row=tBody.getElementsByTagName("tr").length;
        return row;
    }
    if(tableRowList<=10){
        document.getElementById("load-add-list").style.display="none";
    }

</script>
</html>
