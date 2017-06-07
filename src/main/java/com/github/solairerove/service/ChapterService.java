package com.github.solairerove.service;

import com.github.solairerove.service.dto.ChapterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Chapter.
 */
public interface ChapterService {

    /**
     * Save a chapter.
     *
     * @param chapterDTO the entity to save
     * @return the persisted entity
     */
    ChapterDTO save(ChapterDTO chapterDTO);

    /**
     *  Get all the chapters.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<ChapterDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" chapter.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    ChapterDTO findOne(Long id);

    /**
     *  Delete the "id" chapter.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
