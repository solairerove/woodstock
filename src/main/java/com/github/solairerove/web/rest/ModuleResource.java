package com.github.solairerove.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.github.solairerove.service.ModuleService;
import com.github.solairerove.web.rest.util.HeaderUtil;
import com.github.solairerove.web.rest.util.PaginationUtil;
import com.github.solairerove.service.dto.ModuleDTO;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Module.
 */
@RestController
@RequestMapping("/api")
public class ModuleResource {

    private final Logger log = LoggerFactory.getLogger(ModuleResource.class);

    private static final String ENTITY_NAME = "module";

    private final ModuleService moduleService;

    public ModuleResource(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    /**
     * POST  /modules : Create a new module.
     *
     * @param moduleDTO the moduleDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new moduleDTO, or with status 400 (Bad Request) if the module has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/modules")
    @Timed
    public ResponseEntity<ModuleDTO> createModule(@RequestBody ModuleDTO moduleDTO) throws URISyntaxException {
        log.debug("REST request to save Module : {}", moduleDTO);
        if (moduleDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new module cannot already have an ID")).body(null);
        }
        ModuleDTO result = moduleService.save(moduleDTO);
        return ResponseEntity.created(new URI("/api/modules/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /modules : Updates an existing module.
     *
     * @param moduleDTO the moduleDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated moduleDTO,
     * or with status 400 (Bad Request) if the moduleDTO is not valid,
     * or with status 500 (Internal Server Error) if the moduleDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/modules")
    @Timed
    public ResponseEntity<ModuleDTO> updateModule(@RequestBody ModuleDTO moduleDTO) throws URISyntaxException {
        log.debug("REST request to update Module : {}", moduleDTO);
        if (moduleDTO.getId() == null) {
            return createModule(moduleDTO);
        }
        ModuleDTO result = moduleService.save(moduleDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, moduleDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /modules : get all the modules.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of modules in body
     */
    @GetMapping("/modules")
    @Timed
    public ResponseEntity<List<ModuleDTO>> getAllModules(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Modules");
        Page<ModuleDTO> page = moduleService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/modules");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /modules/:id : get the "id" module.
     *
     * @param id the id of the moduleDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the moduleDTO, or with status 404 (Not Found)
     */
    @GetMapping("/modules/{id}")
    @Timed
    public ResponseEntity<ModuleDTO> getModule(@PathVariable Long id) {
        log.debug("REST request to get Module : {}", id);
        ModuleDTO moduleDTO = moduleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(moduleDTO));
    }

    /**
     * DELETE  /modules/:id : delete the "id" module.
     *
     * @param id the id of the moduleDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/modules/{id}")
    @Timed
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        log.debug("REST request to delete Module : {}", id);
        moduleService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
