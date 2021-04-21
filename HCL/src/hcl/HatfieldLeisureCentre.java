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

    public String registerCoach(String firstName, String lastName, String tel, String officeHours, String officeDay) {
        if(firstName.equals("") || lastName.equals("") || tel.equals("") || officeHours.equals("") || officeDay.equals("")){
            return "Error";
        }
        Coach coach = new Coach(firstName, lastName, tel, officeHours, officeDay);
        return addCoach(coach);
    }
    
    public boolean coachDoesExist(String coachId){
        for (Map.Entry<String, Coach> entry : coaches.entrySet()) {
            String k = entry.getKey();
            if (k.equals(coachId)) {
                return true;
            }
        }
        return false;
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

    public String registerStudent(String firstName, String lastName, String address, String tel, String parrentName) {
        if(firstName.equals("") || lastName.equals("") || address.equals("") || tel.equals("") || parrentName.equals("")){
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
            System.out.println("The coach: " + lesson.getCoachName() + " is already teaching 3 lessons per week");
            return "Max lesson";
        } else if (lesson.getDay().equals(lesson.getCoach().getOfficeDay()) && lesson.getHour().equals(lesson.getCoach().getOfficeHours())) {
            System.out.println("The lesson time is conflicting with the coach " + lesson.getCoachName() + " 's office hour");
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

    public String displayLessons() {
        String result="";
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            Lesson v = entry.getValue();
            result = result + (k + ": " + v.getArea() + " / " + v.getDay() + " / " + v.getHour()+"\n");

        }
        System.out.println(result);
        return result;
    }

    public Lesson getLesson(String lessonId) {
        return lessons.get(lessonId);
    }

    public String lookupLessonByArea(String area) {
        String result = "";
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            Lesson v = entry.getValue();
            if (v.getArea().equals(area)) {
                result = result + (k + ": " + v.getName() + " / " + v.getArea() + " / " + v.getDay() + " / " + v.getHour() + " / " + v.getCoachName() + " / " + v.isFull() + "\n");
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
            if (v.getCoachName().equals(coachName)) {
                result = result + (k + ": " + v.getName() + " / " + v.getArea() + " / " + v.getDay() + " / " + v.getHour() + " / " + v.getCoachName() + " / " + v.isFull() + "\n");
            }
        }
        System.out.println(result);
        return result;
    }

    public boolean checkSameTimeLessons(String idS, Lesson lesson) {
        String day = lesson.getDay();
        String time = lesson.getHour();
        for (Map.Entry<String, Booking> entry : bookings.entrySet()) {
            String k = entry.getKey();
            Booking v = entry.getValue();
            if (v.getStudentId().equals(idS)) {
                if (v.getDay().equals(day)) {
                    if (v.getTime().equals(time)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String book(String idS, String lessonId) {
        if(idS.equals("") || lessonId.equals("")){
            return "Empty Fields";
        }
        String error="";
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            Lesson v = entry.getValue();
            if (v.getId().equals(lessonId)) {
                error = "Exist";
            }
        }
        if(!error.equals("Exist")){
            return "Error";
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

    public String displayBookings() {
        String result="";
        for (Map.Entry<String, Booking> entry : bookings.entrySet()) {
            String k = entry.getKey();
            Booking v = entry.getValue();
            result = result + (k + ": " + v.getStudentId() + " " + v.getLessonId() + " " + v.getState()+"\n");
        }
        System.out.println(result);
        return result;
    }

    public String cancelBooking(String bookNum) {
        if(bookNum.equals("")){
            return "Empty Fields";
        }
        String error="";
        for (Map.Entry<String, Booking> entry : bookings.entrySet()) {
            Booking v = entry.getValue();
            if (v.getBookingNumber().equals(bookNum)) {
                error = "Exist";
            }
        }
        if(error.equals("")){
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
        book(booking.getStudentId(), newLessonId);
        booking.setState("Changed");

        return book(booking.getStudentId(), newLessonId);
    }

    public String attendLesson(String bookNum) {
        if(bookNum.equals("")){
            return "Empty Fields";
        }
        String error="";
        for (Map.Entry<String, Booking> entry : bookings.entrySet()) {
            String k = entry.getKey();
            if (k.equals(bookNum)) {
                error = "Exist";
            }
        }
        if(error.equals("")){
            return"Error";
        }
        Booking booking = bookings.get(bookNum);
        booking.setState("Attended");
        return bookNum;
    }

    public String lookupTimeslotsByCoach(String coachName) {
        String result = "";
        for (Map.Entry<String, ParentAppointment> entry : parentAppointments.entrySet()) {
            String k = entry.getKey();
            ParentAppointment v = entry.getValue();
            if (v.getCoachName().equals(coachName)) {
                result = result + (k + ": " + v.getCoachName() + " / " + v.getDay() + " / " + v.getTime() + " / Week: " + v.getWeek() + " / " + "Slot: " + v.getSlot() + " / " + v.getState() + "\n");
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
            for (String coachArea : v.getExpertiseArea()) {
                if (coachArea.equals(area)) {
                    result = result + (k + ": " + v.getCoachName() + " / " + area + " / " + v.getDay() + " / " + v.getTime() + " / Week: " + v.getWeek() + " / " + "Slot: " + v.getSlot() + " / " + v.getState() + "\n");
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public void bookApointment(String appointmentId, String idS) {
        ParentAppointment parentAppointment = parentAppointments.get(appointmentId);
        Student student = students.get(idS);
        if (parentAppointment.getState().equals("Availble")) {
            parentAppointment.setBooked();
            parentAppointment.setIdS(idS);
            parentAppointment.setParentName(student.getParentName());
        } else {
            System.out.println("This apointment slot is already booked");
        }

    }

    public void report1() {
        System.out.println("Lessons:");
        for (Map.Entry<String, Lesson> entry : lessons.entrySet()) {
            String k = entry.getKey();
            Lesson v = entry.getValue();
            System.out.println(k + ": " + v.getName() + " / " + v.getDay() + " / " + v.getHour() + " / Students number: " + v.getStudentNumber() + " / " + v.isFull());
        }
        System.out.println("Appointments:");
        for (Map.Entry<String, ParentAppointment> entry : parentAppointments.entrySet()) {
            String k = entry.getKey();
            ParentAppointment v = entry.getValue();
            if (v.getState().equals("Booked")) {
                System.out.println(k + ": " + v.getWeek() + " / " + v.getDay() + " / " + v.getTime() + " / " + v.getSlot() + " / " + v.getParentName() + " / " + v.getCoachName());
            }
        }
    }

    public void report2() {
        for (Map.Entry<String, Student> entry1 : students.entrySet()) {
            String key1 = entry1.getKey();
            Student value1 = entry1.getValue();
            for (Map.Entry<String, Booking> entry2 : bookings.entrySet()) {
                String key2 = entry2.getKey();
                Booking value2 = entry2.getValue();
                if (value1.getId() == value2.getStudentId()) {
                    System.out.println("Student: " + value1.getFirstName() + " " + value1.getLastName() + " is signed up for:");
                    System.out.println(value2.getLessonId() + " / " + value2.getLessonName());
                }
            }
        }
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
    public String displayCoaches() {
        String result = "";
        for (Map.Entry<String, Coach> entry : coaches.entrySet()) {
            String k = entry.getKey();
            Coach v = entry.getValue();
            System.out.println(k + " / " + v.getFullName());
            result = result + (k + " / " + v.getFullName() + "\n");
        }
        return result;
    }

    public void displayStudents() {
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            String k = entry.getKey();
            Student v = entry.getValue();
            System.out.println(k + ": " + v.getFullName());
        }
    }

}
