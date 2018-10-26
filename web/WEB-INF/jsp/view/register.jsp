<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<%--@elvariable id="registration" type="cs4012.project2.context.web.site.RegisterController$Registration"--%>
<form:form method="post" modelAttribute="registration">
    <form:input type="text" path="username"/><br>
    <form:input type="password" path="password"/><br>
    <form:input type="text" path="fname"/><br>
    <form:input type="text" path="lname"/><br>
    <form:input type="text" path="addrBody"/><br>
    <form:input type="text" path="addrCity"/><br>
    <form:input type="text" path="addrState"/><br>
    <form:input type="text" path="addrZip"/><br>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
