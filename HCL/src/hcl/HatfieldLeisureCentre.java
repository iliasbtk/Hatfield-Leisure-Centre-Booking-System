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
public class HatfieldLeisureCentre {

    Map<String, Student> students = new HashMap<>();
    Map<String, Coach> coaches = new HashMap<>();
    Map<String, Lesson> lessons = new HashMap<>();
    Map<String, Booking> bookings = new HashMap<>();
    Map<String, ParentAppointment> parentAppointments = new HashMap<>();

    Integer idC = 0;
    Integer idS = 0;
    Integer bookNum = 0;
    Integer idL = 10;
    Integer idPA = 0;
    
    /*
    Student
    */

    public String registerStudent(String firstName, String lastName, String address, String tel, String parrentName) {
        if (firstName.equals("") || lastName.equals("") || address.equals("") || tel.equals("") || parrentName.equals("")) {
            return "Error";
        }
        Student student = new Student(firstName, lastName, address, tel, parrentName);
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            Student v = entry.getValue();
            if (v.getFullName().equals(student.getFullName())) {
                System.out.println("This student named: " + student.getFullName() + " is already registered");
                return "";
            }
        }
        String studentId = generateId("S0", idS);
        students.put(studentId, student);
        student.setId(studentId);
        return studentId;
    }
    public String lookupLessonByArea(String area) {
        String result = "";
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            Lesson v = entry.getValue();
            if (v.getArea().equals(area)) {
                result = result + (k + ": " + v.getName() + " / " + v.getArea() + " / " + v.getDay() + " / " + v.getHour() + " / " + v.getCoach().getFullName() + " / " + v.isFull() + "\n");
            }
        }
        System.out.println(result);
        return result;

    }

    public String lookupLessonByCoach(String coachName) {
        String result = "";
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            Lesson v = entry.getValue();
            if (v.getCoach().getFullName().equals(coachName)) {
                result = result + (k + ": " + v.getName() + " / " + v.getArea() + " / " + v.getDay() + " / " + v.getHour() + " / " + v.getCoach().getFullName() + " / " + v.isFull() + "\n");
            }
        }
        System.out.println(result);
        return result;
    }
    public String book(String idS, String lessonId) {
        if(idS.equals("") || lessonId.equals("")){
            return "Empty Fields";
        }
        if(!studentDoesExist(idS)){
            return "Error studentId";
        }
        if(!lessonDoesExist(lessonId)){
            return "Error lessonId";
        }
        Lesson lesson = lessons.get(lessonId);
        Student student = students.get(idS);
        if (checkSameTimeLessons(idS, lesson)) {
            System.out.println("You are already registered in a class running at the same time");
            return "Already enrolled into a class running at the same time";
        }
        if (lesson.isFull().equals("Full")) {
            System.out.println("This class is fully booked");
            return "Lesson full";
        } else {
            Booking booking = new Booking(student, lesson, "Booked");
            String bookingNumber;
            bookNum = bookNum + 1;
            bookingNumber = "B0" + String.valueOf(bookNum);
            booking.setBookNumber(bookingNumber);
            bookings.put(bookingNumber, booking);
            lesson.increaseStudentsNumber();
            return bookingNumber;
        }
    }
    public String cancelBooking(String bookNum) {
        if(bookNum.equals("")){
            return "Empty Fields";
        }
        if(!bookingDoesExist(bookNum)){
            return"Error";
        }
        Booking booking = bookings.get(bookNum);
        booking.setState("Canceled");
        Lesson lesson = booking.getLesson();
        lesson.decreaseStudentsNumber();
        return "The booking: "+bookNum+" is succesfully canceled";
    }

    public String changeBooking(String bookNum, String newLessonId) {
        if(bookNum.equals("") || newLessonId.equals("")){
            return "Empty Fields";
        }
        if(cancelBooking(bookNum).equals("Error")){
            return "Error";
        }
        Booking booking = bookings.get(bookNum);
        book(booking.getStudent().getId(), newLessonId);
        booking.setState("Changed");

        return book(booking.getStudent().getId(), newLessonId);
    }

    public String attendLesson(String bookNum) {
        if(bookNum.equals("")){
            return "Empty Fields";
        }
        if(!bookingDoesExist(bookNum)){
            return"Error";
        }
        Booking booking = bookings.get(bookNum);
        booking.setState("Attended");
        return bookNum;
    }
    /*
    Student's parent
    */
    public String lookupTimeslotsByCoach(String coachName) {
        String result = "";
        for (Map.Entry<String, ParentAppointment> entry : parentAppointments.entrySet()) {
            String k = entry.getKey();
            ParentAppointment v = entry.getValue();
            if (v.getCoach().getFullName().equals(coachName)) {
                result = result + (k + ": " + v.getCoach().getFullName() + " / " + v.getDay() + " / " + v.getTime() + " / Week: " + v.getWeek() + " / " + "Slot: " + v.getSlot() + " / " + v.getState() + "\n");
            }
        }
        if (result == "") {
            result = "Coach name: " + coachName + " is incorrect";
        }
        System.out.println(result);
        return result;
    }

    public String lookupTimeslotsByArea(String area) {
        String result = "";
        for (Map.Entry<String, ParentAppointment> entry : parentAppointments.entrySet()) {
            String k = entry.getKey();
            ParentAppointment v = entry.getValue();
            for (String coachArea : v.getCoach().getExpertiseArea()) {
                if (coachArea.equals(area)) {
                    result = result + (k + ": " + v.getCoach().getFullName() + " / " + area + " / " + v.getDay() + " / " + v.getTime() + " / Week: " + v.getWeek() + " / " + "Slot: " + v.getSlot() + " / " + v.getState() + "\n");
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public String bookApointment(String appointmentId, String idS) {
        if(appointmentId.equals("") || idS.equals("")){
            return "Empty Fields";
        }
        if(!appointmentDoesExist(appointmentId)){
            return"Error appointmentId";
        }
        if(!studentDoesExist(idS)){
            return"Error studentId";
        }        
        ParentAppointment parentAppointment = parentAppointments.get(appointmentId);
        Student student = students.get(idS);
        if (parentAppointment.getState().equals("Availble")) {
            parentAppointment.setBooked();
            parentAppointment.setIdS(idS);
            parentAppointment.setParentName(student.getParentName());
            return "Booked";
        } else {
            return "This apointment slot is already booked";
        }
    }    
        
    /*
    Helper Methods    
    */ 
    public boolean coachDoesExist(String coachId) {
        for (Map.Entry<String, Coach> entry : coaches.entrySet()) {
            String k = entry.getKey();
            if (k.equals(coachId)) {
                return true;
            }
        }
        return false;
    }  
    public boolean studentDoesExist(String studentId) {
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            String k = entry.getKey();
            if (k.equals(studentId)) {
                return true;
            }
        }
        return false;
    }  
    public boolean lessonDoesExist(String lessonId) {
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            if (k.equals(lessonId)) {
                return true;
            }
        }
        return false;
    }  
    public boolean bookingDoesExist(String bookingNum) {
        for (Map.Entry<String, Booking> entry : bookings.entrySet()) {
            String k = entry.getKey();
            if (k.equals(bookingNum)) {
                return true;
            }
        }
        return false;
    }  
    public boolean appointmentDoesExist(String bookingNum) {
        for (Map.Entry<String, ParentAppointment> entry : parentAppointments.entrySet()) {
            String k = entry.getKey();
            if (k.equals(bookingNum)) {
                return true;
            }
        }
        return false;
    }  
    
    /*
    Coach
    */
    public String registerCoach(String firstName, String lastName, String tel, String officeHours, String officeDay) {
        if (firstName.equals("") || lastName.equals("") || tel.equals("") || officeHours.equals("") || officeDay.equals("")) {
            return "Error";
        }
        Coach coach = new Coach(firstName, lastName, tel, officeHours, officeDay);
        return addCoach(coach);
    }
    public String addCoach(Coach coach) {
        for (Map.Entry<String, Coach> entry : coaches.entrySet()) {
            Coach v = entry.getValue();
            if (v.getFullName().equals(coach.getFullName())) {
                System.out.println("This coach named: " + coach.getFullName() + " is already registered");
                return "";
            }
        }
        String coachId = generateId("C0", idC);
        coach.setId(coachId);
        coaches.put(coachId, coach);
        addCoachTimeSlots(coach);
        return coachId;
    }
    
    public void addCoachTimeSlots(Coach coach) {
        for (Integer week = 1; week <= 4; week++) {
            for (Integer slot = 1; slot <= 3; slot++) {
                ParentAppointment parentAppointment = new ParentAppointment(coach, coach.getOfficeDay(), coach.getOfficeHours(), "Slot: " + slot, week);
                idPA = idPA + 1;
                String appointmentId = "Appoint0" + String.valueOf(idPA);
                parentAppointment.setId(appointmentId);
                parentAppointments.put(appointmentId, parentAppointment);
            }
        }
    }



    
    /*
    Administration
    */
    public String displayCoaches() {
        String result = "";
        for (Map.Entry<String, Coach> entry : coaches.entrySet()) {
            String k = entry.getKey();
            Coach v = entry.getValue();
            System.out.println(k + " / " + v.getFullName());
            result = result + (k + " / " + v.getFullName() + " / Office hour: " + v.getOfficeDay() + "  " + v.getOfficeHours() + "\n");
        }
        return result;
    }
    public String displayStudents() {
        String result = "";
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            String k = entry.getKey();
            Student v = entry.getValue();
            System.out.println(k + ": " + v.getFullName()+" / Parent name: "+v.getParentName());
            result = result + (k + ": " + v.getFullName()+" / Parent name: "+v.getParentName()+"\n");
        }
        return result;
    }
    public String addLesson(String name, String place, String coachId, String day, String hour, String area, Integer capacity) {
        if(name.equals("") || place.equals("") || coachId.equals("") || day.equals("") || hour.equals("")){
            return "Empty Fields";
        }
        if(!coachDoesExist(coachId)){
            return "Coach not registered";
        }
        Coach coach = coaches.get(coachId);
        if(!coach.hasExpertiseArea(area)){
            return "Expertise area not teached by the coach";
        }
        Lesson lesson = new Lesson(name, place, coaches.get(coachId), day, hour, area, capacity);
        if (lesson.getCoach().getLessonsNumber() >= 3) {
            System.out.println("The coach: " + lesson.getCoach().getFullName() + " is already teaching 3 lessons per week");
            return "Max lesson";
        } else if (lesson.getDay().equals(lesson.getCoach().getOfficeDay()) && lesson.getHour().equals(lesson.getCoach().getOfficeHours())) {
            System.out.println("The lesson time is conflicting with the coach " + lesson.getCoach().getFullName() + " 's office hour");
            return "Time conflict";
        } else {
            String lessonId;
            idL = idL + 1;
            lessonId = "less" + String.valueOf(idL);
            lessons.put(lessonId, lesson);
            lesson.setId(lessonId);
            lesson.getCoach().increaseLessonNumbers();
            return lessonId;
        }
    }
    public Lesson getLesson(String lessonId) {
        return lessons.get(lessonId);
    }
    public String displayBookings() {
        String result = "";
        for (Map.Entry<String, Booking> entry : bookings.entrySet()) {
            String k = entry.getKey();
            Booking v = entry.getValue();
            result = result + (k + ": " + v.getStudent().getId() + " " + v.getLesson().getId() + " " + v.getState() + "\n");
        }
        System.out.println(result);
        return result;
    }

    public String report1() {
        String result="";
        result = result+"Lessons:\n";
        System.out.println("Lessons:");
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            Lesson v = entry.getValue();
            result=result+(k + ": " + v.getName() + " / " + v.getDay() + " / " + v.getHour() + " / Students number: " + v.getStudentNumber() + " / " + v.isFull()+"\n");
            System.out.println(k + ": " + v.getName() + " / " + v.getDay() + " / " + v.getHour() + " / Students number: " + v.getStudentNumber() + " / " + v.isFull());
        }
        result = result+"Appointments:\n";
        System.out.println("Appointments:");
        for (Map.Entry<String, ParentAppointment> entry : parentAppointments.entrySet()) {
            String k = entry.getKey();
            ParentAppointment v = entry.getValue();
            if (v.getState().equals("Booked")) {
                result=result+(k + ": " + v.getWeek() + " / " + v.getDay() + " / " + v.getTime() + " / " + v.getSlot() + " / " +
                        v.getParentName() + " / " + v.getCoach().getFullName()+"\n");
                System.out.println(k + ": " + v.getWeek() + " / " + v.getDay() + " / " + v.getTime() + " / " + v.getSlot() +
                        " / " + v.getParentName() + " / " + v.getCoach().getFullName());
            }
        }
        return result;
    }
    public String studentReport(String studentId) {
        String result="";
        result = result+"Lessons:\n";
        for (Map.Entry<String, Booking> entry : bookings.entrySet()) {
            String k = entry.getKey();
            Booking v = entry.getValue();
            if(v.getStudent().getId().equals(studentId)){
                result=result+(k + ": " + v.getLesson().getName() + " / " + v.getLesson().getArea()  + " / " + v.getLesson().getDay() +" / "+v.getLesson().getHour() + "\n");
            } 
        }
        result = result+"Appointments:\n";
        for (Map.Entry<String, ParentAppointment> entry : parentAppointments.entrySet()) {
            String k = entry.getKey();
            ParentAppointment v = entry.getValue();
            if(v.getState().equals("Booked")){
                if (v.getStudentId().equals(studentId)) {
                    result=result+(k + ": / Week: " + v.getWeek() + " / Day: " + v.getDay() + " / " + v.getTime() + " / " + v.getSlot() + " / Parent: " +
                    v.getParentName() + " / Coach Name: " + v.getCoach().getFullName()+"\n");
                }
            }
            
        }
        return result;
    }
        public String coachReport(String coachId) {
        String result="";
        result = result+"Lessons:\n";
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            Lesson v = entry.getValue();
            if(v.getCoach().getId().equals(coachId)){
                result=result+(k + ": " + v.getName() + " / " + v.getDay() + " / " + v.getHour() + " / Students number: " + v.getStudentNumber() + "\n");
            } 
        }
        result = result+"Appointments:\n";
        for (Map.Entry<String, ParentAppointment> entry : parentAppointments.entrySet()) {
            String k = entry.getKey();
            ParentAppointment v = entry.getValue();
            if(v.getState().equals("Booked")){
                if (v.getCoach().getId().equals(coachId)) {
                    result=result+(k + ": / Week: " + v.getWeek() + " / Day: " + v.getDay() + " / " + v.getTime() + " / " + v.getSlot() + " / Parent: " +
                    v.getParentName() + " / Student Name: " + students.get(v.getStudentId()).getFullName()+"\n");
                }
            }
            
        }
        return result;
    }

    public String report2() {
        String result="";
        for (Map.Entry<String, Student> entry1 : students.entrySet()) {
            String key1 = entry1.getKey();
            Student value1 = entry1.getValue();
            for (Map.Entry<String, Booking> entry2 : bookings.entrySet()) {
                String key2 = entry2.getKey();
                Booking value2 = entry2.getValue();
                if (value1.getId() == value2.getStudent().getId()) {
                    result=result+"Student: " + value1.getFirstName() + " " + value1.getLastName() + " is signed up for:\n"+
                            value2.getLesson().getId() + " / " + value2.getLesson().getName()+"\n";
                    System.out.println("Student: " + value1.getFirstName() + " " + value1.getLastName() + " is signed up for:");
                    System.out.println(value2.getLesson().getId() + " / " + value2.getLesson().getName());
                }
            }
        }
        return result;
    }
 

    
    





    



    public boolean checkSameTimeLessons(String idS, Lesson lesson) {
        String day = lesson.getDay();
        String time = lesson.getHour();
        for (Map.Entry<String, Booking> entry : bookings.entrySet()) {
            String k = entry.getKey();
            Booking v = entry.getValue();
            if (v.getStudent().getId().equals(idS)) {
                if (v.getLesson().getDay().equals(day)) {
                    if (v.getLesson().getHour().equals(time)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    





    /*
    Helper Methods
     */
    public String generateId(String code, Integer i) {
        String id;
        i = i + 1;
        switch (code) {
            case "S0":
                idS = i;
                break;
            case "C0":
                idC = i;
                break;
            default:
                ;
                break;
        }

        id = code + String.valueOf(i);
        return id;
    }

    /*
    Testing methods
     */

   

}
