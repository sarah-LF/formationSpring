/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.petclinic.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Owner findByFirstName(String firstName);
}
