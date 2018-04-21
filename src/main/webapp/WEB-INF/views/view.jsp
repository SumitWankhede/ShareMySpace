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
<h2>HTML Table View</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>
        <tr>
            <td>${lists.teamID}</td>
            <td>${lists.name}</td>
        </tr>
</table>
<a href="/team">back</a>
</body>
</html>