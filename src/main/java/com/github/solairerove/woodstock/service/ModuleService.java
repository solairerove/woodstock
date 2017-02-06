package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.dto.ModuleDTO;

public interface ModuleService {

    Module create(String unitId, ModuleDTO moduleDTO);

    Module get(String unitId, String moduleId);
//
    Iterable<Module> getAll(String unitId);
//
//    Module update(String unitId, Long moduleId, ModuleDTO moduleDTO);
}
