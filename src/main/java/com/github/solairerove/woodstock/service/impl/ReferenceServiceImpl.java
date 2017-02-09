package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ReferenceDTO;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToReference;

@Service
public class ReferenceServiceImpl implements ReferenceService {

    private final UnitRepository repository;

    @Autowired
    public ReferenceServiceImpl(UnitRepository repository) {
        this.repository = repository;
    }

    @Override
    public Reference create(String unitId, String moduleId, ReferenceDTO referenceDTO) {
        Reference reference = convertToReference(referenceDTO);

        Unit unit = repository.findOne(unitId);

        unit.getModules()
                .stream()
                .filter(module$ -> module$.getId().equals(moduleId))
                .findFirst()
                .orElse(null)
                .getReferences()
                .add(reference);
        repository.save(unit);

        return reference;
    }

    @Override
    public Reference get(String unitId, String moduleId, String refId) {
        return repository
                .findOne(unitId)
                .getModules()
                .stream()
                .filter(el -> el.getId().equals(moduleId))
                .findFirst()
                .orElse(null)
                .getReferences()
                .stream()
                .filter(el -> el.getId().equals(refId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reference> getAll(String unitId, String moduleId) {
        return repository
                .findOne(unitId)
                .getModules()
                .stream()
                .filter(module$ -> module$.getId().equals(moduleId))
                .findFirst()
                .orElse(null)
                .getReferences();
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
