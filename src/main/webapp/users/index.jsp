<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>
<a href="user-create">Create New User</a>
<table border="1px">
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>
                <a href="user-edit?username=${user.username}">edit</a>
                <form action="users" method="post">
                    <input type="hidden" name="username" value="${user.username}">
                    <button>Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
