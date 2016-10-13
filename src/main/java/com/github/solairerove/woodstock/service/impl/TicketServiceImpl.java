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

    private final TicketRepository repository;

    @Autowired
    public TicketServiceImpl(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ticket create(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket(ticketDTO.getValue());
        ticket.setCreatedDate(LocalDateTime.now().toString());
        return repository.save(ticket);
    }

    @Override
    public Ticket get(String id) {
        return repository.findOneTicketById(id);
    }

    @Override
    public Page<Ticket> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Ticket update(String id, TicketDTO ticketDTO) {
        Ticket ticket = repository.findOne(id);
        ticket.setValue(ticketDTO.getValue());
        ticket.setUpdatedDate(LocalDateTime.now().toString());
        return repository.save(ticket);
    }

    @Override
    public String delete(String id) {
        repository.delete(id);
        return id;
    }

    @Override
    public List<Ticket> deleteAll() {
        List<Ticket> tickets = repository.findAll();
        repository.deleteAll();
        return tickets;
    }
}
