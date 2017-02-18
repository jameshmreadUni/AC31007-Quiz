/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.servlets;

import com.Agile.Quiz.lib.Convertors;
import com.Agile.Quiz.models.ModelQuiz;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jamesread
 */
@WebServlet(name = "Quiz", urlPatterns = {"/Quiz"})


public class Quiz extends HttpServlet {
    
    
     private HashMap CommandsMap = new HashMap();
    
    

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz() {
        super();
        CommandsMap.put("Quiz", 1);

    }

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        //cluster = CassandraHosts.getCluster();
    }

   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. 
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String args[] = Convertors.SplitRequestPath(request);
        int command;
        try {
            command = (Integer) CommandsMap.get(args[1]);
        } catch (Exception et) {
            return;
        }
        switch (command) {
            case 1:
                System.out.println("QUIZ URL CAPTURED");
               getQuiz(request, response, null);
                break;
            default:
               
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
        System.out.println("POST");
    }

    
    private void getQuiz(HttpServletRequest request, HttpServletResponse response, String quizName) throws ServletException, IOException{
        ModelQuiz modelQuestions = new ModelQuiz();
        
        //modelQuestions.getAnswers(quizName);
        modelQuestions.getQuestions(quizName);
        
        RequestDispatcher rd = request.getRequestDispatcher("/quizPage.jsp");
        //request.setAttribute("answers", modelQuestions.getAnswers(quizName));
        request.setAttribute("question", modelQuestions.getQuestions(quizName));
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

}
