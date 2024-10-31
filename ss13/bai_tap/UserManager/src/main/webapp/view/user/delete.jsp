<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/31/2024
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>XÓA USER</h1>
<form action="/user?action=delete" method="post">
    Id: <input type="text" name="id"><br>
    <input type="submit" value="Xóa"><br>
    <a href="/user">Quay lại</a>
</form>
</body>
</html>
