package com.telusko;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Alien {

    @Id
    private int aid;
    private String aname;
    private String tech;
    /** here without mapped by it will create a separate table for alien and laptop mapping
     since we have already created a table for laptop and alien mapping in laptop class with the help of @ManyToOne annotation
     so we will use mapped by to tell that the mapping is already done in laptop class
     and we don't need to create a separate table for it.
    */

    /**
     * Rule of thumb the one is having @OneToMany annotation will be the parent and the one is having @ManyToOne annotation will be the child.
     * if we don't tell the parent that your child will create the mapping then parent will create it.
      */
    @OneToMany(mappedBy = "alien")
    private List<Laptop> laptops;

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

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
                ", laptops=" + laptops +
                '}';
    }
}
