<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 02-Dec-21
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminPage1</title>
</head>
<body>

    <h1>Admin - Page 1</h1>
<c:forEach items="${customers}" var="customer">
    <div>
        ${customer.contactFirstName} ${customer.contactLastName} : ${customer.role}
    </div>
</c:forEach>

</body>
</html>
