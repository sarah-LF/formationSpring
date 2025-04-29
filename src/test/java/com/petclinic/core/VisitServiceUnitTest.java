/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.petclinic.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class VisitServiceUnitTest {

    @Autowired
    VisitService visitService;

    @MockitoBean
    VisitRepository visitRepository;

    @Test
    void shouldFindVisitByReferenceNumber(){
        when(visitRepository.findByReferenceNumber(any())).thenReturn(new Visit(1L, "1234", LocalDate.of(2025, 4, 28), "sick"));

        Visit result = visitService.findByReferenceNumber("123");
        assertEquals("1234", result.getReferenceNumber());
    }
}
