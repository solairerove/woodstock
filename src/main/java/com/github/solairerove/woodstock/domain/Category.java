package com.github.solairerove.woodstock.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;

/**
 * Created by krivitski-no on 10/14/16.
 */
@NodeEntity
public class Category implements Serializable {

    @GraphId
    private Long id;
    private String name;

    public Category() {
        // why JPA? why...
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
