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
    @Test
    public void testGetQuestions() {
        System.out.println("getQuestions");
        String quizName = "testName";
        ModelQuiz instance = new ModelQuiz();
        LinkedList<QuestionBean> expResult = null;
        LinkedList<QuestionBean> result = instance.getQuestions(quizName);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
 
    @Test
    public void testDeleteQuiz(){
    System.out.println("deleteQuiz");
    
    ModelQuiz instance = new ModelQuiz();
    boolean result = instance.deleteQuiz();
    boolean expResult = true; 
    
    assertEquals(expResult, result);
    
    
    }

}
