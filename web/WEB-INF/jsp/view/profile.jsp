<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>Profile</h1>
<%--@elvariable id="update" type="cs4012.project2.context.web.site.ProfileController.Update"--%>
<h3>Basic Info</h3>
<form method="post" action="/profile/basic">
    <input type="text" name="fname"/><br>
    <input type="text" name="lname"/><br>
    <input type="text" name="birthday"/><br>
    <input type="text" name="timeZone"/><br>
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
<form method="post" action="/profile/contact">
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
