/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NGSI
 */
public class CoachTest {
    
    public CoachTest() {
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
     * Test of addArea method, of class Coach.
     */
    @Test
    public void testAddArea() {
        System.out.println("addArea");
        String sport = "";
        Coach instance = null;
        instance.addArea(sport);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayExpertiseArea method, of class Coach.
     */
    @Test
    public void testDisplayExpertiseArea() {
        System.out.println("displayExpertiseArea");
        Coach instance = null;
        instance.displayExpertiseArea();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasExpertiseArea method, of class Coach.
     */
    @Test
    public void testHasExpertiseArea() {
        System.out.println("hasExpertiseArea");
        String areaName = "";
        Coach instance = null;
        boolean expResult = false;
        boolean result = instance.hasExpertiseArea(areaName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
