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
abstract public class Personnel {
    private String firstName;
    private String lastName;
    private String address;
    private String tel;
    private String id;
    
    public Personnel(String firstName, String lastName, String address, String tel){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.tel = tel;
    }
    
    public Personnel(String firstName, String lastName, String tel){
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
    }
    
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getFullName(){
        return this.getFirstName() + " " + this.getLastName();
    }
    public void setId(String id){
        this.id = id; 
    }
    public String getId(){
        return id;
    }
}
