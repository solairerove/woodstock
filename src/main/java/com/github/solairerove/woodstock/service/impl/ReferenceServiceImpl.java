package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.dto.ReferenceDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.ReferenceRepository;
import com.github.solairerove.woodstock.service.ReferenceService;
import com.github.solairerove.woodstock.service.common.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.github.solairerove.woodstock.service.common.ModelMapper.convertToReference;

@Service
public class ReferenceServiceImpl extends GenericServiceImpl<Reference, ReferenceRepository> implements ReferenceService {

    private final ModuleRepository moduleRepository;

    @Autowired
    public ReferenceServiceImpl(ReferenceRepository repository, ModuleRepository moduleRepository) {
        super(repository);
        this.moduleRepository = moduleRepository;
    }

    @Override
    public Reference create(Long moduleId, ReferenceDTO referenceDTO) {
        Reference reference = convertToReference(referenceDTO);

        Module module = moduleRepository.findOne(moduleId);
        module.getReferences().add(reference);
        moduleRepository.save(module);

        return reference;
    }

    @Override
    public Reference update(Long moduleId, Long refId, ReferenceDTO referenceDTO) {
        Reference reference = repository.getOneThatHasInNode(moduleId, refId);
        reference.setTitle(referenceDTO.getTitle());
        reference.setVersion(referenceDTO.getVersion());

        return repository.save(reference);
    }
}
