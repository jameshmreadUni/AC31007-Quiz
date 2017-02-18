/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.stores.QuestionBean;
import java.util.LinkedList;

/**
 *
 * @author jamesread
 */
public class ModelQuiz {
    
    public LinkedList<QuestionBean> getQuestions(String quizName){
        //database connection, return info using quiz name
        //select all questions, answers from quizName
        int numberOfRowsReturned = 4;
        LinkedList<QuestionBean> question = new LinkedList<>();
        QuestionBean questionBean;
        
        //this loop will go through the questions for a quiz and put the result into the Question bean
        //the list of these beans will then be exported to the controller-->view
        for(int i = 0; i < numberOfRowsReturned; i++){
            questionBean = new QuestionBean(numberOfRowsReturned);
            question.add(questionBean);
        }
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
