package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.base.BaseEntity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

public interface GenericRepository<T extends BaseEntity> extends GraphRepository<T> {

    @Query("MATCH (task:Task)<-[:HAS_IN]-(tickets) WHERE id(task)={id1} RETURN tickets")
    Iterable<T> getTicketsThatHasInTaskFromId(@Param("id") Long id1);

    @Query("MATCH (task:Task)<-[:HAS_IN]-(ticket) WHERE id(task)={id1} AND id(ticket)={id2} RETURN ticket")
    T getTicketThatHasInTaskFromId(@Param("id1") Long id1, @Param("id2") Long id2);
}
