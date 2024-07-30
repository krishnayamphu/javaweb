<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp</title>
</head>
<body>
<%
    String user= (String) session.getAttribute("user");
%>

<p>Username: <%= user %></p>
</body>
</html>
