package com.jb.mailservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmailEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    private String name;
    private String email;

    public EmailEntry(){

    }

    public void setID(Integer ID){
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "Name: " + name + " Email: " + email;
    }
}
