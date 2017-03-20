/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.lib.Database;
import com.Agile.Quiz.stores.QuestionBean;
import com.Agile.Quiz.stores.QuizResultBean;
import java.util.LinkedList;

/**
 *
 * @author jamesread
 */
public class ModelFeedback {
    public LinkedList<QuestionBean> getFeedback(String quizName){
        //TODO database stuff      
       LinkedList<QuestionBean> quizFeedback = new LinkedList<>();
      
//        String questions = "Question TEXT";
//        String[] correctAnswers = {"correct1","correct2","correct3"};
//        String questionExplanations = "Explanation of answer";
//        String module = "Module A";
//        int score = 2;
        
        Database db = new Database();
        
        
//        QuestionBean quizResult = new QuestionBean();
//        quizResult.setQuizName(quizName);
//        quizResult.setCorrectAnswers(correctAnswers);
//        quizResult.setQuestionText(questions);
//        quizResult.setExplanation(questionExplanations);
//        quizResult.setCorrectAnswers(correctAnswers);
        
        //quizFeedback.add(quizResult);
        return db.selectFeedback(quizName);
        //return quizFeedback;
    }
}
