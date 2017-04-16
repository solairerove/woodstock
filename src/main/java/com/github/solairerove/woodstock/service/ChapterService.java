package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToChapter;

@Service
public class ChapterService {

    private final UnitRepository repository;

    private final ServiceUtil util;

    @Autowired
    public ChapterService(UnitRepository repository, ServiceUtil util) {
        this.repository = repository;
        this.util = util;
    }

//    public Chapter create(String unitId, String moduleId, String refId, ChapterDTO chapterDTO) {
//        Chapter chapter = convertToChapter(chapterDTO);
//
//        Unit unit = repository.findOne(unitId);
//
//        unit.getModules()
//                .stream()
//                .filter(el -> moduleId.equals(el.getId()))
//                .findFirst()
//                .orElse(null)
//                .getReferences()
//                .stream()
//                .filter(el -> refId.equals(el.getId()))
//                .findFirst()
//                .orElse(null)
//                .getChapters()
//                .add(chapter);
//        repository.save(unit);
//
//        return chapter;
//    }
//
//    public Chapter get(String unitId, String moduleId, String refId, String chapterId) {
//        return this.util.getChapter(unitId, moduleId, refId, chapterId);
//    }
//
//    public List<Chapter> getAll(String unitId, String moduleId, String refId) {
//        return this.util.getChapters(unitId, moduleId, refId);
//    }
}
