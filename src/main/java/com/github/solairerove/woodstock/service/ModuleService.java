package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ModuleDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



//    public Module create(String unitId, ModuleDTO moduleDTO) {
//        Module module = convertToModule(moduleDTO);
//
//        Unit unit = repository.findOne(unitId);
//        unit.getModules().add(module);
//        repository.save(unit);
//
//        return module;
//    }
//
//    public Module get(String unitId, String moduleId) {
//        return this.util.getModule(unitId, moduleId);
//    }
//
//    public List<Module> getAll(String unitId) {
//        return this.util.getModules(unitId);
//    }

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
