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
    
    /**
     * Test of registerCoach method, of class HatfieldLeisureCentre.
     */
    
    @Test
    public void testRegisterCoach() {
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        
        Coach actualResult = hcl.coaches.get(idC);
        Coach expectedResult = coach;
        assertEquals(actualResult.getFullName(), expectedResult.getFullName());
        
        String actualResult2 = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        String expectedResult2 = "";
        assertEquals(actualResult2, expectedResult2);
    }

    /**
     * Test of registerStudent method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testRegisterStudent() {
        Student student = new Student("Loida", "Poon", "Address", "tel", "Parent name");
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        
        Student actualResult = hcl.students.get(idS);
        Student expectedResult = student;
        assertEquals(actualResult.getFullName(), expectedResult.getFullName());
        
        String actualResult2 = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        String expectedResult2 = "";
        assertEquals(expectedResult2, actualResult2);
        
    }

    /**
     * Test of addLesson method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testAddLesson() {
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        Coach coach = new Coach("Serita", "Tuck", "tel", "16:00 - 17:00", "Mon");
        coach.addArea("swimming");
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC).addArea("swimming");
        Lesson lesson = new Lesson("Swimming 1", "swimming pool A", coach, "Mon", "14:00 - 15:00", "swimming", 10);
        String lessonId = hcl.addLesson("Swimming 1", "swimming pool A",idC , "Mon", "14:00 - 15:00", "swimming", 10);
        
        Lesson actualResult = hcl.lessons.get(lessonId);
        Lesson expectedResult = lesson;
        assertEquals(actualResult.getName(), expectedResult.getName());
        
        Coach coach2 = new Coach("Cyndy", "Cerrato", "tel", "16:00 - 17:00", "Tue");
        coach2.addArea("swimming");
        Lesson lesson2 = new Lesson("Swimming 1", "swimming pool A", coach2, "Mon", "16:00 - 17:00", "swimming", 5);
        String actualResult2 = hcl.addLesson("Swimming 1", "swimming pool A", "Cyndy Cerrato", "Mon", "14:00 - 15:00", "swimming", 10);
        String expectedResult2 = "Coach not registered";
        assertEquals(actualResult2, expectedResult2);
        
        String actualResult3 = hcl.addLesson("Gymnastics 1", "Gym", idC, "Wed", "14:00 - 15:00", "gymnastics", 5);
        String expectedResult3 = "Expertise area not teached by the coach";
        assertEquals(expectedResult3, actualResult3);
        
        hcl.addLesson("Gymnastics 1", "Gym", idC, "Wed", "14:00 - 15:00", "swimming", 5);
        hcl.addLesson("Swimming 1", "swimming pool A", idC, "Fri", "14:00 - 15:00", "swimming", 5);
        String actualResult4 = hcl.addLesson("Swimming 1", "swimming pool A", idC, "Thu", "17:00 - 18:00", "swimming", 5);
        String expectedResult4 = "Max lesson";
        assertEquals(actualResult4, expectedResult4);
        
        String idC2 = hcl.registerCoach("Celia", "Wanda", "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC2).addArea("swimming");
        String actualResult5 = hcl.addLesson("Swimming 1", "swimming pool A", idC2, "Mon", "16:00 - 17:00", "swimming", 5);
        String expectedResult5 = "Time conflict";
        assertEquals(actualResult5, expectedResult5);
    }
    /**
     * Test of lookupLessonByArea method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testLookupLessonByArea() {
        Coach coach = new Coach("Serita", "Tuck", "tel", "16:00 - 17:00", "Mon");
        Student student = new Student("Loida", "Poon", "Address", "tel", "Parent name");
        Lesson lesson = new Lesson("Swimming 1", "swimming pool A", coach, "Mon", "14:00 - 15:00", "swimming", 10);
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        
        coach.addArea("swimming");
        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC).addArea("swimming");
        String lessonId = hcl.addLesson("Swimming 1", "swimming pool A", idC, "Mon", "14:00 - 15:00", "swimming", 1);
        
        String actualResult = hcl.lookupLessonByArea("swimming");
        String expectedResult = lessonId+": Swimming 1 / swimming / Mon / 14:00 - 15:00 / Serita Tuck / Availble\n";
        assertEquals(actualResult, expectedResult);
    }

//    /**
//     * Test of lookupLessonByCoach method, of class HatfieldLeisureCentre.
//     */
        @Test
    public void testLookupLessonByCoach() {
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        Coach coach = hcl.coaches.get(idC);
        Student student = new Student("Loida", "Poon", "Address", "tel", "Parent name");
        coach.addArea("swimming");
        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        String lessonId = hcl.addLesson("Swimming 1", "swimming pool A", idC , "Mon", "14:00 - 15:00", "swimming", 1);       
        
        String actualResult = hcl.lookupLessonByCoach("Serita Tuck");
        String expectedResult = lessonId+": Swimming 1 / swimming / Mon / 14:00 - 15:00 / Serita Tuck / Availble\n";
        assertEquals(actualResult, expectedResult);
    }

    /**
     * Test of book method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testBook() {
        /*
        Case: Succesful lesson booking.
         */

        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        Coach coach = new Coach("Serita", "Tuck", "tel", "16:00 - 17:00", "Mon");
        coach.addArea("swimming");
        Student student = new Student("Loida", "Poon", "Address", "tel", "Parent name");
        Lesson lesson = new Lesson("Swimming 1", "swimming pool A", coach, "Mon", "14:00 - 15:00", "swimming", 10);
        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC).addArea("swimming");
        String lessonId = hcl.addLesson("Swimming 1", "swimming pool A", idC, "Mon", "14:00 - 15:00", "swimming", 1);
        String bookNum = hcl.book(idS, lessonId);
          
        Booking actualResult = hcl.bookings.get(bookNum);
        Booking expectedResult = new Booking(student, lesson, "Booked");
        assertEquals(actualResult.getState(), expectedResult.getState());
        assertEquals(actualResult.getStudent().getFullName(), expectedResult.getStudent().getFullName());
        assertEquals(actualResult.getLesson().getName(), expectedResult.getLesson().getName());

        /*
        Case: If one lesson is full, booking will be unsuccessful
         */

        String idS2 = hcl.registerStudent("Ewa", "Porto","","", "");

        String actualResult2 = hcl.book(idS2, lessonId);
        String expectedResult2 = "Lesson full";
        assertEquals(actualResult2, actualResult2);
        
        /*
        Case: Students cannot sign up for two lessons running at the same time 
         */
        Coach coach2 = new Coach("Cyndy", "Cerrato", "tel", "16:00 - 17:00", "Tue");
        coach2.addArea("badminton");
        String lessonId2 = hcl.addLesson("Badminton 1", "badminton court A", "Cyndy Cerrato", "Mon", "14:00 - 15:00", "badminton", 5);

        String actualResult3 = hcl.book(idS, lessonId2);;
        String expectedResult3 = "Already enrolled into a class running at the same time";
        assertEquals(actualResult3, actualResult3);
    }

    /**
     * Test of cancelBooking method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testCancelBooking() {
        Coach coach = new Coach("Serita", "Tuck", "tel", "16:00 - 17:00", "Mon");
        Student student = new Student("Loida", "Poon", "Address", "tel", "Parent name");
        Lesson lesson = new Lesson("Swimming 1", "swimming pool A", coach, "Mon", "14:00 - 15:00", "swimming", 10);
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        
        coach.addArea("swimming");
        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        String lessonId = hcl.addLesson("Swimming 1", "swimming pool A", "Serita Tuck", "Mon", "14:00 - 15:00", "swimming", 1);
        String bookNum = hcl.book(idS, lessonId);
        
        String actualResult = hcl.cancelBooking(bookNum);
        String expectedResult = "The booking: "+bookNum+" is succesfully canceled";
        assertEquals(actualResult, actualResult);
    }
    
    /**
     * Test of changeBooking method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testChangeBooking() {
        Coach coach = new Coach("Serita", "Tuck", "tel", "16:00 - 17:00", "Mon");
        Student student = new Student("Loida", "Poon", "Address", "tel", "Parent name");
        Lesson lesson = new Lesson("Swimming 1", "swimming pool A", coach, "Mon", "14:00 - 15:00", "swimming", 10);
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();

        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC).addArea("swimming");
        String lessonId = hcl.addLesson("Swimming 1", "swimming pool A", idC, "Mon", "14:00 - 15:00", "swimming", 1);
        String idC2 = hcl.registerCoach("Cyndy", "Cerrato", "tel", "16:00 - 17:00", "Tue");
        hcl.coaches.get(idC2).addArea("badminton");
        String lessonId2 = hcl.addLesson("Badminton 1", "badminton court A", idC2, "Wed", "14:00 - 15:00", "badminton", 5);
        String bookNum = hcl.book(idS, lessonId);
        String bookNum2 = hcl.changeBooking(bookNum, lessonId2);
        
        Booking actualResult = hcl.bookings.get(bookNum2);
        Booking expectedResult = new Booking(student, hcl.lessons.get(lessonId2), "Booked");
        assertEquals(actualResult.getState(), expectedResult.getState());
        assertEquals(actualResult.getStudent().getFullName(), expectedResult.getStudent().getFullName());
        assertEquals(actualResult.getLesson().getName(), expectedResult.getLesson().getName());
        assertEquals(hcl.bookings.get(bookNum).getState(), "Changed");
        
    }

    /**
     * Test of attendLesson method, of class HatfieldLeisureCentre.
     */
        @Test
    public void testAttendLesson() {
        Student student = new Student("Loida", "Poon", "Address", "tel", "Parent name");
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();        
        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC).addArea("swimming");
        String lessonId = hcl.addLesson("Swimming 1", "swimming pool A", idC, "Mon", "14:00 - 15:00", "swimming", 1);
        String bookNum = hcl.book(idS, lessonId);
        hcl.attendLesson(bookNum);
        
        String actualResult = hcl.bookings.get(bookNum).getState();
        String expectedResult = "Attended";
        assertEquals(actualResult, expectedResult);
    }

    /**
     * Test of lookupTimeslotsByCoach method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testLookupTimeslotsByCoach() {
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        hcl.registerCoach("Serita", "Tuck", "tel", "16:00 - 17:00", "Mon");
        hcl.registerCoach("Cyndy", "Cerrato", "tel", "16:00 - 17:00", "Tue");

        String actualResult = hcl.lookupTimeslotsByCoach("Serita Tuck");
        String expectedResult = "Appoint02: Serita Tuck / Mon / 16:00 - 17:00 / Week: 1 / Slot: Slot: 2 / Availble\n"
                + "Appoint01: Serita Tuck / Mon / 16:00 - 17:00 / Week: 1 / Slot: Slot: 1 / Availble\n"
                + "Appoint06: Serita Tuck / Mon / 16:00 - 17:00 / Week: 2 / Slot: Slot: 3 / Availble\n"
                + "Appoint05: Serita Tuck / Mon / 16:00 - 17:00 / Week: 2 / Slot: Slot: 2 / Availble\n"
                + "Appoint04: Serita Tuck / Mon / 16:00 - 17:00 / Week: 2 / Slot: Slot: 1 / Availble\n"
                + "Appoint03: Serita Tuck / Mon / 16:00 - 17:00 / Week: 1 / Slot: Slot: 3 / Availble\n"
                + "Appoint09: Serita Tuck / Mon / 16:00 - 17:00 / Week: 3 / Slot: Slot: 3 / Availble\n"
                + "Appoint08: Serita Tuck / Mon / 16:00 - 17:00 / Week: 3 / Slot: Slot: 2 / Availble\n"
                + "Appoint07: Serita Tuck / Mon / 16:00 - 17:00 / Week: 3 / Slot: Slot: 1 / Availble\n"
                + "Appoint012: Serita Tuck / Mon / 16:00 - 17:00 / Week: 4 / Slot: Slot: 3 / Availble\n"
                + "Appoint010: Serita Tuck / Mon / 16:00 - 17:00 / Week: 4 / Slot: Slot: 1 / Availble\n"
                + "Appoint011: Serita Tuck / Mon / 16:00 - 17:00 / Week: 4 / Slot: Slot: 2 / Availble\n";
        assertEquals(actualResult, expectedResult);
    }


//    /**
//     * Test of lookupTimeslotsByArea method, of class HatfieldLeisureCentre.
//     */
        @Test
    public void testLookupTimeslotsByArea() {
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idC = hcl.registerCoach("Serita", "Tuck", "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC).addArea("swimming");
        String idC2 = hcl.registerCoach("Cyndy", "Cerrato", "tel", "16:00 - 17:00", "Tue");
        hcl.coaches.get(idC2).addArea("badminton");
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
        assertEquals(expectedResult, actualResult);
    }
    
    /**
     * Test of bookApointment method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testBookApointment() {
        Student student = new Student("Loida", "Poon", "Address", "tel", "Parent name");
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        Coach coach = new Coach("Serita", "Tuck", "tel", "16:00 - 17:00", "Mon");
        coach.addArea("swimming");
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        ParentAppointment parentAppointment = new ParentAppointment(coach, coach.getOfficeDay(), coach.getOfficeHours(), "Slot: 1", 1);
        String appointmentId = "Appoint01";
        parentAppointment.setId(appointmentId);
        hcl.parentAppointments.put(appointmentId, parentAppointment);
        hcl.bookApointment("Appoint01", idS);
        String actualResult = parentAppointment.getState();
        String expectedResult = "Booked";
        assertEquals(actualResult, expectedResult);
    }
    
    
}
