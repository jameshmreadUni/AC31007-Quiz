<%-- 
    Document   : login
    Created on : 22-Feb-2017, 20:14:00
    Author     :Brian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    <nav>
        <ul>
         <li><a href="/AgileQuiz/index.html">Home</a></li>
        </ul>
    </nav>
    </head>
    <body>
        <h1>Login</h1>
        
        <form method="POST"  action="Login">
                    <ul>
                        <li>User Name <input type="text" name="username"></li>
                        <li>Password <input type="password" name="password"></li>
                    </ul>
                    <br/>
                    <input type="submit" value="Login"> 
                    <ul>
                        <li><a href="/AgileQuiz/register.jsp">Register</a></li>
                    </ul>
        </form>
    </body>
</html>
