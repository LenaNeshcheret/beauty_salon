<!DOCTYPE html>
<html>
    <head>
    <!-- head definitions go here -->
    </head>
    <body>
        <h1>Hello from index html</h1>

        <form action = "client" method = "GET">
            First Name: <input type = "text" name = "first_name">
            <br />
            Phone: <input type = "text" name = "phone" />
            <input type = "submit" value = "Find client" />
        </form>
        <table clas border="3" >
            <tr>
                ${name1}
                <td>record_id</td>
                <td>master</td>
                <td>client</td>
                <td>date</td>
            </tr>
        </table>
<!-- the content goes here -->
    </body>
</html>