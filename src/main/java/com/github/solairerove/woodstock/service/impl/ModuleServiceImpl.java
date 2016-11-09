package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ModuleDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleService {

    private static final Integer MODULES_LIMIT_COUNT = 25;

    private final UnitRepository unitRepository;

    private final ModuleRepository moduleRepository;

    @Autowired
    public ModuleServiceImpl(UnitRepository unitRepository, ModuleRepository moduleRepository) {
        this.unitRepository = unitRepository;
        this.moduleRepository = moduleRepository;
    }

    @Override
    public Module create(Long unitId, ModuleDTO moduleDTO) {
        Module module = new Module();
        module.setName(moduleDTO.getName());

        Unit unit = unitRepository.findOne(unitId);
        unit.getModules().add(module);
        unitRepository.save(unit);

        return module;
    }

    @Override
    public Module get(Long unitId, Long moduleId) {
        return moduleRepository.getModuleThatHasInUnitFromId(unitId, moduleId);
    }

    @Override
    public Iterable<Module> getAll(Long unitId, Integer limit) {
        if (limit == null) {
            limit = MODULES_LIMIT_COUNT;
        }
        return moduleRepository.getModulesThatHasInUnitFromId(unitId, limit);
    }
}
