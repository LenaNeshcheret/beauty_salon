<%--
  Created by IntelliJ IDEA.
  User: Нещерет
  Date: 21.02.2022
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login to beauty salon</title>
</head>
<body>
<form action = "login" method = "post">
    Login: <input type = "text" name = "login" required>
    Passwords: <input type = "text" name = "password" required>
    <input type = "submit" value = "login" />
</form>
</body>
</html>
