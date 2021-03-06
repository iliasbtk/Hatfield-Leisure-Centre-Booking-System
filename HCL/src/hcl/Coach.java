/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author NGSI
 */
public class Coach extends Personnel {
    
    Set<String> expertiseArea = new HashSet<> ();
    private String officeHours;
    private String officeDay;
    private Integer lessonsNumber=0;
    
    public Coach(String firstName, String lastName, String address, String tel, String officeHours, String officeDay){
        super(firstName, lastName, address, tel);
        this.officeHours = officeHours;
        this.officeDay = officeDay;
    }
    public Coach(String firstName, String lastName, String tel, String officeHours, String officeDay){
        super(firstName, lastName, tel);
        this.officeHours = officeHours;
        this.officeDay = officeDay;
    }
    public String getOfficeHours(){
        return this.officeHours;
    }
    public String getOfficeDay(){
        return this.officeDay;
    }
    public Integer getLessonsNumber(){
        return this.lessonsNumber;
    }
    public Set<String> getExpertiseArea(){
        return expertiseArea;
    }
    
    public void addArea(String sport){
        expertiseArea.add(sport);
    }
    public String displayExpertiseArea(){
        String result="";
        System.out.println ("Coach: " + this.getFullName() +" - Expertise area:");
        for (String area : expertiseArea) {       
            result+=area+", ";
            System.out.println (area);
        }
        return result;
    }
    public boolean hasExpertiseArea(String areaName){
        for (String area : expertiseArea) { 
            if(area.equals(areaName)){
                return true;
            }    
        }
        return false;
    }
    public void increaseLessonNumbers(){
        this.lessonsNumber +=1;
    }
    
    
}
