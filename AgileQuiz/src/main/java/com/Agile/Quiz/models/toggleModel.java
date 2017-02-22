/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

/**
 *
 * @author seans
 */
public class toggleModel {
    
    //this will be used for setting a quiz's availability in the DB
    //as well as returning it to the servlet if required.
    public boolean availability; 
  
    
    
    public void checkAvailability(String input){
    //this is for checking the availability of the quiz before its inserted
    
        if (input!=null)
        {
            availability = true;
            System.out.println("Quiz will be set to be available");
        } 
        else if (input==null)
        {
            availability = false;
            System.out.println("Quiz will be set to be unavailable");
        } 
    
    
    
    }
    
    
    public void insertToDB(){
        //this will be used for when we insert stuff into the database
    
    
    }
    
    public void retriveFromDB(){
    
        //this will be for when we retrieve struff from the database
        
        availability = true;
        
    }
    
    
    
}
