<%--
  Created by IntelliJ IDEA.
  User: jawad
  Date: 12/31/12
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>LoginPage</title>
</head>
<body>

<h1 align="center" background-color="blue">Login</h1>

<form method="POST">
    <table>
        <tr>
            <td>
                <c:if test="${not empty error}">
                    <c:forEach items="${error}" var="entry">
                        <span style="color: red;">${entry}</span>
                    </c:forEach>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Username:</td>
            <td><input name="userName" type="text"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input name="password" type="password"/></td>
        </tr>

    </table>
    <button name="loginButton" type="submit">Login</button>

</form>
</body>
</html>