package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Ticket;
import com.github.solairerove.woodstock.repository.common.GenericRepository;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends GenericRepository<Ticket> {

    @Query("MATCH (ticket:Ticket)-[r:HAS_IN]->(task) WHERE id(task)={taskId} AND id(ticket)={ticketId} DELETE r, ticket")
    Ticket deleteTicketThatHasInTaskFromId(@Param("taskId") Long taskId, @Param("ticketId") Long ticketId);
}
