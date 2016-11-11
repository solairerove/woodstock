package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.repository.ChapterRepository;
import com.github.solairerove.woodstock.repository.ReferenceRepository;
import com.github.solairerove.woodstock.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapterServiceImpl implements ChapterService {

    private final ReferenceRepository referenceRepository;

    private final ChapterRepository chapterRepository;

    @Autowired
    public ChapterServiceImpl(ReferenceRepository referenceRepository, ChapterRepository chapterRepository) {
        this.referenceRepository = referenceRepository;
        this.chapterRepository = chapterRepository;
    }

    @Override
    public Chapter create(Long refId, ChapterDTO chapterDTO) {
        Chapter chapter = new Chapter();
        chapter.setTitle(chapterDTO.getTitle());
        chapter.setContent(chapterDTO.getContent());

        Reference reference = referenceRepository.findOne(refId);
        reference.getChapters().add(chapter);
        referenceRepository.save(reference);

        return chapter;
    }

    @Override
    public Chapter get(Long refId, Long chapterId) {
        return null;
    }

    @Override
    public Iterable<Chapter> getAll(Long refId) {
        return null;
    }
}
