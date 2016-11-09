package com.github.solairerove.woodstock.service.impl.reference;

import com.github.solairerove.woodstock.repository.reference.ModuleReferenceRepository;
import com.github.solairerove.woodstock.service.reference.ModuleReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleReferenceServiceImpl implements ModuleReferenceService {

    private final ModuleReferenceRepository repository;

    @Autowired
    public ModuleReferenceServiceImpl(ModuleReferenceRepository repository) {
        this.repository = repository;
    }
}
