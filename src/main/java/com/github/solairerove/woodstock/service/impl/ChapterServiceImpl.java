package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.repository.ChapterRepository;
import com.github.solairerove.woodstock.repository.ReferenceRepository;
import com.github.solairerove.woodstock.service.ChapterService;
import com.github.solairerove.woodstock.utils.FetchUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToChapter;

@Service
public class ChapterServiceImpl implements ChapterService {

    private final FetchUtils utils;

    private final ReferenceRepository referenceRepository;

    private final ChapterRepository chapterRepository;

    @Autowired
    public ChapterServiceImpl(FetchUtils utils,
                              ReferenceRepository referenceRepository,
                              ChapterRepository chapterRepository) {

        this.utils = utils;
        this.referenceRepository = referenceRepository;
        this.chapterRepository = chapterRepository;
    }

    @Override
    public Chapter create(String unitId, String moduleId, String refId, ChapterDTO chapterDTO) {
        Chapter chapter = chapterRepository.save(convertToChapter(chapterDTO));

        Reference reference = referenceRepository.findOne(utils.fetchReference(unitId, moduleId, refId));
        reference.getChapters().add(chapter.getId());
        referenceRepository.save(reference);

        return chapter;
    }

    @Override
    public Chapter get(String unitId, String moduleId, String refId, String chapterId) {
        return this.chapterRepository.findOne(this.utils.fetchChapter(unitId, moduleId, refId, chapterId));
    }

    @Override
    public Iterable<Chapter> getAll(String unitId, String moduleId, String refId) {
        return this.chapterRepository.findAll(this.utils.fetchChapters(unitId, moduleId, refId));
    }

    @Override
    public Chapter update(String unitId, String moduleId, String refId, String chapterId, ChapterDTO chapterDTO) {
        return null;
    }
}
