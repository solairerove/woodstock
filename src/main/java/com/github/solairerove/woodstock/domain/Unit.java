package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NodeEntity(label = "Unit")
public class Unit implements Serializable {

    @GraphId
    private Long id;

    private String label;

    private String avatar;

    private String description;

    @Relationship(type = "HAS_IN", direction = Relationship.INCOMING)
    private List<Module> modules;

    public List<Module> getModules() {
        if (modules == null) {
            modules = new ArrayList<>();
        }

        return modules;
    }
}
