package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.repository.CategoryReferenceRepository;
import com.github.solairerove.woodstock.service.CategoryReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryReferenceServiceImpl implements CategoryReferenceService {

    private final CategoryReferenceRepository repository;

    @Autowired
    public CategoryReferenceServiceImpl(CategoryReferenceRepository repository) {
        this.repository = repository;
    }
}