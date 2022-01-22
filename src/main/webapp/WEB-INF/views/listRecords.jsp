<%--<!DOCTYPE html>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- head definitions go here -->
</head>
<body>
<h1>Show available of records </h1>
<table clas border="2" >
        <tr>

            <td>date</td>
            <td>client_name</td>
            <td>client_phone</td>
            <td>client_address</td>
            <td>master_name</td>

        </tr>
<br />
<c:forEach items="${listRecords}" var="record">
    <tr>
        <td>${record.date}</td>
        <td>${record.client.name}</td>
        <td>${record.client.phone}</td>
        <td>${record.client.address}</td>
        <td>${record.master.name}</td>
    </tr>
    <br />
</c:forEach>
<!-- the content goes here -->
</body>
</html>