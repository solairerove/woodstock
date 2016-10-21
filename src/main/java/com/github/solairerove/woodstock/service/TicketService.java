package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {

    Ticket create(TicketDTO ticketDTO);

    Ticket get(Long id);

    Page<Ticket> findAll(Pageable pageable);

    Ticket update(Long id, TicketDTO ticketDTO);

    Long delete(Long id);

    Iterable<Ticket> deleteAll();
}
