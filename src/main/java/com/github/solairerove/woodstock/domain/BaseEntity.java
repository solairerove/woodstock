package com.github.solairerove.woodstock.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;

import java.io.Serializable;

@NoArgsConstructor
public class BaseEntity implements Serializable {

    @Getter
    @GraphId
    private Long id;
}
