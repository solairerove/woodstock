package com.github.solairerove.woodstock.domain;

import org.neo4j.ogm.annotation.NodeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krivitski-no on 10/1/16.
 */
@NodeEntity(label = "Task")
public class Task extends Block {

    private String question;
    private List<Ticket> tickets;

    public Task() {
        // why JPA? why...
    }

    public Task(String question) {
        this.question = question;
        super.setEnable(Boolean.TRUE);
        super.setCorrect(Boolean.FALSE);
    }

    public Task(String question, List<Ticket> tickets) {
        this.question = question;
        this.tickets = tickets;
        super.setEnable(Boolean.TRUE);
        super.setCorrect(Boolean.FALSE);
    }

    public Task(String question, List<Ticket> tickets, Boolean enable, Boolean correct) {
        this.question = question;
        this.tickets = tickets;
        super.setEnable(enable);
        super.setCorrect(correct);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Ticket> getTickets() {
        if(tickets == null) {
            tickets = new ArrayList<>();
        }
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
