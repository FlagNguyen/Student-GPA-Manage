/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author asus
 */
public class Student extends Person{
    private int student_id;
    private String class_name;

    public Student(int student_id, String class_name) {
        this.student_id = student_id;
        this.class_name = class_name;
    }

    public Student(int student_id, String class_name, String name, String address, String phone) {
        super(name, address, phone);
        this.student_id = student_id;
        this.class_name = class_name;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Student() {
    } 
    
    
}
