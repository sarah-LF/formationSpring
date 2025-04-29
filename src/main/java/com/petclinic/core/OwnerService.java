/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.petclinic.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private static final Logger logger = LoggerFactory.getLogger(OwnerService.class);

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner findByFirstName(String firstName) {
        Owner result = ownerRepository.findByFirstName(firstName);
        logger.debug("result found " + result);
        return result;
    }

    public void save(Owner owner) {
        ownerRepository.save(owner);
    }
}
