package com.github.solairerove.service;

import com.github.solairerove.service.dto.ModuleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Module.
 */
public interface ModuleService {

    /**
     * Save a module.
     *
     * @param moduleDTO the entity to save
     * @return the persisted entity
     */
    ModuleDTO save(ModuleDTO moduleDTO);

    /**
     *  Get all the modules.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<ModuleDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" module.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    ModuleDTO findOne(Long id);

    /**
     *  Delete the "id" module.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
