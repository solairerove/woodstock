package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NodeEntity(label = "Category")
public class Category implements Serializable {

    @GraphId
    private Long id;

    private String name;

    @Relationship(type = "HAS_IN", direction = Relationship.INCOMING)
    private List<Task> tasks;

    public List<Task> getTasks() {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }

        return tasks;
    }
}
