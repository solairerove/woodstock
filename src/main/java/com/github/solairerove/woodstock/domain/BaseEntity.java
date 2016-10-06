package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by krivitski-no on 10/1/16.
 */
@Data
@Document
public class BaseEntity implements Serializable {
    @Id
    private String id;
    private transient LocalDateTime createdDate;
    private transient LocalDateTime updatedDate;

    public BaseEntity() {
        // default contructor
    }
}
