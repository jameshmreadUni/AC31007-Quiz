/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.servlets;

import com.Agile.Quiz.lib.Convertors;
import com.Agile.Quiz.models.ModelCreateQuiz;
import com.Agile.Quiz.stores.QuestionBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jamesread
 */
@WebServlet(name = "CreateQuestion", 
        urlPatterns = {
            "/CreateQuestion", 
            "/CreateQuestion/changeAnswerType/*",
            "/changeAnswerType/*"})
public class CreateQuestion extends HttpServlet {
    
     private final HashMap CommandsMap = new HashMap();
     LinkedList<QuestionBean> quiz;
     public CreateQuestion() {
        super();
        quiz = new LinkedList<>();
        CommandsMap.put("CreateQuestion", 1);
        CommandsMap.put("changeAnswerType", 2);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doGET");
        String args[] = Convertors.SplitRequestPath(request);
        int command;
        int command2;
        try {
            command = (Integer) CommandsMap.get(args[1]);
            //command2 = (Integer) CommandsMap.get(args[2]);
            //System.out.println("Args 2" + command2);
        } catch (Exception et) {
            System.out.println("CreateQuestion.java Exception: " + et);
            return;
        }
        switch (command) {
            case 1:
                if((String)request.getParameter("answerType") !=null)
                    displayAnswerTypes(request, response, (String)request.getParameter("answerType"));
                else{
                RequestDispatcher rd = request.getRequestDispatcher("/createQuestion.jsp");
                rd.forward(request, response);
                }
                break;
           
            default:
               System.out.println("DEFAULT CALLED CREATQUESTION.java");
        }
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(request.getParameter("answerType") != null ){
        if(request.getParameter("answerType").equals("text"))
           addTextQuestion(request, response);
        else{
           addMultiChoiceQuestion(request, response);
        }
       }
        
       RequestDispatcher rd = request.getRequestDispatcher("/createQuestion.jsp");
       rd.forward(request, response);
    }

    private void displayAnswerTypes(HttpServletRequest request, HttpServletResponse response, String answerType)
    throws ServletException, IOException{
        System.out.println("display answer " + answerType);
        request.setAttribute("answerType", answerType);
        RequestDispatcher rd = request.getRequestDispatcher("/createQuestion.jsp");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void addTextQuestion(HttpServletRequest request, HttpServletResponse response) {
       String questionText = (String)request.getParameter("question");
       String correctAnswerText = (String)request.getParameter("answer");
       System.out.println("Textbox Question Added");
       ModelCreateQuiz.addTextQuestion(questionText, correctAnswerText);
       //add question is static, trying out static model
    }

    private void addMultiChoiceQuestion(HttpServletRequest request, HttpServletResponse response) {
        String questionText = (String)request.getParameter("question");
        String[] answerArray = request.getParameterValues("answer");
        int numberOfAnswers = (int)request.getParameterValues("answer").length;
        String[] correctAnswerArray = request.getParameterValues("correctAnswer");
        System.out.println("Multichoice Question Added");
        ModelCreateQuiz.addMultiAnswerQuestion(questionText, 
                answerArray, numberOfAnswers, correctAnswerArray);
        
       
        for(int i = 0; i < request.getParameterValues("answer").length; i++)
            if(answerArray[i] != "")
                System.out.println("Answers: " + answerArray[i]);
        for(int i = 0; i < request.getParameterValues("correctAnswer").length; i++)
            System.out.println("Correct Answer?: " + correctAnswerArray[i]);
        
    }

}
