package com.github.solairerove.woodstock.hipster.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.github.solairerove.woodstock.hipster.service.UnitService;
import com.github.solairerove.woodstock.hipster.web.rest.util.HeaderUtil;
import com.github.solairerove.woodstock.hipster.web.rest.util.PaginationUtil;
import com.github.solairerove.woodstock.hipster.service.dto.UnitDTO;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing Unit.
 */
@RestController
@RequestMapping("/api")
public class UnitResource {

    private final Logger log = LoggerFactory.getLogger(UnitResource.class);

    private static final String ENTITY_NAME = "unit";
        
    private final UnitService unitService;

    public UnitResource(UnitService unitService) {
        this.unitService = unitService;
    }

    /**
     * POST  /units : Create a new unit.
     *
     * @param unitDTO the unitDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new unitDTO, or with status 400 (Bad Request) if the unit has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/units")
    @Timed
    public ResponseEntity<UnitDTO> createUnit(@RequestBody UnitDTO unitDTO) throws URISyntaxException {
        log.debug("REST request to save Unit : {}", unitDTO);
        if (unitDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new unit cannot already have an ID")).body(null);
        }
        UnitDTO result = unitService.save(unitDTO);
        return ResponseEntity.created(new URI("/api/units/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /units : Updates an existing unit.
     *
     * @param unitDTO the unitDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated unitDTO,
     * or with status 400 (Bad Request) if the unitDTO is not valid,
     * or with status 500 (Internal Server Error) if the unitDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/units")
    @Timed
    public ResponseEntity<UnitDTO> updateUnit(@RequestBody UnitDTO unitDTO) throws URISyntaxException {
        log.debug("REST request to update Unit : {}", unitDTO);
        if (unitDTO.getId() == null) {
            return createUnit(unitDTO);
        }
        UnitDTO result = unitService.save(unitDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, unitDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /units : get all the units.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of units in body
     */
    @GetMapping("/units")
    @Timed
    public ResponseEntity<List<UnitDTO>> getAllUnits(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Units");
        Page<UnitDTO> page = unitService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/units");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /units/:id : get the "id" unit.
     *
     * @param id the id of the unitDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the unitDTO, or with status 404 (Not Found)
     */
    @GetMapping("/units/{id}")
    @Timed
    public ResponseEntity<UnitDTO> getUnit(@PathVariable Long id) {
        log.debug("REST request to get Unit : {}", id);
        UnitDTO unitDTO = unitService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(unitDTO));
    }

    /**
     * DELETE  /units/:id : delete the "id" unit.
     *
     * @param id the id of the unitDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/units/{id}")
    @Timed
    public ResponseEntity<Void> deleteUnit(@PathVariable Long id) {
        log.debug("REST request to delete Unit : {}", id);
        unitService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
