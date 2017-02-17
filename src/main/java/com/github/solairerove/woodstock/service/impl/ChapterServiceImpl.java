package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToChapter;

@Service
public class ChapterServiceImpl implements ChapterService {

    private final UnitRepository repository;

    @Autowired
    public ChapterServiceImpl(UnitRepository repository) {
        this.repository = repository;
    }

    @Override
    public Chapter create(String unitId, String moduleId, String refId, ChapterDTO chapterDTO) {
        Chapter chapter = convertToChapter(chapterDTO);

        Unit unit = repository.findOne(unitId);

        unit.getModules()
                .stream()
                .filter(el -> moduleId.equals(el.getId()))
                .findFirst()
                .orElse(null)
                .getReferences()
                .stream()
                .filter(el -> refId.equals(el.getId()))
                .findFirst()
                .orElse(null)
                .getChapters()
                .add(chapter);
        repository.save(unit);

        return chapter;
    }

    @Override
    public Chapter get(String unitId, String moduleId, String refId, String chapterId) {
        return repository
                .findOne(unitId)
                .getModules()
                .stream()
                .filter(el -> moduleId.equals(el.getId()))
                .findFirst()
                .orElse(null)
                .getReferences()
                .stream()
                .filter(el -> refId.equals(el.getId()))
                .findFirst()
                .orElse(null)
                .getChapters()
                .stream()
                .filter(el -> chapterId.equals(el.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Chapter> getAll(String unitId, String moduleId, String refId) {
        return repository
                .findOne(unitId)
                .getModules()
                .stream()
                .filter(el -> moduleId.equals(el.getId()))
                .findFirst()
                .orElse(null)
                .getReferences()
                .stream()
                .filter(el -> refId.equals(el.getId()))
                .findFirst()
                .orElse(null)
                .getChapters();
    }
}
