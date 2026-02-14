package com.telusko;

import jakarta.persistence.Embeddable;

// Laptop class is not an entity, it is a component of Alien class.
// It is not a separate table in the database. It is embedded in the Alien table.
// It is a value type. It does not have its own identity. It is not a separate entity. It is a part of the Alien entity.
@Embeddable
public class Laptop {
    private String brand;
    private String model;
    private int ram;


    public void setModel(String model) {
        this.model = model;
    }


    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public String getModel() {
        return model;
    }


    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
