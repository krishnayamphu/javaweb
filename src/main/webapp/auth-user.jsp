<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    if(username.equals("admin")&& password.equals("a123")){
        session.setAttribute("user",username);
        response.sendRedirect("welcome.jsp");
    }else{
        response.sendRedirect("index.jsp");
    }
%>

</body>
</html>
