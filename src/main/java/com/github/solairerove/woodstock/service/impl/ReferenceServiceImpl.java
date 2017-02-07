package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.dto.ReferenceDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.ReferenceRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToReference;

@Service
public class ReferenceServiceImpl implements ReferenceService {

    private final UnitRepository unitRepository;

    private final ModuleRepository moduleRepository;

    private final ReferenceRepository referenceRepository;

    @Autowired
    public ReferenceServiceImpl(UnitRepository unitRepository, ModuleRepository moduleRepository, ReferenceRepository referenceRepository) {
        this.unitRepository = unitRepository;
        this.moduleRepository = moduleRepository;
        this.referenceRepository = referenceRepository;
    }

    @Override
    public Reference create(String unitId, String moduleId, ReferenceDTO referenceDTO) {
        Reference reference = referenceRepository.save(convertToReference(referenceDTO));
        String refId = reference.getId();

        if (unitRepository
                .findOne(unitId)
                .getModules()
                .stream()
                .anyMatch(moduleId::equals)) {
            Module module = moduleRepository.findOne(moduleId);
            module.getReferences().add(refId);
            moduleRepository.save(module);
        }

        return reference;
    }

    @Override
    public Reference get(String unitId, String moduleId, String refId) {
        return null;
    }

    @Override
    public List getAll(String unitId, String moduleId) {
        return unitRepository.findOne(unitId).getModules().contains(moduleId)
                ?
                (List) referenceRepository.findAll(moduleRepository.findOne(moduleId).getReferences())
                :
                Collections.EMPTY_LIST;
    }

    @Override
    public Reference update(String unitId, String moduleId, String refId, ReferenceDTO referenceDTO) {
        return null;
    }

    @Override
    public Reference delete(String unitId, String moduleId, String refId) {
        return null;
    }

    //    @Override
//    public Reference create(Long moduleId, ReferenceDTO referenceDTO) {
//        Reference reference = convertToReference(referenceDTO);
//
//        Module module = moduleRepository.findOne(moduleId);
//        module.getReferences().add(reference);
//        moduleRepository.save(module);
//
//        return reference;
//    }
//
//    @Override
//    public Reference get(Long moduleId, Long refId) {
//        return referenceRepository.getOneThatHasInNode(moduleId, refId);
//    }
//
//    @Override
//    public Iterable<Reference> getAll(Long moduleId) {
//        return referenceRepository.getAllThatHasInNode(moduleId);
//    }
//
//    @Override
//    public Reference update(Long moduleId, Long refId, ReferenceDTO referenceDTO) {
//        Reference reference = referenceRepository.getOneThatHasInNode(moduleId, refId);
//        reference.setTitle(referenceDTO.getTitle());
//        reference.setVersion(referenceDTO.getVersion());
//
//        return referenceRepository.save(reference);
//    }
//
//    @Override
//    public Reference delete(Long moduleId, Long refId) {
//        Reference reference = referenceRepository.getOneThatHasInNode(moduleId, refId);
//        referenceRepository.delete(refId);
//        return reference;
//    }
}
