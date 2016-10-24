package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {

    Ticket create(Long taskId, TicketDTO ticketDTO);

    Ticket get(Long taskId, Long ticketId);

    Iterable<Ticket> getAll(Long taskId);

    Ticket update(Long id, TicketDTO ticketDTO);

    Ticket delete(Long taskId, Long ticketId);

    Iterable<Ticket> deleteAll();
}
