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

@RestController
@RequestMapping(value = "/api/tasks/{taskId}/tickets", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TicketController {

    private final TicketManagerService ticketManagerService;

    @Autowired
    public TicketController(TicketManagerService ticketManagerService) {
        this.ticketManagerService = ticketManagerService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@PathVariable Long taskId, @RequestBody TicketDTO ticketDTO) {
        return new ResponseEntity<>(ticketManagerService.create(taskId, ticketDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{ticketId}")
    public ResponseEntity get(@PathVariable Long taskId, @PathVariable Long ticketId) {
        return new ResponseEntity<>(ticketManagerService.get(taskId, ticketId), HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity getAll(@PathVariable Long taskId) {
        return new ResponseEntity<>(ticketManagerService.getAll(taskId), HttpStatus.OK);
    }

    @RequestMapping(path = "/{ticketId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long taskId, @PathVariable Long ticketId) {
        return new ResponseEntity<>(ticketManagerService.delete(taskId, ticketId), HttpStatus.ACCEPTED);
    }
}
