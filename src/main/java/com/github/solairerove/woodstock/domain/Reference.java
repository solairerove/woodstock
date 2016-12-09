package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NodeEntity(label = "Reference")
public class Reference implements Serializable {

    @GraphId
    private Long id;

    private String title;

    private String version;

    @Relationship(type = "HAS_CHAPTER", direction = Relationship.OUTGOING)
    private List<Chapter> chapters;

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Chapter> getChapters() {
        if (chapters == null) {
            chapters = new ArrayList<>();
        }

        return chapters;
    }
}
