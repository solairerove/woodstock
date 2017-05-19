package com.github.solairerove.woodstock.hipster.service.impl;

import com.github.solairerove.woodstock.hipster.service.ModuleService;
import com.github.solairerove.woodstock.hipster.domain.Module;
import com.github.solairerove.woodstock.hipster.repository.ModuleRepository;
import com.github.solairerove.woodstock.hipster.service.dto.ModuleDTO;
import com.github.solairerove.woodstock.hipster.service.mapper.ModuleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Module.
 */
@Service
@Transactional
public class ModuleServiceImpl implements ModuleService{

    private final Logger log = LoggerFactory.getLogger(ModuleServiceImpl.class);
    
    private final ModuleRepository moduleRepository;

    private final ModuleMapper moduleMapper;

    public ModuleServiceImpl(ModuleRepository moduleRepository, ModuleMapper moduleMapper) {
        this.moduleRepository = moduleRepository;
        this.moduleMapper = moduleMapper;
    }

    /**
     * Save a module.
     *
     * @param moduleDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ModuleDTO save(ModuleDTO moduleDTO) {
        log.debug("Request to save Module : {}", moduleDTO);
        Module module = moduleMapper.toEntity(moduleDTO);
        module = moduleRepository.save(module);
        ModuleDTO result = moduleMapper.toDto(module);
        return result;
    }

    /**
     *  Get all the modules.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ModuleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Modules");
        Page<Module> result = moduleRepository.findAll(pageable);
        return result.map(module -> moduleMapper.toDto(module));
    }

    /**
     *  Get one module by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ModuleDTO findOne(Long id) {
        log.debug("Request to get Module : {}", id);
        Module module = moduleRepository.findOne(id);
        ModuleDTO moduleDTO = moduleMapper.toDto(module);
        return moduleDTO;
    }

    /**
     *  Delete the  module by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Module : {}", id);
        moduleRepository.delete(id);
    }
}
