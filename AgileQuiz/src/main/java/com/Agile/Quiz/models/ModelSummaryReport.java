/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

/**
 *
 * @author Brian
 */
public class ModelSummaryReport {
    
    public ModelSummaryReport() {
        //Dummy Data
        int correct = 7;
        int total = 10;
        int wrong = total - correct;
        double percentage = correct/total * 100;
        String breif = "this was the correct answer because: data from database will display here";
    }
    
    
}
