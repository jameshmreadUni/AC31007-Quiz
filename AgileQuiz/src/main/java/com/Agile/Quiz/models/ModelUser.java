/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.lib.Database;
import com.Agile.Quiz.stores.RegisterBean;
import com.Agile.Quiz.stores.loginBean;
import java.util.Vector;

/**
 *
 * @author jamesread
 */
public class ModelUser {
        
        public RegisterBean checkRegistration(String username, String password, String confirmPassword, String email){
            Vector errorList = new Vector();
          
        if(checkExistingUsername(username))
            errorList.add("Username already exists");
        if(!password.equals(confirmPassword))
            errorList.add("Passwords do not match");
        if(!validPassword(password))
            errorList.add("Your password is too short");
           RegisterBean register = new RegisterBean(); 
           
           register.setInputErrors(errorList);
           register.setUsername(username);
           register.setPassword(password);
           register.setConfirmPassword(confirmPassword);
           register.setEmail(email);
           return register;
    }

    private boolean validPassword(String password){
        return password.length() >= 7;
    }
        
        private boolean checkExistingUsername(String username){
        //select from users where username == username, if no results, return true
        if(username.length() < 5) return true;
        return username.equals("existingUsername");
        
    }
        
    public boolean validUser(String username, String password){
        
        Database db = new Database();
        boolean valid = db.checkUserDetails(username, password);
        
        return valid;    
    }    
        
        
        
   public String getUserType(String username, String passsword){
       
       Database db = new Database();
       
       String userType = db.selectUserType(username, passsword);
 
       return userType;
   }    
        
   public boolean register(String username, String password){
       Database db = new Database();
       
       boolean valid = db.checkUserDetails(username, password);
       
       if(!valid){
           db.registerUser(username, password);
           return true; 
       } else{
           return false; 
       }

   }     
}
