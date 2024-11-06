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
<h1>DANH SÁCH</h1>
<table>
    <tr>
        <th>Mã</th>
        <th>Tên người thuê</th>
        <th>Số điện thoại</th>
        <th>Ngày thuê</th>
        <th>Hình thức</th>
        <th>Ghi chú</th>
    </tr>
    <c:forEach var="phongTro" items="${phongTros}">
        <tr>
            <td>${phongTro.maPhongTro}</td>
            <td>${phongTro.tenNguoiThue}</td>
            <td>${phongTro.soDienThoai}</td>
            <td>${phongTro.ngayThue}</td>
            <td>${phongTro.hinhThucThue}</td>
            <td>${phongTro.ghiChu}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>