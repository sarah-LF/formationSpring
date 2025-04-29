/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.petclinic.core;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Owner {

    @Id @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private double accountStatement;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Owner() {
    }

    public Owner(Long id, String firstName, String lastName, double accountStatement) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountStatement = accountStatement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAccountStatement() {
        return accountStatement;
    }

    public void setAccountStatement(double accountStatement) {
        this.accountStatement = accountStatement;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
