package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.repository.TaskRepository;
import com.github.solairerove.woodstock.repository.TicketRepository;
import com.github.solairerove.woodstock.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToTicket;

@Service
public class TicketServiceImpl implements TicketService {

    private final TaskRepository taskRepository;

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TaskRepository taskRepository, TicketRepository ticketRepository) {
        this.taskRepository = taskRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket create(Long taskId, TicketDTO ticketDTO) {
        Ticket ticket = convertToTicket(ticketDTO);

        Task task = taskRepository.findOne(taskId);
        task.getTickets().add(ticket);
        taskRepository.save(task);

        return ticket;
    }

    @Override
    public Ticket get(Long taskId, Long ticketId) {
        return ticketRepository.getOneThatHasInNode(taskId, ticketId);
    }

    @Override
    public Iterable<Ticket> getAll(Long taskId) {
        return ticketRepository.getAllThatHasInNode(taskId);
    }

    @Override
    public Ticket update(Long taskId, Long ticketId, TicketDTO ticketDTO) {
        Ticket ticket = ticketRepository.getOneThatHasInNode(taskId, ticketId);
        ticket.setValue(ticketDTO.getValue());

        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket delete(Long taskId, Long ticketId) {
        Ticket ticket = ticketRepository.getOneThatHasInNode(taskId, ticketId);
        ticketRepository.deleteOneThatHasInNode(taskId, ticketId);

        return ticket;
    }
}
