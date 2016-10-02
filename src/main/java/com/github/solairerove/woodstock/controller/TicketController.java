package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by krivitski-no on 9/28/16.
 */
@RestController
@ExposesResourceFor(Ticket.class)
@RequestMapping(value = "/api/tickets", produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private PagedResourcesAssembler<Ticket> assembler;

    @Autowired
    private EntityLinks entityLinks;

    @RequestMapping
    public ResponseEntity<?> getAllTickets(Pageable pageable) {
        return new ResponseEntity<>(assembler.toResource(ticketService.findAll(pageable)), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<?> getTicket(@PathVariable String id) {
        Resource<Ticket> resource = new Resource<>(ticketService.getTicket(id));
        resource.add(this.entityLinks.linkToSingleResource(Ticket.class, id));

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createTicket(@RequestBody TicketDTO ticketDTO) {
        return new ResponseEntity<>(ticketService.createTicket(ticketDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTicket(@PathVariable String id, @RequestBody TicketDTO ticketDTO) {
        return new ResponseEntity<>(ticketService.updateTicket(id, ticketDTO), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTicket(@PathVariable String id) {
        return new ResponseEntity<>(ticketService.deleteTicket(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/delete_all", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAll() {
        return new ResponseEntity<>(ticketService.deleteAll(), HttpStatus.ACCEPTED);
    }
}