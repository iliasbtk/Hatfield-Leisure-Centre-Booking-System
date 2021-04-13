/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author NGSI
 */
public class HCL {
    Map<String, Student> students = new HashMap<> (); 
    Map<String, Coach> coaches = new HashMap<> ();
    Map<String, Lesson> lessons = new HashMap<> ();
    Map<String, Booking> bookings = new HashMap<> ();
    Integer idC=0;
    Integer idS=0;
   
    public static void main(String[] args) {
        
        HCL hatfieldLeisureCentre = new HCL();
        
        
        Coach coach1 = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
        Coach coach2 = new Coach("Cyndy" ,  "Cerrato",  "tel", "16:00 - 17:00", "Tue");
        Coach coach3 = new Coach("Annamae" ,  "Koski",  "tel", "16:00 - 17:00", "Wed");
        Coach coach4 = new Coach("Sari" ,  "Stlaurent",  "tel", "16:00 - 17:00", "Thu");
        Coach coach5 = new Coach("Desire" ,  "Royalty",  "tel", "16:00 - 17:00", "Fri");
        Coach coach6 = new Coach("Ronny" ,  "Eriksen",  "tel", "15:00 - 16:00", "Tue");
        Coach coach7 = new Coach("Steward" ,  "Denver",  "tel", "15:00 - 16:00", "Wed");
        
        hatfieldLeisureCentre.addCoach(coach1);
        hatfieldLeisureCentre.addCoach(coach2);
        hatfieldLeisureCentre.addCoach(coach3);
        hatfieldLeisureCentre.addCoach(coach4);
        hatfieldLeisureCentre.addCoach(coach5);
        hatfieldLeisureCentre.addCoach(coach6);
        hatfieldLeisureCentre.addCoach(coach7);
        
        coach1.addArea("swimming");
        coach1.addArea("badminton");
        
        coach1.displayExpertiseArea();
        hatfieldLeisureCentre.displayCoaches();
        
        Student student1 = new Student ("Loida", "Poon", "", "");
        Student student2 = new Student ("Ewa", "Porto", "", "");
        Student student3 = new Student ("Dylan ", "Bucher", "", "");
        Student student4 = new Student ("Reggie ", "Malan", "", "");
        Student student5 = new Student ("Landon ", "Buel", "", "");
        Student student6 = new Student ("Enid ", "Lepine", "", "");
        Student student7 = new Student ("Aiko ", "Redmon", "", "");
        Student student8 = new Student ("Earl ", "Evatt", "", "");
        Student student9 = new Student ("Annita ", "Bruckner", "", "");
        Student student10 = new Student ("Emilee ", "Lubin", "", "");
        Student student11 = new Student ("Estell ", "Dillenbeck", "", "");
        Student student12 = new Student ("Charleen ", "Boss", "", "");
        Student student13 = new Student ("Chadwick ", "Fiscus", "", "");
        Student student14 = new Student ("Steven", "Pullman", "", "");
        Student student15 = new Student ("Elizabeth", "Simpson", "", "");
       
        
        hatfieldLeisureCentre.registerStudent(student1);
        hatfieldLeisureCentre.registerStudent(student2);
        hatfieldLeisureCentre.registerStudent(student3);
        hatfieldLeisureCentre.registerStudent(student4);
        hatfieldLeisureCentre.registerStudent(student5);
        hatfieldLeisureCentre.registerStudent(student6);
        hatfieldLeisureCentre.registerStudent(student7);
        hatfieldLeisureCentre.registerStudent(student8);
        hatfieldLeisureCentre.registerStudent(student9);
        hatfieldLeisureCentre.registerStudent(student10);
        hatfieldLeisureCentre.registerStudent(student11);
        hatfieldLeisureCentre.registerStudent(student12);
        hatfieldLeisureCentre.registerStudent(student13);
        hatfieldLeisureCentre.registerStudent(student14);
        hatfieldLeisureCentre.registerStudent(student15);
        
        hatfieldLeisureCentre.displayStudents();
        
    /**    
       Lesson Lesson1 = new Lesson(coach1, "Mon", "14:00 - 15:00", "area", "lessonId");
       Lesson Lesson2 = new Lesson(coach1, "Tue", "14:00 - 15:00", "area", "lessonId");
       Lesson Lesson3 = new Lesson(coach1, "Wed", "14:00 - 15:00", "area", "lessonId");
       Lesson Lesson4 = new Lesson(coach2, "Thu", "14:00 - 15:00", "area", "lessonId");
       Lesson Lesson5 = new Lesson(coach2, "Fri", "14:00 - 15:00", "area", "lessonId");
       Lesson Lesson6 = new Lesson(coach2, "Mon", "14:00 - 15:00", "area", "lessonId");
       Lesson Lesson7 = new Lesson(coach3, "Mon", "17:00 - 18:00", "area", "lessonId");
       Lesson Lesson8 = new Lesson(coach3, "Tue", "17:00 - 18:00", "area", "lessonId");
       Lesson Lesson9 = new Lesson(coach3, "Wed", "17:00 - 18:00", "area", "lessonId");
       Lesson Lesson10 = new Lesson(coach4, "Thu", "17:00 - 18:00", "area", "lessonId");
       Lesson Lesson11 = new Lesson(coach4, "Fri", "17:00 - 18:00", "area", "lessonId");
       Lesson Lesson12 = new Lesson(coach4, "Wed", "17:00 - 18:00", "area", "lessonId");
       Lesson Lesson13 = new Lesson(coach5, "Mon", "19:00 - 20:00", "area", "lessonId");
       Lesson Lesson14 = new Lesson(coach5, "Tue", "19:00 - 20:00", "area", "lessonId");
       Lesson Lesson15 = new Lesson(coach5, "Wed", "19:00 - 20:00", "area", "lessonId");
       Lesson Lesson16 = new Lesson(coach6, "Thu", "19:00 - 20:00", "area", "lessonId");
       Lesson Lesson17 = new Lesson(coach7, "Fri", "19:00 - 20:00", "area", "lessonId");
       Lesson Lesson18 = new Lesson(coach6, "Tue", "19:00 - 20:00", "area", "lessonId");
       Lesson Lesson19 = new Lesson(coach6, "Wed", "19:00 - 20:00", "area", "lessonId");
       Lesson Lesson20 = new Lesson(coach7, "Thu", "19:00 - 20:00", "area", "lessonId");
    **/    
        
    }
    public void addCoach(Coach coach){
        String coachId;
        idC = idC+1;
        coachId = "C0"+ String.valueOf(idC);
        coach.setId(coachId);
        coaches.put(coachId, coach);
    }
    
    public void displayCoaches(){
        for (Map.Entry<String, Coach> entry : coaches.entrySet()) {
            String k = entry.getKey();
        //    String v = entry.getValue().;
            System.out.println(k);
        }
    }
    
    public void registerStudent(Student student){
        String studentId;
        idS = idS+1;
        studentId = "S0"+ String.valueOf(idS);
        students.put(studentId, student);
    }
    
    public void displayStudents(){
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            String k = entry.getKey();
        //    String v = entry.getValue().;
            System.out.println(k);
        }
    }
    
    
    
    public void lookupLesson(String area){
        
    }
    
    
}
