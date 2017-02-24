/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.stores;

/**
 *
 * @author JoeDavis
 */
public class storeQuestion {
    
    private String Question = null;
    private String Answer1 = null;
    private String Answer2 = null;
    private String Answer3 = null;
    private String Answer4 = null;
    private String correctAnswer = null;
    
    public void setQuestion(String question) {
        this.Question = question;
    }

    public String getQuestion() {
        return Question;
        
    }
    
    public void setAnswer1(String answer1) {
        this.Answer1 = answer1;
    }

    public String getAnswer1() {
        return Answer1;
        
    }
    
    public void setAnswer2(String answer2) {
        this.Answer2 = answer2;
    }

    public String getAnswer2() {
        return Answer2;
        
    }
    
    public void setAnswer3(String answer3) {
        this.Answer3 = answer3;
    }

    public String getAnswer3() {
        return Answer3;
        
    }
    
    public void setAnswer4(String answer4) {
        this.Answer4 = answer4;
    }

    public String getAnswer4() {
        return Answer4;
        
    }
    
    public void setCorrectAnswer(String correct) {
        this.correctAnswer = correct;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
        
    }
    
}
