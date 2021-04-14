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
public class Lesson {
    private Coach coach;
    private String day;
    private String hour;
    private String area;
    private boolean isFull = false ;
    private String lessonId;
    private Integer studentsNumber = 0;
    
    public Lesson(Coach coach, String day, String hour, String area, String lessonId){
        if(coach.hasExpertiseArea(area) == true){
            this.coach = coach;
            this.day = day;
            this.hour = hour;
            this.area = area;
            this.lessonId = lessonId;
        }else {
            System.out.println ("The Coach: " + coach.getFirstName() + " " + coach.getLastName() + " does not teach " + area);
        }
    }
    
    public String getId(){
        return lessonId;
    }
    public String getArea(){
        return area;
    }
    public String getDay(){
        return day;
    }
    public String getHour(){
        return hour;
    }
    public String getCoachName(){
        return this.coach.getFirstName() + " " + this.coach.getLastName();
    }
    public void updateState(){
        if(this.studentsNumber == 5){
            this.isFull = true;
        }else if(this.studentsNumber < 5){
            this.isFull = false;
        }
    }
    public String isFull(){
        if(isFull == true){
            return "Full";
        }else{
            return "Availble";
        }
    }
    public void increaseStudentsNumber(){
        this.studentsNumber +=1;
    }
    
    
}
