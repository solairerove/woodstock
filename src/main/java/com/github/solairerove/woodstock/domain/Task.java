package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by krivitski-no on 10/1/16.
 */
@Data
@Document
public class Task implements Serializable {
    @Id
    private String id;
    private String question;
    private Boolean enable;
    private Boolean correct;
    private Iterable<? extends Ticket> tickets = new ArrayList<>();

    public Task() {
    }

    public Task(String question, Collection<? extends Ticket> tickets) {
        this.question = question;
        this.enable = Boolean.TRUE;
        this.correct = Boolean.FALSE;
        this.tickets = tickets;
    }

    public Task(String question, Boolean enable, Boolean correct, Collection<? extends Ticket> tickets) {
        this.question = question;
        this.enable = enable;
        this.correct = correct;
        this.tickets = tickets;
    }
}
