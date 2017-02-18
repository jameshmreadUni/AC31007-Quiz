/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.stores.QuestionBean;
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
public class ModelQuizTest {
    
    public ModelQuizTest() {
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
     * Test of getQuestions method, of class ModelQuiz.
     */
    @org.junit.Test
    public void testGetQuestions() {
        System.out.println("getQuestions");
        String quizName = "TESTQUIZ NAME";
        ModelQuiz instance = new ModelQuiz();
        QuestionBean expResult = null;
        QuestionBean result = instance.getQuestions(quizName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnswers method, of class ModelQuiz.
     */
    @org.junit.Test
    public void testGetAnswers() {
        System.out.println("getAnswers");
        String quizName = "";
        ModelQuiz instance = new ModelQuiz();
        String[] expResult = null;
        String[] result = instance.getAnswers(quizName);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
