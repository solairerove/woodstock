package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.dto.ChapterDTO;

public interface ChapterService {

    Chapter create(Long refId, ChapterDTO chapterDTO);

    Chapter get(Long refId, Long chapterId);

    Iterable<Chapter> getAll(Long refId);
}
