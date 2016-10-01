package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.Application;
import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.utils.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by krivitski-no on 9/30/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TicketRepositoryTest {
    @Autowired
    private TicketRepository ticketRepository;

    @Test
    public void findOneTicketByIdTest() {
        Ticket saved = EntityUtils.generateTicket();
        ticketRepository.save(saved);

        Assert.assertEquals(saved, ticketRepository.findOneTicketById(saved.getId()));
    }
}
