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
    Connection conn = null;
    
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("test");
        } catch (Exception ex) {
            // handle the error
        }
        
        
    

    try {
       conn =
          DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk/16agileteam4db?" +
                                      "user=16agileteam4&password=9348.at4.8439");

       // Do something with the Connection
       
       return conn; 


   } catch (SQLException ex) {
       // handle any errors
       System.out.println("SQLException: " + ex.getMessage());
       System.out.println("SQLState: " + ex.getSQLState());
       System.out.println("VendorError: " + ex.getErrorCode());
   }
    
    return conn;
    
    }



    }

