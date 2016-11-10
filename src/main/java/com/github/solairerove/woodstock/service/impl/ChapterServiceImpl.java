package com.github.solairerove.woodstock.service.impl;

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
}
