package com.github.solairerove.woodstock.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by krivitski-no on 10/1/16.
 */
@Data
public class Task extends Block {
    private String question;
    private Iterable<? extends Ticket> tickets = new ArrayList<>();

    public Task() {
    }

    public Task(String question) {
        this.question = question;
        super.setEnable(Boolean.TRUE);
        super.setCorrect(Boolean.FALSE);
    }

    public Task(String question, Collection<? extends Ticket> tickets) {
        this.question = question;
        this.tickets = tickets;
        super.setEnable(Boolean.TRUE);
        super.setCorrect(Boolean.FALSE);
    }

    public Task(String question, Collection<? extends Ticket> tickets, Boolean enable, Boolean correct) {
        this.question = question;
        this.tickets = tickets;
        super.setEnable(enable);
        super.setCorrect(correct);
    }
}
