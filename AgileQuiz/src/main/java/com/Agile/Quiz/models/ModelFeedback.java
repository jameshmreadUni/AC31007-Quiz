/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.stores.QuizResultBean;

/**
 *
 * @author jamesread
 */
public class ModelFeedback {
    public static QuizResultBean getFeedback(String quizName){
        //TODO database stuff
        
        String[] questions = {"question1", "question2", "question3"};
        String[] correctAnswers = {"correct1","correct2","correct3"};
        String[] questionExplanations = {"explanation1", "explanation2", "explanation3"};
        
        QuizResultBean quizResult = new QuizResultBean();
        quizResult.setQuizName(quizName);
        quizResult.setQuizModule("Module A");
        quizResult.setCorrectAnswers(correctAnswers);
        quizResult.setQuestions(questions);
        quizResult.setQuestionExplanations(questionExplanations);
        quizResult.setCorrectAnswers(correctAnswers);
        quizResult.setScore(2);
        
        return quizResult;
    }
}
