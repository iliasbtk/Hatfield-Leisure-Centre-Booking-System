/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl;

/**
 *
 * @author NGSI
 */
public class Booking {
    private Student student;
    private Lesson lesson;
    private String state;
    private String bookingNumber;
    
    public Booking(Student student, Lesson lesson, String state){
        this.student = student;
        this.lesson = lesson;
        this.state = state;
        
    }
    
    public void setBookNumber(String bookingNumber){
        this.bookingNumber = bookingNumber;
    }
    public Student getStudent(){
        return this.student;
    }
    public String getBookingNumber(){
        return bookingNumber;
    }
    public Lesson getLesson(){
        return this.lesson;
    }
    public String getState(){
        return state;
    }
    public void setState(String state){
        this.state= state;
    }
   
}
