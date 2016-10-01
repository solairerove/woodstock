package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Block;
import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Created by krivitski-no on 9/28/16.
 */
@Service
@Transactional
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

    public Ticket updateTicket(String id, Ticket ticket) {
        if (ticketRepository.exists(id)) {
            ticket.setId(id);
            ticket.setUpdatedDate(LocalDateTime.now());
            ticketRepository.save(ticket);
        }
        return ticket;
    }

    public String deleteTicket(String id) {
        ticketRepository.delete(id);
        return id;
    }

    public String deleteTicket(Ticket ticket) {
        ticketRepository.delete(ticket);
        return ticket.getId();
    }

    public Iterable<? extends Block> deleteAll() {
        Iterable<? extends Ticket> tickets = ticketRepository.findAll();
        ticketRepository.deleteAll();
        return tickets;
    }

    public Page<Ticket> findAll(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }
}
