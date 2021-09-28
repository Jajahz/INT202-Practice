<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 23-Aug-21
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new student</title>
</head>
<body>
<form action="add-new-student" method="post">
    Id: <input type="number" name="id" required><br>
    Name: <input type="text" name="name" required><br>
    Gpax: <input type="number" name="gpax" required><br>
    <input type="submit" value="save">

<%--    <input type="hidden" name="x" value="100">--%>
<%--    <input type="hidden" name="x" value="900">--%>
<%--    <input type="hidden" name="x" value="400">--%>

</form>
</body>
</html>
