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
 * @author Brian
 */
public class ModelStaffUserTest {
    
    public ModelStaffUserTest() {
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
     * Test of IsValidUser method, of class ModelStaffUser.
     */
    @org.junit.Test
    public void testIsValidUserTrue() {
        System.out.println("Is Valid User");
        String username = "staff";
        String password = "password";
        ModelStaffUser instance = new ModelStaffUser();
        boolean expResult = true;
        boolean result = instance.IsValidUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
        @org.junit.Test
    public void testIsValidUserFalse() {
        System.out.println("Is Not a Valid User");
        String username = "100000001";
        String password = "Password";
        ModelStaffUser instance = new ModelStaffUser();
        boolean expResult = false;
        boolean result = instance.IsValidUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
           @org.junit.Test
    public void testIsValidUserFalseEmpty() {
        System.out.println("Is Not a Valid User");
        String username = "";
        String password = "";
        ModelStaffUser instance = new ModelStaffUser();
        boolean expResult = false;
        boolean result = instance.IsValidUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    //test for correct username but wrong password
           @org.junit.Test
    public void testIsValidUserFalsePassword() {
        System.out.println("Is Not a Valid User");
        String username = "staff";
        String password = "Password";
        ModelStaffUser instance = new ModelStaffUser();
        boolean expResult = false;
        boolean result = instance.IsValidUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
