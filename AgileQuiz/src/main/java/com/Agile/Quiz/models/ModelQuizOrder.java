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

    //Code edited From: http://stackoverflow.com/questions/8688413/sorting-strings-using-bubblesort-in-java
    public String[] OrderByName(LinkedList<String> ls)
    {
        //Dummy Data
        String [] quizName = {"Quiz 1", "Quiz 2"};
        int size = quizName.length;
        
        
        
        //How many quizzes there are
        for (int i=0; i<size; i++)
        {
            System.out.println("How many quizzes there are" + quizName[i]);
        }
       
            for(int i = 0; i<quizName.length - 1; i++)        
        {                                               
            for(int j = 0; j<quizName.length - 1; j++) 
            {                                           
                if(quizName[j].compareTo(quizName[j+1]) > 0)
                {                                       
                  String  temp = quizName[j];                    
                    quizName[j] = quizName[j+1];              
                    quizName[j+1] = temp; 
                    
                }                                       
            }
        }

        for (String quizName1 : quizName) {
            System.out.println(quizName1);
            ls.add(quizName1);
        }
       //This orders the quizzes 
//        for(int i = 0; i<ls.size() - 1; i++)        
//        {                                                
//            for(int j = 0; j<ls.size() - 1; j++) 
//            {                                           
//                if(ls.get(j).compareTo(ls.get(j+1)) > 0)
//                {                                       
//                    String temp = ls.get(j);                    
//                    ls.set(j, ls.get(j+1));              
//                    ls.set(j+1, temp);  
//                }                                       
//            }         System.out.println(" order of quizzes - " + ls);
//        }
//        
       return quizName;
    }
}