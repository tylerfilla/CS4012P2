<%--@elvariable id="user" type="cs4012.project2.context.web.site.entity.User"--%>
<%--@elvariable id="profileImageOrig" type="java.lang.String"--%>
<%--@elvariable id="profileImageScaled" type="java.lang.String"--%>
<%--@elvariable id="edus" type="java.util.List<cs4012.project2.context.web.site.entity.Edu>"--%>
<%--@elvariable id="works" type="java.util.List<cs4012.project2.context.web.site.entity.Work>"--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">${user.fname}'s Profile</h1>
        <p class="lead">This is your personal profile. Feel free to customize it as you desire.</p>
        <hr class="my-4">
        <a class="btn btn-primary btn-lg" href="<c:url value="/login?logout=1"/>" role="button">Log Out</a>
    </div>
    <div class="card">
        <div class="card-header">Profile Image</div>
        <div class="card-body">
            <c:if test='${param.updated eq "image"}'>
                <div class="alert alert-success" role="alert">
                    Your profile image was successfully updated!
                </div>
            </c:if>
            <img src="data:image/jpeg;base64,${profileImageScaled}"/>
            <form method="post" enctype="multipart/form-data" action="<c:url value="/profile/image"/>">
                <input type="file" class="form-control-file" name="image" required/><br>
                <button class="btn btn-primary">Update Profile Image</button>
            </form>
        </div>
    </div><br>
    <div class="card">
        <div class="card-header">Basic Info</div>
        <div class="card-body">
            <c:if test='${param.updated eq "basic"}'>
                <div class="alert alert-success" role="alert">
                    Your basic info was successfully updated!
                </div>
            </c:if>
            <form method="post" action="<c:url value="/profile/basicInfo"/>">
                <div class="form-group row">
                    <label for="fname" class="col-md-4 col-form-label text-md-right">First Name</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="fname" name="fname" value="${user.fname}" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="lname" class="col-md-4 col-form-label text-md-right">Last Name</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="lname" name="lname" value="${user.lname}" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="birthday" class="col-md-4 col-form-label text-md-right">Birthday</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="birthday" name="birthday" value="${user.birthday}" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="timeZone" class="col-md-4 col-form-label text-md-right">Time Zone</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="timeZone" name="timeZone" value="${user.timeZone}" required/>
                    </div>
                </div>
                <button class="btn btn-primary">Update Basic Info</button>
            </form>
        </div>
    </div><br>
    <div class="card">
        <div class="card-header">Password</div>
        <div class="card-body">
            <c:if test='${param.updated eq "password"}'>
                <div class="alert alert-success" role="alert">
                    Your password was successfully updated!
                </div>
            </c:if>
            <form method="post" action="<c:url value="/profile/password"/>">
                <input type="password" class="form-control" name="password" placeholder="New Password" required/><br>
                <button class="btn btn-primary">Update Password</button>
            </form>
        </div>
    </div><br>
    <div class="card">
        <div class="card-header">Contact Info</div>
        <div class="card-body">
            <c:if test='${param.updated eq "contact"}'>
                <div class="alert alert-success" role="alert">
                    Your contact info was successfully updated!
                </div>
            </c:if>
            <form method="post" action="<c:url value="/profile/contactInfo"/>">
                <div class="form-group row">
                    <label for="addrBody" class="col-md-4 col-form-label text-md-right">Address</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="addrBody" name="addrBody" value="${user.addrBody}" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="addrCity" class="col-md-4 col-form-label text-md-right">City</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="addrCity" name="addrCity" value="${user.addrCity}" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="addrState" class="col-md-4 col-form-label text-md-right">State</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="addrState" name="addrState" value="${user.addrState}" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="addrZip" class="col-md-4 col-form-label text-md-right">ZIP Code</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="addrZip" name="addrZip" value="${user.addrZip}" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="phoneHome" class="col-md-4 col-form-label text-md-right">Home Phone</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="phoneHome" name="phoneHome" value="${user.phoneHome}" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="phoneCell" class="col-md-4 col-form-label text-md-right">Cell Phone</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="phoneCell" name="phoneCell" value="${user.phoneCell}" required/>
                    </div>
                </div>
                <button class="btn btn-primary">Update Contact Info</button>
            </form>
        </div>
    </div><br>
    <div class="card">
        <div class="card-header">Education History</div>
        <div class="card-body">
            <c:if test='${param.updated eq "edu"}'>
                <div class="alert alert-success" role="alert">
                    Your education history was successfully updated!
                </div>
            </c:if>
            <ul class="list-group">
                <c:forEach items="${edus}" var="edu">
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        <span>${edu.degreeType} in ${edu.degreeDiscipline} at ${edu.institution}</span>
                        <span>
                            <span class="badge badge-primary badge-pill">${edu.year}</span>
                            <a href="?eduToDelete=${edu.id}" class="btn" role="button">X</a>
                        </span>
                    </li>
                </c:forEach>
            </ul>
            <hr class="my-4">
            <h5>Add Education History</h5>
            <form method="post" action="<c:url value="/profile/edu"/>">
                <div class="form-group row">
                    <label for="institution" class="col-md-4 col-form-label text-md-right">Institution</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="institution" name="institution" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="degreeType" class="col-md-4 col-form-label text-md-right">Degree Type</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="degreeType" name="degreeType" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="degreeDiscipline" class="col-md-4 col-form-label text-md-right">Degree Discipline</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="degreeDiscipline" name="degreeDiscipline" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="year" class="col-md-4 col-form-label text-md-right">Year of Achievement</label>
                    <div class="col-md-6">
                        <input type="number" class="form-control" id="year" name="year" required/>
                    </div>
                </div>
                <button class="btn btn-primary">Add education</button>
            </form>
        </div>
    </div><br>
    <div class="card">
        <div class="card-header">Work History</div>
        <div class="card-body">
            <c:if test='${param.updated eq "work"}'>
                <div class="alert alert-success" role="alert">
                    Your work history was successfully updated!
                </div>
            </c:if>
            <ul class="list-group">
                <c:forEach items="${works}" var="work">
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        <span>${work.title} at ${work.company}</span>
                        <span>
                            <span class="badge badge-primary badge-pill">${work.years} years</span>
                            <a href="?workToDelete=${work.id}" class="btn" role="button">X</a>
                        </span>
                    </li>
                </c:forEach>
            </ul>
            <hr class="my-4">
            <h5>Add Work History</h5>
            <form method="post" action="<c:url value="/profile/work"/>">
                <div class="form-group row">
                    <label for="company" class="col-md-4 col-form-label text-md-right">Company</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="company" name="company" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="title" class="col-md-4 col-form-label text-md-right">Title</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="title" name="title" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="years" class="col-md-4 col-form-label text-md-right">Years of Service</label>
                    <div class="col-md-6">
                        <input type="number" class="form-control" id="years" name="years" required/>
                    </div>
                </div>
                <button class="btn btn-primary">Add work</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
