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
    String username;
    private String userType;
    
    //Constructor
    public void loginBean(){
        
    }
    
    public void setUsername(String name){
        this.username=name;
    }
    public String getUsername(){
        return username;
    }
    public void setLoggedin(){
        loggedin=true;
    }

    public boolean getloggedin(){
        return loggedin;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }
        
}

