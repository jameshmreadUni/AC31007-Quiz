<%@page import="com.Agile.Quiz.stores.loginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>


    <body>
        <h1>Hello World!</h1>
        
        <h3>This should break things</h3>

        <h2>We are testing branches </h2>
<nav>
    <ul>
        <%--<li><a href="/AgileQuiz/Login">Login</a></li>
<li><a href="/AgileQuiz/register.jsp">Register</a></li>  <%--%>
    <%
                    loginBean lg = (loginBean) session.getAttribute("loginBean");
                    if (lg != null) {
                        String username = lg.getUsername();
                        if(lg.getloggedin()){
    %>
    <li><a href="/AgileQuiz/LogOut" >Logout</a></li>
    <li><a href="/AgileQuiz/Quiz/test" >Quiz</a></li>
                        <%}
                        }else{
                        %>
    <li><a href="/AgileQuiz/Login">Login</a></li>
    <li><a href="/AgileQuiz/Register">Register</a></li>
     <%}%>
    
    </ul>
</nav>
    </body>
</html>
