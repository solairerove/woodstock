package com.github.solairerove.woodstock.hipster.service.impl;

import com.github.solairerove.woodstock.hipster.service.ReferenceService;
import com.github.solairerove.woodstock.hipster.domain.Reference;
import com.github.solairerove.woodstock.hipster.repository.ReferenceRepository;
import com.github.solairerove.woodstock.hipster.service.dto.ReferenceDTO;
import com.github.solairerove.woodstock.hipster.service.mapper.ReferenceMapper;
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
 * Service Implementation for managing Reference.
 */
@Service
@Transactional
public class ReferenceServiceImpl implements ReferenceService{

    private final Logger log = LoggerFactory.getLogger(ReferenceServiceImpl.class);

    private final ReferenceRepository referenceRepository;

    private final ReferenceMapper referenceMapper;

    public ReferenceServiceImpl(ReferenceRepository referenceRepository, ReferenceMapper referenceMapper) {
        this.referenceRepository = referenceRepository;
        this.referenceMapper = referenceMapper;
    }

    /**
     * Save a reference.
     *
     * @param referenceDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ReferenceDTO save(ReferenceDTO referenceDTO) {
        log.debug("Request to save Reference : {}", referenceDTO);
        Reference reference = referenceMapper.toEntity(referenceDTO);
        reference = referenceRepository.save(reference);
        return referenceMapper.toDto(reference);
    }

    /**
     *  Get all the references.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ReferenceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all References");
        Page<Reference> result = referenceRepository.findAll(pageable);
        return result.map(referenceMapper::toDto);
    }

    /**
     *  Get one reference by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ReferenceDTO findOne(Long id) {
        log.debug("Request to get Reference : {}", id);
        Reference reference = referenceRepository.findOne(id);
        return referenceMapper.toDto(reference);
    }

    /**
     *  Delete the  reference by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Reference : {}", id);
        referenceRepository.delete(id);
    }
}
