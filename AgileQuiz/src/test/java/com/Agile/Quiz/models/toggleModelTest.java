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
 * @author seans
 */
public class toggleModelTest {
    
    public toggleModelTest() {
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
     * Test of checkAvailability method, of class toggleModel.
     */
    @org.junit.Test
    public void testCheckTrue() {
        System.out.println("checkAvailability");
        String input ="true";
        toggleModel instance = new toggleModel();
       boolean test = instance.checkAvailability(input);
        assertEquals("Should be true", true, test);  
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

     @org.junit.Test
    public void testCheckFalse() {
        System.out.println("checkAvailability");
        String input = null;
        toggleModel instance = new toggleModel();
       boolean test = instance.checkAvailability(input);
        assertEquals("Should be true", false, test);  
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }   
    
    
    
    

    
}
