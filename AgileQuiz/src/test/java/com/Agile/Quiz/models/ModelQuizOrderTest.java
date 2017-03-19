/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brian
 */
public class ModelQuizOrderTest {
    
    public ModelQuizOrderTest() {
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
     * Test of QuizOrder method, of class ModelQuizOrder.
     */
    @Test
    public void testQuizOrder() {
        System.out.println("QuizOrder");
        LinkedList<String> expResult = new LinkedList<>();
        expResult.add("MathsQuiz");
        expResult.add("EnglishQuiz");
        expResult.add("ComputingQuiz");
        LinkedList<String> result = ModelQuizOrder.QuizOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
}
