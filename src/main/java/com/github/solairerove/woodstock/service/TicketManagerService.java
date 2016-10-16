package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;

import java.util.List;

/**
 * Created by krivitski-no on 10/12/16.
 */
public interface TicketManagerService {

    Ticket create(Long taskId, TicketDTO ticketDTO);

    List<Ticket> get(Long taskId);

    Ticket delete (Long taskId, Long ticketId);
}
