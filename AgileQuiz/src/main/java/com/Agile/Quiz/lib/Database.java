/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.lib;
import com.Agile.Quiz.stores.QuestionBean;
import java.sql.*;  
import java.util.LinkedList;

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
    
    public LinkedList<QuestionBean> selectQuestionText(String quizID){
        System.out.println("--- SELECT QUESTION TEXT ---"); 
        
        LinkedList<QuestionBean> questions = new LinkedList<>(); 
                
        
        PreparedStatement ps = null;
       
        String text = "SELECT questionID,questionText, answerType FROM question WHERE quizID = ?";
        
        try{
           conn = this.establishConnection();
           System.out.println("Conn: " + conn);
           ps = conn.prepareStatement(text);
           ps.setString(1, quizID);
           System.out.println(ps);
           System.out.println(quizID);
           ResultSet rs = ps.executeQuery();
           System.out.println(rs);
           
           QuestionBean question; 
           while (rs.next()) {
               question = new QuestionBean(); 
               question.setQuestionID(rs.getString("questionID"));
               question.setQuestionText(rs.getString("questionText"));
               question.setAnswerText(this.selectAnswerText(rs.getString("questionID")));
               question.setAnswerType(rs.getString("answerType"));
               questions.add(question);
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
      
     public LinkedList<String> selectAnswerText(String questionID){
        System.out.println("--- SELECT ANSWER TEXT ---"); 
        
        
        LinkedList<String> answerText = new LinkedList<>();
        PreparedStatement ps = null;
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
               
               answerText.add(rs.getString("answerText"));
             
            }

        }catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
  
        conn = this.closeConnection(); 
       
        }
       
        
        return answerText; 
    }

    public void insertQuiz(String quizName) {
       System.out.println("------INSERT QUIZ------");
       
       String quizID = null;
       //String questionID = null;
       
       try{
       conn = this.establishConnection();
       String storedprocedure = "{CALL createQuiz(?,?)}";
       CallableStatement stmt = conn.prepareCall(storedprocedure);
       stmt.setString(1,quizName);
       stmt.setString(2, "MODTEST");
       
       ResultSet rs = stmt.executeQuery();
       while (rs.next()){
           quizID = rs.getString("quizID");
           
       }
             
    } catch (SQLException ex) {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());

    } finally {

        conn = this.closeConnection(); 

    }
             
    }

    public void insertQuestion(String quizID, String questionText, LinkedList<String> answerList) throws SQLException {
        System.out.println("Insert Question");
        try{
            conn = this.establishConnection();          
            String storedprocedure = "{CALL createQuestion(?,?,?,?)}";
            CallableStatement stmt = conn.prepareCall(storedprocedure);
            stmt.setString(1, quizID);
            stmt.setString(2, questionText);
            stmt.setString(3, "test");
            stmt.setString(4, "radio");
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                String questionID = rs.getString("questionID");
                    insertAnswer(answerList, questionID);
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        
        } finally {
            conn = this.closeConnection();
        
        }
    }

    public void insertAnswer(LinkedList<String> answerList, String questionID) throws SQLException {
        
        try{
            conn = this.establishConnection(); 

            String text = ("INSERT INTO answer (answerText, questionID) VALUES (?,?)");
            PreparedStatement ps = conn.prepareStatement(text);

            for(int i = 0; i < answerList.size(); i++ ){
                ps.setString(1,answerList.get(i));
                ps.setString(2, questionID);
                ps.execute();
            } 
        } catch (SQLException ex) {
            // handle any errors
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
        
        } finally{
            conn = this.closeConnection();
        }
    }
    
}