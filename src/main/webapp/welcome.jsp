<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(session==null){
        response.sendRedirect("index.jsp");
    }else {
        if(session.getAttribute("user")==null){
            response.sendRedirect("index.jsp");
        }
    }
%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome page</h1>

<form action="logout.jsp" method="post">
    <button>Logout</button>
</form>
</body>
</html>
