/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.lib.Database;
import com.Agile.Quiz.stores.QuestionBean;
import java.sql.*;
import java.util.LinkedList;

/**
 *
 * @author jamesread
 * this model returns the requested quiz
 */
public class ModelQuiz {
    
    public LinkedList<QuestionBean> getQuestions(String quizName){
        
        Database db = new Database();
        
        
        //What we need
        
        //Return the quizid for the matching quiz title and module
        //Return the total number of questions for that quizid (Could maybe be done with an array and use the length?)
        //Select all the questions from that quiz
        //Return the number of answers for each question.(Could maybe be done with an array and use the length?)
        //Return the answers for each question
        
        //Use a question bean to return question details
        //Use an array to return the question details
        
        
        
        String quizID = db.selectQuizID(quizName); 
        System.out.println(quizID);
        int numberOfQuestions = db.getQuestionsNumbers(quizID);
        int numberOfAnswers = db.getAnswerNumbers(1000);
        
        //database connection, return info using quiz name
        //select all questions, answers from quizName
        //int numberOfAnswers = 5;
        String answerType = "radio";
        String questionText = db.selectQuestionText(quizID);
        String answerText[] = db.selectAnswerText("1000", numberOfAnswers);
        
        LinkedList<QuestionBean> question = new LinkedList<>();
        QuestionBean questionBean;
        
        //this loop will go through the questions for a quiz and put the result into the Question bean
        //the list of these beans will then be exported to the controller-->view
        for(int i = 0; i < numberOfQuestions; i++){
            questionBean = new QuestionBean(numberOfAnswers);
            questionBean.setQuestionText(questionText);
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
