
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp</title>
</head>
<body>

<%
  pageContext.setAttribute("email","test@email.com",PageContext.SESSION_SCOPE);
%>

<p>email value set successfully.</p>

</body>
</html>
