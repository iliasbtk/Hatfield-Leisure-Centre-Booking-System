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
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    


    
    @Test
    public void testAddCoach() {
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        HCL hcl = new HCL();
        String idC = hcl.addCoach(coach);
        assertEquals(coach, (hcl.coaches).get(idC));
    }

    @Test
    public void testDisplayCoaches() {
        HCL hcl = new HCL();
        Coach coach1 = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        Coach coach2 = new Coach("Cyndy" ,  "Cerrato",  "tel", "16:00 - 17:00", "Tue");
        hcl.addCoach(coach1);
        hcl.addCoach(coach2);
        hcl.displayCoaches();

    }
    
    @Test
    public void testRegisterStudent() {
        Student student = new Student("Loida", "Poon", "", "");
        HCL hcl = new HCL();
        String idS = hcl.registerStudent(student);
        assertEquals(student, (hcl.students).get(idS));
    }


    @Test
    public void testDisplayStudents() {
        HCL hcl = new HCL();
        Student student1 = new Student("A", "B", "", "");
        Student student2 = new Student("C", "D", "", "");
        hcl.registerStudent(student1);
        hcl.registerStudent(student2);
        hcl.displayStudents();
    }


    @Test
    public void testAddLesson() {
        Coach coach = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        coach.addArea("swimming");
        Lesson lesson = new Lesson(coach, "Mon", "14:00 - 15:00", "swimming", "less01");
        HCL hcl = new HCL();
        hcl.addLesson(lesson);
        assertEquals(lesson, (hcl.lessons).get(lesson.getId()));
    }


    @Test
    public void testDisplayLessons() {
        
    }

  

    
    @Test
    public void testLookupLessonByArea() {
        System.out.println("lookupLessonByArea");
        String area = "";
        HCL instance = new HCL();
        instance.lookupLessonByArea(area);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lookupLessonByCoach method, of class HCL.
     */
    @Test
    public void testLookupLessonByCoach() {
        System.out.println("lookupLessonByCoach");
        String coachName = "";
        HCL instance = new HCL();
        instance.lookupLessonByCoach(coachName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of book method, of class HCL.
     */
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

    /**
     * Test of displayBookings method, of class HCL.
     */
    @Test
    public void testDisplayBookings() {
        System.out.println("displayBookings");
        HCL instance = new HCL();
        instance.displayBookings();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


}
