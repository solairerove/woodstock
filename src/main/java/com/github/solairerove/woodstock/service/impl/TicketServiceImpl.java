package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.repository.TaskRepository;
import com.github.solairerove.woodstock.repository.TicketRepository;
import com.github.solairerove.woodstock.service.TicketService;
import com.github.solairerove.woodstock.service.common.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.github.solairerove.woodstock.service.common.ModelMapper.convertToTicket;

@Service
public class TicketServiceImpl extends GenericServiceImpl<Ticket, TicketRepository> implements TicketService {

    private final TaskRepository taskRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository repository, TaskRepository taskRepository) {
        super(repository);
        this.taskRepository = taskRepository;
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
    public Ticket update(Long taskId, Long ticketId, TicketDTO ticketDTO) {
        Ticket ticket = repository.getOneThatHasInNode(taskId, ticketId);
        ticket.setValue(ticketDTO.getValue());

        return repository.save(ticket);
    }

    @Override
    public Ticket delete(Long taskId, Long ticketId) {
        Ticket ticket = repository.getOneThatHasInNode(taskId, ticketId);
        repository.deleteTicketThatHasInTaskFromId(taskId, ticketId);
        return ticket;
    }
}
