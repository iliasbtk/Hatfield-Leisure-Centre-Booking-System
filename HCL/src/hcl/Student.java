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
public class Student extends Personnel{
    
    private String parrentName;
    
    public Student(String firstName, String lastName, String address, String tel, String parrentName){
        super(firstName, lastName, address, tel);
        this.parrentName = parrentName;
    }
    public Student(String firstName, String lastName, String tel, String parrentName){
        super(firstName, lastName, tel);
        this.parrentName = parrentName;
    }
    
    
}
