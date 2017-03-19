<%-- 
    Document   : createQuestion
    Created on : 21-Feb-2017, 17:44:24
    Author     : JoeDavis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.Agile.Quiz.stores.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Style.css">
        <%storeQuestion storequestion = (storeQuestion) session.getAttribute("ProfileStore");%>
        <%String answerType = (String) request.getAttribute("answerType");%>
        <% if(answerType == null) answerType = "radio"; %>
        <title>Create Question</title>
    </head>
    <body>
        <div id = "header">
            
            <h4>Logged in as: STAFF</h4>
            
        </div>
        
        <div id = "content">
            <form method="GET" action="CreateQuestion">
                    Answer Type
                    <br>
                    <input type="radio" name="answerType" value="radio" > Radio Button <br>
                    <input type="radio" name="answerType" value="checkbox" > Check box <br>
                    <input type="radio" name="answerType" value="text" > Text Box <br>
                    <input type="submit" name="Submit" value="Change answer type">
            </form>
            
                <%  if(answerType.equals("radio") || answerType.equals("checkbox")){%>
            <form method="POST" action="CreateQuestion">
                Question<br>
                <input type="text" name="question" placeholder="Question">
                <br>
                <br>
                Answer Please indicate the correct answer(s)<br>
                <%for(int i = 0; i < 10; i++){%>
                <input type="text" name="answer" placeholder="Answer <%=i%>"> <input type="<%=answerType%>" name="correctAnswer" value="correct-<%=i%>"><br>
                <%}%>
                <input type="hidden" name="answerType" value="<%=answerType%>">
                <br><br>
                <input type="submit" value="Add to Quiz">
            </form>
            <%}else if(answerType.equals("text")){%>
                 <form method="POST" action="CreateQuestion">
                     <input type="text" name="question" placeholder="Question">
                     <br><br>
                     <input type="text" name="answer" placeholder="Replace this text with answer text"> 
                     <br><br>
                     <input type="hidden" name="answerType" value="<%=answerType%>">
                     <input type="submit" value="Add to Quiz">
                 </form>
            <%}%>
            <form method="POST" action ="FinishQuiz">
                <input type="checkbox" name="toggleQuizAvailable"> Quiz is available upon creation <br>
                <input type="submit" value="Finish Quiz">
            </form>
            
            <%storeQuestion sq = (storeQuestion) session.getAttribute("storeQuestion");%>
            
            <% if(sq == null){ %>
                <p></p>
            <%}else if (sq != null){ %>
            <form>
                <input type="submit" value="View Question">
            </form>
                <%} %>
            
        </div>
        
    </body>
</html>
