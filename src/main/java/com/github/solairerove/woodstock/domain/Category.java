package com.github.solairerove.woodstock.domain;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "Category")
public class Category extends BaseEntity {

    private String name;

    public Category() {
        // why DATA? why...
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
