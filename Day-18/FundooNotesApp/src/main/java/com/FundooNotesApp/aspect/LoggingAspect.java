package com.FundooNotesApp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.FundooNotesApp.controller..*.*(..))")
    public void controllerPointcut() {}

    @Pointcut("execution(* com.FundooNotesApp.service..*.*(..))")
    public void servicePointcut() {}

    @Around("controllerPointcut() || servicePointcut()")
    public Object logExecutionTimeAndDetails(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("--> Entering: {}.{}() with arguments = {}", className, methodName, Arrays.toString(args));
        long startTime = System.currentTimeMillis();

        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("<-- Exception in {}.{}() with message = {}", className, methodName, throwable.getMessage());
            throw throwable;
        }

        long elapsedTime = System.currentTimeMillis() - startTime;
        logger.info("<-- Exiting: {}.{}() | Execution time: {} ms", className, methodName, elapsedTime);

        return result;
    }

    @AfterThrowing(pointcut = "controllerPointcut() || servicePointcut()", throwing = "e")
    public void logAfterThrowing(org.aspectj.lang.JoinPoint joinPoint, Throwable e) {
        logger.error("Exception in {}.{}() with cause = '{}' and exception = '{}'",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                e.getCause() != null ? e.getCause() : "NULL",
                e.getMessage());
    }
}
