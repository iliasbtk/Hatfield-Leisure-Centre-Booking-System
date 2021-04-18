/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl;

import java.util.HashSet;
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
    
    
    
    @Test
    public void testBookApointment() {
        Student student = new Student("Loida", "Poon", "", "");
        HCL hcl = new HCL();
        String idS = hcl.registerStudent(student);
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        coach.addArea("swimming");
        ParentAppointment parentAppointment = new ParentAppointment(coach, coach.getOfficeDay(), coach.getOfficeHours(),"Slot: 1", 1);
        String appointmentId = "Appoint01";
        parentAppointment.setId(appointmentId);
        hcl.parentAppointments.put(appointmentId, parentAppointment);
        hcl.bookApointment(appointmentId, idS);
        String actualResult = parentAppointment.getState();
        String expectedResult = "Booked";
        assertEquals(actualResult, expectedResult);   
    }
    @Test
    public void testLookupLessonByArea() {
        HCL hcl = new HCL();
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        coach.addArea("swimming");
        Coach coach2 = new Coach("Cyndy" ,  "Cerrato",  "tel", "16:00 - 17:00", "Tue");
        coach2.addArea("swimming");
        Lesson lesson = new Lesson("Swimming 1", "swimming pool A",coach, "Mon", "14:00 - 15:00", "swimming", 3);
        hcl.addLesson(lesson);
        Lesson lesson2 = new Lesson("Swimming 2","swimming pool B",coach, "Wed", "19:00 - 20:00", "swimming", 5);
        hcl.addLesson(lesson2);
        String actualResult = hcl.lookupLessonByArea("swimming");
        String expectedResult = "less11: Swimming 1 / swimming / Mon / 14:00 - 15:00 / Serita Tuck / Availble\n" +
                                "less12: Swimming 2 / swimming / Wed / 19:00 - 20:00 / Serita Tuck / Availble\n";
        assertEquals(actualResult, expectedResult);     
    }
    @Test
    public void testLookupLessonByCoach() {
        HCL hcl = new HCL();
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        coach.addArea("swimming");
        coach.addArea("badminton");
        Lesson lesson = new Lesson("Swimming 1", "swimming pool A",coach, "Mon", "14:00 - 15:00", "swimming", 3);
        hcl.addLesson(lesson);
        Lesson lesson2 = new Lesson("Badminton 1","badminton court A",coach, "Tue", "14:00 - 15:00", "badminton", 5);
        hcl.addLesson(lesson2);
        hcl.lookupLessonByCoach("Serita Tuck");
        String actualResult = hcl.lookupLessonByCoach("Serita Tuck");
        String expectedResult = "less11: Swimming 1 / swimming / Mon / 14:00 - 15:00 / Serita Tuck / Availble\n" +
                                "less12: Badminton 1 / badminton / Tue / 14:00 - 15:00 / Serita Tuck / Availble\n";
        assertEquals(actualResult, expectedResult);
    }
    

    @Test
    public void testLookupTimeslotsByCoach() {
        HCL hcl = new HCL();
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        Coach coach2 = new Coach("Cyndy" ,  "Cerrato",  "tel", "16:00 - 17:00", "Tue");
        hcl.addCoach(coach);
        hcl.addCoach(coach2);
        String actualResult = hcl.lookupTimeslotsByCoach("Serita Tuck");
        String expectedResult = "Appoint02: Serita Tuck / Mon / 16:00 - 17:00 / Week: 1 / Slot: Slot: 2 / Availble\n" +
                                "Appoint01: Serita Tuck / Mon / 16:00 - 17:00 / Week: 1 / Slot: Slot: 1 / Availble\n" +
                                "Appoint06: Serita Tuck / Mon / 16:00 - 17:00 / Week: 2 / Slot: Slot: 3 / Availble\n" +
                                "Appoint05: Serita Tuck / Mon / 16:00 - 17:00 / Week: 2 / Slot: Slot: 2 / Availble\n" +
                                "Appoint04: Serita Tuck / Mon / 16:00 - 17:00 / Week: 2 / Slot: Slot: 1 / Availble\n" +
                                "Appoint03: Serita Tuck / Mon / 16:00 - 17:00 / Week: 1 / Slot: Slot: 3 / Availble\n" +
                                "Appoint09: Serita Tuck / Mon / 16:00 - 17:00 / Week: 3 / Slot: Slot: 3 / Availble\n" +
                                "Appoint08: Serita Tuck / Mon / 16:00 - 17:00 / Week: 3 / Slot: Slot: 2 / Availble\n" +
                                "Appoint07: Serita Tuck / Mon / 16:00 - 17:00 / Week: 3 / Slot: Slot: 1 / Availble\n" +
                                "Appoint012: Serita Tuck / Mon / 16:00 - 17:00 / Week: 4 / Slot: Slot: 3 / Availble\n" +
                                "Appoint010: Serita Tuck / Mon / 16:00 - 17:00 / Week: 4 / Slot: Slot: 1 / Availble\n" +
                                "Appoint011: Serita Tuck / Mon / 16:00 - 17:00 / Week: 4 / Slot: Slot: 2 / Availble\n";
        assertEquals(actualResult, expectedResult);
    }

   
    @Test
    public void testLookupTimeslotsByArea() {
        HCL hcl = new HCL();
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        Coach coach2 = new Coach("Cyndy" ,  "Cerrato",  "tel", "16:00 - 17:00", "Tue");
        coach.addArea("swimming");
        coach2.addArea("badminton");
        hcl.addCoach(coach);
        hcl.addCoach(coach2);
        String actualResult = hcl.lookupTimeslotsByArea("badminton");
        String expectedResult = "Appoint018: Cyndy Cerrato / badminton / Tue / 16:00 - 17:00 / Week: 2 / Slot: Slot: 3 / Availble\n" +
                                "Appoint019: Cyndy Cerrato / badminton / Tue / 16:00 - 17:00 / Week: 3 / Slot: Slot: 1 / Availble\n" +
                                "Appoint016: Cyndy Cerrato / badminton / Tue / 16:00 - 17:00 / Week: 2 / Slot: Slot: 1 / Availble\n" +
                                "Appoint017: Cyndy Cerrato / badminton / Tue / 16:00 - 17:00 / Week: 2 / Slot: Slot: 2 / Availble\n" +
                                "Appoint014: Cyndy Cerrato / badminton / Tue / 16:00 - 17:00 / Week: 1 / Slot: Slot: 2 / Availble\n" +
                                "Appoint015: Cyndy Cerrato / badminton / Tue / 16:00 - 17:00 / Week: 1 / Slot: Slot: 3 / Availble\n" +
                                "Appoint023: Cyndy Cerrato / badminton / Tue / 16:00 - 17:00 / Week: 4 / Slot: Slot: 2 / Availble\n" +
                                "Appoint013: Cyndy Cerrato / badminton / Tue / 16:00 - 17:00 / Week: 1 / Slot: Slot: 1 / Availble\n" +
                                "Appoint024: Cyndy Cerrato / badminton / Tue / 16:00 - 17:00 / Week: 4 / Slot: Slot: 3 / Availble\n" +
                                "Appoint021: Cyndy Cerrato / badminton / Tue / 16:00 - 17:00 / Week: 3 / Slot: Slot: 3 / Availble\n" +
                                "Appoint022: Cyndy Cerrato / badminton / Tue / 16:00 - 17:00 / Week: 4 / Slot: Slot: 1 / Availble\n" +
                                "Appoint020: Cyndy Cerrato / badminton / Tue / 16:00 - 17:00 / Week: 3 / Slot: Slot: 2 / Availble\n";
        assertEquals(actualResult, expectedResult);
    }

  
    

 
/*    

 
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
    
   
    

 
    
/*
    @Test
    public void testAddCoachTimeSlots() {
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        HCL hcl = new HCL();
        hcl.addCoachTimeSlots(coach);
        assertEquals(hcl.parentAppointments.get("Appoint01"),);
    }


    @Test
    public void testDisplayLessons() {
        
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
