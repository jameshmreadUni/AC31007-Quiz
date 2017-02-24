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
        System.out.println("checkRegistration all right");
        String username = "uniqueGoodUsername";
        String password = "validPassword";
        String confirmPassword = "validPassword";
        String email = "email@email.com";
        
        RegisterBean expResult = new RegisterBean(); 
        //expResult.setUsername(username);
        //expResult.setPassword(password);
        //expResult.setConfirmPassword(confirmPassword);
        //expResult.setEmail(email);
        ModelUser instance = new ModelUser();
        RegisterBean result = instance.checkRegistration(username, password, confirmPassword, email);
        assertEquals(expResult.getInputErrors(), result.getInputErrors());
    }
    
    @Test
    public void testCheckRegistrationUsername() {
        System.out.println("checkRegistration bad username");
        String username = "existingUsername";
        String password = "validPassword";
        String confirmPassword = "validPassword";
        String email = "email@email.com";
        
        String expResult = "Username already exists";
        
        ModelUser instance = new ModelUser();
        RegisterBean result = instance.checkRegistration(username, password, confirmPassword, email);
        assertEquals(expResult, result.getInputErrors(0));
    }
    
    @Test
    public void testCheckRegistrationPassword() {
        System.out.println("checkRegistration short password");
        String username = "goodUsername";
        String password = "bad";
        String confirmPassword = "bad";
        String email = "email@email.com";
        
        String expResult = "Your password is too short";
        
        ModelUser instance = new ModelUser();
        RegisterBean result = instance.checkRegistration(username, password, confirmPassword, email);
      
        assertEquals(expResult, result.getInputErrors(0));
    }
    
        @Test
    public void testCheckRegistrationAllWrong() {
        System.out.println("checkRegistration all bad info");
        String username = "existingUsername";
        String password = "bad";
        String confirmPassword = "noMatch";
        String email = "email@email.com";
        
        int expResult = 3;
        
        ModelUser instance = new ModelUser();
        RegisterBean result = instance.checkRegistration(username, password, confirmPassword, email);
      
        assertEquals(expResult, result.getInputErrorsSize());
    }
            @Test
    public void testCheckRegistrationAllBlank() {
        System.out.println("checkRegistration all empty");
        String username = "";
        String password = "";
        String confirmPassword = "";
        String email = "email";
        
        int expResult = 2;
        
        ModelUser instance = new ModelUser();
        RegisterBean result = instance.checkRegistration(username, password, confirmPassword, email);
        for(int i = 0; i < result.getInputErrorsSize(); i++)
            System.out.print(result.getInputErrors(i));
       
        assertEquals(expResult, result.getInputErrorsSize());
    }
}
