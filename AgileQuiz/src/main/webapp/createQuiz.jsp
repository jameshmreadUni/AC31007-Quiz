<%-- 
    Document   : createQuiz
    Created on : 23-Feb-2017, 15:34:59
    Author     : JoeDavis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Style.css">
        <title>Create a quiz</title>
    </head>
    <body>
        <div id = "header">
            <h3>Logged in as Staff</h3>
        </div>
        
        <div id="content">
            <form method="POST" action="CreateQuestion">
            <h4>Please give a name for the quiz: </h4>
            <input type="text" name="quizName" placeholder="Name of the quiz">
            <br>
            <h4>How many questions do you want in the quiz?</h4>
            <select>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
            </select>
            <br>
            <h4>Please select a time limit for each question: </h4>
            <select>
                <option value="10sec">10 Seconds</option>
                <option value="20sec">20 Seconds</option>
                <option value="30sec">30 Seconds</option>
                <option value="40sec">40 Seconds</option>
                <option value="50sec">50 Seconds</option>
                <option value="1min">1 minute</option>
                <option value="noLimit">No Limit</option>
            </select>
            
            
                <input type="submit" value ="createQuiz">
            </form>
        </div>
    </body>
</html>
