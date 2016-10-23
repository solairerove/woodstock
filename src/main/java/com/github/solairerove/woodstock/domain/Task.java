package com.github.solairerove.woodstock.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity(label = "Task")
public class Task extends BaseEntity {

    private String question;

    @Relationship(type = "HAS_IN", direction = Relationship.INCOMING)
    private List<Ticket> tickets;

    public Task() {
        // why DATA? why...
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Ticket> getTickets() {
        if (tickets == null) {
            tickets = new ArrayList<>();
        }

        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
