package com.cs544.roommate.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class SetterUser {
    private Logger logger =  Logger.getLogger(getClass().getName());
    @Before("execution(void com.cs544.roommate.*.set*(*))")
    public void callSetters(JoinPoint joinPoint) {
        logger.info("Setter Called");
        logger.info("Method Invoked: " + joinPoint.getSignature().getName());
        logger.info("Value Passed: " + joinPoint.getArgs()[0]);
    }
}
