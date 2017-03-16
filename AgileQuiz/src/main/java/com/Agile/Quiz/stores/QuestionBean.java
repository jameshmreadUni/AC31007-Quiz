/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.stores;

import java.util.LinkedList;

/**
 *
 * @author jamesread
 */
public class QuestionBean {
    private String questionID;
    private String questionText;
    private LinkedList<String> answerText;
    private String quizName; //the quiz from which this question set is returned from
    private int questionNumber;
    private String answerType;
    //constructor initialises the size of the array of questions upon creation
    public QuestionBean(){
        answerText = new LinkedList<>();
       /*
        this.questionText = "Question 1: Who is president?";
       this.answerText[0] = "A: Donald Trump";
        this.answerText[1] = "B: Obama";
       this.quizName = "Current President Challenge";
       this.questionNumber = 1;
        */
    }
   /**
     * @return the questionID
     */
    public String getQuestionID() {
        return questionID;
    }

    /**
     * @param questionID the questionID to set
     */
    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    /**
     * @return the questionText
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * @param questionText the questionText to set
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    
    public void setAnswerText(LinkedList<String> answerText){
        this.answerText = answerText; 
    }
    
    public LinkedList<String> getAnswerText(){
        return this.answerText;
    }
    
    public void setQuizName(String name){
        this.quizName = name;
    }
    public String getQuizName(){
        return this.quizName;
    }
    
    public void setQuestionNumber(int questionNumber){
        this.questionNumber = questionNumber;
    }
    public int getQuestionNumber(){
        return this.questionNumber;
    }
    
    public void setAnswerType(String type){
        this.answerType = type;
    }
    
    public String getAnswerType(){
        return this.answerType;
    }
}
