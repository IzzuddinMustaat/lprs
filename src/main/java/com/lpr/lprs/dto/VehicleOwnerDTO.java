

package com.lpr.lprs.dto;

public class VehicleOwnerDTO {

    private String plateNum;
    private String ownerId;
    private String name;
    private String type;

    // EMPTY CONSTRUCTOR
    public VehicleOwnerDTO() {
    }

    // THIS CONSTRUCTOR IS REQUIRED
    public VehicleOwnerDTO(String plateNum, String ownerId, String name, String type) {

        this.plateNum = plateNum;
        this.ownerId = ownerId;
        this.name = name;
        this.type = type;
    }

    // GETTERS & SETTERS

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}