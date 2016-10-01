package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by krivitski-no on 9/28/16.
 */
public interface TicketRepository extends MongoRepository<Ticket, String> {
    @Query("{ 'id' : ?0 }")
    Ticket findOneTicketById(String id);
}
