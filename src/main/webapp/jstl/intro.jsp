<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>JSTL</title>
</head>
<body>
<c:out value="${'welcome to jstl'}"/>
<%
//    int age=20;
//    out.print(age);
%>

<c:set var="age" value="20" scope="request"/>
<p>${age}</p>



</body>
</html>
