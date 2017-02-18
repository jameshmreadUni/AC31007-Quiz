<%-- 
    Document   : register
    Created on : 18-Feb-2017, 18:09:29
    Author     : jamesread
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register - Student</title>
    </head>
    <body>
        <h1>Student Registration</h1>
        
        <form method="GET" name="registerForm">
        <h2>Username</h2> <input type="text" name="userName">
        <br>
        <h2>Password</h2> <input type="password" name="password">
        <h2>Confirm Password</h2> <input type="password" name="confirmPassword">
        <h2>Email</h2>
        <input type="email" name="email">
        <br>
        <input type="submit" value="Register"> 
        </form>
    </body>
</html>
