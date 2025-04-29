/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.petclinic.tech;

import java.util.concurrent.TimeUnit;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.petclinic.core.VisitService;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.petclinic..*Service.*(..))")
    public void logMethodsCalledBefore(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        logger.info("@Before : Before executing method: {}.{}", className, methodName);
    }

    @Around("execution(* com.petclinic..*Service.*(..))")
    public Object logMethodsCalled(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        logger.info("@Around : Before executing method: {}.{}", className, methodName);
        Object result = joinPoint.proceed();
        logger.info("@Around : After executing method: {}.{}", className, methodName);

        return result;
    }

    @Around("execution(* com.petclinic..*Service.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch =  new StopWatch();
        stopWatch.start();

        logger.info("@Around : Function called: {}", joinPoint.getSignature());
        Object result = joinPoint.proceed();
        stopWatch.stop();
        logger.info("@Around : Execution time: {} ms", stopWatch.getTotalTime(TimeUnit.MILLISECONDS));

        return result;
    }
}
