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
public class ControllerLoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLoggingAspect.class);

    @Before("execution(* com.github.solairerove.woodstock.controller.UnitController.*(..)))")
    public void unitControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Unit controller: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.ModuleController.*(..)))")
    public void moduleControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Module controller: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.ReferenceController.*(..)))")
    public void referenceControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Reference controller: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.ChapterController.*(..)))")
    public void chapterControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Chapter controller: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.TaskController.*(..)))")
    public void taskControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Task controller: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.TicketController.*(..)))")
    public void ticketControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Ticket controller: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.ProfileController.*(..)))")
    public void profileControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Profile controller: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }
}
