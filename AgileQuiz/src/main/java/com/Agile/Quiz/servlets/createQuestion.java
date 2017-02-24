/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Agile.Quiz.stores.storeQuestion;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JoeDavis
 */
@WebServlet(name = "createQuestion", urlPatterns = {"/createQuestion"})
public class createQuestion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet createQuestion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createQuestion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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
        
        response.sendRedirect("/AgileQuiz/createQuestion.jsp");
        
        
        //processRequest(request, response);
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
