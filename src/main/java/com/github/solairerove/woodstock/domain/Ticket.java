package com.github.solairerove.woodstock.domain;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by krivitski-no on 9/28/16.
 */
@NodeEntity(label = "Ticket")
public class Ticket extends Block {

    private String value;

    public Ticket() {
        // why JPA? why...
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
