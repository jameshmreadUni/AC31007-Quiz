/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.lib.Database;
import com.Agile.Quiz.stores.DBQuestionBean;
import com.Agile.Quiz.stores.QuestionBean;
import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author jamesread
 */
public class ModelQuiz {
    
    public LinkedList<QuestionBean> getQuestions(String quizName){
        
        Database db = new Database();
                
        
        String quizID = db.selectQuizID(quizName); 
        System.out.println(quizID);
        
        
        String[] questionText;
        String[] questionID;
        String[] answerText;

        
        
        
        int numberOfQuestions = db.getQuestionsNumbers(quizID);
        int numberOfAnswers = db.getAnswerNumbers("1000");
         QuestionBean questions;
        
        questionText = new String[numberOfQuestions];
        questionID = new String[numberOfQuestions];
        answerText = new String[numberOfAnswers];
        questions = db.selectQuestionText(quizID, numberOfQuestions, numberOfAnswers);
        
        for(int i = 0; i< numberOfQuestions; i++){
        
            questionText[i] = questions.getQuestionText()[i];
            questionID[i] = questions.getQuestionID()[i];
            
            for(int j=0; j<numberOfAnswers; j++){
               
                questions.setAnswerText((db.selectAnswerText(questionID[i], numberOfAnswers)[j]), j);
                
            
            }
        
        }
        
        
        
        //database connection, return info using quiz name
        //select all questions, answers from quizName
        //int numberOfAnswers = 5;
        String answerType = "radio";
        
        
        
        
        
        LinkedList<QuestionBean> question = new LinkedList<>();
        QuestionBean questionBean;
        
        //this loop will go through the questions for a quiz and put the result into the Question bean
        //the list of these beans will then be exported to the controller-->view
        for(int i = 0; i < numberOfQuestions; i++){
            questionBean = new QuestionBean(numberOfQuestions,numberOfAnswers);
            questionBean.setQuestionText(questionText[i], i);
            questionBean.setQuestionNumber(i);
            questionBean.setAnswerType(answerType);
            //the I/j values need to be replaced with values appropriate to the content of the DB
            for(int j = 0; j < numberOfAnswers; j++)
                questionBean.setAnswerText(answerText[j], j);
            
            question.add(questionBean);
        }
        //TODO implement database stuff
        return question;
    }
}
