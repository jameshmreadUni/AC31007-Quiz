/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.lib.Database;
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
                    
        //database connection, return info using quiz name
        //select all questions, answers from quizName
        //int numberOfAnswers = 5;
        String answerType = "radio";
        
        Database db = new Database();

        String quizID = db.selectQuizID(quizName); 
   
        LinkedList<QuestionBean> questions = new LinkedList<>(); 
        
        questions = db.selectQuestionText(quizID);
        
        
        
        LinkedList<QuestionBean> question = new LinkedList<>();
        QuestionBean questionBean;
        
        return questions;
    }
}
