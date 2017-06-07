package com.github.solairerove.service;

import com.github.solairerove.service.dto.QuestionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Question.
 */
public interface QuestionService {

    /**
     * Save a question.
     *
     * @param questionDTO the entity to save
     * @return the persisted entity
     */
    QuestionDTO save(QuestionDTO questionDTO);

    /**
     *  Get all the questions.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<QuestionDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" question.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    QuestionDTO findOne(Long id);

    /**
     *  Delete the "id" question.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
