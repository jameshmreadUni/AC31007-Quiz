/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.stores;

/**
 *
 * @author Brian
 */
public class loginBean {
    boolean loggedin=false;
    String Username=null;
    
    //Constructor
    public void loginBean(){
        
    }
    
    public void setUsername(String name){
        this.Username=name;
    }
    public String getUsername(){
        return Username;
    }
    public void setLoggedin(){
        loggedin=true;
    }
    
   // public void setLoginState(){
   //     this.loggedin=true;
  //  }
    public boolean getlogedin(){
        return loggedin;
    }
        
}

