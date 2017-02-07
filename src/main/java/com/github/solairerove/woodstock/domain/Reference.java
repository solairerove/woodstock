package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Document
public class Reference implements Serializable {

    @Id
    private String id;

    private String title;

    private String version;

    private Collection<String> chapters;

    public Collection<String> getChapters() {
        if (chapters == null) {
            chapters = new ArrayList<>();
        }

        return chapters;
    }
}
