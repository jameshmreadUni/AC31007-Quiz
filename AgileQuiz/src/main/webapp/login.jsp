<%-- 
    Document   : login
    Created on : 22-Feb-2017, 20:14:00
    Author     :Brian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <link rel="stylesheet" type="text/css" href="/AgileQuiz/Style.css" />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    <nav>
        <ul>
         
        </ul>
    </nav>
    </head>
    <body>
        <script>
            function validateForm()
            {
                var usernameValue = document.getElementById("username").value;
                var passwordValue = document.getElementById("password").value;
                
                validateForm_userFeedback.innerHTML = ""
                
                
                if(usernameValue == "" && passwordValue == "")
                {
                    validateForm_userFeedback.innerHTML = "Error! You must enter a Username and Password to login!"
                    return false;
                }
                if (usernameValue == "")
                {
                    validateForm_userFeedback.innerHTML = "Error! Username field must not be empty."
                    return false;
                }
                if(passwordValue == "")
                {
                    validateForm_userFeedback.innerHTML = "Error! Password field must not be empty."
                    return false;
                }
                else
                {
                    return true;
                }
            }
        </script>
         <nav>
        <ul id ="menubar">
            <h1 id="homepagehead">Student Portal</h1>
        
        <li><a href="quizPage.jsp">Quiz</a></li>
        <li><a href="quizes.jsp">Quiz List</a></li>
        <li><a href="quizPage.jsp">Quiz Page</a></li>
        <li><a href="createQuestion.jsp">Create Question</a></li>
        <li><a href="/AgileQuiz/EditQuiz">Staff View - Quiz Page</a></li>
        <li><a href="/AgileQuiz/register.jsp">Register</a></li>
                        <li><a href="/AgileQuiz/index.jsp">Home</a></li>
        <li style="float:right"><a href="login.jsp">Login</a></li>
        </ul>
    </nav>
        
        <form method="POST"  action="Login" onsubmit="return validateForm();">
                    <ul>
                        <li style="float:center">User Name <input type="text" id="username" name="username"></li>
                        <li style="float:center">Password <input type="password" id="password" name="password"></li>
                        <p id = "validateForm_userFeedback"></p>
                    </ul>
                        
                    <br/>
                    <input type="submit" value="Login"> 
                    
                   
        </form>
    </body>
</html>
