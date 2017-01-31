package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class DomainModel {

    @Id private String id;
    private String firstField;
    private String lastField;

    public DomainModel(String firstField, String lastField) {
        this.firstField = firstField;
        this.lastField = lastField;
    }
}
