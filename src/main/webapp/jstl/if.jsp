<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
<c:set var="temp" value="50"/>
<c:if test="${temp>=35}">
    <h1>High Temperature</h1>
</c:if>
</body>
</html>
