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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%LinkedList<QuestionBean> questionList = (LinkedList<QuestionBean>)request.getAttribute("question"); %>
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
        %>
                    
                    <h2><%=question.getQuestionText() %></h2>
                    <%String[] answers = question.getAnswerText(); %>
                    <form>
                            <%--going to need to use an iterator to iterate through the 'now' linked list of questions--%>
                        <%for(int i = 0; i < question.getAnswerText().length; i++){ %>
                        <input type="radio" name = "answer" value="<%=i%>"> <%=answers[i] %></li> <br>
                        <%}%>
            <%}%>
                    </form>
    </body>
</html>