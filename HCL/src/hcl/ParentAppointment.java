/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl;

import java.util.Set;

/**
 *
 * @author NGSI
 */
public class ParentAppointment {
    private String id;
    private String idS;
    private Coach coach;
    private String day;
    private String time;
    private Integer week;
    private String state = "Availble";
    
    
    public ParentAppointment(Coach coach, String day, String time, Integer week){
        this.coach = coach;
        this.day = day;
        this.time = time;
        this.week = week;
        
    }
    public void setIdC(String idS){
        this.idS = idS;
    }
    public void setState(String state){
        this.state = state;
    }
    public void setWeek(Integer week){
        this.week = week;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getCoachName(){
        return this.coach.getFirstName() + " " + this.coach.getLastName();
    }
    public Set<String> getExpertiseArea(){
        return coach.getExpertiseArea();
    }
    public String getDay(){
        return this.day;
    }
    public String getTime(){
        return this.time;
    }
    public String getState(){
        return this.state;
    }
    public Integer getWeek(){
        return this.week;
    }
}
