package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.Application;
import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.dto.TicketDTO;
import com.github.solairerove.woodstock.repository.TicketRepository;
import com.github.solairerove.woodstock.utils.EntityUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by krivitski-no on 10/2/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TicketServiceTest {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketRepository ticketRepository;

    @Before
    public void setUp() {
        ticketRepository.deleteAll();
    }

    @Test
    public void createTicketTest() {
        TicketDTO saved = EntityUtils.generateTicketDTO();
        String id = ticketService.create(saved);

        Assert.assertEquals(saved.getValue(), ticketRepository.findOne(id).getValue());
    }

    @Test
    public void getTicketTest() {
        Ticket saved = EntityUtils.generateTicket();
        ticketRepository.save(saved);

        Assert.assertEquals(saved, ticketService.get(saved.getId()));
    }

    @Test
    public void updateTicketTest() {
        Ticket saved = EntityUtils.generateTicket();
        ticketRepository.save(saved);
        String id = saved.getId();

        TicketDTO ticketDTO = EntityUtils.generateTicketDTO();
        String value = EntityUtils.getRandomString();
        ticketDTO.setValue(value);

        ticketService.update(id, ticketDTO);

        Assert.assertEquals(value, ticketRepository.findOne(id).getValue());
    }

    @Test
    public void deleteTicketTest() {
        Ticket saved = EntityUtils.generateTicket();
        ticketRepository.save(saved);
        String id = saved.getId();

        ticketService.delete(id);

        Assert.assertEquals(null, ticketRepository.findOne(id));
    }

    @Test
    public void deleteAll() {
        ticketRepository.save(EntityUtils.generateTicketCollection());

        ticketService.deleteAll();

        Assert.assertEquals(0, ticketRepository.count());
    }

    @Test
    public void findAllTest() {
        ticketRepository.save(EntityUtils.generateTicketCollection());
        int count = EntityUtils.NUMBER_OF_ENTITIES_IN_COLLECTION;

        Assert.assertEquals(count, ticketService.findAll(new PageRequest(0, count)).getTotalElements());
    }
}
