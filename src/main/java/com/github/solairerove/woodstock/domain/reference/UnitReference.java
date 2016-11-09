package com.github.solairerove.woodstock.domain.reference;

import com.github.solairerove.woodstock.domain.chapter.UnitChapter;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "UnitReference")
public class UnitReference extends Reference<UnitChapter> {

}
