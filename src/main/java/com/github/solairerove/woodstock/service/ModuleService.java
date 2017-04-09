package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ModuleDTO;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToModule;

@Service
public class ModuleService {

    private final UnitRepository repository;

    private final ServiceUtil util;

    @Autowired
    public ModuleService(UnitRepository repository, ServiceUtil util) {
        this.repository = repository;
        this.util = util;
    }

    public Module create(String unitId, ModuleDTO moduleDTO) {
        Module module = convertToModule(moduleDTO);

        Unit unit = repository.findOne(unitId);
        unit.getModules().add(module);
        repository.save(unit);

        return module;
    }

    public Module get(String unitId, String moduleId) {
        return this.util.getModule(unitId, moduleId);
    }

    public List<Module> getAll(String unitId) {
        return this.util.getModules(unitId);
    }

    public Module update(String unitId, String moduleId, ModuleDTO dto) {
        Unit unit = repository.findOne(unitId);

        Module module = util.getModule(unitId, moduleId);
        module.setName(dto.getName());
        module.setAvatar(dto.getAvatar());
        module.setDescription(dto.getDescription());

        unit.add(module);
        repository.save(unit);

        return module;
    }
}
