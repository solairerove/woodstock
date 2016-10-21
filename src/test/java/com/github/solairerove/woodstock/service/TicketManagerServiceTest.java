package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.Application;
import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.repository.TaskRepository;
import com.github.solairerove.woodstock.repository.TicketRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.github.solairerove.woodstock.utils.EntityUtils.*;
import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class TicketManagerServiceTest {

    @Autowired
    private TicketManagerService service;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Before
    public void setUp() {
        ticketRepository.deleteAll();
        taskRepository.deleteAll();
    }

    @After
    public void clear() {
        ticketRepository.deleteAll();
        taskRepository.deleteAll();
    }

    @Test
    public void createTicketTest() {
        Task task = generateTask();
        Long taskId = taskRepository.save(task).getId();

        TicketDTO ticketDTO = generateTicketDTO();

        assertEquals(ticketDTO.getValue(), service.create(taskId, ticketDTO).getValue());
        assertEquals(ticketRepository.count(), task.getTickets().size());
    }

    @Test
    public void getTicketTest() {
        Task task = generateTask();
        Ticket ticket = generateTicket();

        task.getTickets().add(ticket);
        taskRepository.save(task).getId();

        assertEquals(ticket, service.get(task.getId(), ticket.getId()));
    }

    @Test
    public void getAllTicketsTest() {
        Task task = generateTask();
        List<Ticket> tickets = generateTicketCollection();

        task.getTickets().addAll(tickets);
        taskRepository.save(task);

        sort(tickets, ((o1, o2) -> o2.getId().compareTo(o1.getId())));

        List<Ticket> result = (List<Ticket>) service.getAll(task.getId());
        sort(result, (o1, o2) -> o2.getId().compareTo(o1.getId()));

        assertEquals(tickets, result);
    }

    @Test
    public void deleteTicketTest() {
        Task task = generateTask();
        Ticket ticket = generateTicket();

        task.getTickets().add(ticket);
        taskRepository.save(task);

        Long ticketId = ticket.getId();

        assertEquals(ticket, ticketRepository.findOne(ticketId));
        assertEquals(ticket, service.delete(task.getId(), ticketId));
        assertEquals(0, ticketRepository.count());
    }
}
