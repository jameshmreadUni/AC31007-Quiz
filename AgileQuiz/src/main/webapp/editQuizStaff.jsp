<%-- 
    Document   : QuizStaffView
    Created on : 23-Feb-2017, 16:38:49
    Author     : gemmawhyte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="/2016-agileteam4/Style.css" />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal - Edit Quiz</title>
    </head>
    <body>
         <nav>
        <ul id ="menubar">
            <h1 id="homepagehead">Student Portal</h1>
        
        <li><a href="quizPage.jsp">Quiz</a></li>
        <li><a href="quizes.jsp">Quiz List</a></li>
        <li><a href="quizPage.jsp">Quiz Page</a></li>
        <li><a href="createQuestion.jsp">Create Question</a></li>
        <li><a href="/2016-agileteam4/EditQuiz">Staff View - Quiz Page</a></li>
        <li style="float:right"><a href="login.jsp">Login</a></li>
        </ul>
    </nav>
        <h1>Staff View - Quiz Page</h1>

        <p> When this is finished, you will be able to see all quiz names and be able to edit them (you may also be able to edit questions etc)</p>
        <p> This will display a linked list </p>
    <%        String quizTitle = (String)request.getAttribute("quizTitle"); %>
    <%=quizTitle%>
       
            
            <form method="POST"  action="EditQuiz">
            <b><ul align="center" id="updateform">Quiz Name:-<input type="text" name="quizName" value="<%=quizTitle%>" required></ul></b>
            <ul align="center"><input type="submit" value="Update Quiz Name" id="updateQuizName">  </ul>
            </form>
    </body>
</html>
