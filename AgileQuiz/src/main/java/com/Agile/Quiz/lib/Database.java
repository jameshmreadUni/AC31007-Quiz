/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.lib;
import com.Agile.Quiz.stores.DBQuestionBean;
import java.sql.*;  

/**
 *
 * @author seanstewart
 */
public class Database {
    
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
        if(conn!=null)
            conn.close(); System.out.println("Closed");

    }catch (SQLException ex){
       System.out.println("SQLException: " + ex.getMessage());
       System.out.println("SQLState: " + ex.getSQLState());
       System.out.println("VendorError: " + ex.getErrorCode());
    }
    return conn; 
    }


    public String selectQuizID(String quizName){
    //Return the quizID for a specfic quiz title
    System.out.println("--- SELECT QUIZ ID ---");
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
        } finally {
  
        conn = this.closeConnection(); 
       
        }
        return quizid; 
    }



    public int getQuestionsNumbers(String quizID){
    //Return the total number of questions for a specfic quizID 
        System.out.println("--- GET NUMBER OF QUESTIONS ---");
        PreparedStatement ps = null; 
        int numberofquestions = 0;
        
        String text = "SELECT COUNT(*) FROM question WHERE quizID = ?";
        
        try{
           conn = this.establishConnection();
           System.out.println("Conn: " + conn);
           ps = conn.prepareStatement(text);
           ps.setString(1, quizID);
           System.out.println(ps);
           System.out.println(quizID);
           ResultSet rs = ps.executeQuery();
           System.out.println(rs);
           while (rs.next()) {
               
                numberofquestions = rs.getInt("COUNT(*)");
                System.out.println("Num of Qs : " + numberofquestions);
            }

        }catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
  
        conn = this.closeConnection(); 
       
        }

       
        return numberofquestions; 
    }
    public int getAnswerNumbers(int questionID){
    //Return the total number of answers for a specfic questionID
        System.out.println("--- GET NUMBER OF ANSWERS ---");
        PreparedStatement ps = null; 
        int numberofanswers = 0;
        
        String text = "SELECT COUNT(*) FROM answer WHERE questionID = ?";
        
        try{
           conn = this.establishConnection();
           System.out.println("Conn: " + conn);
           ps = conn.prepareStatement(text);
           ps.setInt(1, questionID);
           System.out.println(ps);
           System.out.println(questionID);
           ResultSet rs = ps.executeQuery();
           System.out.println(rs);
           while (rs.next()) {
               
                numberofanswers = rs.getInt("COUNT(*)");
                System.out.println("numberofanswers : " + numberofanswers);
            }

        }catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
  
        conn = this.closeConnection(); 
       
        }
       
        return numberofanswers; 
    }
    
    public DBQuestionBean selectQuestionText(String quizID, int numberofQuestions){
        System.out.println("--- SELECT QUESTION TEXT ---"); 
        
        DBQuestionBean questions = new DBQuestionBean(numberofQuestions); 
        
        
        
        String questionText[];
        String questionID[];
        questionText = new String[numberofQuestions];
        questionID = new String[numberofQuestions];
        PreparedStatement ps = null;
        int i = 0; 
        String text = "SELECT questionID,questionText FROM question WHERE quizID = ?";
        
        try{
           conn = this.establishConnection();
           System.out.println("Conn: " + conn);
           ps = conn.prepareStatement(text);
           ps.setString(1, quizID);
           System.out.println(ps);
           System.out.println(quizID);
           ResultSet rs = ps.executeQuery();
           System.out.println(rs);
           while (rs.next()) {
                questionText[i] = rs.getString("questionText");
                questionID[i] = rs.getString("questionID");
                System.out.println("questionText: " + questionText[i]);
                System.out.println("questionID: " + questionID[i]);
                i++; 
            }

           for (int j = 0; j < numberofQuestions; j++){
           
               questions.setQuestionID(questionID[j], j);
               questions.setQuestionText(questionText[j], j);
               System.out.println("Information Set");
           
           }
                      
        }catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
  
        conn = this.closeConnection(); 
       
        }
       
        
        return questions; 
    }
      
     public String[] selectAnswerText(String questionID, int numberofanswers){
        System.out.println("--- SELECT ANSWER TEXT ---"); 
        
        
        String answertext[];
        answertext = new String[numberofanswers]; 
        PreparedStatement ps = null;
        int i = 0;
        String text = "SELECT answerText FROM answer WHERE questionID = ?";
        
        try{
           conn = this.establishConnection();
           System.out.println("Conn: " + conn);
           ps = conn.prepareStatement(text);
           ps.setString(1, questionID);
           System.out.println(ps);
           System.out.println(questionID);
           ResultSet rs = ps.executeQuery();
           System.out.println(rs);
           while (rs.next()) {
                answertext[i] = rs.getString("answerText");
                System.out.println("Answer : " + answertext[i]);
                i++;
            }

        }catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
  
        conn = this.closeConnection(); 
       
        }
       
        
        return answertext; 
    }
    
}