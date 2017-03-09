<%@page import="com.Agile.Quiz.stores.loginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="/AgileQuiz/Style.css" />
    <head>
        <title>Student Portal</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>


    <body>
        
        <div id = "navBar">
            <h3>Student Login</h3>
            <h3>Staff Login</h3>
        </div>
        
        <img id ="uniLogo" src="Images/UniLogo.png" alt="Dundee University">
        <h1>Team 4 Quiz</h1>

<nav>
    <ul>
    <%
                    loginBean lg = (loginBean) session.getAttribute("loginBean");
                    if (lg != null) {
                        String username = lg.getUsername();

                        if(lg.getloggedin()){
    %>
    <li><a href="/AgileQuiz/LogOut" >Logout</a></li>
    <li><a href="/AgileQuiz/Quiz/test" >Quiz</a></li>
    <li><a href="/AgileQuiz/CompletedQuizzes">Completed Quizzes</a></li>
                        <%}
                        }else{
                        %>
    <li><a href="/AgileQuiz/Login">Login</a></li>
    <li><a href="/AgileQuiz/Register">Register</a></li>
     <%}%>
    
    </ul>
</nav>
    </body>
</html>
