<%--
  Created by IntelliJ IDEA.
  User: Нещерет
  Date: 15.02.2022
  Time: 20:50
  To change this template use File | Settings | File Templates.
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
    <title>createFeedback</title>
</head>
<body>


<c:if test  ="${feedback!=null}">
    Feedback Created
    <td>${feedback.date}</td>
    <td>${feedback.client_id.name}</td>
    <td>${feedback.master_id.name}</td>
    <td>${feedback.rating}</td>
    <td>${feedback.feedback}</td>
    <br/>
</c:if>
<c:if test = "${error!=null}">
   Feedback is not possible.
    <br/>
    ${error}
    <br/>
</c:if>


<form action="/" method="GET">
    <input type="submit" value="back to home"/>
</form>


</body>
</html>
