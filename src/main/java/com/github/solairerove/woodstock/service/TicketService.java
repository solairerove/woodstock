package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by krivitski-no on 9/28/16.
 */
@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public String createTicket(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket(ticketDTO.getValue());
        ticket.setCreatedDate(LocalDateTime.now());
        ticketRepository.save(ticket);
        return ticket.getId();
    }

    public Ticket getTicket(String id) {
        return ticketRepository.findOneTicketById(id);
    }

    public String updateTicket(String id, TicketDTO ticketDTO) {
        if (ticketRepository.exists(id)) {
            Ticket ticket = ticketRepository.findOne(id);
            ticket.setValue(ticketDTO.getValue());
            ticket.setUpdatedDate(LocalDateTime.now());
            ticketRepository.save(ticket);
        }
        return id;
    }

    public String deleteTicket(String id) {
        ticketRepository.delete(id);
        return id;
    }

    public Collection<Ticket> deleteAll() {
        Collection<Ticket> tickets = ticketRepository.findAll();
        ticketRepository.deleteAll();
        return tickets;
    }

    public Page<Ticket> findAll(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }
}
