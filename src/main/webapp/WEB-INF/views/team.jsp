<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <title>Team example</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<h2>HTML Table</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th></th>
    </tr>
    <c:forEach var="list" items="${lists}">
        <tr>
            <td>${list.teamID}</td>
            <td>${list.name}</td>
            <td><a href="/view/${list.teamID}">View</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/edit/${list.teamID}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/delete/${list.teamID}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<form action="/save" method="post">
    <input type="hidden" name="teamID" value=""/>
    Name:<br>
    <input type="text" name="name" autofocus>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>