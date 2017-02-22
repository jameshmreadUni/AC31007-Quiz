/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import static jdk.nashorn.internal.objects.NativeFunction.call;
import com.Agile.Quiz.stores.loginBean;
/**
 *
 * @author Brian
 */
public class ModelStaffUser {
      String staffUserName = "100000000";
    String staffUserPass = "password";
    public ModelStaffUser(){
        
    }
    
   
    public boolean IsValidUser(String username, String password) {
        
        if(username == staffUserName && password == staffUserPass){
        loginBean ls = new loginBean();
        ls.setLoggedin();
        return true;
        } // could be a sequrity flaw as gives out vaild usernames by brute force
        else if(username == staffUserName && password != staffUserPass){
            System.out.println("Please Enter The Correct Password");
        }else{
            System.out.println("This is Not a Valid User");
            return false;
        }
          return false;
            
    }
    
}
    
