<%--
  Created by IntelliJ IDEA.
  User: jawad
  Date: 1/2/13
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MealPlan</title>
    <style type="text/css">
        table.MealTable {
            table-layout: fixed;
            width: 900px;
            empty-cells: show;

        }

        td.MealCell {
            width: 300px;
            border-color: blue;
        }

        th {
            width: 300px;
        }

        label {
            width: 100px;
            display: block;
            float: left;
            padding-left: 10px;
            /*text-align: left;*/
        }

        select {
            display: block;
            /*padding-top: 10px;*/
            /*margin-bottom: 10px;*/
        }
    </style>
    <script type="text/javascript">
        function changeTable2(tablecell) {
            tablecell.innerHTML = "<input type='text' class='inputtext'  name='textfield2' style='height: 150px; width: 280px; display: block;' onblur='submitNewName(this)' value='" + tablecell.innerHTML + "'>"
            //document.getElementById("mtable").innerHTML
            tablecell.firstChild.focus();
        }
        function submitNewName(textfield) {

            document.getElementById("h").value = textfield.value;
            textfield.parentNode.innerHTML = textfield.value;
        }

        function changeTable(tablecell) {
            tablecell.innerHTML = "<textarea name='textfield' rows=\"5\" cols=\"120\" onblur='submitNewName(this)' onclick='submitNewName(this)'>" + tablecell.innerHTML + "</textarea>";
            tablecell.firstChild.focus();
        }
        function keyPressed(e) {
            var key;
            if (window.event)
                key = window.event.keyCode;
            else
                key = e.which;

            return (key != 13);
        }
        function isSelected(meals) {
            if (meals == "breakfast") {
                document.getElementById("ltable").innerHTML =
                        "<table id=\"mtable\" border=\"1\" cellpadding=\"20px\" align=\"center\" class=\"MealTable\" ><tr><th>Breakfast</th></tr><tr><td class=\"MealCell\" height=\"150px\" ondblclick=\"changeTable(this)\"></td></tr></table>";

            }
            else if (meals == "lunch") {
                document.getElementById("ltable").innerHTML =
                        "<table id=\"mtable\" border=\"1\" cellpadding=\"20px\" align=\"center\" class=\"MealTable\" ><tr><th>Lunch</th></tr><tr><td class=\"MealCell\" height=\"150px\" ondblclick=\"changeTable(this)\"></td></tr></table>";
            }
            else if (meals == "dinner") {
                document.getElementById("ltable").innerHTML =
                        "<table id=\"mtable\" border=\"1\" cellpadding=\"20px\" align=\"center\" class=\"MealTable\" ><tr><th>Dinner</th></tr><tr><td class=\"MealCell\" height=\"150px\" ondblclick=\"changeTable(this)\"></td></tr></table>";
            }
            else if (meals == "all") {
                document.getElementById("ltable").innerHTML =
                        "<table id=\"mtable\" border=\"1\" cellpadding=\"20px\" align=\"center\" class=\"MealTable\"><tr><th>Breakfast</th><th>Lunch</th><th>Dinner</th></tr><tr><td class=\"MealCell\" height=\"150px\"></td><td class=\"MealCell\" height=\"150px\"></td><td class=\"MealCell\" height=\"150px\"></td></tr></table>"


            }

        }
        function Alert() {

            alert("loading...");
        }

    </script>

</head>
<body style="background-color:aqua;" onkeypress="return keyPressed(event)">
<p style="float: right;background-color: #87cefa;">
    <a href="/logout" style="text-decoration:none;color: blue;">Logout</a>
</p>

<h1 align="center" style="color: RED;">Meal Menu</h1>

<form name="f1" method="POST" action="mealplan">
    <%--<div>--%>

    <div>
        <div>
            <label>Meal Type:</label>
            <c:choose>
                <c:when test="${not empty combo}">
                    <select name="cmb" id="mt" onchange="isSelected(this.value)">

                        <option value="lunch" <c:if test="${combo==\"lunch\"}">selected="selected" </c:if>>lunch</option>
                        <option value="breakfast" <c:if test="${combo==\"breakfast\"}">selected="selected" </c:if>>breakfast</option>

                        <option value="dinner" <c:if test="${combo==\"dinner\"}">selected="selected" </c:if>>dinner</option>

                    </select>
                </c:when>
                <c:otherwise>

                    <select name="cmb" id="mt" onchange="isSelected(this.value)">

                        <option value="lunch">lunch</option>
                        <option value="breakfast">breakfast</option>

                        <option value="dinner">dinner</option>

                    </select>
                </c:otherwise>
            </c:choose>

        </div>
        <br>

        <div>
            <label>
                Date:
            </label>
            <c:if test="${not empty mealDate}">
                <c:forEach items="${mealDate}">
                    ${mealDate}
                </c:forEach>
            </c:if>
        </div>
    </div>
    <br>
    <br>


    <%--All table--%>
    <%--<table id="mtable" border="1" cellpadding="20px" align="center" class="MealTable">--%>
    <%--<tr>--%>
    <%--<th>Breakfast</th>--%>
    <%--<th>Lunch</th>--%>
    <%--<th>Dinner</th>--%>
    <%--</tr>--%>
    <%--<tr>--%>

    <%--<td class="MealCell" height="150px"></td>--%>
    <%--<td class="MealCell" height="150px"></td>--%>
    <%--<td class="MealCell" height="150px"></td>--%>
    <%--</tr>--%>
    <%--</table>--%>

    <%--Breakfast table--%>


    <%--Lunch table--%>
    <c:if test="${Isadmin==1}">
        <table id="ltable" border="1" cellpadding="20px" align="center" class="MealTable">
            <tr>
                <th>Lunch</th>
            </tr>
            <tr>

                <td class="MealCell" height="150px" ondblclick="changeTable(this)"></td>

            </tr>
        </table>

        <input name="hide" id="h" type="hidden" value="0"/>
    </c:if>
    <c:if test="${not empty mealItem}">
        <c:forEach items="${mealItem}" varStatus="loop">
            <table id="lctable" border="1" cellpadding="20px" align="center" class="MealTable">
                <tr>
                    <th>${mealType[loop.index]}</th>
                </tr>
                <tr>

                    <td class="MealCell" height="150px">${mealItem[loop.index]}</td>

                </tr>
            </table>
        </c:forEach>
    </c:if>
    <%--&lt;%&ndash;dinner table&ndash;%&gt;--%>
    <%--<table id="mtable" border="1" cellpadding="20px" align="center" class="MealTable">--%>
    <%--<tr>--%>
    <%--<th>Dinner</th>--%>
    <%--</tr>--%>
    <%--<tr>--%>

    <%--<td class="MealCell" height="150px" ondblclick="changeTable(this)"></td>--%>

    <%--</tr>--%>
    <%--</table>--%>
    <%--</div>--%>
    <br>
    <br>
    <c:if test="${Isadmin==1}">

        <button name="submit" type="submit" value="menuchange">Change Menu</button>
    </c:if>
    <br>
    <br>
    <%--</form>--%>

    <%--<form METHOD="POST" action="mealplan">--%>
    <c:if test="${not empty comments}">
        <c:forEach items="${comments}" varStatus="loop">

            <div align="center" style="background-color: #f0ffff;">
                <div style="float: left;color: #8a2be2;">
                        ${usernames[loop.index]}:
                </div>

                <div style="float: left;padding-left: 100px;position: absolute;">
                        ${comments[loop.index]}
                </div>
                <br>
                <br>
            </div>

        </c:forEach>
    </c:if>
    <br>
    <br>
    <%--<jsp:include page="commentsProcess.jsp"></jsp:include>--%>
    Add your comment:<br>
    <textarea name="commentArea" rows="10" cols="40"></textarea><br>
    <button name="submit" type="submit" value="commentsave">comment</button>
</form>

<%--<c:if test="${username=='imon'}">--%>
<%--<form>--%>
<%--I want to eat food....--%>
<%--</form>--%>
<%--</c:if>--%>
</body>
</html>