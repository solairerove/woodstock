package com.github.solairerove.woodstock.domain.base;

import org.neo4j.ogm.annotation.GraphId;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    @GraphId
    private Long id;

    public BaseEntity() {

    }

    public Long getId() {
        return id;
    }
}
