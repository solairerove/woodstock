package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.repository.TicketRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.solairerove.woodstock.utils.EntityUtils.NUMBER_OF_ENTITIES_IN_COLLECTION;
import static com.github.solairerove.woodstock.utils.EntityUtils.generateTicket;
import static com.github.solairerove.woodstock.utils.EntityUtils.generateTicketCollection;
import static com.github.solairerove.woodstock.utils.EntityUtils.generateTicketDTO;
import static com.github.solairerove.woodstock.utils.EntityUtils.getRandomString;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketRepository ticketRepository;

    @Before
    public void setUp() {
        ticketRepository.deleteAll();
    }

    @After
    public void clear() {
        ticketRepository.deleteAll();
    }

    @Test
    public void createTicketTest() {
        TicketDTO saved = generateTicketDTO();
        Long id = ticketService.create(saved).getId();

        assertEquals(saved.getValue(), ticketRepository.findOne(id).getValue());
    }

    @Test
    public void getTicketTest() {
        Ticket saved = generateTicket();
        ticketRepository.save(saved);

        assertEquals(saved, ticketService.get(saved.getId()));
    }

    @Test
    public void updateTicketTest() {
        Ticket saved = generateTicket();
        ticketRepository.save(saved);
        Long id = saved.getId();

        TicketDTO ticketDTO = generateTicketDTO();
        String value = getRandomString();
        ticketDTO.setValue(value);

        ticketService.update(id, ticketDTO);

        assertEquals(value, ticketRepository.findOne(id).getValue());
    }

    @Test
    public void deleteTicketTest() {
        Ticket saved = generateTicket();
        ticketRepository.save(saved);
        Long id = saved.getId();

        ticketService.delete(id);

        assertEquals(null, ticketRepository.findOne(id));
    }

    @Test
    public void deleteAll() {
        ticketRepository.save(generateTicketCollection());

        ticketService.deleteAll();

        assertEquals(0, ticketRepository.count());
    }

    @Test
    public void findAllTest() {
        ticketRepository.save(generateTicketCollection());
        int count = NUMBER_OF_ENTITIES_IN_COLLECTION;

        assertEquals(count, ticketService.findAll(new PageRequest(0, count)).getNumberOfElements());
    }
}
