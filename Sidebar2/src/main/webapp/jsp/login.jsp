<%--
  Created by IntelliJ IDEA.
  User: swagg
  Date: 2021/6/19
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="../login" method="post">
    <label for="username">用户名：</label><input type="text" name="username" id="username">
    <label for="password-label">密码：</label><input type="password" name="password" id="password-label">
    <input type="submit" value="登录">
</form>
</body>
</html>
