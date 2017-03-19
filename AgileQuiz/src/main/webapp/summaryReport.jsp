<%-- 
    Document   : summaryReport
    Created on : Mar 14, 2017, 4:29:10 PM
    Author     : Brian
--%>

<%@page import="com.Agile.Quiz.stores.SummaryReportBean"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.Agile.Quiz.stores.loginBean"%>
<%@page import="com.Agile.Quiz.models.ModelSummaryReport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Summary Report</title>
    </head>
    <body>
        <h1>Quiz Name Here</h1>
    </body>
<%-- 
    Display Number of correct answers.
    Display Number of wrong answers if any.
    Display Percentage of Correct Answers.
    Display the correct answer if student gets it wrong.
    Display a breif reason of why is the correct answer.
--%>
   // might not do it as a linked list
   
    <%
        loginBean lg = (loginBean) session.getAttribute("loginBean");
                    LinkedList sl = (LinkedList) request.getAttribute("summaryList");
                    
                    if (lg != null) {
                        String UserName = lg.getUsername();
                        if (lg.getloggedin()) {
                            
    %>
    
          <%                                 //think this should be completedbean? instead of model quiz order
                        java.util.LinkedList<SummaryReportBean> slLink = (java.util.LinkedList<SummaryReportBean>) request.getAttribute("summaryList");
                        if (slLink == null) {
                    %>
                    <p>No List Found</p> 
                    <%
                    } else {
                    %>  
                    <h2>Summary Report</h2>
                    <%
                        for(int i =0; i < slLink.size(); i++)
                        {
                    %>
                    <p>
                        
                        <h6>Your Percentage</h6>
                        <%=slLink.get(i).getPercentage() %>
                        <h6>Total</h6>
                        <%=slLink.get(i).getTotal() %>
                        <h6>Correct Answers</h6>
                        <%=slLink.get(i).getCorrect() %>
                        <h6>Wrong Answers</h6>
                        <%= slLink.get(i).getWrong() %>
                        <h6>Explenation on correct Answers</h6>
                        <%=slLink.get(i).getBreif() %>

                    </p>
                    <%
                        }
                    }
                }
            }
                        %>
</html>
