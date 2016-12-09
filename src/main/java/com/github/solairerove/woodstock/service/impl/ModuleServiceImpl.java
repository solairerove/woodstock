package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ModuleDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToModule;

@Service
public class ModuleServiceImpl implements ModuleService {

    private static final int MODULES_SIZE = 25;

    private final UnitRepository unitRepository;

    private final ModuleRepository moduleRepository;

    @Autowired
    public ModuleServiceImpl(UnitRepository unitRepository, ModuleRepository moduleRepository) {
        this.unitRepository = unitRepository;
        this.moduleRepository = moduleRepository;
    }

    @Override
    public Module create(Long unitId, ModuleDTO moduleDTO) {
        Module module = convertToModule(moduleDTO);

        Unit unit = unitRepository.findOne(unitId);
        unit.getModules().add(module);
        unitRepository.save(unit);

        return module;
    }

    @Override
    public Module get(Long unitId, Long moduleId) {
        return moduleRepository.getOneThatHasInNode(unitId, moduleId);
    }

    @Override
    public Iterable<Module> getAll(Long id1, Integer size) {
        if (size == null) {
            return moduleRepository.getAllThatHasInNode(id1, MODULES_SIZE);
        }

        return moduleRepository.getAllThatHasInNode(id1, size);
    }

    @Override
    public Module update(Long unitId, Long moduleId, ModuleDTO moduleDTO) {
        Module module = moduleRepository.getOneThatHasInNode(unitId, moduleId);
        module.setName(moduleDTO.getName());
        module.setDescription(moduleDTO.getDescription());

        return moduleRepository.save(module);
    }
}
