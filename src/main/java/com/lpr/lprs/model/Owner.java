package com.lpr.lprs.model;

import jakarta.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @Column(name = "ownerId")
    private String ownerId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    // getters/setters
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