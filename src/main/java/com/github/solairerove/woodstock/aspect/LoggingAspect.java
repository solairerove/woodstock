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

    @Before("execution(* com.github.solairerove.woodstock.service.ProfileService.*(..)))")
    public void profileServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Profile service: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.ProfileController.*(..)))")
    public void profileControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Profile controller: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.woodstock.service.TicketService.*(..)))")
    public void ticketServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Ticket service: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.TicketController.*(..)))")
    public void ticketControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Ticket controller: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.woodstock.service.TaskService.*(..)))")
    public void taskServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Task service: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.TaskController.*(..)))")
    public void taskControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Task controller: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.woodstock.service.CategoryService.*(..)))")
    public void categoryServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Category service: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.CategoryController.*(..)))")
    public void categoryControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Category controller: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.woodstock.service.TicketManagerService.*(..)))")
    public void ticketManagerServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Ticket manager service: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.woodstock.controller.TicketManagerController.*(..)))")
    public void ticketManagerControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Ticket manager controller: " + joinPoint.getSignature().getName());
    }
}
