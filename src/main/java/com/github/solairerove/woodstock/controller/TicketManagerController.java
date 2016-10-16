package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.service.TicketManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by krivitski-no on 10/12/16.
 */
@RestController
@RequestMapping(value = "/api/tasks/{taskId}/tickets", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TicketManagerController {

    private final TicketManagerService ticketManagerService;

    @Autowired
    public TicketManagerController(TicketManagerService ticketManagerService) {
        this.ticketManagerService = ticketManagerService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@PathVariable Long taskId, @RequestBody TicketDTO ticketDTO) {
        return new ResponseEntity<>(ticketManagerService.create(taskId, ticketDTO), HttpStatus.CREATED);
    }

    @RequestMapping
    public ResponseEntity getAll(@PathVariable Long taskId) {
        return new ResponseEntity<>(ticketManagerService.get(taskId), HttpStatus.OK);
    }

    @RequestMapping(path = "/{ticketId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long taskId, @PathVariable Long ticketId) {
        return new ResponseEntity<>(ticketManagerService.delete(taskId, ticketId), HttpStatus.ACCEPTED);
    }
}
