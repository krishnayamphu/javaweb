<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp</title>
</head>
<body>
<%
    String email= (String) pageContext.getAttribute("email",PageContext.SESSION_SCOPE);
%>
<p>Email: <%=email%></p>
</body>
</html>
