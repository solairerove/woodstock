package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.dto.ReferenceDTO;
import com.github.solairerove.woodstock.service.common.GenericService;

public interface ReferenceService extends GenericService<Reference> {

    Reference create(Long moduleId, ReferenceDTO referenceDTO);

    Reference update(Long moduleId, Long refId, ReferenceDTO referenceDTO);
}
