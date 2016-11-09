package com.github.solairerove.woodstock.domain.reference;

import com.github.solairerove.woodstock.domain.base.BaseEntity;
import com.github.solairerove.woodstock.domain.chapter.Chapter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity(label = "Reference")
public class Reference<T extends Chapter> extends BaseEntity {

    private String title;

    private String version;

    @Relationship(type = "HAS_CHAPTER", direction = Relationship.OUTGOING)
    private List<T> chapters;

    public Reference() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<T> getChapters() {
        if (chapters == null) {
            chapters = new ArrayList<>();
        }

        return chapters;
    }

    public void setChapters(List<T> chapters) {
        this.chapters = chapters;
    }
}
