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
<h1>Profile</h1>
<a href="<c:url value="/login?logout=1"/>">Log out</a>
<img src="data:image/jpeg;base64,${profileImageOrig}"/>
<h3>Basic Info</h3>
<form method="post" action="<c:url value="/profile/basicInfo"/>">
    <input type="text" name="fname" placeholder="${user.fname}"/><br>
    <input type="text" name="lname" placeholder="${user.lname}"/><br>
    <input type="text" name="birthday" placeholder="${user.birthday}"/><br>
    <input type="text" name="timeZone" placeholder="${user.timeZone}"/><br>
    <input type="submit" value="Update Basic Info"/>
</form>
<h3>Profile Image</h3>
<img src="data:image/jpeg;base64,${profileImageScaled}"/>
<form method="post" enctype="multipart/form-data" action="<c:url value="/profile/image"/>">
    <input type="file" name="image"/><br>
    <input type="submit" value="Update Profile Image"/>
</form>
<h3>Password</h3>
<form method="post" action="<c:url value="/profile/password"/>">
    <input type="password" name="password" placeholder="New Password"/><br>
    <input type="submit" value="Update Password"/>
</form>
<h3>Contact Info</h3>
<form method="post" action="<c:url value="/profile/contactInfo"/>">
    <input type="text" name="addrBody" placeholder="${user.addrBody}"/><br>
    <input type="text" name="addrCity" placeholder="${user.addrCity}"/><br>
    <input type="text" name="addrState" placeholder="${user.addrState}"/><br>
    <input type="text" name="addrZip" placeholder="${user.addrZip}"/><br>
    <input type="text" name="phoneHome" placeholder="${user.phoneHome}"/><br>
    <input type="text" name="phoneCell" placeholder="${user.phoneCell}"/><br>
    <input type="submit" value="Update Contact Info"/>
</form>
<h3>Education</h3>
<div>
    <c:forEach items="${edus}" var="edu">
        <div>${edu.institution}</div>
    </c:forEach>
</div>
<h3>Work Experience</h3>
<div>
    <c:forEach items="${works}" var="work">
        <div>${work.company}</div>
    </c:forEach>
</div>
</body>
</html>
