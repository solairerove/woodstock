package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.repository.ChapterRepository;
import com.github.solairerove.woodstock.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository repository;

    @Autowired
    public ChapterServiceImpl(ChapterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Chapter create(Long refId, ChapterDTO chapterDTO) {
        return repository.create(refId, chapterDTO.getTitle(), chapterDTO.getContent());
    }

    @Override
    public Chapter get(Long refId, Long chapterId) {
        return repository.getOneThatHasInNode(refId, chapterId);
    }

    @Override
    public Iterable<Chapter> getAll(Long refId) {
        return repository.getAllThatHasInNode(refId);
    }

    @Override
    public Chapter update(Long refId, Long chapterId, ChapterDTO chapterDTO) {
        Chapter chapter = repository.getOneThatHasInNode(refId, chapterId);
        chapter.setTitle(chapterDTO.getTitle());
        chapter.setContent(chapterDTO.getContent());

        return repository.save(chapter);
    }
}
