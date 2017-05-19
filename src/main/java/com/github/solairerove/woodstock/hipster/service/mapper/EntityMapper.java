package com.github.solairerove.woodstock.hipster.service.mapper;

import java.util.List;

/**
 * Contract for a generic dto to entity mapper.
 @param <DTO> - DTO type parameter.
 @param <ENTITY> - Entity type parameter.
 */

public interface EntityMapper <DTO, ENTITY> {

    public ENTITY toEntity(DTO dto);

    public DTO toDto(ENTITY entity);

    public List <ENTITY> toEntity(List<DTO> dtoList);

    public List <DTO> toDto(List<ENTITY> entityList);
}
