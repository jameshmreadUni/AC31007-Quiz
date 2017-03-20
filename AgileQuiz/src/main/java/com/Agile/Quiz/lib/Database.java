/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.lib;
import com.Agile.Quiz.stores.AnswerBean;
import com.Agile.Quiz.stores.ModuleBean;
import com.Agile.Quiz.stores.QuestionBean;
import com.Agile.Quiz.stores.QuizResultBean;
import java.sql.*;  
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author seanstewart
 */

//This class contains all the database funcitonality code used for connecting between the 
public class Database {
    
    private Connection conn = null;
    
   
    public Connection establishConnection(){
    //This establishes the connection with the MySQL Database
        try {
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
        //This closes the connection if there is one.
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
        //Returns the questiosns and answers and stores them in a linked list of question beans
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
        //Returns all the answers for a specific question ID and stores them in a linked list of strings
        
        
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
       //Inserts a quiz into the Database
       String quizID = null;
       
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
    //also calls insertAnswer() below
    public void insertQuestion(String quizID, String questionText, LinkedList<AnswerBean> answerList, String correctAnswerArray) throws SQLException {
        //Inserts questions and the appropriate answers into the Database
        System.out.println("Insert Question");
        try{
            conn = this.establishConnection();          
            String storedprocedure = "{CALL createQuestion(?,?,?,?)}";
            
            int qID = Integer.parseInt(quizID);
        
            CallableStatement stmt = conn.prepareCall(storedprocedure);
            stmt.setInt(1, qID);
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
    //called by insertQuestion()
    public void insertAnswer(LinkedList<AnswerBean> answerList, String questionID) throws SQLException {
        //Inserts the answers into the database
        try{
            String text = ("INSERT INTO answer (answerText, questionID, correct) VALUES (?,?,?)");
            PreparedStatement ps = conn.prepareStatement(text);

            Iterator<AnswerBean> iterator;
            iterator = answerList.iterator();
            while (iterator.hasNext()) {
                AnswerBean answer = (AnswerBean)iterator.next();
                if(!answer.getAnswerText().isEmpty()){
                    ps.setString(1,answer.getAnswerText());
                    ps.setString(2,questionID);
                    if(answer.isCorrectAnswer()){
                       ps.setInt(3, 1);
                    } else {
                       ps.setInt(3, 0);
                    }
                    ps.execute();
                }
            }             
        } catch (SQLException ex) {
            // handle any errors
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
        
        }
    }
    
    
    public void updateAvailability(String quizName){
        //Updates a specific quiz so that the quiz is available
        try{
            
            conn = this.establishConnection();

            String text = "UPDATE quiz SET availability = ? WHERE quizName = ?";
            PreparedStatement ps = null;
            ps = conn.prepareStatement(text);
            ps.setInt(1, 1);
            ps.setString(1, quizName);
            ps.execute(); 
        

        } catch (SQLException ex){
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
                  
        } finally {
        
            conn = this.closeConnection(); 
            
        }   
    
    }
    
    
    public LinkedList<ModuleBean> selectQuizes(){
    //Returns all the modules and Quizzes in a linked list of ModuleBeans
        LinkedList<ModuleBean> moduleList = new LinkedList<>();
        
        try{
            conn = this.establishConnection();
            
            ModuleBean module;
            PreparedStatement ps = null;
            PreparedStatement ps2 = null;
      
            String statement1 = "SELECT * FROM module";

            
            ps = conn.prepareStatement(statement1);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                module = new ModuleBean(); 
                module.setModuleCode(rs.getString("moduleCode"));
                System.out.println(rs.getString("moduleCode"));
                module.setModuleName(rs.getString("moduleName"));
                System.out.println(rs.getString("moduleName"));
                
                module.setQuizName(this.selectQuestionName(rs.getString("moduleCode")));

                moduleList.add(module);                
            }
 
            
        }catch(SQLException ex){
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
            
        }finally{
            conn = this.closeConnection();
        }
    
    
     return moduleList; 
    }

    public LinkedList<String> selectQuestionName(String moduleCode) throws SQLException {
        //Selects all the quiz names and stores them in a linked list of strings.
        LinkedList<String> questionNames = new LinkedList<>();
        
        try{
                conn = this.establishConnection();
                 String statement = "SELECT quizName from quiz where moduleCode = ? "; 
                PreparedStatement ps = null;
                ps = conn.prepareStatement(statement);
                ps.setString(1, moduleCode);
                ResultSet result = ps.executeQuery();
                while (result.next()){
                    questionNames.add(result.getString("quizName"));
                }
        } catch (SQLException ex){
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
        
        } finally{ 
        
            conn = this.closeConnection();
        }
        
       return questionNames; 
    }
    
    public boolean checkUserDetails(String username, String password){
       //This checks if a user with that specific username and password exists. 
        boolean valid = false; 
        
        try{
            conn = this.establishConnection();
            String statement = "SELECT username, password FROM user where username = ? AND password = ?";
            PreparedStatement ps = null;
            ps = conn.prepareStatement(statement);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            valid = rs.isBeforeFirst();
        
        } catch (SQLException ex){
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
        }finally{
            conn = this.closeConnection();
        }
    
        return valid; 
    }
        
    public String selectUserType(String username, String password){
    //This returns the user's type from the database
        String userType = null;
        try{
            
            conn = this.establishConnection();
            String statement = "SELECT userType from user where username = ? and password = ?";
            PreparedStatement ps = null;
            
            ps = conn.prepareStatement(statement);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              userType = rs.getString("userType");  
 
            }
    
        }   catch (SQLException ex){
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
        
        }finally{
            conn = this.closeConnection();
        }
        
        return userType; 
    }
    
    public void registerUser(String username, String password){
     try {
         conn = this.establishConnection();
         
         String statement = "INSERT INTO user (username, password) VALUES (?,?)";
         
         PreparedStatement ps = conn.prepareStatement(statement);
         ps.setString(1, username);
         ps.setString(2, password);
         ps.execute();
     
     } catch (SQLException ex) {
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
     } finally {
         
      conn = this.closeConnection();
     } 
    }
     
     public void deleteQuiz(String quizName) {
        //This should delete a quiz and all associated questions/answers with it 
         try{
             conn = this.establishConnection();
             String statement = "DELETE FROM quiz WHERE quizName = ?";
             
             PreparedStatement ps = conn.prepareStatement(statement);
             ps.setString(1, quizName);
             ps.execute();
         
         
         } catch (SQLException ex){
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
         } finally {
             conn = this.closeConnection();
         }
     }  

    //DB command to return feedback to ModelFeedback
     public LinkedList<QuestionBean> selectFeedback(String quizName){
        //Returns the questiosns and answers and stores them in a linked list of question beans
        System.out.println("--- SELECT QUIZ FEEDBACK ---"); 
        
        LinkedList<QuestionBean> quizFeedback = new LinkedList<>();
        PreparedStatement ps = null;
        
        String quizID = this.selectQuizID(quizName);
        String text = "SELECT * FROM question LEFT JOIN answer ON answer.questionID = question.questionID WHERE answer.correct = 1 AND question.quizID = ? ORDER BY question.questionID ASC";
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
           LinkedList<String> answerText;
           while (rs.next()){
               question = new QuestionBean();
               answerText = new LinkedList<>();
               question.setQuestionText(rs.getString("questionText"));
               answerText.add(rs.getString("answerText"));
               question.setAnswerText(answerText);
               question.setAnswerType(rs.getString("answerType"));
               question.setExplanation(rs.getString("explanation"));
               //TODO set quiz title
               //the sql statement only returns the correct answers anyway
               quizFeedback.add(question);
            }
           
                      
        }catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
  
        conn = this.closeConnection(); 
       
        }
        return quizFeedback; 
    }
    
    
}
