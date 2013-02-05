<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>OK!</h1>
<c:forEach var="employee" items="${employees}">
    <h3 style="color: #6005ff"><c:out value="${employee.email}" /><a href="employeeform?id=<c:out value="${employee.id}" />" /> edit</a></h3>
    <h4>Name: <c:out value="${employee.firstName}" /></h4>
    <h4>SurName: <c:out value="${employee.lastName}" /></h4>
    <h4>Password: <c:out value="${employee.password}" /></h4>
    <h4>Birth date: <c:out value="${employee.birhdate}" /></h4>
</c:forEach>

</body>
</html>