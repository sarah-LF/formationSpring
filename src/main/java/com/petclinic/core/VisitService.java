/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.petclinic.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {

    private final VisitRepository visitRepository;
    private static final Logger logger = LoggerFactory.getLogger(VisitService.class);

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }


    public Visit findByReferenceNumber(String referenceNumber) {
        Visit result = visitRepository.findByReferenceNumber(referenceNumber);
        logger.debug("result found " + result);
        return result;
    }

    public void save(Visit visit) {
        visitRepository.save(visit);
    }
}
