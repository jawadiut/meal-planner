<%--
  Created by IntelliJ IDEA.
  User: jawad
  Date: 12/30/12
  Time: 12:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:forEach items="${user}" var="entry">
${entry.key}: ${entry.value}<br>
    <%--<c:out value="${entry}"/>--%>
</c:forEach>
</body>
</html>