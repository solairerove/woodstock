package com.github.solairerove.woodstock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static com.github.solairerove.woodstock.utils.EntityUtils.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketControllerTest {

    private static final String API_PATH = "/api/tasks";

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TicketRepository ticketRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = webAppContextSetup(context).build();
        ticketRepository.deleteAll();
        taskRepository.deleteAll();
    }

    @After
    public void clear() {
        ticketRepository.deleteAll();
        taskRepository.deleteAll();
    }

    @Test
    public void createTicketTest() throws Exception {
        Task task = generateTask();
        Long id = taskRepository.save(task).getId();

        ObjectMapper objectMapper = new ObjectMapper();
        TicketDTO ticketDTO = generateTicketDTO();

        mockMvc.perform(post(API_PATH + "/" + id + "/tickets")
                .accept(APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(ticketDTO))
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.value", is(ticketDTO.getValue())))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    public void getTicketTest() throws Exception {
        Task task = generateTask();
        Ticket ticket = generateTicket();

        task.getTickets().add(ticket);

        Long taskId = taskRepository.save(task).getId();
        Long ticketId = ticket.getId();

        mockMvc.perform(get(API_PATH + "/" + taskId + "/" + "tickets" + "/" + ticketId)
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id", is(ticketId.intValue())))
                .andExpect(jsonPath("$.value", is(ticket.getValue())))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    public void getAllTickets() throws Exception {
        Task task = generateTask();
        List<Ticket> tickets = generateTicketCollection();

        task.getTickets().addAll(tickets);

        Long id = taskRepository.save(task).getId();

        mockMvc.perform(get(API_PATH + "/" + id + "/" + "tickets")
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.[0].id", isA(Integer.class)))
                .andExpect(jsonPath("$", hasSize(NUMBER_OF_ENTITIES_IN_COLLECTION)))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    public void deleteTicketTest() throws Exception {
        Task task = generateTask();
        Ticket ticket = generateTicket();

        task.getTickets().add(ticket);

        Long taskId = taskRepository.save(task).getId();
        Long ticketId = ticket.getId();

        mockMvc.perform(delete(API_PATH + "/" + taskId + "/" + "tickets" + "/" + ticketId)
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isAccepted())
                .andDo(print())
                .andExpect(jsonPath("$.id", is(ticketId.intValue())))
                .andExpect(jsonPath("$.value", is(ticket.getValue())))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

}
