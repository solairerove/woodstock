package com.github.solairerove.woodstock.domain;

import com.github.solairerove.woodstock.domain.base.BaseEntity;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "Ticket")
public class Ticket extends BaseEntity {

    private String value;

    private Boolean enable;

    private Boolean correct;

    public Ticket() {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
