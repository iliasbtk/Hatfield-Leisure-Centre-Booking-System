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
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        //Succesful registration
        String actualResult = hcl.coaches.get(idC).getFullName();
        String expectedResult = "Serita Tuck";
        assertEquals(expectedResult, actualResult);
        //Coach already registered
        String actualResult2 = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        String expectedResult2 = "";
        assertEquals(expectedResult2, actualResult2);
    }

    /**
     * Test of registerStudent method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testRegisterStudent() {
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        //Succesful registration
        String actualResult = hcl.students.get(idS).getFullName();
        String expectedResult = "Loida Poon";
        assertEquals(expectedResult, actualResult);
        //Student already registered
        String actualResult2 = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        String expectedResult2 = "";
        assertEquals(actualResult2,expectedResult2);
        
    }

    /**
     * Test of addLesson method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testAddLesson() {
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC).addArea("swimming"); 
        //Successful 
        String actualResult = hcl.addLesson("Swimming 1", "swimming pool A",idC , "Mon", "14:00 - 15:00", "swimming", 10);
        String expectedResult = "Successful lesson creation";
        assertEquals(expectedResult, actualResult);
        //Coach not registered
        String actualResult2 = hcl.addLesson("Swimming 1", "swimming pool A", "Cyndy Cerrato", "Mon", "14:00 - 15:00", "swimming", 10);
        String expectedResult2 = "Coach not registered";
        assertEquals(expectedResult2, actualResult2);
        //Expertise area not teached by the coach
        String actualResult3 = hcl.addLesson("Gymnastics 1", "Gym", idC, "Wed", "14:00 - 15:00", "gymnastics", 5);
        String expectedResult3 = "Expertise area not teached by the coach";
        assertEquals(actualResult3, expectedResult3);
        //Maximum lessons teached by the coach reached
        hcl.addLesson("Gymnastics 1", "Gym", idC, "Wed", "14:00 - 15:00", "swimming", 5);
        hcl.addLesson("Swimming 1", "swimming pool A", idC, "Fri", "14:00 - 15:00", "swimming", 5);
        String actualResult4 = hcl.addLesson("Swimming 1", "swimming pool A", idC, "Thu", "17:00 - 18:00", "swimming", 5);
        String expectedResult4 = "Max lesson";
        assertEquals(expectedResult4, actualResult4);
        //Time Conflict with coach's office hour
        String idC2 = hcl.registerCoach("Celia", "Wanda", "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC2).addArea("swimming");
        String actualResult5 = hcl.addLesson("Swimming 1", "swimming pool A", idC2, "Mon", "16:00 - 17:00", "swimming", 5);
        String expectedResult5 = "Time conflict";
        assertEquals(expectedResult5, actualResult5);
    }
    /**
     * Test of lookupLessonByArea method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testLookupLessonByArea() {        
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC).addArea("swimming");
        String lessonId = hcl.addLesson("Swimming 1", "swimming pool A", idC, "Mon", "14:00 - 15:00", "swimming", 1);
        //Succesful lookup
        String actualResult = hcl.lookupLessonByArea("swimming");
        String expectedResult = "Lesson Id: less104 / Swimming 1 / swimming / Week: 4 / Mon / 14:00 - 15:00 / Coach: Serita Tuck / Availble\n" +
                                "Lesson Id: less101 / Swimming 1 / swimming / Week: 1 / Mon / 14:00 - 15:00 / Coach: Serita Tuck / Availble\n" +
                                "Lesson Id: less102 / Swimming 1 / swimming / Week: 2 / Mon / 14:00 - 15:00 / Coach: Serita Tuck / Availble\n" +
                                "Lesson Id: less103 / Swimming 1 / swimming / Week: 3 / Mon / 14:00 - 15:00 / Coach: Serita Tuck / Availble\n";
        assertEquals(expectedResult, actualResult);
    }

//    /**
//     * Test of lookupLessonByCoach method, of class HatfieldLeisureCentre.
//     */
        @Test
    public void testLookupLessonByCoach() {
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC).addArea("swimming");
        hcl.addLesson("Swimming 1", "swimming pool A", idC , "Mon", "14:00 - 15:00", "swimming", 1);       
        //Succesful lookup
        String actualResult = hcl.lookupLessonByCoach("Serita Tuck");
        String expectedResult = "Lesson Id: less104 / Swimming 1 / swimming / Week: 4 / Mon / 14:00 - 15:00 / Coach: Serita Tuck / Availble\n" +
                                "Lesson Id: less101 / Swimming 1 / swimming / Week: 1 / Mon / 14:00 - 15:00 / Coach: Serita Tuck / Availble\n" +
                                "Lesson Id: less102 / Swimming 1 / swimming / Week: 2 / Mon / 14:00 - 15:00 / Coach: Serita Tuck / Availble\n" +
                                "Lesson Id: less103 / Swimming 1 / swimming / Week: 3 / Mon / 14:00 - 15:00 / Coach: Serita Tuck / Availble\n";
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test of book method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testBook() {
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC).addArea("swimming");
        hcl.addLesson("Swimming 1", "swimming pool A", idC, "Mon", "14:00 - 15:00", "swimming", 1);
        String bookNum = hcl.book(idS, "less101");
        //Succesful lesson booking
        String actualResult = hcl.bookings.get(bookNum).getState();
        String expectedResult = "Booked";
        String actualResult2 = hcl.bookings.get(bookNum).getStudent().getFullName();
        String expectedResult2 = "Loida Poon";
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult2, actualResult2);
        //Lesson fully booked
        String idS2 = hcl.registerStudent("Ewa", "Porto","Address","tel", "Parent name");
        String actualResult3 = hcl.book(idS2, "less101");
        String expectedResult3 = "Lesson full";
        assertEquals(expectedResult3, actualResult3);
        //Time conflict between two lessons
        String idC2 = hcl.registerCoach("Bryan",  "London",  "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC2).addArea("badminton");
        hcl.addLesson("Badminton 1", "badminton court A", idC2, "Mon", "14:00 - 15:00", "badminton", 5);
        String actualResult4 = hcl.book(idS, "less111");
        String expectedResult4 = "Already enrolled into a class running at the same time";
        assertEquals(expectedResult4, actualResult4);
    }

    /**
     * Test of cancelBooking method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testCancelBooking() {
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC).addArea("swimming");
        hcl.addLesson("Swimming 1", "swimming pool A", idC, "Mon", "14:00 - 15:00", "swimming", 1);
        String bookNum = hcl.book(idS, "less101");
        //Successful booking cancellation
        String actualResult = hcl.cancelBooking(bookNum);
        String expectedResult = "The booking: "+bookNum+" is succesfully canceled";
        assertEquals(expectedResult, actualResult);
    }
    
    /**
     * Test of changeBooking method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testChangeBooking() {
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC).addArea("swimming");
        hcl.addLesson("Swimming 1", "swimming pool A", idC, "Mon", "14:00 - 15:00", "swimming", 1);
        String idC2 = hcl.registerCoach("Cyndy", "Cerrato", "tel", "16:00 - 17:00", "Tue");
        hcl.coaches.get(idC2).addArea("badminton");
        hcl.addLesson("Badminton 1", "badminton court A", idC2, "Wed", "14:00 - 15:00", "badminton", 5);
        String bookNum = hcl.book(idS, "less101");
        //Before booking change
        String actualResult = hcl.bookings.get(bookNum).getState();
        String expectedResult = "Booked";
        assertEquals(expectedResult, actualResult);
        hcl.changeBooking(bookNum, "less111");
        //After booking change
        String actualResult2 = hcl.bookings.get(bookNum).getState();
        String expectedResult2 = "Changed";
        assertEquals(expectedResult2, actualResult2);
    }

    /**
     * Test of attendLesson method, of class HatfieldLeisureCentre.
     */
        @Test
    public void testAttendLesson() {
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();        
        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC).addArea("swimming");
        hcl.addLesson("Swimming 1", "swimming pool A", idC, "Mon", "14:00 - 15:00", "swimming", 1);
        String bookNum = hcl.book(idS, "less101");
        hcl.attendLesson(bookNum);
        //Successful lesson attendance
        String actualResult = hcl.bookings.get(bookNum).getState();
        String expectedResult = "Attended";
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test of lookupTimeslotsByCoach method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testLookupTimeslotsByCoach() {
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        hcl.registerCoach("Serita", "Tuck", "tel", "16:00 - 17:00", "Mon");
        hcl.registerCoach("Cyndy", "Cerrato", "tel", "16:00 - 17:00", "Tue");
        //Successful lookup
        String actualResult = hcl.lookupTimeslotsByCoach("Serita Tuck");
        String expectedResult = "Appointment Id: Appoint02 / Coach name: Serita Tuck / Week: 1 / Mon / 16:00 - 17:00 / Slot: 2 / Availble\n" +
                                "Appointment Id: Appoint01 / Coach name: Serita Tuck / Week: 1 / Mon / 16:00 - 17:00 / Slot: 1 / Availble\n" +
                                "Appointment Id: Appoint06 / Coach name: Serita Tuck / Week: 2 / Mon / 16:00 - 17:00 / Slot: 3 / Availble\n" +
                                "Appointment Id: Appoint05 / Coach name: Serita Tuck / Week: 2 / Mon / 16:00 - 17:00 / Slot: 2 / Availble\n" +
                                "Appointment Id: Appoint04 / Coach name: Serita Tuck / Week: 2 / Mon / 16:00 - 17:00 / Slot: 1 / Availble\n" +
                                "Appointment Id: Appoint03 / Coach name: Serita Tuck / Week: 1 / Mon / 16:00 - 17:00 / Slot: 3 / Availble\n" +
                                "Appointment Id: Appoint09 / Coach name: Serita Tuck / Week: 3 / Mon / 16:00 - 17:00 / Slot: 3 / Availble\n" +
                                "Appointment Id: Appoint08 / Coach name: Serita Tuck / Week: 3 / Mon / 16:00 - 17:00 / Slot: 2 / Availble\n" +
                                "Appointment Id: Appoint07 / Coach name: Serita Tuck / Week: 3 / Mon / 16:00 - 17:00 / Slot: 1 / Availble\n" +
                                "Appointment Id: Appoint012 / Coach name: Serita Tuck / Week: 4 / Mon / 16:00 - 17:00 / Slot: 3 / Availble\n" +
                                "Appointment Id: Appoint010 / Coach name: Serita Tuck / Week: 4 / Mon / 16:00 - 17:00 / Slot: 1 / Availble\n" +
                                "Appointment Id: Appoint011 / Coach name: Serita Tuck / Week: 4 / Mon / 16:00 - 17:00 / Slot: 2 / Availble\n";
        assertEquals(expectedResult, actualResult);
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
        //Successful lookup
        String actualResult = hcl.lookupTimeslotsByArea("badminton");
        String expectedResult = "Appointment Id: Appoint018 / Coach name: Cyndy Cerrato / Week: 2 / Tue / 16:00 - 17:00 / Slot: 3 / Availble\n" +
                                "Appointment Id: Appoint019 / Coach name: Cyndy Cerrato / Week: 3 / Tue / 16:00 - 17:00 / Slot: 1 / Availble\n" +
                                "Appointment Id: Appoint016 / Coach name: Cyndy Cerrato / Week: 2 / Tue / 16:00 - 17:00 / Slot: 1 / Availble\n" +
                                "Appointment Id: Appoint017 / Coach name: Cyndy Cerrato / Week: 2 / Tue / 16:00 - 17:00 / Slot: 2 / Availble\n" +
                                "Appointment Id: Appoint014 / Coach name: Cyndy Cerrato / Week: 1 / Tue / 16:00 - 17:00 / Slot: 2 / Availble\n" +
                                "Appointment Id: Appoint015 / Coach name: Cyndy Cerrato / Week: 1 / Tue / 16:00 - 17:00 / Slot: 3 / Availble\n" +
                                "Appointment Id: Appoint023 / Coach name: Cyndy Cerrato / Week: 4 / Tue / 16:00 - 17:00 / Slot: 2 / Availble\n" +
                                "Appointment Id: Appoint013 / Coach name: Cyndy Cerrato / Week: 1 / Tue / 16:00 - 17:00 / Slot: 1 / Availble\n" +
                                "Appointment Id: Appoint024 / Coach name: Cyndy Cerrato / Week: 4 / Tue / 16:00 - 17:00 / Slot: 3 / Availble\n" +
                                "Appointment Id: Appoint021 / Coach name: Cyndy Cerrato / Week: 3 / Tue / 16:00 - 17:00 / Slot: 3 / Availble\n" +
                                "Appointment Id: Appoint022 / Coach name: Cyndy Cerrato / Week: 4 / Tue / 16:00 - 17:00 / Slot: 1 / Availble\n" +
                                "Appointment Id: Appoint020 / Coach name: Cyndy Cerrato / Week: 3 / Tue / 16:00 - 17:00 / Slot: 2 / Availble\n";
        assertEquals(expectedResult, actualResult);
    }
    
    /**
     * Test of bookApointment method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testBookApointment() {
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        //Successful appointment booking
        String actualResult = hcl.bookApointment("Appoint01", idS);;
        String expectedResult = "Booked";
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test of checkSameTimeLessons method, of class HatfieldLeisureCentre.
     */
    @Test
    public void testCheckSameTimeLessons() {
        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
        String idS = hcl.registerStudent("Loida", "Poon", "Address", "tel", "Parent name");
        String idC = hcl.registerCoach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        hcl.coaches.get(idC).addArea("swimming");
        hcl.addLesson("Swimming 1", "swimming pool A", idC, "Mon", "14:00 - 15:00", "swimming", 1);
        String bookNum = hcl.book(idS, "less101");
        boolean actualResult = hcl.checkSameTimeLessons(idS, hcl.lessons.get("less101"));
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    
    
}
