package com.lpr.lprs.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "vehicle_log")
public class VehicleLog {

    //data type mesti sama ngan collum type kat db 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plateNum")
    private String plateNum;

    @Column(name = "entry_time")
    private Timestamp entryTime;

    @Column(name = "exit_time")
    private Timestamp exitTime;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    public Timestamp getExitTime() {
        return exitTime;
    }

    public void setExitTime(Timestamp exitTime) {
        this.exitTime = exitTime;
    }
}