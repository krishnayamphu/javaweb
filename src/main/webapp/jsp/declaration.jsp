<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp</title>
</head>
<body>
<%!
 int getSquareValue(){
     return 5*5;
 }
%>

<p>Output: <%=getSquareValue()%></p>
</body>
</html>
