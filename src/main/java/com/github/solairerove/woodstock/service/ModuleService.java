package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.dto.ModuleDTO;

public interface ModuleService extends GenericService<Module> {

    Module create(Long unitId, ModuleDTO moduleDTO);
}
