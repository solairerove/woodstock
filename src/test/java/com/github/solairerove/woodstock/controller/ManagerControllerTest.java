package com.github.solairerove.woodstock.controller;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.github.solairerove.woodstock.utils.EntityUtils.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerControllerTest {

    private static final String API_PATH = "/api";

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TaskRepository taskRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        ticketRepository.deleteAll();
        taskRepository.deleteAll();
    }

    @After
    public void clear() {
        ticketRepository.deleteAll();
        taskRepository.deleteAll();
    }

    @Test
    public void deleteAllTicketsTest() throws Exception {
        ticketRepository.save(generateTicketCollection());

        mockMvc.perform(delete(API_PATH + "/" + "tickets" + "/" + "delete_all")
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isAccepted())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(NUMBER_OF_ENTITIES_IN_COLLECTION)))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    public void deleteAllTasksTest() throws Exception {
        taskRepository.save(generateTaskCollection());

        mockMvc.perform(delete(API_PATH + "/" + "tasks" + "/" + "delete_all")
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isAccepted())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(NUMBER_OF_ENTITIES_IN_COLLECTION)))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }
}
