<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp</title>
</head>
<body>


<h1>Hello JSP</h1>

<p>Application Name: <%= config.getInitParameter("app-name") %></p>
</body>
</html>
