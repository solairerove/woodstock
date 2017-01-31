package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class DomainModel {

    @Id
    private String id;
    private String firstField;
    private String lastField;
    private List<CollectionModel> collectionModels;

    public DomainModel(String firstField, String lastField) {
        this.firstField = firstField;
        this.lastField = lastField;
    }

    public List<CollectionModel> getCollectionModels() {
        if (this.collectionModels == null) {
            this.collectionModels = new ArrayList<>();
        }
        return collectionModels;
    }
}
