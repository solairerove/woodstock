package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.dto.ReferenceDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.ReferenceRepository;
import com.github.solairerove.woodstock.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceServiceImpl implements ReferenceService {

    private final ModuleRepository moduleRepository;

    private final ReferenceRepository referenceRepository;

    @Autowired
    public ReferenceServiceImpl(ModuleRepository moduleRepository, ReferenceRepository referenceRepository) {
        this.moduleRepository = moduleRepository;
        this.referenceRepository = referenceRepository;
    }

    @Override
    public Reference create(Long moduleId, ReferenceDTO referenceDTO) {
        Reference reference = new Reference();
        reference.setTitle(referenceDTO.getTitle());
        reference.setVersion(referenceDTO.getVersion());

        Module module = moduleRepository.findOne(moduleId);
        module.getReferences().add(reference);
        moduleRepository.save(module);

        return reference;
    }

    @Override
    public Reference get(Long moduleId, Long refId) {
        return null;
    }

    @Override
    public Iterable<Reference> getAll(Long moduleId) {
        return null;
    }
}
