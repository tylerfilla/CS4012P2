<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container">
    <div class="card">
        <div class="card-header">Register</div>
        <div class="card-body">
            <%--@elvariable id="registration" type="cs4012.project2.context.web.site.RegisterController$Registration"--%>
            <form:form method="post" modelAttribute="registration">
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
                <div class="form-group row">
                    <label for="fname" class="col-md-4 col-form-label text-md-right">First Name</label>
                    <div class="col-md-6">
                        <form:input type="fname" class="form-control" id="fname" path="fname" required="1"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="lname" class="col-md-4 col-form-label text-md-right">Last Name</label>
                    <div class="col-md-6">
                        <form:input type="lname" class="form-control" id="lname" path="lname" required="1"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="addrBody" class="col-md-4 col-form-label text-md-right">Address Body</label>
                    <div class="col-md-6">
                        <form:input type="addrBody" class="form-control" id="addrBody" path="addrBody" required="1"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="addrCity" class="col-md-4 col-form-label text-md-right">City</label>
                    <div class="col-md-6">
                        <form:input type="addrCity" class="form-control" id="addrCity" path="addrCity" required="1"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="addrState" class="col-md-4 col-form-label text-md-right">State</label>
                    <div class="col-md-6">
                        <form:input type="addrState" class="form-control" id="addrState" path="addrState" required="1"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="addrZip" class="col-md-4 col-form-label text-md-right">ZIP Code</label>
                    <div class="col-md-6">
                        <form:input type="addrZip" class="form-control" id="addrZip" path="addrZip" required="1"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="method" class="col-md-4 col-form-label text-md-right">Method</label>
                    <div class="col-md-6">
                        <select id="method" class="form-control" onchange="this.form.method = this.value;">
                            <option value="post" selected>POST (default)</option>
                            <option value="get">GET</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-6 offset-md-4">
                    <button type="submit" class="btn btn-primary">Register</button>
                    <a href="<c:url value="/login"/>" class="btn btn-link">Back to login</a>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
