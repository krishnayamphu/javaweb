<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp</title>
</head>
<body>
<%
    String username=request.getParameter("username");
    //out.print(username);
%>
<p>Username: <%= username %></p>
</body>
</html>
