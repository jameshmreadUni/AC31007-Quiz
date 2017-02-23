<%-- 
    Document   : login
    Created on : 17-Feb-2017, 20:14:00
    Author     : jamesread
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>This is the Login Page!</h1>
        
        <% String test  = (String)request.getAttribute("TEST"); %>
        <h2><%=test %></h2>
    </body>
</html>
