package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.bson.types.ObjectId;
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

    private List<Chapter> chapters;

    public Reference() {
        this.id = ObjectId.get().toHexString();
    }

    public List<Chapter> getChapters() {
        if (this.chapters == null) {
            this.chapters = new ArrayList<>();
        }

        return this.chapters;
    }
}
