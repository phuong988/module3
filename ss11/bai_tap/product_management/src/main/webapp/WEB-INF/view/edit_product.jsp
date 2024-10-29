<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/29/2024
  Time: 8:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h2>Product List</h2>
<a href="products?action=add">Add New Product</a><br>
<form action="products" method="get">
    <input type="text" name="name" placeholder="Search by name">
    <input type="hidden" name="action" value="search">
    <input type="submit" value="Search">
</form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Manufacturer</th>
        <th>Price</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.manufacturer}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.quantity}</td>
            <td>
                <a href="products?action=edit&id=${product.id}">Edit</a>
                <a href="products?action=delete&id=${product.id}">Delete</a>
                <a href="products?action=detail&id=${product.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
