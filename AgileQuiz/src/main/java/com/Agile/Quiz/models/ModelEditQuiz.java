/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import java.sql.PreparedStatement;

/**
 *
 * @author gemmawhyte 
 */
public class ModelEditQuiz {
    
    public void updateQuizTitle(String newQuizName) {
        
//        PreparedStatement ps = session.prepare("UPDATE quiz set quizname= ? WHERE login= ?");
//        BoundStatement bs = new BoundStatement(ps);
//        session.execute(bs.bind(newQuizName));
        
        
    }
    
    public String getQuizTitle(){
        // TODO: Get quiz title from database
        String testquiztitle = "james";
        return testquiztitle;
    }
    
    /**
 *
 * @author Brian Stevenson
 */
    
    //Method to edit the context of an answer
    public String editQuizAnswer(){
        
        String quizAnswer = "Sean";
        //wtf do I do? :( 
        return quizAnswer;
        
    }
    
    //Method to delete an answer from a quiz
    public String removeQuizAnswer(){
        
        return null;
    }
    
    
    //Method to add an answer to the quiz
    public String addQuizAnswer(){
        
        return null;
        
    }
    
    
}
