<%-- 
    Document   : modulePage
    Created on : 19-Mar-2017, 15:14:27
    Author     : seanstewart
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.Agile.Quiz.stores.ModuleBean"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modules</title>
    </head>
    <body>
        <h1>Modules</h1>
        <% 
            LinkedList<ModuleBean> moduleList = (LinkedList<ModuleBean>)request.getAttribute("modules");
            Iterator<ModuleBean> iterator;
            iterator = moduleList.iterator();
            while (iterator.hasNext()) {
                 ModuleBean module = (ModuleBean)iterator.next();
        %> 
        <h2><%=module.getModuleCode()%> -  <%=module.getModuleName()%> </h2>
                <h3>Quizzes Available: </h3>
                <ul>
                    <% 
                    Iterator<String> quiz;
                       quiz = module.getQuizName().iterator();
                                while (quiz.hasNext()) {
                                String quizName = (String)quiz.next();
                    %>
                    <li><a href="/AgileQuiz/Quiz/<%=quizName%>"><%=quizName%></a>
                <%  } %>
                </ul> 
                <% } %>
    </body>
</html>
