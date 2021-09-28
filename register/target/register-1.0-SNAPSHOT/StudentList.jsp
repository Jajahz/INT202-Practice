<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Collection" %>
<%@ page import="sit.int202.register.models.Student" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 23-Aug-21
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%-- this sentence it's a directive--%>
<html>
<head>
  <title>Student List</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <h3>Student List :</h3>
  <hr>
  <div class="row p-2">
    <%--        <%--%>
    <%--            Collection<Student> students = (Collection<Student>) request.getAttribute("students");--%>
    <%--            for (Student student : students) {%>--%>
    <c:forEach items="${students}" var="s" varStatus="vs">
      <div class="col-2 p-1 m-2 border border-secondary
        ${vs.count%5==1 || vs.count%5==3 ? 'bg-primary' : ''}">
          <%--            <div>Id: <%= student.getId()%></div>--%>
          <%--            <div>Name: <%= student.getName()%></div>--%>
          <%--            <div>gpax: <%= student.getGpax()%></div>--%>
        <div>Id : ${s.id}</div>
        <div>Name : ${s.name}</div>
        <div>Gpax : ${s.gpax}</div>
        <div><hr></div>
      </div>
    </c:forEach>
    <%--        <%}%>--%>
  </div>
</div>
</body>
</html>