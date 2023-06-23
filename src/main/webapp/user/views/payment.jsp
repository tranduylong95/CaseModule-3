<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 17/06/2023
  Time: 4:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../layout/head.jsp" />
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
<div class="container" style="max-width: 1030px;">
    <div class="content">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="#">Trang chủ</a>
                </li>
                <li class="breadcrumb-item">
                    <a href="#">Hot</a>
                </li>
            </ol>
        </nav>
        <div class="content-main">
            <div class="row" style="margin: 0px;">
                <div class="col-lg-6 offset-lg-3">
                    <form method="post" action="/thanh-toan" style="">
                        <div class="logo-payment">
                            <h1 >Nạp tiền qua VNPay</h1>
                            <img src="https://vnpay.vn/assets/images/logo-icon/logo-primary.svg">
                        </div>

                        <div class="mb-3">
                            <label style="font-size: 16px;">Số tiền:</label>
                            <input type="text" class="form-control"  name="amount" style="text-align: right">
                            <div class="error"></div>
                        </div>
                        <div class="mb-3">
                            <label style="font-size: 16px;">Nội dung:</label>
                            <textarea class="form-control" cols="20" id="OrderDescription" name="OrderDescription" rows="2"></textarea>
                            <div class="error"></div>
                        </div>
                        <div class="mb-3">
                            <label style="font-size: 16px;">Nội dung:</label>
                            <select name="bankcode" id="bankcode" class="form-control">
                                <option value="">Không chọn </option>
                                <option value="MBAPP">Ung dung MobileBanking</option>
                                <option value="VNPAYQR">VNPAYQR</option>
                                <option value="VNBANK">LOCAL BANK</option>
                                <option value="IB">INTERNET BANKING</option>
                                <option value="ATM">ATM CARD</option>
                                <option value="INTCARD">INTERNATIONAL CARD</option>
                                <option value="VISA">VISA</option>
                                <option value="MASTERCARD"> MASTERCARD</option>
                                <option value="JCB">JCB</option>
                                <option value="UPI">UPI</option>
                                <option value="VIB">VIB</option>
                                <option value="VIETCAPITALBANK">VIETCAPITALBANK</option>
                                <option value="SCB">Ngan hang SCB</option>
                                <option value="NCB">Ngan hang NCB</option>
                                <option value="SACOMBANK">Ngan hang SacomBank  </option>
                                <option value="EXIMBANK">Ngan hang EximBank </option>
                                <option value="MSBANK">Ngan hang MSBANK </option>
                                <option value="NAMABANK">Ngan hang NamABank </option>
                                <option value="VNMART"> Vi dien tu VnMart</option>
                                <option value="VIETINBANK">Ngan hang Vietinbank  </option>
                                <option value="VIETCOMBANK">Ngan hang VCB </option>
                                <option value="HDBANK">Ngan hang HDBank</option>
                                <option value="DONGABANK">Ngan hang Dong A</option>
                                <option value="TPBANK">Ngân hàng TPBank </option>
                                <option value="OJB">Ngân hàng OceanBank</option>
                                <option value="BIDV">Ngân hàng BIDV </option>
                                <option value="TECHCOMBANK">Ngân hàng Techcombank </option>
                                <option value="VPBANK">Ngan hang VPBank </option>
                                <option value="AGRIBANK">Ngan hang Agribank </option>
                                <option value="MBBANK">Ngan hang MBBank </option>
                                <option value="ACB">Ngan hang ACB </option>
                                <option value="OCB">Ngan hang OCB </option>
                                <option value="IVB">Ngan hang IVB </option>
                                <option value="SHB">Ngan hang SHB </option>
                            </select>
                            <div class="error"></div>
                        </div>
                        <div class="d-grid gap-2">
                            <button class="btn  btn-danger" type="submit">Nạp tiền</button>
                            <button class="btn  btn-danger">Quay về trang chủ</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp"/>
</body>
</html>
