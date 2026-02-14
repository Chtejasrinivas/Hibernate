package com.telusko;

import jakarta.persistence.*;

@Entity
@Table(name = "alien_table")
public class Alien {

    @Id
    private int aid;

    @Column(name = "alien_name")
    private String aname;


    // If we use Transient annotation then this variable will not be stored in the database
    // it will not be considered as a column in the table.
    @Transient
    private String tech;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }


    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
