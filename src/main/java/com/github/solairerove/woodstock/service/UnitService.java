package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.UnitDTO;

import java.util.List;

public interface UnitService {

    Unit create(UnitDTO unitDTO);

    Unit get(String id);

    List<Unit> getAll();

    Unit update(String id, UnitDTO unitDTO);

    Unit delete(String id);
}
