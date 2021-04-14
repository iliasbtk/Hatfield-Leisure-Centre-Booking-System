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
    
    public void addArea(String sport){
        expertiseArea.add(sport);
    }
    public void displayExpertiseArea(){
        for (String area : expertiseArea) {                                   
            System.out.println (area);
        }
    }

    
    public boolean hasExpertiseArea(String areaName){
        for (String area : expertiseArea) { 
            if(area == areaName){
                return true;
            }    
        }
        return false;
    }
    
    
}
