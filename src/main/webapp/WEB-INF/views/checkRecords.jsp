<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!-- head definitions go here -->
</head>
<body>

<h1>Welcome to our page Beauty Salon</h1>
<h1> Beauty Salon</h1>
<h1>Schedule of records for the week</h1>

<form action="checkRecords" method="GET">
    Start date: <input type="date" name="start_date" required>
    Start time: <input type="time" name="start_time" min="08:00" max="19:00">
    <br/>
    End date: <input type="date" name="end_date">
    End time: <input type="time" name="end_time" min="09:00" max="20:00">

    <input type="submit" value="Check Records"/>
    <input type="submit" formaction="checkAvailableRecords" value="Show Available Records"/>

</form>



<form action="listMasters" method="GET">
    <input type="submit" value="Show masters"/>
    <select name="sort_order">
        <option value="DESC">Sort by descending rating</option>
        <option value="ASC">Sort by ascending rating</option>
    </select>

</form>

<c:if test="${listMasters!=null}">
    Show masters rating
    <br/>

    <table clas border="2">
        <tr>

            <td>name</td>
            <td>rating</td>

        </tr>
        <c:forEach items="${listMasters}" var="master">
            <tr>
                <td>${master.name}</td>
                <td>${master.rating}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
</c:if>
<!-- the content goes here -->
</body>
</html>