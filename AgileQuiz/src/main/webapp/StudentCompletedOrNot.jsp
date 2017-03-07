<%-- 
    Document   : StudentCompletedOrNot
    Created on : Feb 24, 2017, 5:33:14 PM
    Author     : Brian
--%>

<%@page import="com.Agile.Quiz.models.ModelQuizOrder"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.Agile.Quiz.stores.loginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Quizzes Completed/Not Completed</h1>
        <article>
                
    <%
        loginBean lg = (loginBean) session.getAttribute("loginBean");
                    LinkedList ls = (LinkedList) session.getAttribute("linkedlist");
                    
                    if (lg != null) {
                        String UserName = lg.getUsername();
                        if (lg.getloggedin()) {
                            
                        }
                        }
    %>
    
          <%
                        java.util.LinkedList<ModelQuizOrder> lsLink = (java.util.LinkedList<ModelQuizOrder>) request.getAttribute("linkedlist");
                        if (lsLink == null) {
                    %>
                    <p>No List Found</p> 
                    <%
                    } else {
                        Iterator<ModelQuizOrder> iterator;
                        iterator = lsLink.iterator();
                        while (iterator.hasNext()) {
                            ModelQuizOrder lt = (ModelQuizOrder) iterator.next();



                    %>
                    <p>Quiz List</p>
                    <a href="/AgileQuiz/QuizOrder<%=ls.listIterator()%>"></a><br/><%
           

                            }
                        }
                        %> 
                </article>
    </body>
</html>

               <%-- <article>
                    <h1>Your Pics</h1>
                    <%
                        java.util.LinkedList<Pic> lsPics = (java.util.LinkedList<Pic>) request.getAttribute("Pics");
                        if (lsPics == null) {
                    %>
                    <p>No Pictures found</p>
                    <%
                    } else {
                        Iterator<Pic> iterator;
                        iterator = lsPics.iterator();
                        while (iterator.hasNext()) {
                            Pic p = (Pic) iterator.next();

                    %>
                    <a class="image featured" href="/Instagrim/Image/<%=p.getUUID()%>" ><img src="/Instagrim/Thumb/<%=p.getUUID()%>"></a><br/><%

                            }
                        }
                        %>
                </article> --%>