<%--@elvariable id="user" type="cs4012.project2.context.web.site.entity.User"--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>Profile</h1>
<h3>Basic Info</h3>
<form method="post" action="/profile/basicInfo">
    <input type="text" name="fname" placeholder="${user.fname}"/><br>
    <input type="text" name="lname" placeholder="${user.lname}"/><br>
    <input type="text" name="birthday" placeholder="${user.birthday}"/><br>
    <input type="text" name="timeZone" placeholder="${user.timeZone}"/><br>
    <input type="submit" value="Update Basic Info"/>
</form>
<h3>Profile Image</h3>
<form method="post" enctype="multipart/form-data" action="/profile/profileImage">
    <input type="file" name="image"/><br>
    <input type="submit" value="Update Profile Image"/>
</form>
<h3>Password</h3>
<form method="post" action="/profile/password">
    <input type="password" name="password"/><br>
    <input type="submit" value="Update Password"/>
</form>
<h3>Contact Info</h3>
<form method="post" action="/profile/contactInfo">
    <input type="text" name="addrBody"/><br>
    <input type="text" name="addrCity"/><br>
    <input type="text" name="addrState"/><br>
    <input type="text" name="addrZip"/><br>
    <input type="text" name="phoneHome"/><br>
    <input type="text" name="phoneCell"/><br>
    <input type="submit" value="Update Contact Info"/>
</form>
</body>
</html>
