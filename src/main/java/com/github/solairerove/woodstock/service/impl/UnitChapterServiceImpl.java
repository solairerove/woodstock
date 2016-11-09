package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.repository.UnitChapterRepository;
import com.github.solairerove.woodstock.service.UnitChapterService;
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
