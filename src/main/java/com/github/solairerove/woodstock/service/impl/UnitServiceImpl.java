package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.UnitDTO;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToUnit;

@Service
public class UnitServiceImpl implements UnitService {

    private final UnitRepository repository;

    @Autowired
    public UnitServiceImpl(UnitRepository repository) {
        this.repository = repository;
    }

    @Override
    public Unit create(UnitDTO unitDTO) {
        return repository.save(convertToUnit(unitDTO));
    }

    @Override
    public Unit get(String id) {
        return repository.findOne(id);
    }

    @Override
    public Collection<Unit> getAll() {
        return repository.findAll();
    }

    @Override
    public Unit update(String id, UnitDTO unitDTO) {
        Unit unit = repository.findOne(id);
        unit.setLabel(unitDTO.getLabel());
        unit.setDescription(unitDTO.getDescription());

        return repository.save(unit);
    }

    @Override
    public Unit delete(String id) {
        Unit unit = repository.findOne(id);
        repository.delete(id);

        return unit;
    }
}
