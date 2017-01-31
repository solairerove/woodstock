package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.DomainModel;
import com.github.solairerove.woodstock.dto.DomainModelDTO;
import com.github.solairerove.woodstock.repository.DomainModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DomainModelServiceImpl {

    private final DomainModelRepository repository;

    @Autowired
    public DomainModelServiceImpl(DomainModelRepository repository) {
        this.repository = repository;
    }

    public DomainModel create(DomainModelDTO dto) {
        return repository.save(new DomainModel(dto.getFirstField(), dto.getLastField()));
    }

    public Collection<DomainModel> getAll() {
        return repository.findAll();
    }
}
