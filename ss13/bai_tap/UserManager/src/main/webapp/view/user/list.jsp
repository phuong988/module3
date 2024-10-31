<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/31/2024
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
</head>
<body>
<h1>DANH SÁCH USER</h1>
<h3>${sessionScope.mess}</h3>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>country</th>
        <th colspan="2">option</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td><a href="/user?action=delete&id=${user.id}" >Delete</a></td>
            <td><a href="/user?action=update&id=${user.id}" >Update</a></td>
        </tr>
    </c:forEach>
</table>

<c:if test="${not empty sessionScope.successMessage}">
    <script>
        toastr.options = {
            timeOut: 3000
        }
        toastr.success('${sessionScope.successMessage}');

    </script>
    <c:remove var="successMessage" scope="session"/>
</c:if>


<a href="/view/user/add.jsp">THÊM USER MỚI</a><br>
<a href="/view/user/searchForm.jsp">TÌM USER THEO ID</a><br>
<a href="http://localhost:8080/user?action=sort">SẮP XẾP USER THEO TÊN</a><br>
<a href="http://localhost:8080/user?action=text-transaction">THÊM VÀ SỬA</a><br>

</body>
</html>
