<%-- 
    Document   : feedback
    Created on : 13-Mar-2017, 20:58:29
    Author     : jamesread
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.Agile.Quiz.stores.QuestionBean"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question Feedback</title>
    </head>
    <%LinkedList<QuestionBean> quizResult = (LinkedList<QuestionBean>)request.getAttribute("quizFeedback"); %>
    <body>
        <h1>FEEDBACK</h1>
         <% Iterator<QuestionBean> iterator;
            iterator = quizResult.iterator();
            while (iterator.hasNext()) {
                QuestionBean question = (QuestionBean)iterator.next();
                %>
 
        <h2><%--question.getQuizName()--%></h2>
       
            <li> Question : <%=question.getQuestionText()%></li>
            <br>
            <li> Correct Answers: <%=question.getAnswerText()%></li>
            <br>
            <li> Explanation: <%=question.getExplanation()%></li>
            <br><br>
        <%}%>
    </body>
</html>
