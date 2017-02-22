/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.servlets;

import com.Agile.Quiz.models.ModelStaffUser;
import com.Agile.Quiz.stores.loginBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Brian
 */

@WebServlet(name = "staffLogin", urlPatterns = {"/Login","/login","/staffLogin","/stafflogin", "/Stafflogin","/StaffLogin", "/Login/*"})

public class staffLogin {
  
    public staffLogin(){
//super();
        
}

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
   // @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
    
    }
    
   // @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = (String)request.getParameter("username");
       
        String password = request.getParameter("password");

// need a user model with placeholder
        ModelStaffUser us = new ModelStaffUser();
        boolean isValid = us.IsValidUser(username, password);
        HttpSession session = request.getSession();
        System.out.println("Session in servlet " + session);
        if (isValid) {
            loginBean lg = new loginBean();
            lg.setLoginState();
            lg.setUsername(username);


            session.setAttribute("loginBean", lg);
// This Will be the page that the login redipaches to once a vaild login is accheved
           System.out.println("Session in servlet " + session);
           // ProfileStore ps = new ProfileStore();
           // ps.setUUID(us.selectProfilePic(username));
            //session.setAttribute("profilepic", ps);
           RequestDispatcher rd = request.getRequestDispatcher("index.html");
           rd.forward(request, response);

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    //@Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

