/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl;

import java.util.HashMap;
import java.util.HashSet;
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
    Map<String, ParentAppointment> parentAppointments = new HashMap<> ();
    
    Integer idC=0;
    Integer idS=0;
    Integer bookNum=0;
    Integer idL=10;
    Integer idPA=0;
   
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
        
        
       
        
        Student student1 = new Student ("Loida", "Poon", "", "Brad");
        Student student2 = new Student ("Ewa", "Porto", "", "Linkon");
        Student student3 = new Student ("Dylan ", "Bucher", "", "Jimmy");
        Student student4 = new Student ("Reggie ", "Malan", "", "Smith");
        Student student5 = new Student ("Landon ", "Buel", "", "Henderson");
        Student student6 = new Student ("Enid ", "Lepine", "", "Eriksen");
        Student student7 = new Student ("Aiko ", "Redmon", "", "Marco");
        Student student8 = new Student ("Earl ", "Evatt", "", "Lucas");
        Student student9 = new Student ("Annita ", "Bruckner", "", "Sergio");
        Student student10 = new Student ("Emilee ", "Lubin", "", "Dani");
        Student student11 = new Student ("Estell ", "Dillenbeck", "", "Ferland");
        Student student12 = new Student ("Charleen ", "Boss", "", "Toni");
        Student student13 = new Student ("Chadwick ", "Fiscus", "", "Fede");
        Student student14 = new Student ("Steven", "Pullman", "", "Nacho");
        Student student15 = new Student ("Elizabeth", "Simpson", "", "Fernandez");
       
        
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
        
    
       
        
       hatfieldLeisureCentre.addLesson(new Lesson("Swimming 1", "swimming pool A",coach1, "Mon", "14:00 - 15:00", "swimming", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Badminton 1","badminton court A",coach1, "Tue", "14:00 - 15:00", "badminton", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Gymnastics 1","Gym",coach1, "Wed", "14:00 - 15:00", "gymnastics", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Swimming 1","swimming pool A",coach2, "Thu", "14:00 - 15:00", "swimming", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Swimming 1","swimming pool A",coach2, "Fri", "14:00 - 15:00", "swimming", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Badminton 1","badminton court A",coach2, "Mon", "14:00 - 15:00", "badminton", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Gymnastics 1","Gym",coach3, "Mon", "17:00 - 18:00", "gymnastics", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Gymnastics 1","Gym",coach3, "Tue", "17:00 - 18:00", "gymnastics", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Gymnastics 2","Gym",coach3, "Wed", "17:00 - 18:00", "gymnastics", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Swimming 1","swimming pool A",coach4, "Thu", "17:00 - 18:00", "swimming", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Gymnastics 2","Gym",coach4, "Fri", "17:00 - 18:00", "gymnastics", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Gymnastics 2","Gym",coach4, "Wed", "17:00 - 18:00", "gymnastics", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Badminton 2","badminton court B",coach5, "Mon", "19:00 - 20:00", "badminton", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Badminton 2","badminton court B",coach5, "Tue", "19:00 - 20:00", "badminton", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Gymnastics 3","Gym",coach5, "Wed", "19:00 - 20:00", "gymnastics", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Swimming 1","swimming pool B",coach6, "Thu", "19:00 - 20:00", "swimming", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Swimming 2","swimming pool B",coach7, "Fri", "19:00 - 20:00", "swimming", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Swimming 2","swimming pool B",coach6, "Tue", "19:00 - 20:00", "swimming", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Swimming 2","swimming pool B",coach6, "Wed", "19:00 - 20:00", "swimming", 5));
       hatfieldLeisureCentre.addLesson(new Lesson("Gymnastics 3","Gym",coach7, "Thu", "19:00 - 20:00", "gymnastics", 5));
       
      
       
       hatfieldLeisureCentre.book("S01", "less11");
       hatfieldLeisureCentre.book("S01", "less20");
       hatfieldLeisureCentre.book("S02", "less11");
       hatfieldLeisureCentre.book("S03", "less11");
       hatfieldLeisureCentre.book("S04", "less11");
       hatfieldLeisureCentre.book("S05", "less11");
       hatfieldLeisureCentre.book("S06", "less11");
       hatfieldLeisureCentre.book("S07", "less11");
       hatfieldLeisureCentre.book("S07", "less12");
       hatfieldLeisureCentre.book("S08", "less13");
       hatfieldLeisureCentre.book("S09", "less14");
       hatfieldLeisureCentre.book("S010", "less15");
       hatfieldLeisureCentre.book("S011", "less16");
       hatfieldLeisureCentre.book("S012", "less17");
     
      
       
       
       hatfieldLeisureCentre.bookApointment("Appoint016", "S01");
       hatfieldLeisureCentre.bookApointment("Appoint014", "S02");
       hatfieldLeisureCentre.bookApointment("Appoint015", "S03");
       hatfieldLeisureCentre.bookApointment("Appoint013", "S04");
       hatfieldLeisureCentre.bookApointment("Appoint016", "S05");
       hatfieldLeisureCentre.bookApointment("Appoint03", "S06");
       
       hatfieldLeisureCentre.report2();
       
       
        
    }
    
    public String addCoach(Coach coach){
        String coachId;
        idC = idC+1;
        coachId = "C0"+ String.valueOf(idC);
        coach.setId(coachId);
        coaches.put(coachId, coach);
        addCoachTimeSlots(coach);
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
        String lessonId;
        idL = idL+1;
        lessonId = "less"+ String.valueOf(idL);
        lessons.put(lessonId, lesson);
        lesson.setId(lessonId);
    }
    
    public void displayLessons(){
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            Lesson v = entry.getValue();
            System.out.println(k+": "+v.getArea()+" / "+v.getDay()+" / "+v.getHour());
        }
    }
    
    public Lesson getLesson(String lessonId){
        return lessons.get(lessonId);
    }
    
    public void lookupLessonByArea(String area){
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            Lesson v = entry.getValue();
            if(v.getArea().equals(area)){
                System.out.println(k+": "+v.getName()+" / "+v.getArea()+" / "+v.getDay()+" / "+v.getHour()+" / "+v.getCoachName()+" / "+v.isFull());
            }
        }
    }
    
    public void lookupLessonByCoach(String coachName){
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            Lesson v = entry.getValue();
            if(v.getCoachName().equals(coachName)){
                System.out.println(k+": "+v.getName()+" / "+v.getArea()+" / "+v.getDay()+" / "+v.getHour()+" / "+v.getCoachName()+" / "+v.isFull());
            }
        }
    }
    
    
    public Booking book(String idS, String lessonId){
        Lesson lesson = lessons.get(lessonId);
        Student student = students.get(idS);
        if(lesson.isFull().equals("Full")){
            System.out.println("This class is fully booked");
            return null;
        }else{
            Booking booking = new Booking(student, lesson, "Booked");
            String bookingNumber;
            bookNum = bookNum+1;
            bookingNumber = "B0"+ String.valueOf(bookNum);
            bookings.put(bookingNumber, booking);
            lesson.increaseStudentsNumber();
            return booking;
        }
        
    }
    
    public void displayBookings(){
        for (Map.Entry<String, Booking> entry : bookings.entrySet()) {
            String k = entry.getKey();
            Booking v = entry.getValue();
            System.out.println(k+": "+v.getStudentId()+" "+v.getLessonId()+" "+ v.getState());
        }
    }
    
    public void cancelBooking (String bookNum){
        Booking booking = bookings.get(bookNum);
        booking.setState("Canceled");
        Lesson lesson = lessons.get(booking.getLessonId());
        lesson.decreaseStudentsNumber();
    }
    public void changeBooking (String bookNum, String newLessonId){
        cancelBooking(bookNum);
        Booking booking = bookings.get(bookNum);
        book(booking.getStudentId(), newLessonId);
        booking.setState("Changed");
    }
    
    public void attendLesson (String bookNum){
        Booking booking = bookings.get(bookNum);
        booking.setState("Attended");
    }
    
    public void lookupTimeslotsByCoach(String coachName){
        for (Map.Entry<String, ParentAppointment> entry : parentAppointments.entrySet()) {
            String k = entry.getKey();
            ParentAppointment v = entry.getValue();
            if(v.getCoachName().equals(coachName)){
                System.out.println(k+": "+v.getCoachName()+" / "+v.getDay()+" / "+v.getTime()+" / Week: "+v.getWeek()+" / "+v.getState());
            }else{
                System.out.println("Coach name: "+coachName+" is incorrect");
            }
        }
    }
    public void lookupTimeslotsByArea(String area){
        for (Map.Entry<String, ParentAppointment> entry : parentAppointments.entrySet()) {
            String k = entry.getKey();
            ParentAppointment v = entry.getValue();
            for(String coachArea : v.getExpertiseArea()) {
                if(coachArea.equals(area)){
                    System.out.println(k+": "+v.getCoachName()+" / "+area+" / "+v.getDay()+" / "+v.getTime()+" / Week: "+v.getWeek()+" / "+v.getState());
                }
            }
        }
    }
    public void addCoachTimeSlots(Coach coach){
        for(Integer week=1; week <=4; week++){
            for (Integer slot=1; slot <=3; slot++){
                ParentAppointment parentAppointment = new ParentAppointment(coach, coach.getOfficeDay(), coach.getOfficeHours(),"Slot: "+slot, week);
                idPA = idPA+1;
                String appointmentId = "Appoint0"+ String.valueOf(idPA);
                parentAppointment.setId(appointmentId);
                parentAppointments.put(appointmentId, parentAppointment);
            }
        }
    }
    public void bookApointment(String appointmentId, String idS){
        ParentAppointment parentAppointment = parentAppointments.get(appointmentId);
        Student student = students.get(idS);
        if(parentAppointment.getState().equals("Availble")){
            parentAppointment.setBooked();
            parentAppointment.setIdS(idS);
            parentAppointment.setParentName(student.getParentName());    
        }else{
            System.out.println("This apointment slot is already booked");
        }
        
    }
    public void report1(){
        System.out.println("Lessons:");
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            Lesson v = entry.getValue();
            System.out.println(k+": "+v.getName()+" / "+v.getDay()+" / "+v.getHour()+" / Students number: "+v.getStudentNumber()+" / "+v.isFull());
        }
        System.out.println("Appointments:");    
        for (Map.Entry<String, ParentAppointment> entry : parentAppointments.entrySet()) {
            String k = entry.getKey();
            ParentAppointment v = entry.getValue();
            if(v.getState().equals("Booked")){
                System.out.println(k+": "+v.getWeek()+" / "+v.getDay()+" / "+v.getTime()+" / "+v.getSlot()+" / "+v.getParentName()+" / "+v.getCoachName());
            }
        }
    }
    public void report2(){
        for (Map.Entry<String, Student> entry1 : students.entrySet()) {
            String key1 = entry1.getKey();
            Student value1 = entry1.getValue();
            for (Map.Entry<String, Booking> entry2 : bookings.entrySet()) {
                String key2 = entry2.getKey();
                Booking value2 = entry2.getValue();
                if(value1.getId()==value2.getStudentId()){
                    System.out.println("Student: "+value1.getFirstName()+" "+value1.getLastName()+" is signed up for:");
                    System.out.println(value2.getLessonId()+" / "+value2.getLessonName());
                }          
            }    
        }
    }
   
    
   
    
   
    
    
   
    
    
}
