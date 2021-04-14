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
public class BookingTest {
    
    public BookingTest() {
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
     * Test of setBookNum method, of class Booking.
     */
    @Test
    public void testSetBookNum() {
        System.out.println("setBookNum");
        String bookingNumber = "";
        Booking instance = null;
        instance.setBookNum(bookingNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentId method, of class Booking.
     */
    @Test
    public void testGetStudentId() {
        System.out.println("getStudentId");
        Booking instance = null;
        String expResult = "";
        String result = instance.getStudentId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentFullName method, of class Booking.
     */
    @Test
    public void testGetStudentFullName() {
        System.out.println("getStudentFullName");
        Booking instance = null;
        String expResult = "";
        String result = instance.getStudentFullName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingNumber method, of class Booking.
     */
    @Test
    public void testGetBookingNumber() {
        System.out.println("getBookingNumber");
        Booking instance = null;
        String expResult = "";
        String result = instance.getBookingNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLessonId method, of class Booking.
     */
    @Test
    public void testGetLessonId() {
        System.out.println("getLessonId");
        Booking instance = null;
        String expResult = "";
        String result = instance.getLessonId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getState method, of class Booking.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Booking instance = null;
        String expResult = "";
        String result = instance.getState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
