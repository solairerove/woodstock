package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "modules")
public class Module implements Serializable {

    @Id
    private String id;

    private String name;

    private String avatar;

    private String description;

    private List<Reference> references;

    public Module() {
        this.init();
    }

    private void init() {
        this.id = ObjectId.get().toHexString();
        this.references = new ArrayList<>();
    }

    public List<Reference> getReferences() {
        if (this.references == null) {
            this.references = new ArrayList<>();
        }

        return this.references;
    }

    public void add(Reference reference) {
        this.references.add(reference);
    }
}
