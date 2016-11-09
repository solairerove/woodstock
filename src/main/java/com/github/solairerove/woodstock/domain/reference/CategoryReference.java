package com.github.solairerove.woodstock.domain.reference;

import com.github.solairerove.woodstock.domain.chapter.CategoryChapter;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "CategoryReference")
public class CategoryReference extends Reference<CategoryChapter> {

}
