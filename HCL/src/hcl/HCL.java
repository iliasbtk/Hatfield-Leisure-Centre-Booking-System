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
   
    public static void main(String[] args) {
        
        HCL hatfieldLeisureCentre = new HCL();
        
        
        Coach coach1 = new Coach("Serita",  "Tuck",  "tel", "officeHours", "officeDay");
        Coach coach2 = new Coach("Cyndy" ,  "Cerrato",  "tel", "officeHours", "officeDay");
        Coach coach3 = new Coach("Annamae" ,  "Koski",  "tel", "officeHours", "officeDay");
        Coach coach4 = new Coach("Sari" ,  "Stlaurent",  "tel", "officeHours", "officeDay");
        Coach coach5 = new Coach("Desire" ,  "Royalty",  "tel", "officeHours", "officeDay");
        
        hatfieldLeisureCentre.addCoach(coach1);
        hatfieldLeisureCentre.addCoach(coach2);
        hatfieldLeisureCentre.addCoach(coach3);
        hatfieldLeisureCentre.addCoach(coach4);
        hatfieldLeisureCentre.addCoach(coach5);
        
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
        
       Less
        
        
    }
    public void addCoach(Coach coach){
        String coachId;
        coachId = coach.getLastName()+"."+coach.getFirstName().substring(0,1);
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
        studentId = student.getLastName()+"."+student.getFirstName().substring(0,1);
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
