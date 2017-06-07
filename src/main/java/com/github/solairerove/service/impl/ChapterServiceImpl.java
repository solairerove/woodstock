package com.github.solairerove.service.impl;

import com.github.solairerove.service.ChapterService;
import com.github.solairerove.domain.Chapter;
import com.github.solairerove.repository.ChapterRepository;
import com.github.solairerove.service.dto.ChapterDTO;
import com.github.solairerove.service.mapper.ChapterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
        return chapterMapper.toDto(chapter);
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
        return chapterRepository.findAll(pageable)
            .map(chapterMapper::toDto);
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
        return chapterMapper.toDto(chapter);
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
