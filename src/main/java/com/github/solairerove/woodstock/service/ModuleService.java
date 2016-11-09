package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.dto.ModuleDTO;

public interface ModuleService {

    Module create(Long unitId, ModuleDTO moduleDTO);

    Module get(Long unitId, Long moduleId);

    Iterable<Module> getAll(Long unitId, Integer limit);
}
