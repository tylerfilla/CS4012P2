<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
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
