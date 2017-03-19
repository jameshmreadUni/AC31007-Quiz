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
                    LinkedList ls = (LinkedList) request.getAttribute("linkedlist");
                    
                    if (lg != null) {
                        String UserName = lg.getUsername();
                        if (lg.getloggedin()) {
                            
    %>
    
          <%                                 //think this should be completedbean? instead of model quiz order
                        java.util.LinkedList<ModelQuizOrder> lsLink = (java.util.LinkedList<ModelQuizOrder>) request.getAttribute("linkedlist");
                        if (lsLink == null) {
                    %>
                    <p>No List Found</p> 
                    <%
                    } else {
                    %>  
                    <h2>Quiz List</h2>
                    <%
                        for(int i =0; i < lsLink.size(); i++)
                        {
                    %>
                    <p>
                        <%=lsLink.get(i)%>
                    </p>
                    <%
                        }
                    }
                }
            }
                        %> 
                </article>
    </body>
</html>