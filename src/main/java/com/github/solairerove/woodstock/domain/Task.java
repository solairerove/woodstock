package com.github.solairerove.woodstock.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krivitski-no on 10/1/16.
 */
@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "Task")
public class Task extends BaseEntity {

    private String question;

    @Relationship(type = "HAS_IN", direction = Relationship.INCOMING)
    private List<Ticket> tickets;

    private Boolean enable;

    private Boolean correct;

    private String createdDate;

    private String updatedDate;

    public List<Ticket> getTickets() {
        if (tickets == null) {
            tickets = new ArrayList<>();
        }
        return tickets;
    }
}
