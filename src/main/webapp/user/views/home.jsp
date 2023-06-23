<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 05/06/2023
  Time: 3:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.utils.StringUtils" %>
<!DOCTYPE html>
    <head>
        <jsp:include page="../layout/head.jsp" />
    </head>
    <body>
        <jsp:include page="../layout/header.jsp"/>
        <div class="container">
            <div class="content">
                <div class="content-title"><h5>Truyện đề cử ></h5></div>
                <div class="sildes-show" style="position: relative;">
                    <div class="owl-carousel">
                        <div class="product">
                            <a href="">
                                <img src="//st.nhattruyenmin.com/data/comics/230/thien-dao-do-thu-quan.jpg">
                            </a>
                            <div class="sildes-content">
                                <h3>
                                    <a href="#">
                                        Thiên Đạo Đồ Thư Quán sds sds s sdsd s dsds
                                    </a>
                                </h3>
                                <a href="#" style=" font-size: 12px; color: white;">Chapter 1201</a>
                                <span class="time" style="color: white; display:inline-block;margin-left: 10px;">
                  <i class="fa fa-clock-o">
                  </i> 1 ngày trước
                </span>
                            </div>
                        </div>
                        <div class="product">
                            <a href="">
                                <img src="//st.nhattruyenmin.com/data/comics/230/thien-dao-do-thu-quan.jpg">
                            </a>
                            <div class="sildes-content">
                                <h3>
                                    <a href="#">
                                        Thiên Đạo Đồ Thư Quán sds sds s sdsd s dsds
                                    </a>
                                </h3>
                                <a href="#" style=" font-size: 12px; color: white;">Chapter 1201</a>
                                <span class="time" style="color: white; display:inline-block;margin-left: 10px;">
                  <i class="fa fa-clock-o">
                  </i> 1 ngày trước
                </span>
                            </div>
                        </div>
                        <div class="product">
                            <a href="">
                                <img src="//st.nhattruyenmin.com/data/comics/230/thien-dao-do-thu-quan.jpg">
                            </a>
                            <div class="sildes-content">
                                <h3>
                                    <a href="#">
                                        Thiên Đạo Đồ Thư Quán sds sds s sdsd s dsds
                                    </a>
                                </h3>
                                <a href="#" style=" font-size: 12px; color: white;">Chapter 1201</a>
                                <span class="time" style="color: white; display:inline-block;margin-left: 10px;">
                  <i class="fa fa-clock-o">
                  </i> 1 ngày trước
                </span>
                            </div>
                        </div>
                        <div class="product">
                            <a href="">
                                <img src="//st.nhattruyenmin.com/data/comics/230/thien-dao-do-thu-quan.jpg">
                            </a>
                            <div class="sildes-content">
                                <h3>
                                    <a href="#">
                                        Thiên Đạo Đồ Thư Quán sds sds s sdsd s dsds
                                    </a>
                                </h3>
                                <a href="#" style=" font-size: 12px; color: white;">Chapter 1201</a>
                                <span class="time" style="color: white; display:inline-block;margin-left: 10px;">
                  <i class="fa fa-clock-o">
                  </i> 1 ngày trước
                </span>
                            </div>
                        </div>
                        <div class="product">
                            <a href="">
                                <img src="//st.nhattruyenmin.com/data/comics/230/thien-dao-do-thu-quan.jpg">
                            </a>
                            <div class="sildes-content">
                                <h3>
                                    <a href="#">
                                        Thiên Đạo Đồ Thư Quán sds sds s sdsd s dsds
                                    </a>
                                </h3>
                                <a href="#" style=" font-size: 12px; color: white;">Chapter 1201</a>
                                <span class="time" style="color: white; display:inline-block;margin-left: 10px;">
                  <i class="fa fa-clock-o">
                  </i> 1 ngày trước
                </span>
                            </div>
                        </div>
                        <div class="product">
                            <a href="">
                                <img src="//st.nhattruyenmin.com/data/comics/230/thien-dao-do-thu-quan.jpg">
                            </a>
                            <div class="sildes-content">
                                <h3>
                                    <a href="#">
                                        Thiên Đạo Đồ Thư Quán sds sds s sdsd s dsds
                                    </a>
                                </h3>
                                <a href="#" style=" font-size: 12px; color: white;">Chapter 1201</a>
                                <span class="time" style="color: white; display:inline-block;margin-left: 10px;">
                  <i class="fa fa-clock-o">
                  </i> 1 ngày trước
                </span>
                            </div>
                        </div>
                    </div>
                    <a class="owl-prev sildes-content-ev" href="#" role="presentation">
                        <img  class="img-left" src="https://st.nhattruyenmin.com/Data/Sites/2/skins/comic/images/next_prev.png">
                    </a>
                    <a class="owl-next sildes-content-ev img-right" href="#" role="presentation">
                        <img class="img-right" src="https://st.nhattruyenmin.com/Data/Sites/2/skins/comic/images/next_prev.png">
                    </a>
                </div>
                <div class="content-main">
                    <div class="row" style="margin: 0px;">
                        <div class="col-lg-8 pd-0">
                            <div class="content-title"><h5>Truyện mới cập nhật ></h5></div>
                            <div class="row">
                                <c:forEach items="${listComic}" var="comic">
                                        <div class="product-item col-lg-3 col-md-4 col-4 mbt-5">
                                            <a href="truyen-tranh/${StringUtils.removeVietnameseDiacritics(comic.getName().replaceAll(" ","-").toLowerCase())}-${comic.getId()}">
                                            <div class="product-item-img">
                                                <img src="${comic.getImage()}">
                                                <div class="sildes-content pd-0">
                                                    <span class="view-clearfix">
                                                      <i class="fa fa-eye"></i>
                                                      <span>3.287K</span>
                                                      <i class="fa fa-comment"></i>
                                                      <span>1.173</span>
                                                      <i class="fa fa-heart"></i>
                                                      <span>${comic.getFollow()}</span>
                                                    </span>
                                                </div>
                                                <c:if test="${comic.getHot()==1}">
                                                    <div style="position: absolute; top:0px;right: 5px;">
                                                        <span class="icoin-hot" style="display: inline-block"></span>
                                                    </div>
                                                </c:if>
                                            </div>
                                            <div class="product-item-content">
                                                <h3>
                                                    <a  class="product-item-link" href="truyen-tranh/${StringUtils.removeVietnameseDiacritics(comic.getName().replaceAll(" ","-").toLowerCase())}-${comic.getId()}">
                                                       ${comic.getName()}
                                                    </a>
                                                </h3>
                                                <div class="product-item-content-chapter">
                                                     <c:forEach items="${comic.getChapters()}" var="chapter">
                                                    <div class="product-item-content-chapter-item d-flex">
                                                        <a href="/truyen-tranh/${StringUtils.removeVietnameseDiacritics(comic.getName().replaceAll(" ","-").toLowerCase())}-${comic.getId()}/${StringUtils.removeVietnameseDiacritics(chapter.getName().replaceAll(" ","-").toLowerCase())}/${chapter.getId()}">${chapter.getName()}</a>
                                                        <span><c:if test="${chapter.getLock()==1}">
                                                            <c:choose>
                                                                <c:when test = "${sessionScope.user!=null && sessionScope.user.checkOrder(chapter.getId()) }">
                                                                    <i class="fa fa-unlock" style="margin-left: 5px"></i>
                                                                </c:when>

                                                                <c:otherwise>
                                                                    <i class="fa fa-lock" style="margin-left: 5px"></i>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:if>
                                                                ${chapter.parseCreatAt()}</span>
                                                    </div>
                                                     </c:forEach>
                                                </div>
                                            </div>
                                            </a>
                                        </div>

                                </c:forEach>
                            </div>
                            <nav  class ="mt-10" aria-label="navigation">
                                <ul class="pagination uk-paginationo justify-content-center"   data-uk-pagination="{items:${totalComic}, itemsOnPage:36 ,currentPage:${page-1}}">

<%--                                    <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--                                    <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
<%--                                    <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--                                    <li class="page-item">--%>
<%--                                        <a class="page-link" href="#">></a>--%>
<%--                                    </li>--%>
                                </ul>
                            </nav>
                        </div>
                        <div class="col-lg-4" style="padding-right: 0px;">
                            <div class="content-main-right border-cr mbt-5">
                                <p class="content-main-right-title">
                                    Truyện đang theo dõi
                                    <a  class="float-r" href="#">Xem tất cả</a>
                                </p>
                                <div>
                                    <div class="d-flex" style="padding: 5px; border-top: 1px solid #DEDEDE;">
                                        <div class="content-main-right-img">
                                            <a href="#" style="width: 70px; height: 60px; overflow: hidden; display: block;">
                                                <img src="https://st.ntcdntempv3.com/data/comics/230/thien-dao-do-thu-quan.jpg" style="width: 100%; transform: translate(-2%, -13%);">
                                            </a>
                                        </div>
                                        <div class="content-main-right-link">
                                            <p><a href="#">Thiên Đạo Đồ Thư Quán</a></p>
                                            <p>
                                                <a href="#">Chapter 255</a>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="content-main-right border-cr mbt-5">
                                <p class="content-main-right-title">
                                    Lịch sử đọc truyện
                                </p>
                                <div class="d-flex" style="padding: 5px; border-top: 1px solid #DEDEDE;">
                                    <div class="content-main-right-img">
                                        <a href="#" style="width: 70px; height: 60px; overflow: hidden; display: block;">
                                            <img src="https://st.ntcdntempv3.com/data/comics/230/thien-dao-do-thu-quan.jpg" style="width: 100%; transform: translate(-2%, -13%);">
                                        </a>
                                    </div>
                                    <div class="content-main-right-link">
                                        <p><a href="#">Thiên Đạo Đồ Thư Quán</a></p>
                                        <p>
                                            <a href="#">Chapter 255</a>
                                            <a class="float-r" href="#">
                                                <i class="fa fa-times"></i>
                                                Xóa
                                            </a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="content-main-right border-cr mbt-5">
                                <ul class="nav nav-tabs">
                                    <li class="nav-item" style="width: auto;">
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.2/js/uikit.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.2/js/components/pagination.js"></script>
<script>
    var owl= $('.owl-carousel').owlCarousel({
        loop:true,
        margin:10,
        responsiveClass:true,
        responsive:{
            0:{
                items:2,
                nav:true
            },
            600:{
                items:3,
                nav:true
            },
            1000:{
                items:5,
                nav:true,
                loop:false
            }
        },
    });
    $('.owl-next').click(function() {
        owl.trigger('next.owl.carousel',[400]);
    });
    $('.owl-prev').click(function() {
        owl.trigger('prev.owl.carousel',[400]);
    });
    // owl.on('changed.owl.carousel', function(e) {
    //   var currentIndex = owl.owlCarousel('current');
    //   var slideCount = owl.owlCarousel('items').length;
    //   console.log(currentIndex);

    //   if (currentIndex === slideCount - 1) {
    //     owl.trigger('to.owl.carousel', [0, 300]);
    //   }

    // });
    // $('.owl-stage-outer').load("load",function(){
    //   owl.trigger('play.owl.autoplay',[3000, 1000]);
    // });

    let x=document.getElementsByClassName("owl-nav")[0];
    x.style.display = "none";
    var element = document.querySelector('.uk-pagination');
    $(document).ready(function() {
        $('select.uk-pagination').off();
    });
    $('[data-uk-pagination]').on('select.uk.pagination', function(e, pageIndex){
        var currentPage = pageIndex + 1;
        window.location.href = "/trang-chu?page="+(pageIndex+1);
    });


</script>
</html>

