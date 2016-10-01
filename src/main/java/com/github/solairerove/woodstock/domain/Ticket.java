package com.github.solairerove.woodstock.domain;

import lombok.Data;

/**
 * Created by krivitski-no on 9/28/16.
 */
@Data
public class Ticket extends Block {
    private String value;

    public Ticket() {
    }

    public Ticket(String value) {
        this.value = value;
        super.setEnable(Boolean.TRUE);
        super.setCorrect(Boolean.FALSE);
    }

    public Ticket(String value, Boolean enable, Boolean correct) {
        this.value = value;
        super.setEnable(enable);
        super.setCorrect(correct);
    }
}
