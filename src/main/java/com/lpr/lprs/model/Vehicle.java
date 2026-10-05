package com.lpr.lprs.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    //data type mesti sama ngan collum type kat db

    @Id
    @Column(name = "plateNum")
    private String plateNum;

    @Column(name = "colour")
    private String colour;

    @Column(name = "model")
    private String model;

    // getters and setters
    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}