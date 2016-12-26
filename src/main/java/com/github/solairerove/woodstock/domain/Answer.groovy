package com.github.solairerove.woodstock.domain

import org.neo4j.ogm.annotation.GraphId
import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity(label = "Answer")
class Answer implements Serializable {

    @GraphId
    Long id

    String answer

    boolean correct

    boolean enable
}
