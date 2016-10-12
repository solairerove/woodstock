package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.repository.TicketRepository;
import com.github.solairerove.woodstock.service.TicketService;
import com.github.solairerove.woodstock.service.common.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by krivitski-no on 9/28/16.
 */
@Service
public class TicketServiceImpl extends AbstractGenericService<Ticket, TicketRepository, String>
        implements TicketService {

    @Autowired
    public TicketServiceImpl(TicketRepository repo) {
        super(repo);
    }

    @Override
    public Ticket update(String id, TicketDTO ticketDTO) {
        Ticket ticket = repo.findOne(id);
        ticket.setValue(ticketDTO.getValue());
        ticket.setUpdatedDate(LocalDateTime.now().toString());
        return repo.save(ticket);
    }
}
