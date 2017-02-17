package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ReferenceDTO;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToReference;

@Service
public class ReferenceService {

    private final UnitRepository repository;

    private final ServiceUtil util;

    @Autowired
    public ReferenceService(UnitRepository repository, ServiceUtil util) {
        this.repository = repository;
        this.util = util;
    }

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

    public Reference get(String unitId, String moduleId, String refId) {
        return this.util.getReference(unitId, moduleId, refId);
    }

    public List<Reference> getAll(String unitId, String moduleId) {
        return this.util.getReferences(unitId, moduleId);
    }

    public Reference update(String unitId, String moduleId, String refId, ReferenceDTO referenceDTO) {
        return null;
    }

    public Reference delete(String unitId, String moduleId, String refId) {
        return null;
    }
}
