package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.repository.CategoryChapterRepository;
import com.github.solairerove.woodstock.service.CategoryChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryChapterServiceImpl implements CategoryChapterService {

    private final CategoryChapterRepository repository;

    @Autowired
    public CategoryChapterServiceImpl(CategoryChapterRepository repository) {
        this.repository = repository;
    }
}
