<%--
  Created by IntelliJ IDEA.
  User: Нещерет
  Date: 02.02.2022
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>done_Delete</title>
</head>
<body>


${resultCancelRecord ? "Record is canceled" : "Record was not canceled"}


<form action="/" method="GET">
    <input type="submit" value="back to home"/>
</form>


</body>
</html>
