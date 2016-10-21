package com.github.solairerove.woodstock.dto;

import java.io.Serializable;

public class TicketDTO implements Serializable {

    private String value;

    public TicketDTO() {
        // why DATA? why...
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
