package com.github.solairerove.woodstock.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity(label = "Reference")
public class Reference extends BaseEntity {

    private String title;

    @Relationship(type = "HAS_CHAPTER", direction = Relationship.OUTGOING)
    private List<Chapter> chapters;

    public Reference() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Chapter> getChapters() {
        if (chapters == null) {
            chapters = new ArrayList<>();
        }

        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}
