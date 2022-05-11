<%--
  Created by IntelliJ IDEA.
  User: Нещерет
  Date: 24.01.2022
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AvailableListRecords</title>
</head>
<body>
<table clas border="4">
    <form action="makeNewRecord" method="GET">
        client name: <input type="text" name="clientName">
        client phone: <input type="text" name="clientPhone">
        master name: <input type="text" name="masterName">

        <c:forEach items="${listAvailableRecords}" var="record">
            <tr>
                <td>${record}</td>
                <td>
                    <input type="text" name="date" value="${record}" hidden>
                    <input type="submit" value="Make New Record"/>
                </td>
            </tr>
        </c:forEach>
    </form>
</table>
</body>
</html>
