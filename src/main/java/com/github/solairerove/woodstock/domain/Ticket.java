package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;

@Data
@NodeEntity(label = "Ticket")
public class Ticket implements Serializable {

    @GraphId
    private Long id;

    private String value;

    private Boolean enable;

    private Boolean correct;
}
