package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@Data
@NodeEntity(label = "Reference")
public class Reference {

    @GraphId
    private Long id;

    private String title;

    @Relationship(type = "HAS_CHAPTER", direction = Relationship.OUTGOING)
    private List<Chapter> chapters;

    public List<Chapter> getChapters() {
        if (chapters == null) {
            chapters = new ArrayList<>();
        }

        return chapters;
    }
}
