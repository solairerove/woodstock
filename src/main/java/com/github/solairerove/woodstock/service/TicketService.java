package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.service.common.GenericService;

/**
 * Created by krivitski-no on 9/28/16.
 */
public interface TicketService extends GenericService<Ticket, String> {
    String create(TicketDTO ticketDTO);

    String update(String id, TicketDTO ticketDTO);
}
