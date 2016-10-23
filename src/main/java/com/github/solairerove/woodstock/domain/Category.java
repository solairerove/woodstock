package com.github.solairerove.woodstock.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity(label = "Category")
public class Category extends BaseEntity {

    private String name;

    @Relationship(type = "HAS_IN", direction = Relationship.INCOMING)
    private List<Task> tasks;

    public Category() {
        // why DATA? why...
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }

        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
