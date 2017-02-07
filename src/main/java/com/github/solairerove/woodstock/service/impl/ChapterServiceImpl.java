package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.repository.ChapterRepository;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.ReferenceRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToChapter;

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
    public Iterable<Chapter> getAll(String unitId, String moduleId, String refId) {
        return null;
    }

    @Override
    public Chapter update(String unitId, String moduleId, String refId, String chapterId, ChapterDTO chapterDTO) {
        return null;
    }
}
