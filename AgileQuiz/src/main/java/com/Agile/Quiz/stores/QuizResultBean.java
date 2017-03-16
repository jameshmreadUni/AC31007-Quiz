/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.stores;

/**
 *
 * @author jamesread
 */
public class QuizResultBean {
    private String quizName;
    private String quizModule;
    private String[] questions;
    private String[] questionExplanations;
    
    private String[] correctAnswers; 
    //might have to be a string array of arrays due to multi correct answers...
    private int score;
    
    public QuizResultBean(){
        
    }
    
    /**
     * @return the quizName
     */
    public String getQuizName() {
        return quizName;
    }

    /**
     * @param quizName the quizName to set
     */
    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    /**
     * @return the quizModule
     */
    public String getQuizModule() {
        return quizModule;
    }

    /**
     * @param quizModule the quizModule to set
     */
    public void setQuizModule(String quizModule) {
        this.quizModule = quizModule;
    }

    /**
     * @return the questions
     */
    public String[] getQuestions() {
        return questions;
    }
    
    public String getQuestions(int i){
        return questions[i];
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    /**
     * @return the questionExplanations
     */
    public String[] getQuestionExplanations() {
        return questionExplanations;
    }
    
    public String getQuestionExplanations(int i){
        return questionExplanations[i];
    }

    /**
     * @param questionExplanations the questionExplanations to set
     */
    public void setQuestionExplanations(String[] questionExplanations) {
        this.questionExplanations = questionExplanations;
    }

    /**
     * @return the correctAnswers
     */
    public String[] getCorrectAnswers() {
        return correctAnswers;
    }
    
    public String getCorrectAnswers(int i){
        return correctAnswers[i];
    }

    /**
     * @param correctAnswers the correctAnswers to set
     */
    public void setCorrectAnswers(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
}
