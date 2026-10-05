package com.lpr.lprs.dto;

public class RegistrationDTO {

    private String ownerId;
    private String name;
    private String type;

    private String plateNum;
    private String colour;
    private String model;

    // Owner ID
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Plate Number
    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    // Colour
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    // Model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}