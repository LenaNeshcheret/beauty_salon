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
    <title>done</title>
</head>
<body>


    <c:if test  ="${record!=null}">
        Record Created
        <td>${record.date}</td>
        <td>${record.client.name}</td>
        <td>${record.client.phone}</td>
        <td>${record.master.name}</td>
        <br/>
    </c:if>
    <c:if test = "${error!=null}">
          Recording is not possible.
        <br/>
        ${error}
        <br/>
    </c:if>


<form action="/" method="GET">
    <input type="submit" value="back to home"/>
</form>


</body>
</html>
