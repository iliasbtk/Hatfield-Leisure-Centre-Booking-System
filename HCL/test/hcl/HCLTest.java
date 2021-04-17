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
public class HCLTest {
    
    public HCLTest() {
    }
    
    
    
    @Test
    public void testAddCoach() {
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        HCL hcl = new HCL();
        String idC = hcl.addCoach(coach);
        assertEquals(coach, (hcl.coaches).get(idC));
    }
   
    @Test
    public void testRegisterStudent() {
        Student student = new Student("Loida", "Poon", "", "");
        HCL hcl = new HCL();
        String idS = hcl.registerStudent(student);
        assertEquals(student, (hcl.students).get(idS));
    }

    
    @Test
    public void testAddLesson() {
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        coach.addArea("swimming");
        Lesson lesson = new Lesson("Swimming 1", "swimming pool A",coach, "Mon", "14:00 - 15:00", "swimming", 10);
        HCL hcl = new HCL();
        hcl.addLesson(lesson);
        assertEquals(lesson, (hcl.lessons).get(lesson.getId()));
    }

    @Test
    public void testBook() {
        Student student = new Student("Loida", "Poon", "", "");
        HCL hcl = new HCL();
        String idS = hcl.registerStudent(student);
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        coach.addArea("swimming");
        Lesson lesson = new Lesson("Swimming 1", "swimming pool A",coach, "Mon", "14:00 - 15:00", "swimming", 10);
        hcl.addLesson(lesson);
        String lessonId = lesson.getId();
        Booking actualResult = hcl.book(idS, lessonId);
        Booking expectedResult = new Booking(student, lesson, "Booked");
        assertEquals(expectedResult.getStudentFullName(), actualResult.getStudentFullName());
        assertEquals(expectedResult.getLessonId(), actualResult.getLessonId());
        assertEquals(expectedResult.getState(), actualResult.getState());
        assertEquals(expectedResult.getBookingNumber(), actualResult.getBookingNumber());
        
    }

    /*

    @Test
    public void testDisplayBookings() {
        System.out.println("displayBookings");
        HCL instance = new HCL();
        instance.displayBookings();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

  
    @Test
    public void testCancelBooking() {
        System.out.println("cancelBooking");
        String bookNum = "";
        HCL instance = new HCL();
        instance.cancelBooking(bookNum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    @Test
    public void testChangeBooking() {
        System.out.println("changeBooking");
        String bookNum = "";
        String newLessonId = "";
        HCL instance = new HCL();
        instance.changeBooking(bookNum, newLessonId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    @Test
    public void testAttendLesson() {
        System.out.println("attendLesson");
        String bookNum = "";
        HCL instance = new HCL();
        instance.attendLesson(bookNum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    @Test
    public void testLookupTimeslotsByCoach() {
        System.out.println("lookupTimeslotsByCoach");
        String coachName = "";
        HCL instance = new HCL();
        instance.lookupTimeslotsByCoach(coachName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

  
    @Test
    public void testLookupTimeslotsByArea() {
        System.out.println("lookupTimeslotsByArea");
        String area = "";
        HCL instance = new HCL();
        instance.lookupTimeslotsByArea(area);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

  
    @Test
    public void testAddCoachTimeSlots() {
        System.out.println("addCoachTimeSlots");
        Coach coach = null;
        HCL instance = new HCL();
        instance.addCoachTimeSlots(coach);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    @Test
    public void testBookApointment() {
        System.out.println("bookApointment");
        String appointmentId = "";
        String idS = "";
        HCL instance = new HCL();
        instance.bookApointment(appointmentId, idS);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    @Test
    public void testReport1() {
        System.out.println("report1");
        HCL instance = new HCL();
        instance.report1();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testReport2() {
        System.out.println("report2");
        HCL instance = new HCL();
        instance.report2();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/    
    /*
     @Test
    public void testLookupLessonByArea() {
        String area = "swimming";
        HCL instance = new HCL();
        instance.lookupLessonByArea(area);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    @Test
    public void testLookupLessonByCoach() {
        System.out.println("lookupLessonByCoach");
        String coachName = "";
        HCL instance = new HCL();
        instance.lookupLessonByCoach(coachName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
/**
    


    @Test
    public void testDisplayLessons() {
        
    }

  

    
   


    @Test
    public void testBook() {
        System.out.println("book");
        String idS = "";
        String lessonId = "";
        HCL instance = new HCL();
        instance.book(idS, lessonId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testDisplayBookings() {
        System.out.println("displayBookings");
        HCL instance = new HCL();
        instance.displayBookings();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/

}
