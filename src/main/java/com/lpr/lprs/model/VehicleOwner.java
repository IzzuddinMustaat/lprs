package com.lpr.lprs.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_owner")
public class VehicleOwner {

    @Id
    @Column(name = "plateNum")
    private String plateNum;

    @Column(name = "ownerId")
    private String ownerId;

    // getters and setters
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
    
}
