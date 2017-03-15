/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.servlets;

import com.Agile.Quiz.models.ModelStaffUser;
import com.Agile.Quiz.stores.loginBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Brian
 */
@WebServlet(name = "Login", urlPatterns = {"/Login","/login","/staffLogin","/stafflogin", "/Stafflogin","/StaffLogin", "/Login/*"})


public class StaffLogin extends HttpServlet {

   
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
         RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
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

        String username = (String)request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        System.out.println(password);
// need a user model with placeholder

        ModelStaffUser us = new ModelStaffUser();

        HttpSession session = request.getSession();
        System.out.println("Session in servlet " + session);
        
        
        if (us.IsValidUser(username, password)) {
            loginBean lg = new loginBean();
            lg.setLoggedin();
            lg.setUsername(username);
            session.setAttribute("loginBean", lg);
            
            
            //If the login is successful, determine the users type
            //Call method to determine user's type.
            //
     
// This Will be the page that the login redipaches to once a vaild login is accheved
           System.out.println("Session in servlet " + session);


           RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
           rd.forward(request, response);

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
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
