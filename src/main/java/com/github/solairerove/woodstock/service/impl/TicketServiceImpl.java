package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.repository.TaskRepository;
import com.github.solairerove.woodstock.repository.TicketRepository;
import com.github.solairerove.woodstock.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    private final TaskRepository taskRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, TaskRepository taskRepository) {
        this.ticketRepository = ticketRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public Ticket create(Long taskId, TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setValue(ticketDTO.getValue());

        Task task = taskRepository.findOne(taskId);
        task.getTickets().add(ticket);
        taskRepository.save(task);

        return ticket;
    }

    @Override
    public Ticket get(Long taskId, Long ticketId) {
        return ticketRepository.getTicketThatHasInTaskFromId(taskId, ticketId);
    }

    @Override
    public Iterable<Ticket> getAll(Long taskId) {
        return ticketRepository.getTicketsThatHasInTaskFromId(taskId);
    }

    @Override
    public Ticket update(Long taskId, Long ticketId, TicketDTO ticketDTO) {
        Ticket ticket = ticketRepository.getTicketThatHasInTaskFromId(taskId, ticketId);
        ticket.setValue(ticketDTO.getValue());

        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket delete(Long taskId, Long ticketId) {
        Ticket ticket = ticketRepository.getTicketThatHasInTaskFromId(taskId, ticketId);
        ticketRepository.deleteTicketThatHasInTaskFromId(taskId, ticketId);
        return ticket;
    }
}
