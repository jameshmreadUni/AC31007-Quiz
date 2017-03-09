/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import java.util.LinkedList;

/**
 *
 * @author Brian
 */
public class ModelQuizOrder {
    
    
    //Code From: http://stackoverflow.com/questions/8688413/sorting-strings-using-bubblesort-in-java
    public LinkedList<String> OrderByName(LinkedList<String> ls)
    {
        for(int i = 0; i<ls.size() - 1; i++)        
        {                                               
            for(int j = 0; j<ls.size() - 1; j++) 
            {                                           
                if(ls.get(j).compareTo(ls.get(j+1)) > 0)
                {                                       
                    String temp = ls.get(j);                    
                    ls.set(j, ls.get(j+1));              
                    ls.set(j+1, temp);  
                }                                       
            }
        }
        
        return ls;
    }
}
