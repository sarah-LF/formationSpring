package com.petclinic.core;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;

@SpringBootTest // permet les @Autowired
//@DataJpaTest // permet de charger un sous-ensemble de packages
class VisitServiceTest {

    @Autowired
    VisitService visitService;

    @BeforeEach
    public void setup() {
        Visit visit = new Visit(null, "V01-23", LocalDate.of(2013, 12, 21), "Teeth whitening");
        visit.setPet(new Pet(null, "dog", "luna"));
        visit.setOwner(new Owner(null, "joe", "satriani", 1000));
        visitService.save(visit);
    }

    @Test
    @Transactional
    void shouldFindByReferenceNumber(){
        Visit result = visitService.findByReferenceNumber("V01-23");
        assertEquals("V01-23", result.getReferenceNumber());
    }

    @Test
//    @Transactional
    void shouldNotFindVisitWithReferenceNumber(){
        Visit result = visitService.findByReferenceNumber("blabla");
        assertEquals(null, result);
    }

    @Test
    @Transactional
    void shouldFindVisitWithPet(){
        Visit result = visitService.findByReferenceNumber("V01-23");
        assertEquals("luna", result.getPet().getName());
    }

    @Test
    @Transactional
    void shouldFindVisitWithOwner(){
        Visit result = visitService.findByReferenceNumber("V01-23");
        assertEquals("joe", result.getOwner().getFirstName());
    }
}