package com.github.solairerove.service.impl;

import com.github.solairerove.service.UnitService;
import com.github.solairerove.domain.Unit;
import com.github.solairerove.repository.UnitRepository;
import com.github.solairerove.service.dto.UnitDTO;
import com.github.solairerove.service.mapper.UnitMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Unit.
 */
@Service
@Transactional
public class UnitServiceImpl implements UnitService{

    private final Logger log = LoggerFactory.getLogger(UnitServiceImpl.class);

    private final UnitRepository unitRepository;

    private final UnitMapper unitMapper;

    public UnitServiceImpl(UnitRepository unitRepository, UnitMapper unitMapper) {
        this.unitRepository = unitRepository;
        this.unitMapper = unitMapper;
    }

    /**
     * Save a unit.
     *
     * @param unitDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public UnitDTO save(UnitDTO unitDTO) {
        log.debug("Request to save Unit : {}", unitDTO);
        Unit unit = unitMapper.toEntity(unitDTO);
        unit = unitRepository.save(unit);
        return unitMapper.toDto(unit);
    }

    /**
     *  Get all the units.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<UnitDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Units");
        return unitRepository.findAll(pageable)
            .map(unitMapper::toDto);
    }

    /**
     *  Get one unit by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public UnitDTO findOne(Long id) {
        log.debug("Request to get Unit : {}", id);
        Unit unit = unitRepository.findOne(id);
        return unitMapper.toDto(unit);
    }

    /**
     *  Delete the  unit by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Unit : {}", id);
        unitRepository.delete(id);
    }
}
