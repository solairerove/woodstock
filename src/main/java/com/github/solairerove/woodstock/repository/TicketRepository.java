package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Ticket;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by krivitski-no on 9/28/16.
 */
public interface TicketRepository extends GraphRepository<Ticket> {

}
