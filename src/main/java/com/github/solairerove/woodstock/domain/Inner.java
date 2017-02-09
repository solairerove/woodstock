package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class Inner implements Serializable {

    @Id
    private String id;

    private String someField;

    public Inner() {
        this.id = ObjectId.get().toHexString();
    }
}
