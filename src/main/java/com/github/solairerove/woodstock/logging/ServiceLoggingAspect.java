package com.github.solairerove.woodstock.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ServiceLoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLoggingAspect.class);

    @Before("execution(* com.github.solairerove.woodstock.service.common.GenericService.*(..)))")
    public void genericServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Generic service: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* com.github.solairerove.woodstock.service.UnitService.*(..)))")
    public void unitServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Unit service: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* com.github.solairerove.woodstock.service.ModuleService.*(..)))")
    public void moduleServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Module service: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* com.github.solairerove.woodstock.service.ReferenceService.*(..)))")
    public void referenceServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Reference service: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* com.github.solairerove.woodstock.service.ChapterService.*(..)))")
    public void chapterServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Chapter service: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* com.github.solairerove.woodstock.service.TaskService.*(..)))")
    public void taskServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Task service: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* com.github.solairerove.woodstock.service.TicketService.*(..)))")
    public void ticketServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Ticket service: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* com.github.solairerove.woodstock.service.ProfileService.*(..)))")
    public void profileServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Profile service: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }
}
