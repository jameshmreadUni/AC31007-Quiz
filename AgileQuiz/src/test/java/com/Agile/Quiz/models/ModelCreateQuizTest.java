/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.stores.QuestionBean;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author James Read
 */
public class ModelCreateQuizTest {
    
    public ModelCreateQuizTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addTextQuestion method, of class ModelCreateQuiz.
     */
    @Test
    public void testAddTextQuestion() {
        System.out.println("addTextQuestion");
        String questionText = "testQuestionText";
        String answerText = "testAnswer";
        int questionNumber = 1;
        String quizName = "testQuiz";
        boolean expResult = true;
        boolean result = ModelCreateQuiz.addTextQuestion(questionText, answerText, questionNumber, quizName);
        assertEquals(expResult, result);

    }

    /**
     * Test of addMultiAnswerQuestion method, of class ModelCreateQuiz.
     */
    @Test
    public void testAddMultiAnswerQuestion() {
        System.out.println("addMultiAnswerQuestion");
        String questionText = "testQuestionText";
        String[] inputAnswerArray = {"answer1", "answer2", "","answer3"};
        
        String[] correctAnswerArray = {"answer1", "answer2","answer3"};
        int questionNumber = 1;
        String quizName = "testQuiz";
        boolean expResult = true;
        boolean result = ModelCreateQuiz.addMultiAnswerQuestion(questionText, 
                inputAnswerArray, 
                correctAnswerArray, questionNumber, quizName);
        assertEquals(expResult, result);

    }

    /**
     * Test of addQuizToDB method, of class ModelCreateQuiz.
     */
    @Test
    public void testAddQuizToDB() {
        System.out.println("addQuizToDB");
        LinkedList<QuestionBean> questionList = null;
        boolean expResult = true;
        boolean result = ModelCreateQuiz.addQuizToDB(questionList);
        assertEquals(expResult, result);

    }
    
    
    @org.junit.Test
    public void testCheckTrue() {
        System.out.println("checkAvailability");
        String input ="true";
        ModelCreateQuiz instance = new ModelCreateQuiz();
       boolean test = instance.toggleAvailability(input);
        assertEquals("Should be true", true, test);  
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @org.junit.Test
    public void testCheckOn() {
        System.out.println("checkAvailability");
        String input ="on";
        ModelCreateQuiz instance = new ModelCreateQuiz();
       boolean test = instance.toggleAvailability(input);
        assertEquals("Should be true", true, test);  
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
