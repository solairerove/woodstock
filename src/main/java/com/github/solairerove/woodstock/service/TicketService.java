package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.service.common.GenericService;

public interface TicketService extends GenericService<Ticket> {

    Ticket create(Long taskId, TicketDTO ticketDTO);

    Ticket update(Long taskId, Long ticketId, TicketDTO ticketDTO);

    Ticket delete(Long taskId, Long ticketId);
}
