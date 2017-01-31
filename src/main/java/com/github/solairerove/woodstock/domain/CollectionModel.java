package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CollectionModel {

    @Id private String id;
    private String someField;

    public CollectionModel(String someField) {
        this.someField = someField;
    }
}
