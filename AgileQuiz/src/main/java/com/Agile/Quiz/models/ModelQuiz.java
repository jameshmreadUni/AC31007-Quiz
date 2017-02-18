/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.stores.QuestionBean;

/**
 *
 * @author jamesread
 */
public class ModelQuiz {
    
    public QuestionBean getQuestions(String quizName){
        //database connection, return info using quiz name
        int numberOfRowsReturned = 4;
        QuestionBean question = new QuestionBean(numberOfRowsReturned);
        //TODO implement database stuff
        //will need to fill  the question.getfield;
        return question;
    }
    //not sure ill need this
    public String[] getAnswers(String quizName){
        String[] answer = new String[3]; 
        answer[0] = "Answer A"; 
        answer[1] = "Answer B";
        answer[2] = "Answer C";
        return answer;
    }
}
