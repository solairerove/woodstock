package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.UnitDTO;
import com.github.solairerove.woodstock.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToUnit;

@Service
public class UnitService {

    private final UnitRepository repository;

    @Autowired
    public UnitService(UnitRepository repository) {
        this.repository = repository;
    }

    public Unit create(UnitDTO unitDTO) {
        return repository.save(convertToUnit(unitDTO));
    }

    public Unit get(String id) {
        return repository.findOne(id);
    }

    public List<Unit> getAll() {
        return repository.findAll();
    }

    public Unit update(String id, UnitDTO unitDTO) {
        Unit unit = repository.findOne(id);
        unit.setLabel(unitDTO.getLabel());
        unit.setDescription(unitDTO.getDescription());

        return repository.save(unit);
    }

    public Unit delete(String id) {
        Unit unit = repository.findOne(id);
        repository.delete(id);

        return unit;
    }
}
