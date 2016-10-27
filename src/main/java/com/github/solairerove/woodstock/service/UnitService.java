package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.UnitDTO;

public interface UnitService {

    Unit create(UnitDTO unitDTO);

    Unit get(Long id);

    Iterable<Unit> getAll();

    Iterable<Unit> deleteAll();
}
