package com.petclinic.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;

@SpringBootTest
class OwnerServiceTest {

    @Autowired
    OwnerService ownerService;

    @BeforeEach
    public void setup() {
        Owner owner = new Owner(1L, "Sarah", "H", 2034);
        owner.setPets(List.of(new Pet(null, "dog", "Luna"), new Pet(null, "cat", "Miro")));
        ownerService.save(owner);
    }

    @Test
    @Transactional
    void shouldFindOwnerByFirstName(){
        Owner result = ownerService.findByFirstName("Sarah");
        assertEquals("Sarah", result.getFirstName());
    }

    @Test
    @Transactional
    void shouldFindOwnerWithPets(){
        Owner result = ownerService.findByFirstName("Sarah");
        assertThat(result.getPets()).extracting(Pet::getName).contains("Luna");
    }
}