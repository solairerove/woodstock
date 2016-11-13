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
public class ModuleServiceImpl extends GenericServiceImpl<Module, ModuleRepository> implements ModuleService {

    public ModuleServiceImpl(ModuleRepository repository) {
        super(repository);
    }

    @Override
    public Module create(Long unitId, ModuleDTO moduleDTO) {
        return null;
    }
}
