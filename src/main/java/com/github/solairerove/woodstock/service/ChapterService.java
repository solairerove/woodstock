package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.service.common.GenericService;

public interface ChapterService extends GenericService<Chapter> {

    Chapter create(Long refId, ChapterDTO chapterDTO);
}
