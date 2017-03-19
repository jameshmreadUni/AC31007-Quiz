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
public class SummaryReportBean {


    private int total;
    private int correct;
    private int wrong;
    private double percentage;
    private String breif;
    
    public SummaryReportBean(){
        
    }
    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the correct
     */
    public int getCorrect() {
        return correct;
    }

    /**
     * @param correct the correct to set
     */
    public void setCorrect(int correct) {
        this.correct = correct;
    }

    /**
     * @return the wrong
     */
    public int getWrong() {
        return wrong;
    }

    /**
     * @param wrong the wrong to set
     */
    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    /**
     * @return the breif
     */
    public String getBreif() {
        return breif;
    }

    /**
     * @param breif the breif to set
     */
    public void setBreif(String breif) {
        this.breif = breif;
    }

        /**
     * @return the percentage
     */
    public double getPercentage() {
        return percentage;
    }
    
       /**
     * @param percentage the percentage to set
     */
    public void setPercentage(double percentage) { 
        this.percentage = percentage;
    }

}
