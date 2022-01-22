<!DOCTYPE html>
<html>
    <head>
    <!-- head definitions go here -->
    </head>
    <body>
        <h1>Schedule of records for the week</h1>

        <form action = "checkRecords" method = "GET">
            Start date: <input type = "date" name = "start_date" required>
            Start time: <input type = "time" name = "start_time" min="08:00" max="19:00" required>
            <br />
            End date: <input type = "date" name = "end_date">
            End time: <input type = "time" name = "end_time" min="09:00" max="20:00">

            <input type = "submit" value = "Check Records" />
            <input type = "submit" formaction="checkAvailableRecords" value = "Show Available Records" />
        </form>

<!-- the content goes here -->
    </body>
</html>