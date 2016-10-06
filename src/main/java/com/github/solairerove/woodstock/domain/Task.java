package com.github.solairerove.woodstock.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krivitski-no on 10/1/16.
 */
@Data
public class Task extends Block {
    private String question;
    private List<Ticket> tickets = new ArrayList<>();

    public Task() {
        // default contructor
    }

    public Task(String question) {
        this.question = question;
        super.setEnable(Boolean.TRUE);
        super.setCorrect(Boolean.FALSE);
    }
}
