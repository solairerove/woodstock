package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.dto.ReferenceDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.common.GenericRepository;
import com.github.solairerove.woodstock.service.ReferenceService;
import com.github.solairerove.woodstock.service.common.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceServiceImpl extends GenericServiceImpl<Reference> implements ReferenceService {

    private final ModuleRepository moduleRepository;

    @Autowired
    public ReferenceServiceImpl(GenericRepository<Reference> repository, ModuleRepository moduleRepository) {
        super(repository);
        this.moduleRepository = moduleRepository;
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
}
