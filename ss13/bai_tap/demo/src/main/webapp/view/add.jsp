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
    <title>Add Product</title>
</head>
<body>
<form id="addProduct" action="product?action=add" method="post">
    <h1>Thêm phong trọ</h1>
    <label>Nhập mã phòng trọ:</label>
    <input type="text" name="code" id="code" />
    <label>Nhập tên người thuê </label>
    <input type="text" name="name" placeholder="tên người thuê"><br>
    <label></label>
    <select name="unit">
        <option value="kg">kg</option>
        <option value="Bó">Bó</option>
    </select><br>
    <label>Nhập giá:</label>
    <input type="number" name="price" id="price" min="1000" step="1"
           required title="Giá phải là số nguyên dương và lớn hơn hoặc bằng 1.000 VNĐ."><br>
    <label>Chọn loại sản phẩm</label>
    <select name="categoryId">
        <c:forEach items="${categories}" var="category">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select><br>
    <label>Nhập ngày thu hoạch(năm-tháng-ngày)</label>
    <input type="text" name="harvestDay" placeholder="2024-10-23">
    <button type="submit">Thêm</button>
</form>
</body>
</html>
