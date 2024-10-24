<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <style type="text/css">
      .login {
        height: 180px; width: 230px;
        margin: 0;
        padding: 10px;
        border: 1px solid;
      }
      .login input {
        padding:5px;, margin: 5px;
       }
  </style>
  <title>form đăng nhập</title>
</head>
<body>
  <form action="/login" method="post">
    <div class="login">
      <h2>login</h2>
      <input type="text" name="username" size="30" placeholder="username" />
      <input type="password" name="password" size="30" placeholder="password"/>
      <input type="submit" value="Sign in"/>
    </div>
  </form>
</body>
</html>