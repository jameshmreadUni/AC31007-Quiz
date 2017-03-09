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
    private String questionText;
    private String[] answerText;
    private String quizName; //the quiz from which this question set is returned from
    private int questionNumber;
    private String answerType;
    private String explanation;
    //constructor initialises the size of the array of questions upon creation
    public QuestionBean(int numberOfAnswers){
        answerText = new String[numberOfAnswers];
       /*
        this.questionText = "Question 1: Who is president?";
       this.answerText[0] = "A: Donald Trump";
        this.answerText[1] = "B: Obama";
       this.quizName = "Current President Challenge";
       this.questionNumber = 1;
        */
    }
    
    public void setQuestionText(String questionText){
        this.questionText = questionText;
    }
    
    public String getQuestionText(){
        return this.questionText;
    }
    
    public String getExplanation()
    {
        return this.explanation;
    }
    
    public void setExplanation(String explain)
    {
        explanation = explain;
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
