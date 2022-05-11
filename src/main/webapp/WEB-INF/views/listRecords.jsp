<%--<!DOCTYPE html>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- head definitions go here -->
</head>
<body>
<h1>Show busy records </h1>

<table clas border="2">
    <tr>

        <td>date</td>
        <td>client_name</td>
        <td>client_phone</td>
        <td>client_address</td>
        <td>master_name</td>
        <td>delete_records</td>
        <td>leave feed back</td>

    </tr>
    <br/>
    <c:forEach items="${listRecords}" var="record">
        <tr>
            <td>${record.date}</td>
            <td>${record.client.name}</td>
            <td>${record.client.phone}</td>
            <td>${record.client.address}</td>
            <td>${record.master.name}</td>
            <td>
                <form action="/cancelRecord" method="GET">
                    <input type="text" name="record_id" value="${record.id}" hidden>
                    <input type="submit" value="Delete Record"/>
                </form>
            </td>
            <td>
                <form action="/createFeedback" method="GET">
                    Rating: <input type = "number" name = "rating" required>
                    Feedback: <input type = "text" name = "feedback">
                    <input type="text" name="record_id" value="${record.id}" hidden>
                    <input type="submit" value="Submit feedback"/>
                </form>
            </td>
        </tr>
        <br/>
        </tr>
        <br/>
    </c:forEach>
</table>
<!-- the content goes here -->
</body>
</html>