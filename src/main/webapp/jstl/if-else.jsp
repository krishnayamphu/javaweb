<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
<c:set var="marks" value="86"/>
<c:choose>
    <c:when test="${marks>=35}">
        <p>Pass</p>
    </c:when>
    <c:otherwise>
        <p>Fail</p>
    </c:otherwise>
</c:choose>
</body>
</html>
