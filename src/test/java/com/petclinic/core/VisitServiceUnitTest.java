/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.petclinic.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class VisitServiceUnitTest {

    @Autowired
    VisitService visitService;

    @Mock
    VisitRepository visitRepository;

    @Test
    void shouldFindVisitByReferenceNumber(){
        when(visitRepository.findByReferenceNumber(any())).thenReturn(new Visit(1L, "123", LocalDate.of(2025, 4, 28), "sick"));

        Visit result = visitService.findByReferenceNumber("123");
        assertEquals("123", result.getReferenceNumber());
    }
}
