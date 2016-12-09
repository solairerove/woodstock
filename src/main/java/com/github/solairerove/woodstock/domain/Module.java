package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NodeEntity(label = "Module")
public class Module implements Serializable {

    @GraphId
    private Long id;

    private String name;

    private String avatar;

    private String description;

    @Relationship(type = "HAS_REFERENCE")
    private List<Reference> references;

    @Relationship(type = "HAS_IN", direction = Relationship.INCOMING)
    private List<Task> tasks;

    public List<Reference> getReferences() {
        if (references == null) {
            references = new ArrayList<>();
        }

        return references;
    }

    public List<Task> getTasks() {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }

        return tasks;
    }
}
