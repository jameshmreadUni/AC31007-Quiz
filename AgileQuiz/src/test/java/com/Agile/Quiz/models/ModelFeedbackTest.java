/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.lib.Database;
import com.Agile.Quiz.stores.AnswerBean;
import com.Agile.Quiz.stores.QuestionBean;
import com.Agile.Quiz.stores.QuizResultBean;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jamesread
 */
public class ModelFeedbackTest {
    String quizName = "ModelFeedbackQuizName";
    String quizID = "12345";
    String questionText = "Who designed test driven development?!";
    String[] correctAnswers = {"correct1", "correct2", "correct3"};
    LinkedList<AnswerBean> answerList = new LinkedList<>();
    LinkedList<String> setAnswerList = new LinkedList<>();
    
    String correctAnswerArray = "3";
    Database db = new Database();
    
    public ModelFeedbackTest() {
        AnswerBean answerBean;
        for(int i = 0; i < 4; i++){
            answerBean = new AnswerBean();
            answerBean.setAnswerText("Answer: " + i);
            if(i == 0) {
                answerBean.setCorrectAnswer(true);
                setAnswerList.add("Answer: " + i);
            }
            else answerBean.setCorrectAnswer(false);
            
            answerList.add(answerBean);
        }
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("SET UP testGetFeedback");
        
        db.insertQuiz(quizName);
        
        try{
            db.insertQuestion(db.selectQuizID(quizName), questionText, answerList, correctAnswerArray);
        }catch(Exception e){System.out.println("SETUP testGetfeedback: " + e);}
    }
    
    @After
    public void tearDown() {
        //TODO delete quiz (done in testDriven demo)
    }

    /**
     * Test of getFeedback method, of class ModelFeedback.
     */
    @Test
    public void testGetFeedback() {
        System.out.println("getFeedback");        
        ModelFeedback feedback = new ModelFeedback();
        QuestionBean expectedBean = new QuestionBean();
        
        expectedBean.setQuestionText(questionText);
        expectedBean.setExplanation("test");
        expectedBean.setCorrectAnswersFull(correctAnswers);
        expectedBean.setAnswerText(setAnswerList);
        LinkedList<QuestionBean> expResult = new LinkedList<>();
        expResult.add(expectedBean);
        
        LinkedList<QuestionBean> result = feedback.getFeedback(quizName);
        QuestionBean expResultBean = expResult.peekFirst();
        
        QuestionBean resultBean = result.peekFirst();
        System.out.println("expresultbean ");
        System.out.println("result " + resultBean.getAnswerText());

        
        assertEquals(expResultBean.getAnswerText(), resultBean.getAnswerText());
        assertEquals(expResultBean.getQuestionText(), resultBean.getQuestionText());
        assertEquals(expResultBean.getExplanation(), resultBean.getExplanation());
    }
    
}
