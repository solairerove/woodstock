package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity(label = "Chapter")
public class Chapter {

    @GraphId
    private Long id;

    private String title;

    private String content;
}
