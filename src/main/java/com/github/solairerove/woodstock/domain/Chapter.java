package com.github.solairerove.woodstock.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Document(collection = "chapters")
public class Chapter implements Serializable {

    @Id
    private String id;

    private String title;

    private String content;

    public Chapter(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
