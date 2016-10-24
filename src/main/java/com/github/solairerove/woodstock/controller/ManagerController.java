package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.service.CategoryService;
import com.github.solairerove.woodstock.service.ProfileService;
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

    private final ProfileService profileService;

    @Autowired
    public ManagerController(CategoryService categoryService, TaskService taskService,
                             TicketService ticketService, ProfileService profileService) {

        this.categoryService = categoryService;
        this.taskService = taskService;
        this.ticketService = ticketService;
        this.profileService = profileService;
    }

    @RequestMapping(path = "/categories/delete_all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAllCategories() {
        return new ResponseEntity<>(categoryService.deleteAll(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/tasks/delete_all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAllTasks() {
        return new ResponseEntity<>(taskService.deleteAll(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/tickets/delete_all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAllTickets() {
        return new ResponseEntity<>(ticketService.deleteAll(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/profiles/delete_all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAllProfiles() {
        return new ResponseEntity<>(profileService.deleteAll(), HttpStatus.ACCEPTED);
    }
}
