<%--
  Created by IntelliJ IDEA.
  User: jawad
  Date: 12/30/12
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>firstJSP</title>
    <style type="text/css">
        h1 {
            background-color: #b0e0e6;
        }
    </style>
</head>
<body>
<div>
    <c:if test="${not empty error }">
        <c:forEach items="${ error}" var="entry">
            ${entry.value}<br>
        </c:forEach>
    </c:if>

</div>

<h1 align="center">User Registration</h1>

<form method="POST">
    <%--Id:<input name="id" type="text"/><br>--%>
    <table>
        <tr>
            <td>Username:</td>
            <td><input name="userName" type="text"/></td>
        </tr>
        <tr>
            <td>First name:</td>
            <td><input name="firstName" type="text"/></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><input name="lastName" type="text"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input name="email" type="text"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input name="password" type="password"/></td>
        </tr>
        <tr>
            <td>Confirm password:</td>
            <td><input name="confirmPassword" type="password"/></td>
        </tr>
    </table>
    <button type="submit"> Submit</button>
</form>
</body>
</html>