package com.github.solairerove.woodstock.service.impl.chapter;

import com.github.solairerove.woodstock.repository.chapter.UnitChapterRepository;
import com.github.solairerove.woodstock.service.chapter.UnitChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitChapterServiceImpl implements UnitChapterService {

    private final UnitChapterRepository repository;

    @Autowired
    public UnitChapterServiceImpl(UnitChapterRepository repository) {
        this.repository = repository;
    }
}
