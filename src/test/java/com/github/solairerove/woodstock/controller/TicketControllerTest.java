package com.github.solairerove.woodstock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.woodstock.Application;
import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.repository.TicketRepository;
import com.github.solairerove.woodstock.utils.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
 * Created by krivitski-no on 10/2/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class TicketControllerTest {

    private static final String API_PATH = "/api/tickets";
    private static final String COLLECTION_JSON_PATH = "_embedded.ticketList";

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TicketRepository ticketRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        ticketRepository.deleteAll();
    }

    @Test
    public void getAllTicketsTest() throws Exception {
        ticketRepository.save(EntityUtils.generateTicketCollection());

        mockMvc.perform(MockMvcRequestBuilders.get(API_PATH)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$." + COLLECTION_JSON_PATH, hasSize(EntityUtils.NUMBER_OF_ENTITIES_IN_COLLECTION)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void getTicketTest() throws Exception {
        Ticket ticket = EntityUtils.generateTicket();
        ticketRepository.save(ticket);
        String id = ticket.getId();

        mockMvc.perform(MockMvcRequestBuilders.get(API_PATH + "/" + id)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(id)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void createTicketTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        TicketDTO ticketDTO = EntityUtils.generateTicketDTO();

        mockMvc.perform(MockMvcRequestBuilders.post(API_PATH)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(ticketDTO))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void updateTicketTest() throws Exception {
        Ticket ticket = EntityUtils.generateTicket();
        ticketRepository.save(ticket);
        String id = ticket.getId();

        ObjectMapper objectMapper = new ObjectMapper();
        TicketDTO ticketDTO = EntityUtils.generateTicketDTO();

        mockMvc.perform(MockMvcRequestBuilders.put(API_PATH + "/" + id)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(ticketDTO))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", is(id)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void deleteTicketTest() throws Exception {
        Ticket ticket = EntityUtils.generateTicket();
        ticketRepository.save(ticket);
        String id = ticket.getId();

        mockMvc.perform(MockMvcRequestBuilders.delete(API_PATH + "/" + id)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", is(id)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void deleteAllTest() throws Exception {
        ticketRepository.save(EntityUtils.generateTicketCollection());

        mockMvc.perform(MockMvcRequestBuilders.delete(API_PATH + "/" + "delete_all")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(EntityUtils.NUMBER_OF_ENTITIES_IN_COLLECTION)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }
}
