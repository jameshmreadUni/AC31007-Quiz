<%-- 
    Document   : quizPage
    Created on : 18-Feb-2017, 15:37:36
    Author     : jamesread
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.Agile.Quiz.stores.QuestionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%-- <link rel="stylesheet" type="text/css" href="/AgileQuiz/Style.css" /> --%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Style.css">
        
        <%LinkedList<QuestionBean> questionList = (LinkedList<QuestionBean>)request.getAttribute("quiz"); %>
        <%String quizTitle = (String)request.getAttribute("quizTitle");%>
        
        <title>Quiz - TODO input Module Code</title>
    </head>
    <body>
       <h1><%=quizTitle%></h1>
        <%
            Iterator<QuestionBean> iterator;
            iterator = questionList.iterator();
            while (iterator.hasNext()) {
                QuestionBean question = (QuestionBean)iterator.next();
                String answerType = question.getAnswerType();
        %>
                    
                    <h2><%=question.getQuestionText() %></h2>
                    <% Iterator<String> answeriterator;
                        answeriterator = question.getAnswerText().iterator();
                        while (answeriterator.hasNext()) {
                        String answerText = (String)answeriterator.next(); %>
                    <form>
                        <input type="<%=answerType%>" name = "<%=question.getQuestionNumber()%>" value="<%=question.getQuestionNumber()%>"> <%=answerText %></li> <br>
                        <%}%>
            <%}%>
                    </form>
    </body>
</html>
