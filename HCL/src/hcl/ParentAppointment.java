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
    private String parentName;
    private Coach coach;
    private String day;
    private String time;
    private Integer week;
    private String state = "Availble";
    private String slot; 
    
    
    
    public ParentAppointment(Coach coach, String day, String time, String slot, Integer week){
        this.coach = coach;
        this.day = day;
        this.time = time;
        this.slot = slot;
        this.week = week;
        
    }
    
    public void setIdS(String idS){
        this.idS = idS;
    }
    public void setParentName(String parentName){
        this.parentName = parentName;
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

    public void setSlot(){
        this.slot = slot;
    }
    public String getId(){
        return this.id;
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

    public String getParentName(){
        return this.parentName;
    }
    public String getSlot(){
        return this.slot;
    }
    public void setBooked(){
        this.state = "Booked";
    }
}
