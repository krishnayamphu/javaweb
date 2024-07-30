<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>User Edit</title>
</head>
<body>
<form action="user-edit" method="post">
  <input type="hidden" name="old_name" value="${user.username}" >
  <input type="text" name="username" placeholder="Enter username" value="${user.username}" required>
  <br><br>
  <input type="password" name="password" placeholder="Enter password" value="${user.password}" required>
  <br><br>
  <button type="submit">Update User</button>
</form>
</body>
</html>
