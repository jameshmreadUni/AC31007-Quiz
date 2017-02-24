<%-- 
    Document   : register
    Created on : 18-Feb-2017, 18:09:29
    Author     : jamesread
--%>

<%@page import="com.Agile.Quiz.stores.RegisterBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="/AgileQuiz/Style.css" />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register - Student</title>
    </head>
    <body>
        <h1>Student Registration</h1>
        <%RegisterBean errorFeedback = (RegisterBean)request.getAttribute("errorFeedback");%>
            <%if(errorFeedback != null){%>
                <form method="POST" name="registerForm">
                    <h2>Username</h2> <input type="text" name="username" value="<%=errorFeedback.getUsername()%>">
                    <br>
                    <h2>Password</h2> <input type="password" name="password">
                    <h2>Confirm Password</h2> <input type="password" name="confirmPassword">
                    <h2>Email</h2>
                <input type="email" name="email" value="<%=errorFeedback.getEmail()%>">
        <br>
        
            <%for(int i = 0; i < errorFeedback.getInputErrorsSize(); i++){ %>
                <h4 id="error"> <%=errorFeedback.getInputErrors(i)%></h4>
            <%}%>
        <%}else{%>
            <form method="POST" name="registerForm">
                <h2>Username</h2> <input type="text" name="username">
                <br>
                <h2>Password</h2> <input type="password" name="password">
                <h2>Confirm Password</h2> <input type="password" name="confirmPassword">
                <h2>Email</h2>
                <input type="email" name="email">
                <br>
        <%}%>
        <br>
        <input type="submit" value="Register"> 
            </form>
    </body>
</html>
