<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 02-Dec-21
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>
<h1>63130500135 - Asamaporn Pladsri</h1>
<div class="row">
    <c:forEach items="${customers}" var="customer">
        <div>
        ${customer.contactFirstName} ${customer.contactLastName} : ${customer.role}
        </div>
    </c:forEach>
</div>

</body>
</html>
