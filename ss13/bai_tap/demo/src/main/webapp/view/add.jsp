<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://boostrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://datatables/css/datatables.bootstrap5.min.css"/>
</head>
<body>
<h2>Thêm mới</h2>
<form action="/phongtro?action=add" method="post">
    <span>tên người thuee</span>
    <input type="text" name="tenNguoiThue" pattern="^[A-Za-z ]{5,50}$"
           minlength="5" maxlength="50" required
           title="Tên người thuê chỉ được chứa chữ cái và khoảng trắng, độ dài từ 5 đến 50 ký tự."><br>
    <span>số điện thoại</span>
    <input type="text" name="soDienThoai" pattern="^\d{10}$"
           maxlength="10" minlength="10" required
           title="Số điện thoại phải chỉ chứa 10 chữ số."><br>
    <span>ngaày thuê</span>
    <input type="text"  name="ngayThue"required><br>
    <span>hình thức</span>
    <select id="hinhThucThue" name="hinhThucThue" required>
        <option value="" disabled selected>Chọn hình thức thanh toán</option>
        <option value="theo_thang">Theo tháng</option>
        <option value="theo_quy">Theo quý</option>
        <option value="theo_nam">Theo năm</option>
    </select><br>
    <span>ghi chú</span>
    <input type="text" name="ghiChu" maxlength="200"  title="Không quá 200 ký tự."><br>
    <button type="submit">Save</button>
</form>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>