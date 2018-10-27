<%--@elvariable id="user" type="cs4012.project2.context.web.site.entity.User"--%>
<%--@elvariable id="profileImageOrig" type="java.lang.String"--%>
<%--@elvariable id="profileImageScaled" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>Profile</h1>
<img src="data:image/jpeg;base64,${profileImageOrig}"/>
<h3>Basic Info</h3>
<form method="post" action="/profile/basicInfo">
    <input type="text" name="fname" placeholder="${user.fname}"/><br>
    <input type="text" name="lname" placeholder="${user.lname}"/><br>
    <input type="text" name="birthday" placeholder="${user.birthday}"/><br>
    <input type="text" name="timeZone" placeholder="${user.timeZone}"/><br>
    <input type="submit" value="Update Basic Info"/>
</form>
<h3>Profile Image</h3>
<img src="data:image/jpeg;base64,${profileImageScaled}"/>
<form method="post" enctype="multipart/form-data" action="/profile/image">
    <input type="file" name="image"/><br>
    <input type="submit" value="Update Profile Image"/>
</form>
<h3>Password</h3>
<form method="post" action="/profile/password">
    <input type="password" name="password" placeholder="New Password"/><br>
    <input type="submit" value="Update Password"/>
</form>
<h3>Contact Info</h3>
<form method="post" action="/profile/contactInfo">
    <input type="text" name="addrBody" placeholder="${user.addrBody}"/><br>
    <input type="text" name="addrCity" placeholder="${user.addrCity}"/><br>
    <input type="text" name="addrState" placeholder="${user.addrState}"/><br>
    <input type="text" name="addrZip" placeholder="${user.addrZip}"/><br>
    <input type="text" name="phoneHome" placeholder="${user.phoneHome}"/><br>
    <input type="text" name="phoneCell" placeholder="${user.phoneCell}"/><br>
    <input type="submit" value="Update Contact Info"/>
</form>
<a href="?logout=1">Log out</a>
</body>
</html>
