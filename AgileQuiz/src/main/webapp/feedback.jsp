<%-- 
    Document   : feedback
    Created on : 13-Mar-2017, 20:58:29
    Author     : jamesread
--%>

<%@page import="com.Agile.Quiz.stores.QuizResultBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question Feedback</title>
    </head>
    <%QuizResultBean quizResult = (QuizResultBean)request.getAttribute("quizFeedback"); %>
    <body>
        <h1><%=quizResult.getQuizModule()%></h1>
        <h2><%=quizResult.getQuizName()%></h2>
        
        <%for(int i = 0; i < quizResult.getQuestions().length; i++){ %>
            <li> Question <%=i%>: <%=quizResult.getQuestions(i)%></li>
            <br>
            <li> Correct Answers: <%=quizResult.getCorrectAnswers(i)%></li>
            <br>
            <li> Explanation: <%=quizResult.getQuestionExplanations(i)%></li>
            <br><br>
        <%}%>
    </body>
</html>
