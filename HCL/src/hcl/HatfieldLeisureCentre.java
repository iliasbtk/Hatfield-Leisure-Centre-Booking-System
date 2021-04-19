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
    
    public String registerCoach(String firstName, String lastName, String tel, String officeHours, String officeDay){
        Coach coach = new Coach(firstName, lastName, tel, officeHours, officeDay);
        return addCoach(coach);
    }
    
    public String addCoach(Coach coach){
        for (Map.Entry<String, Coach> entry : coaches.entrySet()) {
            Coach v = entry.getValue();
            if(v.getFullName().equals(coach.getFullName())){
                System.out.println("This coach named: "+coach.getFullName()+" is already registered");
                return"";
            }
        }
        String coachId = generateId("C0",idC);
        coach.setId(coachId);
        coaches.put(coachId, coach);
        addCoachTimeSlots(coach);
        return coachId;
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
   
    /*
    Helper Methods
    */
    public String generateId(String code, Integer i){
        String id;
        i = i+1;
        switch(code)
        {
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
        
        id = code+ String.valueOf(i);
        return id;        
    }
    public String displayCoaches(){
        String result="";
        for (Map.Entry<String, Coach> entry : coaches.entrySet()) {
            String k = entry.getKey();
            Coach v = entry.getValue();
            System.out.println(k+" / "+ v.getFullName());
            result = result+(k+" / "+ v.getFullName()+"\n");
        }
        return result;
    }
    
    
}
