package com.github.solairerove.woodstock.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by krivitski-no on 10/14/16.
 */
@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "Category")
public class Category extends BaseEntity {

    private String name;
}
