package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;

public interface TicketManagerService {

    Ticket create(Long taskId, TicketDTO ticketDTO);

    Ticket get(Long taskId, Long ticketId);

    Iterable<Ticket> getAll(Long taskId);

    Ticket delete(Long taskId, Long ticketId);
}
