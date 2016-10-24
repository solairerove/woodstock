package com.github.solairerove.woodstock.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.github.solairerove.woodstock.controller.CategoryController.*(..)))")
    public void categoryControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Category controller: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.ManagerController.*(..)))")
    public void managerControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Manager controller: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.ProfileController.*(..)))")
    public void profileControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Profile controller: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.TaskController.*(..)))")
    public void taskControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Task controller: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.TicketController.*(..)))")
    public void ticketControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Ticket controller: " + joinPoint.getSignature().getName());
    }
}
