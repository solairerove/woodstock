package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ModuleDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    private final UnitRepository unitRepository;

    private final ModuleRepository moduleRepository;

    @Autowired
    public ModuleService(UnitRepository unitRepository, ModuleRepository moduleRepository) {
        this.unitRepository = unitRepository;
        this.moduleRepository = moduleRepository;
    }

    public Module create(String unitId, ModuleDTO dto) {
        Unit unit = unitRepository.findOne(unitId);

        Module module = new Module(dto.getName(), dto.getAvatar(), dto.getDescription());
        String moduleId = moduleRepository.save(module).getId();

        unit.add(moduleId);
        unitRepository.save(unit);

        return module;
    }

    // TODO: check if exists in collection of ids
    public Module get(String unitId, String moduleId) {
        unitRepository.findOne(unitId).getModules().contains(moduleId);
        return moduleRepository.findOne(moduleId);
    }

    public Iterable<Module> getAll(String unitId) {
        List<String> ids = unitRepository.findOne(unitId).getModules();
        return moduleRepository.findAll(ids);
    }

    // TODO: check if exists in collection of ids
    public Module update(String unitId, String moduleId, ModuleDTO dto) {
        Module module = moduleRepository.findOne(moduleId);
        module.setName(dto.getName());
        module.setAvatar(dto.getAvatar());
        module.setDescription(dto.getDescription());

        moduleRepository.save(module);

        return module;
    }

//    public Module delete(String unitId, String moduleId) {
//        Module module = util.getModule(unitId, moduleId);
//
//        Unit unit = repository.findOne(unitId);
//        unit.getModules().removeIf(s -> moduleId.equals(s.getId()));
//        repository.save(unit);
//
//        return module;
//    }
}
