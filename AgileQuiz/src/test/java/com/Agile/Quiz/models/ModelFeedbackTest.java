/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.stores.QuizResultBean;
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
    
    public ModelFeedbackTest() {
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
     * Test of getFeedback method, of class ModelFeedback.
     */
    @Test
    public void testGetFeedback() {
        System.out.println("getFeedback");
        String quizName = "test";
        
        ModelFeedback feedback = new ModelFeedback();
        String expResult = feedback.getFeedback(quizName).getQuestionExplanations(0);
        String result = feedback.getFeedback(quizName).getQuestionExplanations(0);
        assertEquals(expResult, result);
    }
    
}
