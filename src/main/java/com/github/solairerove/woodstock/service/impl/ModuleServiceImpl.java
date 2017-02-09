package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ModuleDTO;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToModule;

@Service
public class ModuleServiceImpl implements ModuleService {

    private final UnitRepository repository;

    @Autowired
    public ModuleServiceImpl(UnitRepository repository) {
        this.repository = repository;
    }

    @Override
    public Module create(String unitId, ModuleDTO moduleDTO) {
        Module module = convertToModule(moduleDTO);

        Unit unit = repository.findOne(unitId);
        unit.getModules().add(module);
        repository.save(unit);

        return module;
    }

    @Override
    public Optional<Module> get(String unitId, String moduleId) {
        return repository
                .findOne(unitId)
                .getModules()
                .stream()
                .filter(module -> module.getId().equals(moduleId))
                .findFirst();
    }

    @Override
    public List<Module> getAll(String unitId) {
        return repository.findOne(unitId).getModules();
    }
}
