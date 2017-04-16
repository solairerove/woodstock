package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.repository.ChapterRepository;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.ReferenceRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {

    private final UnitRepository unitRepository;

    private final ModuleRepository moduleRepository;

    private final ReferenceRepository referenceRepository;

    private final ChapterRepository chapterRepository;

    @Autowired
    public ChapterService(final UnitRepository unitRepository,
                          final ModuleRepository moduleRepository,
                          final ReferenceRepository referenceRepository,
                          final ChapterRepository chapterRepository) {
        this.unitRepository = unitRepository;
        this.moduleRepository = moduleRepository;
        this.referenceRepository = referenceRepository;
        this.chapterRepository = chapterRepository;
    }

    public Chapter create(String unitId, String moduleId, String refId, ChapterDTO dto) {
        Chapter chapter = new Chapter(dto.getTitle(), dto.getContent());
        chapterRepository.save(chapter);
        String id = chapter.getId();

        Reference reference = referenceRepository.findOne(refId);
        reference.add(id);
        referenceRepository.save(reference);

        return chapter;
    }

    public Chapter get(String unitId, String moduleId, String refId, String chapterId) {
        return chapterRepository.findOne(chapterId);
    }

    public Iterable<Chapter> getAll(String unitId, String moduleId, String refId) {
        Reference reference = referenceRepository.findOne(refId);
        List<String> ids = reference.getChapters();

        return chapterRepository.findAll(ids);
    }

    public Chapter update(String unitId, String moduleId, String refId, String chapterId, ChapterDTO dto) {
        Chapter chapter = chapterRepository.findOne(chapterId);
        chapter.setTitle(dto.getTitle());
        chapter.setContent(dto.getContent());

        return chapterRepository.save(chapter);
    }
}
