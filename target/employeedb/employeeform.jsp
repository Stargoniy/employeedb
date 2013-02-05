<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>

<html>
<html>
<head>
    <title></title>
</head>
<body>
<form name="test" method="post" action="/employeeform">
    <%
        Map<String, String> colors = new HashMap<String, String>();
        colors.put("firstName", "black");
        colors.put("lastName", "black");
        colors.put("email", "black");
        colors.put("password", "black");
        colors.put("passwordConfirmation", "black");
        colors.put("birhdate", "black");

        if (request.getAttribute("errors") != null && !((Set<String>)request.getAttribute("errors")).isEmpty()) {
            Set<String> errors = (Set<String>)request.getAttribute("errors");
            for(String err: errors) {
                colors.put(err, "red");
            }
        }
    %>

    <p style="color: <%=colors.get("firstName")%>"><b>First name:</b><br>
        <input name="firstName" type="text" size="40" value="<c:out value="${employeeform.firstName}" default=""/>">
    </p>

    <p style="color: <%=colors.get("lastName")%>"><b>Surname:</b><br>
        <input name="lastName" type="text" size="40" value="<c:out value="${employeeform.lastName}" default=""/>">
    </p>

    <p style="color: <%=colors.get("email")%>"><b>E-Mail:</b><br>
        <input name="email" type="text" size="40" value="<c:out value="${employeeform.email}" default=""/>">
    </p>

    <p style="color: <%=colors.get("password")%>"><b>Password:</b><br>
        <input name="password" type="password" size="40" value="<c:out value="${employeeform.password}" default=""/>">
    </p>

    <p style="color: <%=colors.get("passwordConfirmation")%>"><b>Confirm password:</b><br>
        <input name="passwordConfirmation" type="password" size="40" value="<c:out value="${employeeform.passwordConfirmation}" default=""/>">
    </p>

    <p style="color: <%=colors.get("birhdate")%>"><b>Birth date:</b><br>
        <input name="birhdate" type="text" size="40" value="<c:out value="${employeeform.birhdate}" default=""/>">
    </p>

    <p><input type="submit" value="Save">
</form>
</body>
</html>