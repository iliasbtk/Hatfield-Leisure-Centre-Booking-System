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
        /*
        Case: Succesful lesson booking.
        */
        Student student = new Student("Loida", "Poon", "", "");
        HCL hcl = new HCL();
        String idS = hcl.registerStudent(student);
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        coach.addArea("swimming");
        Lesson lesson = new Lesson("Swimming 1", "swimming pool A",coach, "Mon", "14:00 - 15:00", "swimming", 3);
        hcl.addLesson(lesson);
        String lessonId = lesson.getId();
        Booking actualResult = hcl.book(idS, lessonId);
        Booking expectedResult = new Booking(student, lesson, "Booked");
        assertEquals(expectedResult.getStudentFullName(), actualResult.getStudentFullName());
        assertEquals(expectedResult.getLessonId(), actualResult.getLessonId());
        assertEquals(expectedResult.getState(), actualResult.getState());
        
        /*
        Case: If one lesson is full, booking will be unsuccessful and the student will be asked to book another one);
        */
        Student student2 = new Student ("Ewa", "Porto", "", "");
        Student student3 = new Student ("Dylan ", "Bucher", "", "");
        Student student4 = new Student ("Reggie ", "Malan", "", "");
        String idS2 = hcl.registerStudent(student2);
        String idS3 = hcl.registerStudent(student3);
        String idS4 = hcl.registerStudent(student4);
        hcl.book(idS2, lessonId);
        hcl.book(idS3, lessonId);
        Booking actualResult2 = hcl.book(idS4, lessonId);
        Booking expectedResult2 = null;
        assertEquals(actualResult2, actualResult2);
        /*
        Case: Students cannot sign up for two lessons running at the same time 
        */
        Lesson lesson2 = new Lesson("Badminton 1","badminton court A",coach, "Mon", "14:00 - 15:00", "badminton", 5);
        String lessonId2 = lesson.getId();
        hcl.book(idS, lessonId2);
        Booking actualResult3 = hcl.book(idS, lessonId2);
        Booking expectedResult3 = null;
        assertEquals(actualResult3, actualResult3);
        
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
    */
  
    
    @Test
    public void testCancelBooking() {
        Student student = new Student("Loida", "Poon", "", "");
        HCL hcl = new HCL();
        String idS = hcl.registerStudent(student);
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        coach.addArea("swimming");
        Lesson lesson = new Lesson("Swimming 1", "swimming pool A",coach, "Mon", "14:00 - 15:00", "swimming", 3);
        hcl.addLesson(lesson);
        String lessonId = lesson.getId();
        Booking actualResult1 = hcl.book(idS, lessonId);
        Integer studentNumbersBefore = lesson.getStudentNumber();
        String bookingNumber = actualResult1.getBookingNumber();
        hcl.cancelBooking(bookingNumber);
        String actualResult = actualResult1.getState();
        String expectedResult = "Canceled";
        Integer actualResult2 = lesson.getStudentNumber();
        Integer expectedResult2 = studentNumbersBefore-1;
        assertEquals(actualResult, expectedResult);
        assertEquals(actualResult2, expectedResult2);
    }
     
 
    @Test
    public void testChangeBooking() {
        Student student = new Student("Loida", "Poon", "", "");
        HCL hcl = new HCL();
        String idS = hcl.registerStudent(student);
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        coach.addArea("swimming");
        coach.addArea("badminton");
        Lesson lesson = new Lesson("Swimming 1", "swimming pool A",coach, "Mon", "14:00 - 15:00", "swimming", 3);
        hcl.addLesson(lesson);       
        Lesson lesson2 = new Lesson("Badminton 1","badminton court A",coach, "Tue", "15:00 - 16:00", "badminton", 5);
        hcl.addLesson(lesson2);        
        String lessonId = lesson.getId();
        Booking booking = hcl.book(idS, lessonId);
        Integer studentNumbersBefore = lesson.getStudentNumber();
        Integer studentNumbersBefore2 = lesson2.getStudentNumber();
        String bookingNumber = booking.getBookingNumber();
        hcl.changeBooking (bookingNumber, lesson2.getId());
        String actualResult = booking.getState();
        String expectedResult = "Changed";
        Integer actualResult2 = lesson.getStudentNumber();
        Integer expectedResult2 = studentNumbersBefore-1;
        Integer actualResult3 = lesson2.getStudentNumber();
        Integer expectedResult3 = studentNumbersBefore2+1;
        assertEquals(actualResult, expectedResult);
        assertEquals(actualResult2, expectedResult2);
        assertEquals(actualResult3, expectedResult3);
        
    }
    
   
    @Test
    public void testAttendLesson() {
        Student student = new Student("Loida", "Poon", "", "");
        HCL hcl = new HCL();
        String idS = hcl.registerStudent(student);
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        coach.addArea("swimming");
        Lesson lesson = new Lesson("Swimming 1", "swimming pool A",coach, "Mon", "14:00 - 15:00", "swimming", 3);
        hcl.addLesson(lesson);
        String lessonId = lesson.getId();
        Booking booking = hcl.book(idS, lessonId);
        String bookingNumber = booking.getBookingNumber();
        hcl.attendLesson(bookingNumber);
        String actualResult = booking.getState();
        String expectedResult = "Attended";
        assertEquals(actualResult, expectedResult);
    }
    /*

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
