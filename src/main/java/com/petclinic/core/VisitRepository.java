/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.petclinic.core;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class VisitRepository {

    public Visit findByReferenceNumber(String referenceNumber) {
        Visit visit = new Visit(1L, "123", LocalDate.of(2025, 4, 28), "sick");

        return visit;
    }
}
