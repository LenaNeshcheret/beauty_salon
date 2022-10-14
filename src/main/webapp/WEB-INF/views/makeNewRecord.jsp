<%--
  Created by IntelliJ IDEA.
  User: Нещерет
  Date: 27.01.2022
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Records</title>
</head>
<body>

<h1>New Records</h1>
        <table clas border="5">
            <tr>

                <td>client_name</td>
                <td>client_phone</td>
                <td>client_email</td>
                <td>client_birthday</td>
                <td>master_name</td>

            </tr>


            <tr>
                <td>${name}</td>
        <td>${phone}</td>
        <td>${email}</td>
        <td>${address}</td>
        <td>${birthday}</td>
        <td>${master.name}</td>

    </tr>
</table>

</body>
</html>
