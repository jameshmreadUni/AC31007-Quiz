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
        int numberOfQuestions = 4;
        int numberOfAnswers = 5;
        String answerType = "radio";
        
        LinkedList<QuestionBean> question = new LinkedList<>();
        QuestionBean questionBean;
        
        //this loop will go through the questions for a quiz and put the result into the Question bean
        //the list of these beans will then be exported to the controller-->view
        String questionText = "Placeholder Question Text";
        String answerText = "Answer";
        
        for(int i = 0; i < numberOfQuestions; i++){
            questionBean = new QuestionBean(numberOfAnswers);
            questionBean.setQuestionText(questionText);
            questionBean.setQuestionNumber(i);
            questionBean.setAnswerType(answerType);
            //the I/j values need to be replaced with values appropriate to the content of the DB
            for(int j = 0; j < numberOfAnswers; j++)
                questionBean.setAnswerText(answerText, j);
            
            question.add(questionBean);
        }
        //TODO implement database stuff
        //will need to fill  the question.getfield;
        return question;
    }
}
