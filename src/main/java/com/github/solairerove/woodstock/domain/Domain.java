package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Domain implements Serializable {

    @Id
    private String id;

    private String firstField;

    private String lastField;

    private List<Inner> inners;

    public List<Inner> getInners() {
        if (this.inners == null) {
            this.inners = new ArrayList<>();
        }
        return this.inners;
    }
}
