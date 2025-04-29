/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.petclinic.core;

import java.time.LocalDate;

//import org.hibernate.annotations.Cascade;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Visit {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String referenceNumber;

    private LocalDate date;

    private String purpose;

    @OneToOne(cascade = CascadeType.ALL)
    private Pet pet;

    @OneToOne(cascade = CascadeType.ALL)
    private Owner owner;

    public Visit() {
    }

    public Visit(Long id, String referenceNumber, LocalDate date, String purpose) {
        this.id = id;
        this.referenceNumber = referenceNumber;
        this.date = date;
        this.purpose = purpose;
    }

    public Visit(Long id, String referenceNumber, LocalDate date, String purpose, Pet pet, Owner owner) {
        this.id = id;
        this.referenceNumber = referenceNumber;
        this.date = date;
        this.purpose = purpose;
        this.pet = pet;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", date=" + date +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
