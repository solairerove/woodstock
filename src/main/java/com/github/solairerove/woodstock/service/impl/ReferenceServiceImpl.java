package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.dto.ReferenceDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.ReferenceRepository;
import com.github.solairerove.woodstock.service.ReferenceService;
import com.github.solairerove.woodstock.utils.FetchUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToReference;

@Service
public class ReferenceServiceImpl implements ReferenceService {

    private final FetchUtils utils;

    private final ModuleRepository moduleRepository;

    private final ReferenceRepository referenceRepository;

    @Autowired
    public ReferenceServiceImpl(FetchUtils utils,
                                ModuleRepository moduleRepository,
                                ReferenceRepository referenceRepository) {
        this.utils = utils;
        this.moduleRepository = moduleRepository;
        this.referenceRepository = referenceRepository;
    }

    @Override
    public Reference create(String unitId, String moduleId, ReferenceDTO referenceDTO) {
        Reference reference = referenceRepository.save(convertToReference(referenceDTO));
        String refId = reference.getId();

        Module module = moduleRepository.findOne(this.utils.fetchModule(unitId, moduleId));
        module.getReferences().add(refId);
        moduleRepository.save(module);

        return reference;
    }

    @Override
    public Reference get(String unitId, String moduleId, String refId) {
        return referenceRepository.findOne(this.utils.fetchReference(unitId, moduleId, refId));
    }

    @Override
    public Iterable<Reference> getAll(String unitId, String moduleId) {
        return referenceRepository.findAll(utils.fetchReferences(unitId, moduleId));
    }

    @Override
    public Reference update(String unitId, String moduleId, String refId, ReferenceDTO referenceDTO) {
        return null;
    }

    @Override
    public Reference delete(String unitId, String moduleId, String refId) {
        return null;
    }
}
