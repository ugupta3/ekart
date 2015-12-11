package com.ekart.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by umam on 12/5/15.
 */
@Aspect
@Component
public class EkartProfiler {

    private static final Logger logger = LoggerFactory
            .getLogger(CacheManagerCheck.class);

    @Pointcut("within(com.ekart.services..*)")
    public void serviceMethods() { }

    @Around("serviceMethods()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();
        logger.info("Calling." + pjp.getSignature().toShortString());
        Object output = pjp.proceed();
        logger.info(pjp.getSignature().toShortString()+" execution completed.");
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info(pjp.getSignature().toShortString()+ " execution time :"  + elapsedTime + " milliseconds.");
        return output;
    }

}
