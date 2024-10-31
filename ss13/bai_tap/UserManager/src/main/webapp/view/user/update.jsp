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
</head>
<body>
<h1>CẬP  NHẬT USER</h1>
<form action="/user?action=update" method="post">
    <table border="1" >

        <c:if test="${user != null}">
            <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
        </c:if>
        <tr>
            <th>User Name:</th>
            <td>
                <input type="text" name="name"
                       value="<c:out value='${user.name}' />"
                />
            </td>
        </tr>
        <tr>
            <th>User Email:</th>
            <td>
                <input type="text" name="email"
                       value="<c:out value='${user.email}' />"
                />
            </td>
        </tr>
        <tr>
            <th>Country:</th>
            <td>
                <input type="text" name="country"
                       value="<c:out value='${user.country}' />"
                />
            </td>
        </tr>
        <tr>
            <td >
                <input type="submit" value="Save"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
