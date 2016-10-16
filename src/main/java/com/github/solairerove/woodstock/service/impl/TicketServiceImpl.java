package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.repository.TicketRepository;
import com.github.solairerove.woodstock.service.TicketService;
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
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repository;

    @Autowired
    public TicketServiceImpl(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ticket create(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setValue(ticketDTO.getValue());
        ticket.setCreatedDate(LocalDateTime.now().toString());
        return repository.save(ticket);
    }

    @Override
    public Ticket get(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Page<Ticket> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Ticket update(Long id, TicketDTO ticketDTO) {
        Ticket ticket = repository.findOne(id);
        ticket.setValue(ticketDTO.getValue());
        ticket.setUpdatedDate(LocalDateTime.now().toString());
        return repository.save(ticket);
    }

    @Override
    public Long delete(Long id) {
        repository.delete(id);
        return id;
    }

    @Override
    public Iterable<Ticket> deleteAll() {
        Iterable<Ticket> tickets = repository.findAll();
        repository.deleteAll();
        return tickets;
    }
}
