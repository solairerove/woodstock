package com.github.solairerove.woodstock.dto;

import com.github.solairerove.woodstock.domain.Ticket;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by krivitski-no on 10/2/16.
 */
@Data
public class TaskDTO implements Serializable {
    private String question;
    private Iterable<? extends Ticket> tickets = new ArrayList<>();

    public TaskDTO() {

    }

    public TaskDTO(String question) {
        this.question = question;
    }

    public TaskDTO(String question, Collection<? extends Ticket> tickets) {
        this.question = question;
        this.tickets = tickets;
    }
}
