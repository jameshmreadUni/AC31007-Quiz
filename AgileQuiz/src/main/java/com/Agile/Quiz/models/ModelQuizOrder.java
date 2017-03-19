/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Brian
 */
public class ModelQuizOrder {

    //Code edited From: http://stackoverflow.com/questions/8688413/sorting-strings-using-bubblesort-in-java
    public LinkedList<String> OrderByName()
    {
        
        LinkedList<String> ls = new LinkedList<>();
        //Dummy Data
        String [] quizName = {"Quiz 1", "Quiz 2"};
        int size = quizName.length;
        
        
        
//        //How many quizzes there are
//        for (int i=0; i<size; i++)
//        {
//            System.out.println("How many quizzes there are" + quizName[i]);
//        }
//       
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

        for (int i = 0; i < quizName.length; i++) {
            System.out.println(Arrays.toString(quizName));
            ls.add(quizName[i]);
            System.out.println("");
        }       
       return ls;
    }
}
