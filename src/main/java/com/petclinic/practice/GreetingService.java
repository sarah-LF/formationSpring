/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.petclinic.practice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
//@RequestScope
//@Profile("dev")
public class GreetingService {

    public String sayHi(){
        return "Hello John";
    }

    @PostConstruct
    public void init(){
        System.out.println(".....Initializing GreetingService.....");
    }

    @PreDestroy
    public void destroy(){
        System.out.println(".....Destroying GreetingService.....");
    }
}
