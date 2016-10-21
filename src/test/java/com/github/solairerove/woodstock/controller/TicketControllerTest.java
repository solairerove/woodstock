package com.github.solairerove.woodstock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.woodstock.Application;
import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.repository.TicketRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static com.github.solairerove.woodstock.utils.EntityUtils.NUMBER_OF_ENTITIES_IN_COLLECTION;
import static com.github.solairerove.woodstock.utils.EntityUtils.generateTicket;
import static com.github.solairerove.woodstock.utils.EntityUtils.generateTicketCollection;
import static com.github.solairerove.woodstock.utils.EntityUtils.generateTicketDTO;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
@Transactional
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

    @After
    public void clear() {
        ticketRepository.deleteAll();
    }

    @Test
    public void getAllTicketsTest() throws Exception {
        ticketRepository.save(generateTicketCollection());

        mockMvc.perform(get(API_PATH)
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$." + COLLECTION_JSON_PATH, hasSize(NUMBER_OF_ENTITIES_IN_COLLECTION)))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    public void getTicketTest() throws Exception {
        Ticket ticket = generateTicket();
        ticketRepository.save(ticket);
        Long id = ticket.getId();

        mockMvc.perform(get(API_PATH + "/" + id)
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id", is(id.intValue())))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    public void createTicketTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        TicketDTO ticketDTO = generateTicketDTO();

        mockMvc.perform(post(API_PATH)
                .accept(APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(ticketDTO))
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    public void updateTicketTest() throws Exception {
        Ticket ticket = generateTicket();
        ticketRepository.save(ticket);
        Long id = ticket.getId();

        ObjectMapper objectMapper = new ObjectMapper();
        TicketDTO ticketDTO = generateTicketDTO();

        mockMvc.perform(put(API_PATH + "/" + id)
                .accept(APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(ticketDTO))
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id", is(id.intValue())))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    public void deleteTicketTest() throws Exception {
        Ticket ticket = generateTicket();
        ticketRepository.save(ticket);
        Long id = ticket.getId();

        mockMvc.perform(delete(API_PATH + "/" + id)
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", is(id.intValue())))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    public void deleteAllTest() throws Exception {
        ticketRepository.save(generateTicketCollection());

        mockMvc.perform(delete(API_PATH + "/" + "delete_all")
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isAccepted())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(NUMBER_OF_ENTITIES_IN_COLLECTION)))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }
}
