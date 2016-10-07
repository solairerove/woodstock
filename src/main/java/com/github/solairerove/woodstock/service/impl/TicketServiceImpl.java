package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.repository.TicketRepository;
import com.github.solairerove.woodstock.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by krivitski-no on 9/28/16.
 */
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public String create(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket(ticketDTO.getValue());
        ticket.setCreatedDate(LocalDateTime.now());
        ticketRepository.save(ticket);
        return ticket.getId();
    }

    @Override
    public Ticket get(String id) {
        return ticketRepository.findOneTicketById(id);
    }

    @Override
    public String update(String id, TicketDTO ticketDTO) {
        if (ticketRepository.exists(id)) {
            Ticket ticket = ticketRepository.findOne(id);
            ticket.setValue(ticketDTO.getValue());
            ticket.setUpdatedDate(LocalDateTime.now());
            ticketRepository.save(ticket);
        }
        return id;
    }

    @Override
    public String delete(String id) {
        ticketRepository.delete(id);
        return id;
    }

    @Override
    public List<Ticket> deleteAll() {
        List<Ticket> tickets = ticketRepository.findAll();
        ticketRepository.deleteAll();
        return tickets;
    }

    @Override
    public Page<Ticket> findAll(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }
}
