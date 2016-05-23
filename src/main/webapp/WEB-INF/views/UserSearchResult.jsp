<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UserSearchResult</title>
</head>
<body>
<div align="center">
    <h1>Users List By Age</h1>

    <table border="1">
        <th>No</th>
        <th>Username</th>
        <th>Age</th>
        <th>IsAdmin</th>
        <th>CreatedDate</th>

        <c:forEach var="user" items="${userList}" varStatus="status">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.isisAdmin}</td>
                <td>${user.createDate}</td>

            </tr>
        </c:forEach>
    </table>
</div>
<div align="center">
    <br>
    <br>
    <a href="/">Return to the Full List of Users</a>
</div>
</body>
</html>