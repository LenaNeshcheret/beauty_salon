<%--
  Created by IntelliJ IDEA.
  User: Нещерет
  Date: 20.01.2022
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <h1>makeRecords</h1>
        <table clas border="5">
            <tr>

                <td>date</td>
                <td>client_name</td>
                <td>client_phone</td>
                <td>client_email</td>
                <td>master_name</td>

            </tr>



            <tr>
                <td>${record.date}</td>
                <td>${record.client.name}</td>
                <td>${record.client.phone}</td>
                <td>${record.client.address}</td>
                <td>${record.master.name}</td>

            </tr>
        </table>

</body>
</html>
