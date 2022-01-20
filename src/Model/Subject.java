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
public class Subject {
    private int subject_id;
    private String subject_name;
    private int credit;
    private int type;

    public Subject() {
    }

    public Subject(int subject_id, String subject_name, int credit, int type) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.credit = credit;
        this.type = type;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String type ="";
        
        switch (this.type){
            case 1: 
                type = "General";
                break;
            case 2:
                type = "Fundamental";
                break;
            case 3:
                type = "Specialized";
                break;
        }
        
        String out = String.format("%-5d| %-20s| %-10d| %-15s|", getSubject_id(),getSubject_name(),getCredit(),type);
        return out;
    }
    
    
}
