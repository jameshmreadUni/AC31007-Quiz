/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;


import com.Agile.Quiz.stores.loginBean;
/**
 *
 * @author Brian
 */
public class ModelStaffUser {
    //This will come from the database
    private String staffUsername = "staff";
    private String staffUserPass = "password";
    
    private String studentUsername = "student";
    private String studentPass = "password";
    
    private String[] usernames = new String[2];
    private String[] passwords = new String[2];
    public ModelStaffUser(){
            usernames[0] = "staff";
            usernames[1] = "student";
            passwords[0] = "password";
            passwords[1] = "password";
    }
    
    public boolean IsValidUser(String username, String password) {
        for(int i = 0; i < usernames.length; i++){
            if(username.equals(usernames[i]) && password.equals(passwords[i])) return true;
        }
      return false;   
      
    }    
    public void retrieveUserInfo(){
        
    
    //This will retrieve all the stuff from the DB when we have one    
        
        
    
    
    }    
        
        

    }
    

    
