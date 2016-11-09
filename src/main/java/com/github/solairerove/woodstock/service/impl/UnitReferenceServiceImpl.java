package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.repository.reference.UnitReferenceRepository;
import com.github.solairerove.woodstock.service.reference.UnitReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitReferenceServiceImpl implements UnitReferenceService {

    private final UnitReferenceRepository repository;

    @Autowired
    public UnitReferenceServiceImpl(UnitReferenceRepository repository) {
        this.repository = repository;
    }
}
