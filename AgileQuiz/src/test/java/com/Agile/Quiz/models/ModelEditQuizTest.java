/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gemmawhyte
 */
public class ModelEditQuizTest {
    
    public ModelEditQuizTest() {
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
     * Test of updateQuizTitle method, of class ModelEditQuiz.
     */
    //@Test
    public void testUpdateQuizTitle() {
        System.out.println("updateQuizTitle");
        String newQuizName = "";
        ModelEditQuiz instance = new ModelEditQuiz();
        instance.updateQuizTitle(newQuizName);
    
    }

    /**
     * Test of getQuizTitle method, of class ModelEditQuiz.
     */
    @Test
    public void testGetQuizTitle() {
        System.out.println("getQuizTitle");
        ModelEditQuiz instance = new ModelEditQuiz();
        String expResult = "james";
        String result = instance.getQuizTitle();
        assertEquals(expResult, result);
        
    }
    
}
