/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    Integer bookNum=0;
   
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
        coach1.addArea("gymnastics");
        coach2.addArea("swimming");
        coach2.addArea("badminton");
        coach3.addArea("gymnastics");
        coach4.addArea("swimming");
        coach4.addArea("badminton");
        coach4.addArea("gymnastics");
        coach5.addArea("badminton");
        coach5.addArea("gymnastics");
        coach6.addArea("swimming");
        coach7.addArea("swimming");
        coach7.addArea("badminton");
        coach7.addArea("gymnastics");
        
        
       
        
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
        
    
       
        
       hatfieldLeisureCentre.addLesson(new Lesson(coach1, "Mon", "14:00 - 15:00", "swimming", "less01"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach1, "Tue", "14:00 - 15:00", "badminton", "less02"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach1, "Wed", "14:00 - 15:00", "gymnastics", "less03"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach2, "Thu", "14:00 - 15:00", "swimming", "less04"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach2, "Fri", "14:00 - 15:00", "swimming", "less05"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach2, "Mon", "14:00 - 15:00", "badminton", "less06"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach3, "Mon", "17:00 - 18:00", "gymnastics", "less07"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach3, "Tue", "17:00 - 18:00", "gymnastics", "less08"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach3, "Wed", "17:00 - 18:00", "gymnastics", "less09"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach4, "Thu", "17:00 - 18:00", "swimming", "less10"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach4, "Fri", "17:00 - 18:00", "gymnastics", "less11"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach4, "Wed", "17:00 - 18:00", "gymnastics", "less12"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach5, "Mon", "19:00 - 20:00", "badminton", "less13"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach5, "Tue", "19:00 - 20:00", "badminton", "less14"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach5, "Wed", "19:00 - 20:00", "gymnastics", "less15"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach6, "Thu", "19:00 - 20:00", "swimming", "less16"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach7, "Fri", "19:00 - 20:00", "swimming", "less17"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach6, "Tue", "19:00 - 20:00", "swimming", "less18"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach6, "Wed", "19:00 - 20:00", "swimming", "less19"));
       hatfieldLeisureCentre.addLesson(new Lesson(coach7, "Thu", "19:00 - 20:00", "gymnastics", "less20"));
       
       hatfieldLeisureCentre.lookupLessonByArea("swimming");
       hatfieldLeisureCentre.lookupLessonByArea("gymnastics");
       hatfieldLeisureCentre.lookupLessonByArea("badminton");
       
       hatfieldLeisureCentre.book("S01", "less10");
       hatfieldLeisureCentre.book("S01", "less01");
       hatfieldLeisureCentre.book("S01", "less20");
       hatfieldLeisureCentre.book("S02", "less10");
       hatfieldLeisureCentre.book("S03", "less10");
       hatfieldLeisureCentre.book("S04", "less10");
       hatfieldLeisureCentre.book("S05", "less10");
       hatfieldLeisureCentre.book("S06", "less10");
       hatfieldLeisureCentre.book("S07", "less11");
       hatfieldLeisureCentre.book("S07", "less12");
       hatfieldLeisureCentre.book("S08", "less13");
       hatfieldLeisureCentre.book("S09", "less14");
       hatfieldLeisureCentre.book("S010", "less15");
       hatfieldLeisureCentre.book("S011", "less16");
       hatfieldLeisureCentre.book("S012", "less17");
       
       hatfieldLeisureCentre.displayBookings();
       
       
        
    }
    public String addCoach(Coach coach){
        String coachId;
        idC = idC+1;
        coachId = "C0"+ String.valueOf(idC);
        coach.setId(coachId);
        coaches.put(coachId, coach);
        return coachId;
    }
    
    public void displayCoaches(){
        for (Map.Entry<String, Coach> entry : coaches.entrySet()) {
            String k = entry.getKey();
        //    String v = entry.getValue().;
            System.out.println(k);
        }
    }
    
    public String registerStudent(Student student){
        String studentId;
        idS = idS+1;
        studentId = "S0"+ String.valueOf(idS);
        students.put(studentId, student);
        student.setId(studentId);
        
        return studentId;
    }
    
    public void displayStudents(){
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            String k = entry.getKey();
            Student v = entry.getValue();
            System.out.println(k+": "+v.getFirstName()+" "+v.getLastName());
        }
    }
    
    public void addLesson(Lesson lesson){
        lessons.put(lesson.getId(), lesson);
    }
    
    public void displayLessons(){
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            Lesson v = entry.getValue();
            System.out.println(k+": "+v.getArea()+" / "+v.getDay()+" / "+v.getHour());
        }
    }
    
    public void lookupLessonByArea(String area){
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            Lesson v = entry.getValue();
            if(v.getArea().equals(area)){
                System.out.println(k+": "+v.getArea()+" / "+v.getDay()+" / "+v.getHour()+" / "+v.getCoachName());
            }
        }
    }
    
    public void lookupLessonByCoach(String coachName){
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            Lesson v = entry.getValue();
            if(v.getCoachName().equals(coachName)){
                System.out.println(k+": "+v.getArea()+" / "+v.getDay()+" / "+v.getHour()+" / "+v.getCoachName()+" / "+v.isFull());
            }
        }
    }
    
    public void book(String idS, String lessonId){
        Lesson lesson = lessons.get(lessonId);
        Student student = students.get(idS);
        if(lesson.isFull().equals("Full")){
            System.out.println("This class is fully booked");
        }else{
            Booking booking = new Booking(student, lesson, "Booked");
            String bookingNumber;
            bookNum = bookNum+1;
            bookingNumber = "B0"+ String.valueOf(bookNum);
            bookings.put(bookingNumber, booking);
            lesson.increaseStudentsNumber();
            lesson.updateState();
        }
    }
    
    public void displayBookings(){
        for (Map.Entry<String, Booking> entry : bookings.entrySet()) {
            String k = entry.getKey();
            Booking v = entry.getValue();
            System.out.println(k+": "+v.getStudentId()+" "+v.getLessonId()+" "+ v.getState());
        }
    }
    
    
   
    
    
}
