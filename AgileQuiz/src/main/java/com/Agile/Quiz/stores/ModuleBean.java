/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.stores;

import java.util.LinkedList;

/**
 *
 * @author seanstewart
 */
public class ModuleBean {
    
    private String moduleCode;
    private String moduleName;
    private LinkedList<String> quizName;
    
    public ModuleBean(){
        quizName = new LinkedList<>();
    
  }
    

    /**
     * @return the moduleCode
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * @param moduleCode the moduleCode to set
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * @return the moduleName
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * @param moduleName the moduleName to set
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * @return the quizName
     */
    public LinkedList<String> getQuizName() {
        return quizName;
    }

    /**
     * @param quizName the quizName to set
     */
    public void setQuizName(LinkedList<String> quizName) {
        this.quizName = quizName;
    }
    
}
