package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Ticket;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends GraphRepository<Ticket> {

    @Query("MATCH (task:Task)<-[:HAS_IN]-(tickets) WHERE id(task)={id} RETURN tickets")
    Iterable<Ticket> getTicketsThatHasInTaskFromId(@Param("id") Long id);

    @Query("MATCH (task:Task)<-[:HAS_IN]-(ticket) WHERE id(task)={taskId} AND id(ticket)={ticketId} RETURN ticket")
    Ticket getTicketThatHasInTaskFromId(@Param("taskId") Long taskId, @Param("ticketId") Long ticketId);

    @Query("MATCH (ticket:Ticket)-[r:HAS_IN]->(task) WHERE id(task)={taskId} AND id(ticket)={ticketId} DELETE r, ticket")
    Ticket deleteTicketThatHasInTaskFromId(@Param("taskId") Long taskId, @Param("ticketId") Long ticketId);
}
