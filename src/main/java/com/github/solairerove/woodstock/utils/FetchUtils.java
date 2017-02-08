package com.github.solairerove.woodstock.utils;

import com.github.solairerove.woodstock.repository.ChapterRepository;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.ReferenceRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Component
public class FetchUtils {

    private final UnitRepository unitRepository;

    private final ModuleRepository moduleRepository;

    private final ReferenceRepository referenceRepository;

    private final ChapterRepository chapterRepository;

    @Autowired
    public FetchUtils(UnitRepository unitRepository,
                      ModuleRepository moduleRepository,
                      ReferenceRepository referenceRepository,
                      ChapterRepository chapterRepository) {
        this.unitRepository = unitRepository;
        this.moduleRepository = moduleRepository;
        this.referenceRepository = referenceRepository;
        this.chapterRepository = chapterRepository;
    }

    public String fetchModule(String unitId, String moduleId) {
        return this.unitRepository
                .findOne(unitId)
                .getModules()
                .stream()
                .filter(this.moduleRepository::exists)
                .filter(moduleId::equals)
                .collect(toList())
                .get(0);
    }

    public String fetchReference(String unitId, String moduleId, String refId) {
        return this.moduleRepository
                .findOne(this.fetchModule(unitId, moduleId))
                .getReferences()
                .stream()
                .filter(referenceRepository::exists)
                .filter(refId::equals)
                .collect(toList())
                .get(0);
    }

    public String fetchChapter(String unitId, String moduleId, String refId, String chapterId) {
        return this.referenceRepository
                .findOne(this.fetchReference(unitId, moduleId, refId))
                .getChapters()
                .stream()
                .filter(this.chapterRepository::exists)
                .filter(chapterId::equals)
                .collect(toList())
                .get(0);
    }

    public Collection<String> fetchChapters(String unitId, String moduleId, String refId) {
        return this.referenceRepository
                .findOne(this.fetchReference(unitId, moduleId, refId))
                .getChapters();
    }
}
