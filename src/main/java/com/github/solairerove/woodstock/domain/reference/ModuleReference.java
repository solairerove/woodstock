package com.github.solairerove.woodstock.domain.reference;

import com.github.solairerove.woodstock.domain.chapter.ModuleChapter;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "ModuleReference")
public class ModuleReference extends Reference<ModuleChapter> {

}
