<%-- 
    Document   : createQuestion
    Created on : 21-Feb-2017, 17:44:24
    Author     : JoeDavis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.Agile.stores.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Style.css">
        <%storeQuestion storequestion = (storeQuestion) session.getAttribute("ProfileStore");%>
        
        <title>Create Question</title>
    </head>
    <body>
        <div id = "header">
            
            <h4>Logged in as: STAFF</h4>
            
        </div>
        
        <div id = "content">
            
            <form method="POST" action="createQuestion">
                Question!<br>
                <input type="text" name="question" placeholder="Question">
                <br>
                <br>
                Answers! (Please indicate the correct answer)<br>
                <input type="text" name="answer1" placeholder="Answer 1"> <input type="radio" name="correctAnswer" value="correct1"><br>
                <input type="text" name="answer2" placeholder="Answer 2"> <input type="radio" name="correctAnswer" value="correct2"><br>
                <input type="text" name="answer3" placeholder="Answer 3"> <input type="radio" name="correctAnswer" value="correct3"><br>
                <input type="text" name="answer4" placeholder="Answer 4"> <input type="radio" name="correctAnswer" value="correct4"><br>
                <br><br>
                <input type="submit" value="Add to Quiz">
            </form>
            
            <form>
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
