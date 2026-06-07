package com.example.learn_spring_aop.aopexample.aspects;
import org.aspectj.lang.annotation.After;
// import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Pointcut - When?
    @Before("com.example.learn_spring_aop.aopexample.aspects.CommonPointConfiguration.allPackageConfigUsingBean()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        // logger.info("Before Aspect - Method is called - {}", joinPoint);

        logger.info("Before Aspect - {} is called with arguments-", joinPoint.getArgs());
    }

    @After("com.example.learn_spring_aop.aopexample.aspects.CommonPointConfiguration.businessPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - Method is called - {}", joinPoint);
    }

    @AfterThrowing(
        pointcut = "com.example.learn_spring_aop.aopexample.aspects.CommonPointConfiguration.businessAndDataPackageConfig()",
        throwing = "exception"
    )
    public void logMethodCallAfterThrowing(JoinPoint joinPoint, Exception exception) {
        // logger.info("AfterThrowing Aspect - Method is called - {}", joinPoint);

        logger.info("AfterThrowing Aspect - {} has thrown an exception: {}", joinPoint.getArgs(), exception.getMessage());
    }

    @AfterReturning(
        pointcut = "com.example.learn_spring_aop.aopexample.aspects.CommonPointConfiguration.dataPackageConfig()",
        returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
        // logger.info("AfterReturning Aspect - Method is called - {}", joinPoint);


        logger.info("AfterReturning Aspect - {} has returned {}", joinPoint.getArgs(), resultValue);
    }
}
