<%-- 
    Document   : QuizStaffView
    Created on : 23-Feb-2017, 16:38:49
    Author     : gemmawhyte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Quiz</title>
    </head>
    <body>
        <h1>Staff View - Quiz Page</h1>
        <p> here is where you will see all info about a quiz (editable info)
    <%        String quizTitle = (String)request.getAttribute("quizTitle"); %>
    <%=quizTitle%>
            
            <form method="POST"  action="EditQuiz">
            <b><ul align="center" id="updateform">Quiz Name:-<input type="text" name="quizName" value="<%=quizTitle%>" required></ul></b>
            <ul align="center"><input type="submit" value="Update Quiz Name" id="updateQuizName">  </ul>
            </form>
    </body>
</html>
