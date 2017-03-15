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
public class QuestionBean {
    private String questionID[];
    private String[] questionText;
    private String[] answerText;
    private String quizName; //the quiz from which this question set is returned from
    private int questionNumber;
    private String answerType;
    //constructor initialises the size of the array of questions upon creation
    public QuestionBean(int numberOfQuestions,int numberOfAnswers){
        answerText = new String[numberOfAnswers];
        questionText = new String[numberOfQuestions];
        questionID = new String[numberOfQuestions];
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
    public String[] getQuestionID() {
        return questionID;
    }

    /**
     * @param questionID the questionID to set
     */
    public void setQuestionID(String questionID, int questionNumber) {
        this.questionID[questionNumber] = questionID;
    }

    /**
     * @return the questionText
     */
    public String[] getQuestionText() {
        return questionText;
    }

    /**
     * @param questionText the questionText to set
     */
    public void setQuestionText(String questionText, int questionNumber) {
        this.questionText[questionNumber] = questionText;
    }
    
    public void setAnswerText(String answerText, int answerNumber){
        this.answerText[answerNumber] = answerText;
    }
    
    public String[] getAnswerText(){
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
