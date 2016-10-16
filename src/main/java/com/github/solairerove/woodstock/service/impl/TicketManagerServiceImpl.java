package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.repository.TaskRepository;
import com.github.solairerove.woodstock.repository.TicketRepository;
import com.github.solairerove.woodstock.service.TicketManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by krivitski-no on 10/12/16.
 */
@Service
@Transactional
public class TicketManagerServiceImpl implements TicketManagerService {

    private final TicketRepository ticketRepository;

    private final TaskRepository taskRepository;

    @Autowired
    public TicketManagerServiceImpl(TicketRepository ticketRepository, TaskRepository taskRepository) {
        this.ticketRepository = ticketRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public Ticket create(Long taskId, TicketDTO ticketDTO) {
        Ticket ticket = new Ticket(ticketDTO.getValue());
        ticket.setCreatedDate(LocalDateTime.now().toString());
        ticketRepository.save(ticket);

        Task task = taskRepository.findOne(taskId);
        task.getTickets().add(ticket);
        task.setUpdatedDate(LocalDateTime.now().toString());
        taskRepository.save(task);

        return ticket;
    }

    @Override
    public List<Ticket> get(Long taskId) {
        return taskRepository.findOne(taskId).getTickets();
    }

    @Override
    public Ticket delete(Long taskId, Long ticketId) {
        Task task = taskRepository.findOne(taskId);
        Ticket ticket = ticketRepository.findOne(ticketId);
        task.getTickets().remove(ticket);
        taskRepository.save(task);
        ticketRepository.delete(ticketId);
        return ticket;
    }
}
