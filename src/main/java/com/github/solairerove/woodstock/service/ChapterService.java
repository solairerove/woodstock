package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.dto.ChapterDTO;

import java.util.List;

public interface ChapterService {

    Chapter create(String unitId, String moduleId, String refId, ChapterDTO chapterDTO);

    Chapter get(String unitId, String moduleId, String refId, String chapterId);

    List<Chapter> getAll(String unitId, String moduleId, String refId);
}
