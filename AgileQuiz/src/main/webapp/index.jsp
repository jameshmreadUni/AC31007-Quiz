<%@page import="com.Agile.Quiz.stores.loginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="/2016-agileteam4/Style.css" />
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
                        String type = lg.getUserType();

                        if(lg.getloggedin()){
                            System.out.println("Type:" + type);
                            

                             if(type.equals("staff")){   

    %>
        <li><a href="/2016-agileteam4/Modules">Modules</a></li>
        <li><a href="/2016-agileteam4/Quiz/test">Sample Quiz</a></li>
        <%--<li><a href="quizes.jsp">Quiz List</a></li> waiting for Ramesh Commit--%>
        <li><a href="/2016-agileteam4/CreateQuiz">Create Question</a></li>
        <%--<li><a href="/2016-agileteam4/EditQuiz">Staff View - Quiz Page</a></li> TODO NEXT SPRINT--%>
        <li><a href="/2016-agileteam4/QuizFeedback" >Quiz Feedback</a></li>
        <li style="float:right"><a href="/2016-agileteam4/LogOut" >Logout</a></li>
        <li><a href="/2016-agileteam4/CompletedQuizzes">Completed Quizzes</a></li>
        <li><a href="/2016-agileteam4/summaryReport"> Quiz Summary Report</a></li>

                        <%} else if(type.equals("student")){
                        %>
        <li><a href="/2016-agileteam4/Modules">Modules</a></li>
        <li><a href="/2016-agileteam4/Quiz/test">Sample Quiz</a></li>
        <li><a href="/2016-agileteam4/QuizFeedback" >Quiz Feedback</a></li>
        <li><a href="/2016-agileteam4/CompletedQuizzes">Completed Quizzes</a></li>
        <li><a href="/2016-agileteam4/summaryReport"> Quiz Summary Report</a></li>
        <li style="float:right"><a href="/2016-agileteam4/LogOut" >Logout</a></li>
                        
                        <%} }
                    }else { 
                        %>
                        
    <li><a href="/2016-agileteam4/Login">Login</a></li>
    <li><a href="/2016-agileteam4/Register">Register</a></li>
     <%}%>
    
    </ul>
</nav>
    </body>
    <li><a href="quizList.jsp">Select A Quiz</a></li>
</html>
