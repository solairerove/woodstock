package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.repository.ChapterRepository;
import com.github.solairerove.woodstock.repository.ReferenceRepository;
import com.github.solairerove.woodstock.service.ChapterService;
import com.github.solairerove.woodstock.service.common.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.github.solairerove.woodstock.service.common.ModelMapper.convertToChapter;

@Service
public class ChapterServiceImpl extends GenericServiceImpl<Chapter, ChapterRepository> implements ChapterService {

    private final ReferenceRepository referenceRepository;

    @Autowired
    public ChapterServiceImpl(ChapterRepository repository, ReferenceRepository referenceRepository) {
        super(repository);
        this.referenceRepository = referenceRepository;
    }

    @Override
    public Chapter create(Long refId, ChapterDTO chapterDTO) {
        Chapter chapter = convertToChapter(chapterDTO);

        Reference reference = referenceRepository.findOne(refId);
        reference.getChapters().add(chapter);
        referenceRepository.save(reference);

        return chapter;
    }
}
