<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Log In</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-header">Log In</div>
        <div class="card-body">
            <c:choose>
                <c:when test="${not empty param.badcreds}">
                    <div class="alert alert-danger" role="alert">
                        Incorrect username or password!
                    </div>
                </c:when>
                <c:when test="${not empty param.logout}">
                    <div class="alert alert-success" role="alert">
                        You were successfully logged out. Have a nice day!
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="alert alert-primary" role="alert">
                        Welcome! Please log in or register below.
                    </div>
                </c:otherwise>
            </c:choose>
            <%--@elvariable id="user" type="cs4012.project2.context.web.site.LoginController$User"--%>
            <form:form method="post" modelAttribute="user">
                <div class="form-group row">
                    <label for="username" class="col-md-4 col-form-label text-md-right">Username</label>
                    <div class="col-md-6">
                        <form:input type="text" class="form-control" id="username" path="username" required="1" autofocus="1"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-md-4 col-form-label text-md-right">Password</label>
                    <div class="col-md-6">
                        <form:input type="password" class="form-control" id="password" path="password" required="1"/>
                    </div>
                </div>
                <div class="col-md-6 offset-md-4">
                    <button type="submit" class="btn btn-primary">Log In</button>
                    <a href="<c:url value="/register"/>" class="btn btn-link">Register</a>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
