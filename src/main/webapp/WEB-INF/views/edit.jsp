<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <title>Team example</title>
</head>
<body>
<form action="/save" method="post">
    <input type="hidden" name="teamID" value="${lists.teamID}"/>
    Name:<br>
    <input type="text" name="name" value="${lists.name}">
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>