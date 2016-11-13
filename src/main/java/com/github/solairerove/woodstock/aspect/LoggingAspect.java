package com.github.solairerove.woodstock.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * The type Logging aspect.
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * Unit controller log.
     *
     * @param joinPoint the join point
     */
    @Before("execution(* com.github.solairerove.woodstock.controller.UnitController.*(..)))")
    public void unitControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Unit controller: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * Module controller log.
     *
     * @param joinPoint the join point
     */
    @Before("execution(* com.github.solairerove.woodstock.controller.ModuleController.*(..)))")
    public void moduleControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Module controller: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * Task controller log.
     *
     * @param joinPoint the join point
     */
    @Before("execution(* com.github.solairerove.woodstock.controller.TaskController.*(..)))")
    public void taskControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Task controller: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * Ticket controller log.
     *
     * @param joinPoint the join point
     */
    @Before("execution(* com.github.solairerove.woodstock.controller.TicketController.*(..)))")
    public void ticketControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Ticket controller: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * Profile controller log.
     *
     * @param joinPoint the join point
     */
    @Before("execution(* com.github.solairerove.woodstock.controller.ProfileController.*(..)))")
    public void profileControllerLog(JoinPoint joinPoint) {
        LOGGER.info("Profile controller: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * Unit service log.
     *
     * @param joinPoint the join point
     */
    @Before("execution(* com.github.solairerove.woodstock.service.UnitService.*(..)))")
    public void unitServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Unit service: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * Module service log.
     *
     * @param joinPoint the join point
     */
    @Before("execution(* com.github.solairerove.woodstock.service.ModuleService.*(..)))")
    public void moduleServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Module service: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * Task service log.
     *
     * @param joinPoint the join point
     */
    @Before("execution(* com.github.solairerove.woodstock.service.TaskService.*(..)))")
    public void taskServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Task service: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * Ticket service log.
     *
     * @param joinPoint the join point
     */
    @Before("execution(* com.github.solairerove.woodstock.service.TicketService.*(..)))")
    public void ticketServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Ticket service: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * Profile service log.
     *
     * @param joinPoint the join point
     */
    @Before("execution(* com.github.solairerove.woodstock.service.ProfileService.*(..)))")
    public void profileServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Profile service: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* com.github.solairerove.woodstock.service.GenericService.*(..)))")
    public void genericServiceLog(JoinPoint joinPoint) {
        LOGGER.info("Generic service: " + joinPoint.getSignature().getName() +
                Arrays.toString(joinPoint.getArgs()));
    }
}
