package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ModuleDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.ModuleService;
import com.github.solairerove.woodstock.service.common.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl extends GenericServiceImpl<Module, ModuleRepository> implements ModuleService {

    private final UnitRepository unitRepository;

    @Autowired
    public ModuleServiceImpl(ModuleRepository repository, UnitRepository unitRepository) {
        super(repository);
        this.unitRepository = unitRepository;
    }

    @Override
    public Module create(Long unitId, ModuleDTO moduleDTO) {
        Module module = new Module();
        module.setName(moduleDTO.getName());
        module.setAvatar(moduleDTO.getAvatar());
        module.setDescription(moduleDTO.getDescription());

        Unit unit = unitRepository.findOne(unitId);
        unit.getModules().add(module);
        unitRepository.save(unit);

        return module;
    }
}
