/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.stores;

/**
 *
 * @author seanstewart
 */
public class DBQuestionBean {
    
    private String questionID[];
    private String questionText[]; 
    
    
    public DBQuestionBean(int numberOfQuestions){
        questionText = new String[numberOfQuestions];
        questionID = new String[numberOfQuestions];

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
    
    
    
}
