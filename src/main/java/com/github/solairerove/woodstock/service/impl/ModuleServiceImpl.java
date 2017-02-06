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

    private final UnitRepository unitRepository;

    private final ModuleRepository moduleRepository;

    @Autowired
    public ModuleServiceImpl(UnitRepository unitRepository, ModuleRepository moduleRepository) {
        this.unitRepository = unitRepository;
        this.moduleRepository = moduleRepository;
    }

    @Override
    public Module create(String unitId, ModuleDTO moduleDTO) {
        Module module = moduleRepository.save(convertToModule(moduleDTO));
        String moduleId = module.getId();

        Unit unit = unitRepository.findOne(unitId);
        unit.getModules().add(moduleId);
        unitRepository.save(unit);

        return module;
    }

    @Override
    public Module get(String unitId, String moduleId) {
        return unitRepository.findOne(unitId).getModules().contains(moduleId) ? moduleRepository.findOne(moduleId) : new Module();
    }

    @Override
    public Iterable<Module> getAll(String unitId) {
        return moduleRepository.findAll(unitRepository.findOne(unitId).getModules());
    }
}
