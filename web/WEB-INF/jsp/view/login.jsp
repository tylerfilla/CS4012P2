<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Log In</title>
</head>
<body>
<h1>Log In</h1>
<%--@elvariable id="user" type="cs4012.project2.context.web.site.LoginController$User"--%>
<form:form method="post" modelAttribute="user">
    <form:input type="text" path="username"/><br/>
    <form:input type="password" path="password"/><br/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
