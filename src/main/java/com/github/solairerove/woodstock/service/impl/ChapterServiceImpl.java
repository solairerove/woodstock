package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.repository.ChapterRepository;
import com.github.solairerove.woodstock.service.ChapterService;
import com.github.solairerove.woodstock.service.common.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapterServiceImpl extends GenericServiceImpl<Chapter, ChapterRepository> implements ChapterService {

    @Autowired
    public ChapterServiceImpl(ChapterRepository repository) {
        super(repository);
    }

    @Override
    public Chapter create(Long refId, ChapterDTO chapterDTO) {
        return repository.create(refId, chapterDTO.getTitle(), chapterDTO.getContent());
    }
}
