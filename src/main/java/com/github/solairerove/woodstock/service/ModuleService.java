package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.dto.ModuleDTO;

import java.util.List;
import java.util.Optional;

public interface ModuleService {

    Module create(String unitId, ModuleDTO moduleDTO);

    Optional<Module> get(String unitId, String moduleId);

    List<Module> getAll(String unitId);
//
//    Module update(String unitId, Long moduleId, ModuleDTO moduleDTO);
}
