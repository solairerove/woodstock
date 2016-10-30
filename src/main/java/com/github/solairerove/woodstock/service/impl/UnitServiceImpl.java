package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.UnitDTO;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UnitServiceImpl implements UnitService {

    private final UnitRepository repository;

    @Autowired
    public UnitServiceImpl(UnitRepository repository) {
        this.repository = repository;
    }

    @Override
    public Unit create(UnitDTO unitDTO) {
        Unit unit = new Unit();
        unit.setLabel(unitDTO.getLabel());
        return repository.save(unit);
    }

    @Override
    public Unit get(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<Unit> getAll() {
        return repository.findAll();
    }
}