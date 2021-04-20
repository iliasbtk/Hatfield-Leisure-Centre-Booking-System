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
public class HatfieldLeisureCentreTest {
    
    public HatfieldLeisureCentreTest() {
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
     * Test of registerCoach method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testRegisterCoach() {
        System.out.println("registerCoach");
        String firstName = "";
        String lastName = "";
        String tel = "";
        String officeHours = "";
        String officeDay = "";
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        String expResult = "";
        String result = instance.registerCoach(firstName, lastName, tel, officeHours, officeDay);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCoach method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testAddCoach() {
        System.out.println("addCoach");
        Coach coach = null;
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        String expResult = "";
        String result = instance.addCoach(coach);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerStudent method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testRegisterStudent() {
        System.out.println("registerStudent");
        Student student = null;
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        String expResult = "";
        String result = instance.registerStudent(student);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLesson method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testAddLesson() {
        System.out.println("addLesson");
        Lesson lesson = null;
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        instance.addLesson(lesson);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayLessons method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testDisplayLessons() {
        System.out.println("displayLessons");
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        instance.displayLessons();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLesson method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testGetLesson() {
        System.out.println("getLesson");
        String lessonId = "";
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        Lesson expResult = null;
        Lesson result = instance.getLesson(lessonId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lookupLessonByArea method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testLookupLessonByArea() {
        System.out.println("lookupLessonByArea");
        String area = "";
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        String expResult = "";
        String result = instance.lookupLessonByArea(area);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lookupLessonByCoach method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testLookupLessonByCoach() {
        System.out.println("lookupLessonByCoach");
        String coachName = "";
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        String expResult = "";
        String result = instance.lookupLessonByCoach(coachName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkSameTimeLessons method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testCheckSameTimeLessons() {
        System.out.println("checkSameTimeLessons");
        String idS = "";
        Lesson lesson = null;
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        boolean expResult = false;
        boolean result = instance.checkSameTimeLessons(idS, lesson);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of book method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testBook() {
        System.out.println("book");
        String idS = "";
        String lessonId = "";
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        Booking expResult = null;
        Booking result = instance.book(idS, lessonId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayBookings method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testDisplayBookings() {
        System.out.println("displayBookings");
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        instance.displayBookings();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelBooking method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testCancelBooking() {
        System.out.println("cancelBooking");
        String bookNum = "";
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        instance.cancelBooking(bookNum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeBooking method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testChangeBooking() {
        System.out.println("changeBooking");
        String bookNum = "";
        String newLessonId = "";
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        Booking expResult = null;
        Booking result = instance.changeBooking(bookNum, newLessonId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attendLesson method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testAttendLesson() {
        System.out.println("attendLesson");
        String bookNum = "";
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        instance.attendLesson(bookNum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lookupTimeslotsByCoach method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testLookupTimeslotsByCoach() {
        System.out.println("lookupTimeslotsByCoach");
        String coachName = "";
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        String expResult = "";
        String result = instance.lookupTimeslotsByCoach(coachName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lookupTimeslotsByArea method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testLookupTimeslotsByArea() {
        System.out.println("lookupTimeslotsByArea");
        String area = "";
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        String expResult = "";
        String result = instance.lookupTimeslotsByArea(area);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bookApointment method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testBookApointment() {
        System.out.println("bookApointment");
        String appointmentId = "";
        String idS = "";
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        instance.bookApointment(appointmentId, idS);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of report1 method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testReport1() {
        System.out.println("report1");
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        instance.report1();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of report2 method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testReport2() {
        System.out.println("report2");
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        instance.report2();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCoachTimeSlots method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testAddCoachTimeSlots() {
        System.out.println("addCoachTimeSlots");
        Coach coach = null;
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        instance.addCoachTimeSlots(coach);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateId method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testGenerateId() {
        System.out.println("generateId");
        String code = "";
        Integer i = null;
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        String expResult = "";
        String result = instance.generateId(code, i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayCoaches method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testDisplayCoaches() {
        System.out.println("displayCoaches");
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        String expResult = "";
        String result = instance.displayCoaches();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayStudents method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testDisplayStudents() {
        System.out.println("displayStudents");
        HatfieldLeisureCentre instance = new HatfieldLeisureCentre();
        instance.displayStudents();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
