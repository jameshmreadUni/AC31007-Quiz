/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

/**
 *
 * @author jamesread
 */
public class ModelQuiz {
    
    public String[] getQuestions(String quizName){
        String[] question = new String[3]; 
        question[0] = "Question 1"; 
        question[1] = "Question 2";
        question[2] = "Question 3";
        return question;
    }
    public String[] getAnswers(String quizName){
        String[] answer = new String[3]; 
        answer[0] = "Answer A"; 
        answer[1] = "Answer B";
        answer[2] = "Answer C";
        return answer;
    }
}
