<%-- 
    Document   : createQuestion
    Created on : 21-Feb-2017, 17:44:24
    Author     : JoeDavis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Question</title>
    </head>
    <body>
        <div id = "header">
            
            <h4>Logged in as: STAFF/STUDENT</h4>
            
        </div>
        
        <div id = "content">
            
            <form>
                Question!<br>
                <input type="text" name="question" value="Question">
                <br>
                <br>
                Answers! (Please indicate the correct answer)<br>
                <input type="text" name="answer1" value="Answer 1"> <input type="radio" name="correctAnswer" value="correct1"><br>
                <input type="text" name="answer2" value="Answer 2"> <input type="radio" name="correctAnswer" value="correct2"><br>
                <input type="text" name="answer3" value="Answer 3"> <input type="radio" name="correctAnswer" value="correct3"><br>
                <input type="text" name="answer4" value="Answer 4"> <input type="radio" name="correctAnswer" value="correct4"><br>
                <br><br>
                <input type="submit" value="Add to Quiz">
            </form>
            
            <form>
                <input type="checkbox" name="available" value ="available"> Quiz is available upon creation <br>
                <input type="submit" value="Finish Quiz">
            </form>
            
        </div>
        
    </body>
</html>
