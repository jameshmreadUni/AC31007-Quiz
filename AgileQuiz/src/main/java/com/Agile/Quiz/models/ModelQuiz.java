/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.lib.Database;
import com.Agile.Quiz.stores.ModuleBean;
import com.Agile.Quiz.stores.QuestionBean;
import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author jamesread
 * this model returns the requested quiz
 */
public class ModelQuiz {
    
    public LinkedList<QuestionBean> getQuestions(String quizName){
                    
        //database connection, return info using quiz name
        //select all questions, answers from quizName
        //int numberOfAnswers = 5;
        String answerType = "radio"; 
        //dummy data as DB does not have 'answer type collumn'
        LinkedList<QuestionBean> questions = new LinkedList<>();
        
        
        try{
        Database db = new Database();
        String quizID = db.selectQuizID(quizName);
        questions = db.selectQuestionText(quizID);
        }catch (Exception e){
            return questions;
        }
        
        return questions;
    }
    
    public LinkedList<ModuleBean> getModules(){
    
    LinkedList<ModuleBean> moduleList = new LinkedList<>();
    
    try{
        Database db = new Database();
        moduleList = db.selectQuizes();
    } catch (Exception e) {
        return moduleList; 
    }
     return moduleList; 
    }
    
    
}
