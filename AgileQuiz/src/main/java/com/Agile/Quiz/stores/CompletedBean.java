/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.stores;

import java.nio.ByteBuffer;

/**
 *
 * @author Brian
 */
public class CompletedBean {
    
    private java.util.UUID UUID=null;
    
    public void Pic() {

    }
    public void setUUID(java.util.UUID UUID){
        this.UUID =UUID;
    }
    public String getUUID(){
       return UUID.toString();
    }
    
}
