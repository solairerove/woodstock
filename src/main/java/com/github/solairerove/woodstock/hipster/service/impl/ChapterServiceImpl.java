package com.github.solairerove.woodstock.hipster.service.impl;

import com.github.solairerove.woodstock.hipster.service.ChapterService;
import com.github.solairerove.woodstock.hipster.domain.Chapter;
import com.github.solairerove.woodstock.hipster.repository.ChapterRepository;
import com.github.solairerove.woodstock.hipster.service.dto.ChapterDTO;
import com.github.solairerove.woodstock.hipster.service.mapper.ChapterMapper;
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
 * Service Implementation for managing Chapter.
 */
@Service
@Transactional
public class ChapterServiceImpl implements ChapterService{

    private final Logger log = LoggerFactory.getLogger(ChapterServiceImpl.class);
    
    private final ChapterRepository chapterRepository;

    private final ChapterMapper chapterMapper;

    public ChapterServiceImpl(ChapterRepository chapterRepository, ChapterMapper chapterMapper) {
        this.chapterRepository = chapterRepository;
        this.chapterMapper = chapterMapper;
    }

    /**
     * Save a chapter.
     *
     * @param chapterDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ChapterDTO save(ChapterDTO chapterDTO) {
        log.debug("Request to save Chapter : {}", chapterDTO);
        Chapter chapter = chapterMapper.toEntity(chapterDTO);
        chapter = chapterRepository.save(chapter);
        ChapterDTO result = chapterMapper.toDto(chapter);
        return result;
    }

    /**
     *  Get all the chapters.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ChapterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Chapters");
        Page<Chapter> result = chapterRepository.findAll(pageable);
        return result.map(chapter -> chapterMapper.toDto(chapter));
    }

    /**
     *  Get one chapter by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ChapterDTO findOne(Long id) {
        log.debug("Request to get Chapter : {}", id);
        Chapter chapter = chapterRepository.findOne(id);
        ChapterDTO chapterDTO = chapterMapper.toDto(chapter);
        return chapterDTO;
    }

    /**
     *  Delete the  chapter by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Chapter : {}", id);
        chapterRepository.delete(id);
    }
}
