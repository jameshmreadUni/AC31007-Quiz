/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.stores.QuestionBean;

/**
 *
 * @author James Read
 */
public class ModelCreateQuiz {
    
    public static void addTextQuestion(String questionText, String answerText){
        //TODO add into DB
        /*
       QuestionBean question = new QuestionBean(1);
       question.setQuestionText(questionText);
       question.setAnswerText(correctAnswerText, 0);
        */
    }
    
    public static void addMultiAnswerQuestion(String questionText, 
        String[] inputAnswerArray, int numberOfAnswers, String[] correctAnswerArray){
        
        String[] answerArray = new String[numberOfAnswers];
        //this new answer array eliminates the spaces in the returned array of
        //inputed answers to avoid an empty answer
         for(int i = 0; i < answerArray.length; i++)
            if(!inputAnswerArray[i].equals(""))
                 answerArray[i] = inputAnswerArray[i];
//TODO ADD DB STUFF
        /*
        QuestionBean question = new QuestionBean(numberOfAnswers);
        question.setQuestionText(questionText);
        
        for(int i = 0; i < numberOfAnswers; i++)
            question.setAnswerText(answerArray[i], i);
            */
    }

}
