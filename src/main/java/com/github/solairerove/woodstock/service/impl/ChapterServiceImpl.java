package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.repository.ChapterRepository;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.ReferenceRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToChapter;
import static java.util.stream.Collectors.toList;

@Service
public class ChapterServiceImpl implements ChapterService {

    private final UnitRepository unitRepository;

    private final ModuleRepository moduleRepository;

    private final ReferenceRepository referenceRepository;

    private final ChapterRepository chapterRepository;

    @Autowired
    public ChapterServiceImpl(UnitRepository unitRepository,
                              ModuleRepository moduleRepository,
                              ReferenceRepository referenceRepository,
                              ChapterRepository chapterRepository) {

        this.unitRepository = unitRepository;
        this.moduleRepository = moduleRepository;
        this.referenceRepository = referenceRepository;
        this.chapterRepository = chapterRepository;
    }

    @Override
    public Chapter create(String unitId, String moduleId, String refId, ChapterDTO chapterDTO) {
        Chapter chapter = chapterRepository.save(convertToChapter(chapterDTO));

        unitRepository
                .findOne(unitId)
                .getModules()
                .stream()
                .filter(moduleId::equals)
                .findFirst()
                .ifPresent(moduleId$ -> moduleRepository
                        .findOne(moduleId$)
                        .getReferences()
                        .stream()
                        .filter(refId::equals)
                        .findFirst()
                        .ifPresent(refId$ -> {
                                    Reference reference = referenceRepository.findOne(refId$);
                                    reference.getChapters().add(chapter.getId());
                                    referenceRepository.save(reference);
                                }
                        )
                );

        return chapter;
    }

    @Override
    public Chapter get(String unitId, String moduleId, String refId, String chapterId) {
//        return unitRepository
//                .findOne(unitId)
//                .getModules()
//                .stream()
//                .filter(moduleId::equals)
//                .findFirst()
//                .ifPresent(moduleId$ -> moduleRepository
//                        .findOne(moduleId$)
//                        .getReferences()
//                        .stream()
//                        .filter(refId::equals)
//                        .findFirst()
//                        .ifPresent(refId$ -> referenceRepository
//                                .findOne(refId$)
//                                .getChapters()
//                                .stream()
//                                .filter(chapterId::equals)
//                                .findFirst()
//                                .ifPresent(chapterRepository::findOne)));
        return null;
    }

    @Override
    public Collection<Chapter> getAll(String unitId, String moduleId, String refId) {
        // TODO some stream utils class maybe
        String module = unitRepository
                .findOne(unitId)
                .getModules()
                .stream()
                .filter(moduleRepository::exists)
                .filter(moduleId::equals)
                .collect(toList())
                .get(0);

        String reference = moduleRepository
                .findOne(module)
                .getReferences()
                .stream()
                .filter(referenceRepository::exists)
                .filter(refId::equals)
                .collect(toList())
                .get(0);

        Collection<String> modules = referenceRepository
                .findOne(reference)
                .getChapters();

        return (Collection<Chapter>) chapterRepository.findAll(modules);
    }

    @Override
    public Chapter update(String unitId, String moduleId, String refId, String chapterId, ChapterDTO chapterDTO) {
        return null;
    }
}
