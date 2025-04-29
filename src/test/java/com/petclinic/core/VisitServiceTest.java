package com.petclinic.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // permet les @Autowired
//@DataJpaTest // permet de charger un sous-ensemble de packages
class VisitServiceTest {

    @Autowired
    VisitService visitService;

    @Test
    void shouldFindByReferenceNumber(){
        Visit result = visitService.findByReferenceNumber("123");
        assertEquals("123", result.getReferenceNumber());
    }
}