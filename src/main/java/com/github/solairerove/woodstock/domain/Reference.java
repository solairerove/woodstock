package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "references")
public class Reference implements Serializable {

    @Id
    private String id;

    private String title;

    private String version;

    private List<String> chapters;

    public Reference() {
        this.chapters = new ArrayList<>();
    }

    public Reference(String title, String version) {
        this.title = title;
        this.version = version;
        this.chapters = new ArrayList<>();
    }

    public void add(String chapter) {
        this.chapters.add(chapter);
    }
}
