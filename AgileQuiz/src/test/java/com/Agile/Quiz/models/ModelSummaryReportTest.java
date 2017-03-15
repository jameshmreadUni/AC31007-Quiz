/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Agile.Quiz.models;

import com.Agile.Quiz.stores.SummaryReportBean;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brian
 */
public class ModelSummaryReportTest {
    
    public ModelSummaryReportTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of QuizSummaryReport method, of class ModelSummaryReport.
     */
    @Test
    public void testQuizSummaryReport() {
        System.out.println("QuizSummaryReport");
        ModelSummaryReport instance = new ModelSummaryReport();
        LinkedList<SummaryReportBean> expResult = null;
        LinkedList<SummaryReportBean> result = instance.QuizSummaryReport();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
