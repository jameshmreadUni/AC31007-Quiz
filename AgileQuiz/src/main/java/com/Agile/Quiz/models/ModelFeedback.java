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
      
        String[] questions = {"question1", "question2", "question3"};
        String[] correctAnswers = {"correct1","correct2","correct3"};
        String[] questionExplanations = {"explanation1", "explanation2", "explanation3"};
        String module = "Module A";
        int score = 2;
        
        Database db = new Database();
        
        
        QuizResultBean quizResult = new QuizResultBean();
        quizResult.setQuizName(quizName);
        quizResult.setQuizModule(module);
        quizResult.setCorrectAnswers(correctAnswers);
        quizResult.setQuestions(questions);
        quizResult.setQuestionExplanations(questionExplanations);
        quizResult.setCorrectAnswers(correctAnswers);
        quizResult.setScore(score);
        
        //return db.selectFeedback(quizName);
        return quizFeedback;
    }
}
