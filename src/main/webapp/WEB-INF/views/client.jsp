<!DOCTYPE html>
<html>
    <head>
    <!-- head definitions go here -->
    </head>
    <body>
        <h1>client.jsp</h1>

        <table clas border="5" >
            <tr>
                <td>id</td>
                <td>name</td>
                <td>address</td>
                <td>accumulateCardDiscount</td>
                <td>total money</td>
            </tr>
            <tr>
                <td>${client.id}</td>
                <td>${client.name}</td>
                <td>${client.address}</td>
                <td>${client.discount.accumulateCard}</td>
                <td>${client.totalMany}</td>
            </tr>
        </table>

<!-- the content goes here -->
    </body>
</html>