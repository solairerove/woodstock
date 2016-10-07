package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by krivitski-no on 9/28/16.
 */
public interface TicketService {
    String createTicket(TicketDTO ticketDTO);

    Ticket getTicket(String id);

    String updateTicket(String id, TicketDTO ticketDTO);

    String deleteTicket(String id);

    List<Ticket> deleteAll();

    Page<Ticket> findAll(Pageable pageable);
}
