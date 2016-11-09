package com.github.solairerove.woodstock.domain;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "CategoryReference")
public class CategoryReference extends Reference<CategoryChapter> {

}
