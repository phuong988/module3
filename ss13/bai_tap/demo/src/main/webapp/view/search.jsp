<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/6/2024
  Time: 8:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search name product</title>
</head>
<body>
<form action="product?action=search" method="post">
    <h1>Tìm kiếm theo tên sản phẩm</h1>
    <label>Nhập tên sản phẩm:</label>
    <input type="text" name="name" placeholder="Rau muống">
    <input type="submit" value="Tìm kiếm">
</form>

<table border="1">
    <tr>
        <th>Stt</th>
        <th>Mã Hàng Hoá</th>
        <th>Tên Hàng Hoá</th>
        <th>Đơn vị tính</th>
        <th>Giá</th>
        <th>Loại hàng hoá</th>
        <th>Ngày thu hoạch</th>
    </tr>
    <c:forEach items="${searchList}" var="product" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${product.code}</td>
            <td>${product.name}</td>
            <td>${product.unit}</td>
            <td>${product.price}</td>
            <td>${product.categoryName}</td>
            <td>${product.harvestDay}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>