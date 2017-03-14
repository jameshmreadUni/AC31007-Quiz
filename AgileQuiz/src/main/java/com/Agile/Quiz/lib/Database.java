/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.lib;
import java.sql.*;  

/**
 *
 * @author seanstewart
 */
public class Database {
    
private String user = "16agileteam4";
private String pass = "9348.at4.8439";
private String dbClass = "com.mysql.jdbc.Driver";
private String dbDriver = "jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam4db";
private Connection conn = null;
    
   
public Connection establishConnection(){
    
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Connecting to DB");
        } catch (Exception ex) {
            // handle the error
            System.out.println(ex);
        }

    try {
       conn =
          DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk/16agileteam4db?" +
                                      "user=16agileteam4&password=9348.at4.8439");
   } catch (SQLException ex) {
       // handle any errors
       System.out.println("SQLException: " + ex.getMessage());
       System.out.println("SQLState: " + ex.getSQLState());
       System.out.println("VendorError: " + ex.getErrorCode());
   }
    
    return conn;
    
    }

public Connection closeConnection(){
    try{
        if(!conn.isClosed())
            conn.close(); System.out.println("Closed");

    }catch (SQLException ex){
       System.out.println("SQLException: " + ex.getMessage());
       System.out.println("SQLState: " + ex.getSQLState());
       System.out.println("VendorError: " + ex.getErrorCode());
    }
    return conn; 
    }


    public String selectQuizID(String quizName){
        String quizid = null; 
        PreparedStatement ps = null;
        String text = "SELECT * FROM quiz WHERE quizName = ?";
        
        try{
           conn = this.establishConnection();
           System.out.println("Conn: " + conn);
           ps = conn.prepareStatement(text);
           ps.setString(1, quizName);
           System.out.println(ps);
           System.out.println(quizName);
           ResultSet rs = ps.executeQuery();
           System.out.println(rs);
           while (rs.next()) {
               
                quizid = rs.getString("quizID");
                System.out.println("quizID : " + quizid);
            }

        }catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return quizid; 
    }
}