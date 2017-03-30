package com.github.solairerove.woodstock.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "references")
public class Reference implements Serializable {

    @Id
    private String id;

    private String title;

    private String version;

    private List<Chapter> chapters;

    public Reference() {
        this.id = ObjectId.get().toHexString();
        this.chapters = new ArrayList<>();
    }

    public Reference(String title, String version) {
        this.id = ObjectId.get().toHexString();
        this.title = title;
        this.version = version;
        this.chapters = new ArrayList<>();
    }

    public String getId() {
        return id;
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

    public List<Chapter> getChapters() {
        if (this.chapters == null) {
            this.chapters = new ArrayList<>();
        }

        return this.chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public void add(Chapter chapter) {
        this.chapters.add(chapter);
    }
}
