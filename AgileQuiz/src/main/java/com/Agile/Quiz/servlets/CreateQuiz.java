/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.servlets;

import com.Agile.Quiz.lib.Convertors;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Agile.Quiz.stores.storeQuestion;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JoeDavis
 */
@WebServlet(name = "CreateQuiz", urlPatterns = {"/CreateQuiz"})
public class CreateQuiz extends HttpServlet {

      private final HashMap CommandsMap = new HashMap();
      
      
      /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateQuiz() {
        super();
        CommandsMap.put("CreateQuiz", 1);

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
        
        String args[] = Convertors.SplitRequestPath(request);
        int command;
        try {
            command = (Integer) CommandsMap.get(args[1]);
        } catch (Exception et) {
            return;
        }
        switch (command) {
            case 1:
                RequestDispatcher rd = request.getRequestDispatcher("/createQuiz.jsp");
                rd.forward(request, response);
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
        
        HttpSession session;
        session = request.getSession();
        
        // Get the valiues of the question and the answers.
        String question=request.getParameter("question");
        String answer1=request.getParameter("answer1");
        String answer2=request.getParameter("answer2");
        String answer3=request.getParameter("answer3");
        String answer4=request.getParameter("answer4");
        
        // Store the question and answers into the question Store.
        storeQuestion storequestion;
        storequestion = new storeQuestion();
        storequestion.setQuestion(question);
        storequestion.setAnswer1(answer1);
        storequestion.setAnswer2(answer2);
        storequestion.setAnswer3(answer3);
        storequestion.setAnswer4(answer4);
        session.setAttribute("storeQuestion", storequestion);
        
        // Get the value of which one is the right answer (radio buttons).
        String correctAnswer = request.getParameter("correctAnswer");
        if (null != correctAnswer){
            switch (correctAnswer) {
                case "correct1":
                    correctAnswer = answer1;
                    break;
                case "correct2":
                    correctAnswer = answer2;
                    break;
                case "correct3":
                    correctAnswer = answer3;
                    break;
                case "correct4":
                    correctAnswer = answer4;
                    break;
            }
            
            storequestion.setCorrectAnswer(correctAnswer);
        }
        
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

}
