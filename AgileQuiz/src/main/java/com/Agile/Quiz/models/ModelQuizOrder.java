/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Brian
 */
public class ModelQuizOrder {

    
 //these will be replaced from the database.
 //the order of completed and non completed will be done by the database.


    
   public ModelQuizOrder(){
 
   }
   
     public static LinkedList<String> QuizOrder() {

 LinkedList<String> linkedlist = new LinkedList<>();

         /*add(String Element) is used for adding 
          * the elements to the linked list*/
         linkedlist.add("MathsQuiz");
         linkedlist.add("EnglishQuiz");
         linkedlist.add("ComputingQuiz");

         /*Display Linked List Content*/
         System.out.println("Linked List Content: " +linkedlist);
         
         return linkedlist;
     }
}
 // sudo for database
//function f
// 
//statement = "";
//query = execute(statement);
//linkedlist ls;
//
//resultset
//        while(resultset.next())
//        string s = resultset.getString("ID");
//        ls.add(s);
//
//return ls;
//end
//   

