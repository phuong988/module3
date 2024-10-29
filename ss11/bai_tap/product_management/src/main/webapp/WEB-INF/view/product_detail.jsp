<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/29/2024
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>
<h2>Product Detail</h2>
<p>ID: ${product.id}</p>
<p>Name: ${product.name}</p>
<p>Manufacturer: ${product.manufacturer}</p>
<p>Price: ${product.price}</p>
<p>Description: ${product.description}</p>
<p>Quantity: ${product.quantity}</p>
<a href="products?action=list">Back to Product List</a>
</body>
</html>
