/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.servlets.SummaryReport;
import com.Agile.Quiz.stores.SummaryReportBean;
import java.text.DecimalFormat;
import java.util.LinkedList;

/**
 *
 * @author Brian
 */
public class ModelSummaryReport {
        int correct = 7;
        int total = 68;
        int wrong = total - correct;
        double percentage = (double) (correct * 100)/total;
        
        String breif = "this was the correct answer because: data from database will display here";
    
    public ModelSummaryReport() {
        //Dummy Data
//        int correct = 7;
//        int total = 10;
//        int wrong = total - correct;
//        double percentage = correct/total * 100;
//        String breif = "this was the correct answer because: data from database will display here";
    }
    //had static but asked me to remove it
    public LinkedList<SummaryReportBean> QuizSummaryReport(){
        
     LinkedList<SummaryReportBean> summaryList = new LinkedList<>();
     
     SummaryReportBean summaryreportbean = new SummaryReportBean();
      //This is currently not working correctly
     DecimalFormat numberFormat = new DecimalFormat("0.00");
    numberFormat.format(percentage);
     
     summaryreportbean.setPercentage(percentage);
     summaryreportbean.setTotal(total);
     summaryreportbean.setCorrect(correct);
     summaryreportbean.setWrong(wrong);
     summaryreportbean.setBreif(breif);
     
     summaryList.add(summaryreportbean);
     
     //SummaryReportBean summaryreportbean;
   
     //summaryreportbean = new SummaryReportBean(total);
        return summaryList;
    }
}
