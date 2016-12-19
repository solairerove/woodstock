package com.github.solairerove.woodstock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.*;

@Data
@AllArgsConstructor
@NodeEntity(label = "Question")
public class Question implements Serializable {

    @GraphId
    private Long id;
    private String question;
    @Relationship(type = "HAS_ANSWER", direction = OUTGOING)
    private List<Answer> answers;
}
