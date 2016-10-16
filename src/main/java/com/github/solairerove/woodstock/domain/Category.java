package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;

/**
 * Created by krivitski-no on 10/14/16.
 */
@Data
@NodeEntity(label = "Category")
public class Category implements Serializable {

    @GraphId
    private Long id;

    private String name;
}
