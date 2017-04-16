package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ReferenceDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.ReferenceRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class ReferenceService {

    private final UnitRepository unitRepository;

    private final ModuleRepository moduleRepository;

    private final ReferenceRepository referenceRepository;

    @Autowired
    public ReferenceService(final UnitRepository unitRepository,
                            final ModuleRepository moduleRepository,
                            final ReferenceRepository referenceRepository) {
        this.unitRepository = unitRepository;
        this.moduleRepository = moduleRepository;
        this.referenceRepository = referenceRepository;
    }

    // TODO: check if exists
    public Reference create(String unitId, String moduleId, ReferenceDTO dto) {
        Reference reference = new Reference(dto.getTitle(), dto.getVersion());
        referenceRepository.save(reference);
        String id = reference.getId();

        Module module = moduleRepository.findOne(moduleId);
        module.addReference(id);
        moduleRepository.save(module);

        return reference;
    }

    public Reference get(String unitId, String moduleId, String refId) {
        return referenceRepository.findOne(refId);
    }

    public Iterable<Reference> getAll(String unitId, String moduleId) {
        List<String> ids = moduleRepository.findOne(moduleId).getReferences();
        return referenceRepository.findAll(ids);
    }

    // TODO: check if exists in collection of ids
    public Reference update(String unitId, String moduleId, String refId, ReferenceDTO dto) {
        Reference reference = referenceRepository.findOne(refId);
        reference.setTitle(dto.getTitle());
        reference.setVersion(dto.getVersion());
        referenceRepository.save(reference);

        return reference;
    }

//    public Reference delete(String unitId, String moduleId, String refId) {
//        return null;
//    }
}
