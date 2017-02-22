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
    public void testCheckAvailability() {
        System.out.println("checkAvailability");
        String input ="true";
        toggleModel instance = new toggleModel();
       boolean test = instance.checkAvailability(input);
        assertEquals("Should be true", true, test);  
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertToDB method, of class toggleModel.
     */
    @org.junit.Test
    public void testInsertToDB() {
        System.out.println("insertToDB");
        toggleModel instance = new toggleModel();
        boolean test = instance.insertToDB();
        assertEquals("Should be true", true, test);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of retriveFromDB method, of class toggleModel.
     */
    @org.junit.Test
    public void testRetriveFromDB() {
        System.out.println("retriveFromDB");
        toggleModel instance = new toggleModel();
        boolean test = instance.retriveFromDB();
        assertEquals("Should be true", true, test);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
