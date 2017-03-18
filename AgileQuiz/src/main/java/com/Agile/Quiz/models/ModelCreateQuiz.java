/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.lib.Database;
import com.Agile.Quiz.stores.QuestionBean;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author James Read
 */
public class ModelCreateQuiz {
    
    //LinkedList<QuestionBean> quiz = new LinkedList<>();
    
    

    
    
    public static boolean addTextQuestion(String questionText, 
            String answerText, int questionNumber, String quizName){
       //TODO DB STUFF
        /*
       QuestionBean question = new QuestionBean(1);
       question.setQuestionText(questionText);
       question.setAnswerText(correctAnswerText, 0);
        */
        boolean inserted = true;
        return inserted;
    }
    
    public static boolean addMultiAnswerQuestion(String questionText, 
        String[] inputAnswerArray, 
        String[] correctAnswerArray, int questionNumber, String quizName){
        
        LinkedList<String> answerList = new LinkedList<>();
        //this new answer array eliminates the spaces in the returned array of
        //inputed answers to avoid an empty answer
         for(int i = 0; i < inputAnswerArray.length; i++)
            if(!inputAnswerArray[i].equals(""))
                 answerList.add(inputAnswerArray[i]);
        //////// 
         System.out.println("Question Number: " + questionNumber);
         Database db = new Database();
         String quizID = db.selectQuizID(quizName);
         try
         {
             System.out.println("Lets try inserting a question");
            db.insertQuestion(quizID, questionText, answerList);
         } 
         catch (SQLException ex)
         {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
         }
       
         //TODO DB STUFF
         boolean inserted = true;
        return inserted;
            
    }
    
        public void addQuiz(String quizName){
    
            Database db = new Database(); 
            db.insertQuiz(quizName);
      
    }
    
    
    
    public static boolean addQuizToDB(LinkedList<QuestionBean> questionList){
        //TODO DB stuff
        return true;
    }

    public boolean toggleAvailability(String available){
        //DB stuff
        return available.equalsIgnoreCase("on");
    }
}
