/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.petclinic.core;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pet {

    @Id @GeneratedValue
    private Long id;

    private String type;

    private String name;

    public Pet() {
    }

    public Pet(Long id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
