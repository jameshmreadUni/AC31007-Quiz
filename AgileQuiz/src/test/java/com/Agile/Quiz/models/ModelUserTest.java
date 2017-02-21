/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.stores.RegisterBean;
import java.util.Vector;
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
public class ModelUserTest {
    
    public ModelUserTest() {
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
     * Test of checkRegistration method, of class ModelUser.
     * test should pass if the inputErrors vector is empty, since it contains errors to be fixed
     * and these inputs should not produce any errors
     */
    @Test
    public void testCheckRegistration() {
        System.out.println("checkRegistration");
        String username = "uniqueUsername";
        String password = "validPassword";
        String confirmPassword = "validPassword";
        String email = "email@email.com";
        
        RegisterBean expResult = new RegisterBean(); //should just be an empty bean
        expResult.setUsername(username);
        expResult.setPassword(password);
        expResult.setConfirmPassword(confirmPassword);
        expResult.setEmail(email);
        ModelUser instance = new ModelUser();
        RegisterBean result = instance.checkRegistration(username, password, confirmPassword, email);
        assertEquals(expResult.getInputErrors(), result.getInputErrors());
    }
    
}
