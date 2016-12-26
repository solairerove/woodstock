package com.github.solairerove.woodstock.domain

import org.neo4j.ogm.annotation.GraphId
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

import static org.neo4j.ogm.annotation.Relationship.OUTGOING

@NodeEntity(label = "Question")
class Question implements Serializable {

    @GraphId
    Long id

    String question

    @Relationship(type = "HAS_ANSWER", direction = OUTGOING)
    List<Answer> answers

    List<Answer> getAnswers() {
        if (answers == null) {
            this.answers = new ArrayList<>()
        }
        return this.answers
    }
}
