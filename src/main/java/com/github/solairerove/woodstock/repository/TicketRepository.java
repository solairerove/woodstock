package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Ticket;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by krivitski-no on 9/28/16.
 */
@Repository
public interface TicketRepository extends GraphRepository<Ticket> {

    @Query("MATCH (task:Task)<-[:HAS_IN]-(tickets) WHERE id(task)={id} RETURN tickets")
    Iterable<Ticket> getTicketsThatHasInTaskFromId(@Param("id") Long id);
}
