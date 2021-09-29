<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Student Info</title>
</head>
<body>
<h2>New student has been added.</h2><hr>
Student Id: ${newStudent.id}<br>
Student Name: ${newStudent.name}<br>
Gpax: ${newStudent.gpax}<br>
<hr>
<a href = "index.jsp"><button> OK </button></a><br>
<%--request.param.id = ${param.id} <br>--%>
<%--request.param.name = ${param.name} <br>--%>
<%--request.param.gpax= ${param.gpax} <br>--%>
<%--x = {${paramValues.x[0]}, ${paramValues.x[1]}, ${paramValues.x[2]}}<br>--%>
<%--<br>--%>
<%--x =--%>
<%--{--%>
<%--<c:forEach items="${paramValues.x}" var="v" varStatus="vs">--%>
<%--    ${vs.count}:${v} &nbsp;--%>
<%--</c:forEach>--%>
<%--}--%>
<%--<br>--%>
<%--<hr>--%>
<%--User-Agent = ${header["User-Agent"]}--%>
</body>
</html>
