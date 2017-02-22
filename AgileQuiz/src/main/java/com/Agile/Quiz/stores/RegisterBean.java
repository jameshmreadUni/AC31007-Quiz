/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.stores;

import java.util.Vector;

/**
 *
 * @author jamesread
 */
public class RegisterBean {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    
    private Vector<String> inputErrors = new Vector();
    
    public RegisterBean(){
     
    }
    
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getConfirmPassword(){
        return this.confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword){
        this.confirmPassword = confirmPassword;
    }
    
    public int getInputErrorsSize(){
        return this.inputErrors.size();
    }
    //for extracting individual elements
    public String getInputErrors(int i){
        return this.inputErrors.elementAt(i);
    }
    //returns entire vector, mainly used for testing
    public Vector<String> getInputErrors(){
        return this.inputErrors;
    }

    public void setInputErrors(Vector errorList){
        this.inputErrors = errorList;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
}
