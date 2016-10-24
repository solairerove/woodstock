package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.service.CategoryService;
import com.github.solairerove.woodstock.service.TaskService;
import com.github.solairerove.woodstock.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ManagerController {

    private final CategoryService categoryService;

    private final TaskService taskService;

    private final TicketService ticketService;

    @Autowired
    public ManagerController(CategoryService categoryService, TaskService taskService, TicketService ticketService) {
        this.categoryService = categoryService;
        this.taskService = taskService;
        this.ticketService = ticketService;
    }

    @RequestMapping(path = "/categories/delete_all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAllCategories() {
        return new ResponseEntity<>(categoryService.deleteAll(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/tasks/delete_all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() {
        return new ResponseEntity<>(taskService.deleteAll(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/tickets/delete_all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAllTickets() {
        return new ResponseEntity<>(ticketService.deleteAll(), HttpStatus.ACCEPTED);
    }
}
