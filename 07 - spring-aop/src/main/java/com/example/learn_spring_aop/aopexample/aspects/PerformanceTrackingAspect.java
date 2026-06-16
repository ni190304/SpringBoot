package com.example.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {


    private Logger logger = LoggerFactory.getLogger(PerformanceTrackingAspect.class);

    @Around("com.example.learn_spring_aop.aopexample.CommonPointConfiguration.trackTimeAnnotationConfig()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        
        // Start a timer before the method execution
        long startTimeMillis = System.currentTimeMillis();

        // Proceed with the method execution
        Object result = proceedingJoinPoint.proceed();

        // Stop the timer after the method execution
        long endTimeMillis = System.currentTimeMillis();

        // Calculate the execution time
        long executionTimeMillis = endTimeMillis - startTimeMillis;

        logger.info("Around Aspect - {} Method executed in {} ms", proceedingJoinPoint, executionTimeMillis);

        return result;
    }
    
}
